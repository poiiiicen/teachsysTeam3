package com.se.tss.CourseArrangeMgr.Dao.UniqueKey;

import java.io.Serializable;

public class TeacherCourseClassRoomRelationKey implements Serializable {
    private static final long serialVersionUID = 1L;
    private String teacherId;
    private String courseId;
    private String classRoomId;
    private Integer weekday;
    private Integer timePeriod;

    public TeacherCourseClassRoomRelationKey(){}

    public TeacherCourseClassRoomRelationKey(String teacherId,
                                             String courseId,
                                             String classRoomId,
                                             Integer weekday,
                                             Integer timePeriod){
        this.teacherId = teacherId;
        this.classRoomId = classRoomId;
        this.courseId = courseId;
        this.weekday = weekday;
        this.timePeriod = timePeriod;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setClassRoomId(String classRoomId) {
        this.classRoomId = classRoomId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getClassRoomId() {
        return classRoomId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getTimePeriod() {
        return timePeriod;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setTimePeriod(Integer timePeriod) {
        this.timePeriod = timePeriod;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || (!(obj instanceof TeacherCourseClassRoomRelationKey))){
            return false;
        }

        TeacherCourseClassRoomRelationKey other = (TeacherCourseClassRoomRelationKey)obj;
        if (other.classRoomId.equals(classRoomId)
                && other.courseId.equals(courseId)
                && other.teacherId.equals(teacherId)
                && other.timePeriod.equals(timePeriod)
                && other.weekday.equals(weekday)){
           return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (teacherId == null ? 0 : teacherId.hashCode());
        result = PRIME * result + (courseId == null ? 0 : courseId.hashCode());
        result = PRIME * result + (classRoomId ==null ? 0 : classRoomId.hashCode());
        result = PRIME * result + (timePeriod == null ? 0 : timePeriod.hashCode());
        result = PRIME * result + (weekday == null ? 0 : weekday.hashCode());
        return result;
    }
}
