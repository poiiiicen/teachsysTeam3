package com.se.tss.ExamOnline.Domain;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    private Integer type;
    private ArrayList<String> choice;
    private Integer answer;
    private Boolean visible;

    public Integer getAnswer() { return answer; }

    public void setAnswer(Integer answer) { this.answer = answer; }

    public void setVisible(Boolean visible) { this.visible = visible; }
}
