package com.se.tss.ExamOnline.Controller;

import com.se.tss.ExamOnline.Domain.Question;
import com.se.tss.ExamOnline.Service.QuestionQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam/questions")
public class QuestionLibController {
    private final QuestionQueryService questionQueryService;

    @Autowired
    public QuestionLibController(QuestionQueryService questionQueryService) {this.questionQueryService = questionQueryService;}

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Hello, here is online exam";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Question> searchResult(Integer type, String description, String tag) {
        return questionQueryService.findQuestion(type, description, tag == null ? null : tag.split(" "));
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyQuestion(Integer id) {
        // TODO
        return "Success";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteQuestion(Integer id) {
        // TODO
        return "Success";
    }

}
