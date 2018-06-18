package com.se.tss.CourseArrangeMgr.Dao;

import javax.persistence.*;

@Entity
@Table(name="class")
public class ClassInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(length=20, nullable = false)
    private String id;

    @Column(length=20, nullable = false)
    private String teacherid;

    @Column(length=20, nullable = false)
    private String name;

    @Column(nullable = false)
    private int length;

    @Column(length=64, nullable = true)
    private String  equipment;

    @Column(length=128, nullable = true)
    private String  classinfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherud(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getClassinfo() {
        return classinfo;
    }

    public void setClassinfo(String classinfo) {
        this.classinfo = classinfo;
    }
}
