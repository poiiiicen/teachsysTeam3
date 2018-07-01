package com.se.tss.ExamOnline.Domain;

public class TestResponseBody {
    private String msg;
    private Double grade;

    public TestResponseBody(String msg) {
        this.msg = msg;
        this.grade = 0.0;
    }

    public TestResponseBody(String msg, Double grade) {
        this.msg = msg;
        this.grade = grade;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
