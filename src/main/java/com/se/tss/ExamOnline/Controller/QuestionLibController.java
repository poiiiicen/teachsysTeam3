package com.se.tss.ExamOnline.Controller;

import com.alibaba.fastjson.JSONObject;
import com.se.tss.CourseArrangeMgr.Service.ClassInfoService;
import com.se.tss.CourseArrangeMgr.Service.TeacherInfoService;
import com.se.tss.ExamOnline.Domain.Question;
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
@RequestMapping("/exam/questions")
public class QuestionLibController {
    private final QuestionService questionService;
    private final ClassInfoService classInfoService;
    private final TeacherInfoService teacherInfoService;
    private final UserService userService; // TODO: Only used for add testing user, should be dropped.
    private final UserRepository userRepository; // TODO: Only used for add testing user, should be dropped.

    private final String[] authorityUser = {"Teacher", "Admin"};

    private Integer maxId;
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
        this.maxId = questionService.queryMaxId();
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
        if (course == null || !classInfoService.getIdByTeacherid(teacherInfoService.findIdByName(user.getName())).contains(course)) {
            return ResponseEntity.badRequest().body(new QuestionResponseBody(course == null ? "Need Course" : "No Such Course"));
        }
        List<Question> questions = questionService.findQuestion(type, description, tag == null ? null : tag.split(" "));
        return ResponseEntity.ok(new QuestionResponseBody(questions.isEmpty() ? "No Result" : "Success", questions));
    }

    @LoginRequired
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addQuestion(@CurrentUser User user, @RequestBody Question question) {
        if (!Arrays.asList(authorityUser).contains(userRepository.findAuthorityById(user.getId()))) {
            return ResponseEntity.badRequest().body(new QuestionResponseBody("Not Teacher or Admin"));
        }
        if (!classInfoService.getIdByTeacherid(teacherInfoService.findIdByName(user.getName())).contains(question.getCourse())) {
            return ResponseEntity.badRequest().body(new QuestionResponseBody("No permission"));
        }
        lock.lock();
        question.setId(maxId + 1);
        question.setVisible(true);
        try {
            questionService.addQuestion(question);
            maxId += 1;
        }
        catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(new QuestionResponseBody("Cannot have null value except id or visible"));
        }
        finally {
            lock.unlock();
        }
        return ResponseEntity.ok(new QuestionResponseBody("Success"));
    }

    @LoginRequired
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyQuestion(Integer id) {
        // TODO

        return "Success";
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
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void add() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "exam");
        jsonObject.put("password", "123456");
        jsonObject.put("age", 11);
        jsonObject.put("gender", Gender.male);
        jsonObject.put("phone", "123");
        userService.add(jsonObject);
    }

    private class QuestionResponseBody {
        private String msg;
        private List<Question> questions;

        QuestionResponseBody(String msg) {
            this.msg = msg;
            this.questions = new ArrayList<>();
        }

        QuestionResponseBody(String msg, List<Question> questions) {
            this.msg = msg;
            this.questions = questions;
        }

        public String getMsg() {
            return msg;
        }

        public List<Question> getQuestions() {
            return questions;
        }
    }
}
