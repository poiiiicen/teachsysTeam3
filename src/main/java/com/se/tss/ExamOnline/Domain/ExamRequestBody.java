package com.se.tss.ExamOnline.Domain;

import java.util.List;

public class ExamRequestBody {
    private Exam exam;
    private List<Integer> questionIds;
    private Integer selectionNum;
    private Integer jugementNum;

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

    public Integer getJugementNum() {
        return jugementNum;
    }

    public void setJugementNum(Integer jugementNum) {
        this.jugementNum = jugementNum;
    }

    public Integer getSelectionNum() {
        return selectionNum;
    }

    public void setSelectionNum(Integer selectionNum) {
        this.selectionNum = selectionNum;
    }
}
