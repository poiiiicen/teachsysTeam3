package com.se.tss.ExamOnline.Controller;

import com.se.tss.ExamOnline.Domain.Question;
import com.se.tss.ExamOnline.Repository.QuestionLibRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/onlineexam/questionlib")
public class QuestionLibController {
    private final QuestionLibRepository questionLibRepository;

    @Autowired
    public QuestionLibController(QuestionLibRepository questionLibRepository) {this.questionLibRepository = questionLibRepository;}

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Hello, here is online exam";
    }

    @RequestMapping(value = "/testlist", method = RequestMethod.GET)
    public List<Question> testlist() {
        return questionLibRepository.findAll();
    }
}
