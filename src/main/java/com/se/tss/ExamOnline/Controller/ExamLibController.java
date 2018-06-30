package com.se.tss.ExamOnline.Controller;

import com.se.tss.CourseArrangeMgr.Service.ClassInfoService;
import com.se.tss.CourseArrangeMgr.Service.TeacherInfoService;
import com.se.tss.ExamOnline.Domain.*;
import com.se.tss.ExamOnline.Service.ExamService;
import com.se.tss.infomgr.annotation.CurrentUser;
import com.se.tss.infomgr.annotation.LoginRequired;
import com.se.tss.infomgr.model.User;
import com.se.tss.infomgr.model.UserRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/exam/exams")
public class ExamLibController {
    private final ExamService examService;
    private final UserRepository userRepository;
    private final ClassInfoService classInfoService;
    private final TeacherInfoService teacherInfoService;

    private final String[] authorityUser = {"Teacher", "Admin"};

    @Autowired
    public ExamLibController(ExamService examService, UserRepository userRepository, ClassInfoService classInfoService, TeacherInfoService teacherInfoService) {
        this.examService = examService;
        this.userRepository = userRepository;
        this.classInfoService = classInfoService;
        this.teacherInfoService = teacherInfoService;
    }

    @LoginRequired
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<?> searchResult(@CurrentUser User user, String course, String name, Date startTime, Date endTime, Boolean release, Boolean over) {
        if (!Arrays.asList(authorityUser).contains(userRepository.findAuthorityById(user.getId()))) {
            return ResponseEntity.badRequest().body(new ExamResponseBody("Not Teacher or Admin"));
        }
        if (course == null || !classInfoService.getIdByTeacherid(teacherInfoService.findIdByName(user.getName())).contains(course)) {
            return ResponseEntity.badRequest().body(new ExamResponseBody(course == null ? "Need Course" : "No Such Course"));
        }
        List<Exam> exams = examService.findExam(course, name, startTime, endTime, release, over);
        return ResponseEntity.ok(new ExamResponseBody(exams.isEmpty() ? "No Result" : "Success", exams));
    }

    @LoginRequired
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResponseEntity<?> getDetail(@CurrentUser User user, Integer eid) {
        if (eid == null) return ResponseEntity.badRequest().body(new ExamResponseBody("Need exam id"));
        String course = examService.findCourseById(eid);
        Exam exam = examService.findExamById(eid);
        if (course == null) return ResponseEntity.badRequest().body(new ExamResponseBody("No such exam"));
        if (!userRepository.findAuthorityById(user.getId()).equals("Admin")
                && !(userRepository.findAuthorityById(user.getId()).equals("Teacher")
                && classInfoService.getIdByTeacherid(teacherInfoService.findIdByName(user.getName())).contains(course))
                && !(userRepository.findAuthorityById(user.getId()).equals("Student")
                && true)) {// TODO : using student class info
            return ResponseEntity.badRequest().body(new ExamResponseBody("No permission"));
        }

        List<Question> questions = examService.getAllQuestionsByExamId(eid);
        if (userRepository.findAuthorityById(user.getId()).equals("Student")) {
            Date date = new Date();
            if (date.getTime() < exam.getEndTime().getTime() && date.getTime() > exam.getStartTime().getTime()) {
                for (Question question : questions) {
                    question.setAnswer(0);
                }
            }
        }
        return ResponseEntity.ok(new QuestionResponseBody("Success", examService.getAllQuestionsByExamId(eid)));
    }


    @LoginRequired
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addExamWithQuestions(@CurrentUser User user, @RequestBody ExamRequestBody examRequestBody) {
        if (!userRepository.findAuthorityById(user.getId()).equals("Admin")
                && !(userRepository.findAuthorityById(user.getId()).equals("Teacher")
                && classInfoService.getIdByTeacherid(teacherInfoService.findIdByName(user.getName())).contains(examRequestBody.getExam().getCourse()))) {
            return ResponseEntity.badRequest().body(new ExamResponseBody("No permission"));
        }
        try {
            if (examRequestBody.getQuestionIds() != null) examService.addExamWithQuestions(examRequestBody);
            else examService.addExamWithoutQuestion(examRequestBody);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(new ExamResponseBody("Cannot have null property"));
        }
        return ResponseEntity.ok(new ExamResponseBody("Success"));
    }

    @LoginRequired
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResponseEntity<?> modifyExam(@CurrentUser User user, @RequestBody ExamRequestBody examRequestBody) {
        if (!userRepository.findAuthorityById(user.getId()).equals("Admin")
                && !(userRepository.findAuthorityById(user.getId()).equals("Teacher")
                && classInfoService.getIdByTeacherid(teacherInfoService.findIdByName(user.getName())).contains(examRequestBody.getExam().getCourse()))) {
            return ResponseEntity.badRequest().body(new ExamResponseBody("No permission"));
        }
        try {
            examService.modifyExam(examRequestBody);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(new ExamResponseBody("Cannot have null property"));
        }
        return ResponseEntity.ok(new ExamResponseBody("Success"));
    }

    @LoginRequired
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<?> deleteExam(@CurrentUser User user, @RequestBody Integer id) {
        if (!userRepository.findAuthorityById(user.getId()).equals("Admin")
                && !(userRepository.findAuthorityById(user.getId()).equals("Teacher")
                && classInfoService.getIdByTeacherid(teacherInfoService.findIdByName(user.getName())).contains(examService.findExamById(id).getCourse()))) {
            return ResponseEntity.badRequest().body(new ExamResponseBody("No permission"));
        }
        if (!examService.deleteExam(id)) {
            return ResponseEntity.badRequest().body(new ExamResponseBody("No permission"));
        } else {
            return ResponseEntity.ok(new ExamResponseBody("Success"));
        }
    }
}
