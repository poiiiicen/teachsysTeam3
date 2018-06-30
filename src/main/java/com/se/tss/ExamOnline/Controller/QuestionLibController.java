package com.se.tss.ExamOnline.Controller;

import com.alibaba.fastjson.JSONObject;
import com.se.tss.CourseArrangeMgr.Service.ClassInfoService;
import com.se.tss.CourseArrangeMgr.Service.TeacherInfoService;
import com.se.tss.ExamOnline.Domain.Question;
import com.se.tss.ExamOnline.Service.QuestionQueryService;
import com.se.tss.infomgr.annotation.CurrentUser;
import com.se.tss.infomgr.annotation.LoginRequired;
import com.se.tss.infomgr.model.Gender;
import com.se.tss.infomgr.model.Teacher;
import com.se.tss.infomgr.model.User;
import com.se.tss.infomgr.model.UserRepository;
import com.se.tss.infomgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/exam/questions")
public class QuestionLibController {
    private final QuestionQueryService questionQueryService;
    private final ClassInfoService classInfoService;
    private final TeacherInfoService teacherInfoService;
    private final UserService userService; // TODO: Only used for add testing user, should be dropped.
    private final UserRepository userRepository; // TODO: Only used for add testing user, should be dropped.

    private final String[] authorityUser = {"Teacher", "Admin"};

    @Autowired
    public QuestionLibController(QuestionQueryService questionQueryService,
                                 ClassInfoService classInfoService,
                                 TeacherInfoService teacherInfoService,
                                 UserService userService,
                                 UserRepository userRepository) {
        this.questionQueryService = questionQueryService;
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
        if (course == null || !classInfoService.getIdByTeacherid(teacherInfoService.findIdByName(user.getName())).contains(course)) {
            return ResponseEntity.badRequest().body(new QuestionResponseBody(course == null ? "Need Course": "No Such Course"));
        }
        List<Question> questions = questionQueryService.findQuestion(type, description, tag == null ? null : tag.split(" "));
        return ResponseEntity.ok(new QuestionResponseBody(questions.isEmpty() ? "No Result" : "Success", questions));
    }

    @LoginRequired
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyQuestion(Integer id) {
        // TODO
        return "Success";
    }

    @LoginRequired
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteQuestion(Integer id) {
        // TODO
        return "Success";
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
