package com.se.tss.ExamOnline.Domain;

import java.util.ArrayList;

public class Answer {
    private Integer examId;
    private ArrayList<Integer> answer;
    private Boolean commit;

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public ArrayList<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<Integer> answer) {
        this.answer = answer;
    }

    public Boolean getCommit() {
        return commit;
    }

    public void setCommit(Boolean commit) {
        this.commit = commit;
    }
}
