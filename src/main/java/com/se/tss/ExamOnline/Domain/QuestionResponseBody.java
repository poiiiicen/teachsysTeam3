package com.se.tss.ExamOnline.Domain;

import java.util.ArrayList;
import java.util.List;

public class QuestionResponseBody {
    private String msg;
    private List<Question> questions;

    public QuestionResponseBody(String msg) {
        this.msg = msg;
        this.questions = new ArrayList<>();
    }

    public QuestionResponseBody(String msg, List<Question> questions) {
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
