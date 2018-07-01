package com.se.tss.ExamOnline.Controller;

import com.alibaba.fastjson.JSONObject;
import com.se.tss.CourseArrangeMgr.Service.ClassInfoService;
import com.se.tss.CourseArrangeMgr.Service.TeacherInfoService;
import com.se.tss.ExamOnline.Domain.Question;
import com.se.tss.ExamOnline.Domain.QuestionResponseBody;
import com.se.tss.ExamOnline.Service.QuestionService;
import com.se.tss.infomgr.annotation.CurrentUser;
import com.se.tss.infomgr.annotation.LoginRequired;
import com.se.tss.infomgr.model.Gender;
import com.se.tss.infomgr.model.User;
import com.se.tss.infomgr.model.UserRepository;
import com.se.tss.infomgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@CrossOrigin("*")
@RequestMapping("/exam/questions")
public class QuestionLibController {
    private final QuestionService questionService;
    private final ClassInfoService classInfoService;
    private final TeacherInfoService teacherInfoService;
    private final UserService userService; // TODO: Only used for add testing user, should be dropped.
    private final UserRepository userRepository;

    private final String[] authorityUser = {"Teacher", "Admin"};

    private Lock lock = new ReentrantLock();

    @Autowired
    public QuestionLibController(QuestionService questionService,
                                 ClassInfoService classInfoService,
                                 TeacherInfoService teacherInfoService,
                                 UserService userService,
                                 UserRepository userRepository) {
        this.questionService = questionService;
        this.classInfoService = classInfoService;
        this.teacherInfoService = teacherInfoService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Hello, here is online exam";
    }

    @LoginRequired
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<?> searchResult(@CurrentUser User user, String course, Integer type, String description, String tag) {
        if (!Arrays.asList(authorityUser).contains(userRepository.findAuthorityById(user.getId()))) {
            return ResponseEntity.badRequest().body(new QuestionResponseBody("Not Teacher or Admin"));
        }
        List<Question> questions = questionService.findQuestion(course, type, description, tag == null ? null : tag.split(" "));
        return ResponseEntity.ok(new QuestionResponseBody(questions.isEmpty() ? "No Result" : "Success", questions));
    }

    @LoginRequired
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addQuestion(@CurrentUser User user, @RequestBody Question question) {
        if (!Arrays.asList(authorityUser).contains(userRepository.findAuthorityById(user.getId()))) {
            return ResponseEntity.badRequest().body(new QuestionResponseBody("Not Teacher or Admin"));
        }
        if (question.getCourse() == null || !classInfoService.getIdByTeacherid(teacherInfoService.findIdByName(user.getName())).contains(question.getCourse())) {
            return ResponseEntity.badRequest().body(new QuestionResponseBody(question.getCourse() == null ? "Course cannot be null" : "No permission"));
        }
        lock.lock();
        try {
            questionService.addQuestion(question);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(new QuestionResponseBody("Cannot have null value except id or visible"));
        } finally {
            lock.unlock();
        }
        return ResponseEntity.ok(new QuestionResponseBody("Success"));
    }

    @LoginRequired
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResponseEntity<?> modifyQuestion(@CurrentUser User user, @RequestBody Question question) {
        // TODO
        if (!Arrays.asList(authorityUser).contains(userRepository.findAuthorityById(user.getId()))) {
            return ResponseEntity.badRequest().body(new QuestionResponseBody("Not Teacher or Admin"));
        }
        if (question.getId() == null
                || questionService.findCourseById(question.getId()) == null
                || !classInfoService.getIdByTeacherid(teacherInfoService.findIdByName(user.getName())).contains(questionService.findCourseById(question.getId()))) {
            return ResponseEntity.badRequest().body(new QuestionResponseBody(question.getId() == null ? "Need question" : questionService.findCourseById(question.getId()) == null ? "No such question" : "No permission"));
        }
        if (question.getCourse() == null || !classInfoService.getIdByTeacherid(teacherInfoService.findIdByName(user.getName())).contains(question.getCourse())) {
            return ResponseEntity.badRequest().body(new QuestionResponseBody(question.getCourse() == null ? "Course cannot be null" : "No permission"));
        }
        lock.lock();
        switch (questionService.modifyQuestion(question)) {
            case 0: {
                lock.unlock();
                return ResponseEntity.ok(new QuestionResponseBody("Success"));
            }
            case 1: {
                lock.unlock();
                return ResponseEntity.badRequest().body(new QuestionResponseBody("Already been deleted"));
            }
            case 2: {
                lock.unlock();
                return ResponseEntity.badRequest().body("Cannot have null value except id or visible");
            }
            default: {
                return ResponseEntity.ok(new QuestionResponseBody("Success"));
            }
        }
    }

    @LoginRequired
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<?> deleteQuestion(@CurrentUser User user, @RequestBody Integer id) {
        // TODO
        if (!Arrays.asList(authorityUser).contains(userRepository.findAuthorityById(user.getId()))) {
            return ResponseEntity.badRequest().body(new QuestionResponseBody("Not Teacher or Admin"));
        }
        if (id == null
                || questionService.findCourseById(id) == null
                || !classInfoService.getIdByTeacherid(teacherInfoService.findIdByName(user.getName())).contains(questionService.findCourseById(id))) {
            return ResponseEntity.badRequest().body(new QuestionResponseBody(id == null ? "Need question" : questionService.findCourseById(id) == null ? "No such question" : "No permission"));
        }
        if (questionService.deleteQuestionById(id))
            return ResponseEntity.ok(new QuestionResponseBody("Success"));
        else
            return ResponseEntity.badRequest().body(new QuestionResponseBody("Failed: Already been deleted"));
    }

    @Deprecated
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public void add() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "test");
        jsonObject.put("password", "123456");
        jsonObject.put("age", 11);
        jsonObject.put("gender", Gender.male);
        jsonObject.put("phone", "123");
        userService.add(jsonObject);
    }

}
