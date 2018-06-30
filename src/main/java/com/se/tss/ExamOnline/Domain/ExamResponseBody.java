package com.se.tss.ExamOnline.Domain;

import java.util.ArrayList;
import java.util.List;

public class ExamResponseBody {
    private String msg;
    private List<Exam> exams;

    public ExamResponseBody(String msg) {
        this.msg = msg;
        this.exams = new ArrayList<>();
    }

    public ExamResponseBody(String msg, List<Exam> exams) {
        this.msg = msg;
        this.exams = exams;
    }

    public String getMsg() {
        return msg;
    }

    public List<Exam> getExams() {
        return exams;
    }
}
