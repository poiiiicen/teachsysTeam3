package com.se.tss.ExamOnline.Domain;

import javax.persistence.*;

@Entity
@Table(name = "testStudentCourse")
public class TestStudentCourse {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer Id;
    @Column(nullable = false)
    private Integer studentId;
    @Column(nullable = false)
    private String course;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
