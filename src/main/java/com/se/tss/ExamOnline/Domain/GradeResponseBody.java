package com.se.tss.ExamOnline.Domain;

public class GradeResponseBody {
    private String msg;
    private Double grade;

    public GradeResponseBody(String msg) {
        this.msg = msg;
        this.grade = 0.0;
    }

    public GradeResponseBody(String msg, Double grade) {
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
