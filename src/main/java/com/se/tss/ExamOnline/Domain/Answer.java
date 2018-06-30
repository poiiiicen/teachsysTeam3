package com.se.tss.ExamOnline.Domain;

import java.util.List;

public class Answer {
    private Integer examId;
    private List<Integer> answer;

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }
}
