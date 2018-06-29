package com.se.tss.CourseArrangeMgr.Dao;

import com.se.tss.CourseArrangeMgr.Dao.UniqueKey.TeacherCourseClassRoomRelationKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teacher_course_class_room_relation")
@IdClass(TeacherCourseClassRoomRelationKey.class)
public class TeacherCourseClassRoomRelation implements Serializable {
    @Id
    @Column(name = "teacherid")
    private String teacherid;
    @Id
    @Column(name = "courseid")
    private String courseid;
    @Id
    @Column(name = "classroomid")
    private String classroomid;
    @Id
    @Column(name = "weekday")
    private Integer weekday;
    @Id
    @Column(name = "timeperiod")
    private Integer timeperiod;

    public void setTimeperiod(Integer timeperiod) {
        this.timeperiod = timeperiod;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public void setClassroomid(String classroomid) {
        this.classroomid = classroomid;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public String getCourseid() {
        return courseid;
    }

    public String getClassroomid() {
        return classroomid;
    }

    public Integer getTimeperiod() {
        return timeperiod;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }
}
