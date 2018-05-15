package com.se.tss.Public;

import javax.persistence.*;

@Entity
@Table(name="Post")
public class Post{
    @Id
    @Column(name="title")
    private String title;
    @Column(name = "creator")
    private  String creator;
    @Column(name = "context")
    private  String context;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCreatord() { return creator; }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public String getContext() { return context; }
    public void setContext(String context) {
        this.context = context;
    }

}