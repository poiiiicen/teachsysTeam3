package com.se.tss.ExamOnline.Domain;

import javax.persistence.*;

@Entity
@Table(name = "ExamQuestion")
public class ExamQuestion {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private Integer questionId;
    @Column(nullable = false)
    private Integer examId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}
