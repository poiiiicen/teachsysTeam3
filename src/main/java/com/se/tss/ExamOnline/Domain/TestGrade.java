package com.se.tss.ExamOnline.Domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ExamGrade")
public class TestGrade {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private Integer examId;
    @Column(nullable = false)
    private Integer studentId;
    @Column(nullable = false)
    private List<Integer> answer;
    private Double grade;

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

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }
}
