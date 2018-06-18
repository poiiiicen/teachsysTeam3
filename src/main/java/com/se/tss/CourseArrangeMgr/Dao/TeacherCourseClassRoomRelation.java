package com.se.tss.CourseArrangeMgr.Dao;

import com.se.tss.CourseArrangeMgr.Dao.UniqueKey.TeacherCourseClassRoomRelationKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teacherCourseClassRoomRelation")
@IdClass(TeacherCourseClassRoomRelationKey.class)
public class TeacherCourseClassRoomRelation implements Serializable {
    @Id
    @Column(name = "teacherId")
    private String teacherId;
    @Id
    @Column(name = "courseId")
    private String courseId;
    @Id
    @Column(name = "classRoomId")
    private String classRoomId;
    @Id
    @Column(name = "weekday")
    private Integer weekday;
    @Id
    @Column(name = "timePeriod")
    private Integer timePeriod;

    public String getClassRoomId() {
        return classRoomId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setClassRoomId(String classRoomId) {
        this.classRoomId = classRoomId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    public void setTimePeriod(Integer timePeriod) {
        this.timePeriod = timePeriod;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public Integer getTimePeriod() {
        return timePeriod;
    }
}
