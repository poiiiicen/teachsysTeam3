package com.se.tss.ExamOnline.Controller;

import com.se.tss.CourseArrangeMgr.Service.ClassInfoService;
import com.se.tss.CourseArrangeMgr.Service.TeacherInfoService;
import com.se.tss.ExamOnline.Domain.Exam;
import com.se.tss.ExamOnline.Domain.ExamResponseBody;
import com.se.tss.ExamOnline.Domain.QuestionResponseBody;
import com.se.tss.ExamOnline.Service.ExamService;
import com.se.tss.ExamOnline.Service.TestService;
import com.se.tss.ExamOnline.Service.TestStudentCourseService;
import com.se.tss.infomgr.annotation.CurrentUser;
import com.se.tss.infomgr.annotation.LoginRequired;
import com.se.tss.infomgr.model.User;
import com.se.tss.infomgr.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/exam/test")
public class TestController {
    private final TestService testService;
    private final UserRepository userRepository;
    private final TestStudentCourseService testStudentCourseService;
    private final ClassInfoService classInfoService;
    private final TeacherInfoService teacherInfoService;
    private final ExamService examService;


    @Autowired
    public TestController(TestService testService,
                          UserRepository userRepository,
                          TestStudentCourseService testStudentCourseService,
                          ClassInfoService classInfoService,
                          TeacherInfoService teacherInfoService,
                          ExamService examService) {
        this.testService = testService;
        this.userRepository = userRepository;
        this.testStudentCourseService = testStudentCourseService;
        this.classInfoService = classInfoService;
        this.teacherInfoService = teacherInfoService;
        this.examService = examService;
    }

    @LoginRequired
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> listAvailableTest(@CurrentUser User user) {
        List<String> courses;
        if (userRepository.findAuthorityById(user.getId()).equals("Student")) {
            courses = testStudentCourseService.findCoursesByStudentId(user.getId());
        } else if (userRepository.findAuthorityById(user.getId()).equals("Teacher")) {
            courses = classInfoService.getIdByTeacherid(teacherInfoService.findIdByName(user.getName()));
        } else if (userRepository.findAuthorityById(user.getId()).equals("Admin")) {
            courses = null;
        } else {
            return ResponseEntity.badRequest().body(new ExamResponseBody("No permission"));
        }
        List<Exam> exams = testService.findExamByCoursesAndPublishTrue(courses);
        return ResponseEntity.ok(new ExamResponseBody(exams.isEmpty() ? "No result" : "Success", exams));
    }

    @LoginRequired
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<?> getTest(@CurrentUser User user, Integer id) {
        if (!userRepository.findAuthorityById(user.getId()).equals("Student")) {
            return ResponseEntity.badRequest().body(new QuestionResponseBody("No permission"));
        }
        Exam exam = examService.findExamById(id);
        if (exam == null) {
            return ResponseEntity.badRequest().body(new QuestionResponseBody("No such exam"));
        }
        if (!testStudentCourseService.findCoursesByStudentId(user.getId()).contains(exam.getCourse())) {
            return ResponseEntity.badRequest().body(new QuestionResponseBody("No permission"));
        }
        Date date = new Date();
        if (date.getTime() < exam.getStartTime().getTime() || date.getTime() > exam.getEndTime().getTime() || !exam.getPublish()) {
            return ResponseEntity.badRequest().body(new QuestionResponseBody("Cannot take"));
        }
        return ResponseEntity.ok(new QuestionResponseBody("Success", testService.findQuestionByExamId(id)));
    }
}
