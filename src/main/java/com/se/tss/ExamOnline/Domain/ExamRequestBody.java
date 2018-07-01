package com.se.tss.ExamOnline.Domain;

import java.util.List;

public class ExamRequestBody {
    private Exam exam;
    private List<Integer> questionIds;
    private Integer selectionNum;
    private Integer judgementNum;

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public List<Integer> getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(List<Integer> questionIds) {
        this.questionIds = questionIds;
    }

    public Integer getJudgementNum() {
        return judgementNum;
    }

    public void setJudgementNum(Integer judgementNum) {
        this.judgementNum = judgementNum;
    }

    public Integer getSelectionNum() {
        return selectionNum;
    }

    public void setSelectionNum(Integer selectionNum) {
        this.selectionNum = selectionNum;
    }
}
