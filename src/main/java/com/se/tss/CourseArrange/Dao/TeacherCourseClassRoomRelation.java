package com.se.tss.CourseArrange.Dao;

import com.se.tss.CourseArrange.Dao.UniqueKey.TeacherCourseClassRoomRelationKey;

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
    @Column(name = "time")
    private String time;

    public String getClassRoomId() {
        return classRoomId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getTime() {
        return time;
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

    public void setTime(String time) {
        this.time = time;
    }

}
