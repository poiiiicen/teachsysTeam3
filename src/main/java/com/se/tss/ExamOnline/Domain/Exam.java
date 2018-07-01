package com.se.tss.ExamOnline.Domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Exam")
public class Exam {
    @Id
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String course;
    @Column(nullable = false)
    private Date startTime;
    @Column(nullable = false)
    private Date endTime;
    @Column(nullable = false)
    private Double selectionGrade;
    @Column(nullable = false)
    private Double judgementGrade;
    @Column(nullable = false)
    private Boolean publish;
    @Column(nullable = false)
    private Boolean over;
    @Column(nullable = false)
    private Boolean visible;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    public Double getJudgementGrade() {
        return judgementGrade;
    }

    public void setJudgementGrade(Double judgementGrade) {
        this.judgementGrade = judgementGrade;
    }

    public Double getSelectionGrade() {
        return selectionGrade;
    }

    public void setSelectionGrade(Double selectionGrade) {
        this.selectionGrade = selectionGrade;
    }

    public Boolean getPublish() {
        return publish;
    }

    public void setPublish(Boolean publish) {
        this.publish = publish;
    }

    public boolean getOver() {
        return over;
    }

    public void setOver(Boolean over) {
        this.over = over;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

}
