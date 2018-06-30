package com.se.tss.ExamOnline.Domain;

import com.fasterxml.jackson.annotation.JsonView;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String course;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Integer type;
    @Column(nullable = false)
    private ArrayList<String> choice;
    @Column(nullable = false)
    private Integer answer;
    @Column(nullable = false)
    private Boolean visible;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public ArrayList<String> getChoice() {
        return choice;
    }

    public void setChoice(ArrayList<String> choice) {
        this.choice = choice;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

}
