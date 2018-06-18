package com.se.tss.CourseArrangeMgr.Dao;

import javax.persistence.*;

@Entity
@Table(name="teacher")
public class TeacherInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(length=20, nullable = false)
    private String id;

    @Column(length=20, nullable = false)
    private String name;

    @Column(length=20, nullable = false)
    private String  place;  //校区

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
