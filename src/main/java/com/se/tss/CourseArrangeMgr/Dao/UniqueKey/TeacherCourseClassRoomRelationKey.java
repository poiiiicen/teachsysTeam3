package com.se.tss.CourseArrangeMgr.Dao.UniqueKey;

import java.io.Serializable;

public class TeacherCourseClassRoomRelationKey implements Serializable {
    private static final long serialVersionUID = 1L;
    private String teacherid;
    private String courseid;
    private String classroomid;
    private Integer weekday;
    private Integer timeperiod;

    public TeacherCourseClassRoomRelationKey(){}

    public TeacherCourseClassRoomRelationKey(String teacherid,
                                             String courseid,
                                             String classroomid,
                                             Integer weekday,
                                             Integer timeperiod){
        this.teacherid = teacherid;
        this.classroomid = classroomid;
        this.courseid = courseid;
        this.weekday = weekday;
        this.timeperiod = timeperiod;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    public Integer getTimeperiod() {
        return timeperiod;
    }

    public String getClassroomid() {
        return classroomid;
    }

    public String getCourseid() {
        return courseid;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setClassroomid(String classroomid) {
        this.classroomid = classroomid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public void setTimeperiod(Integer timeperiod) {
        this.timeperiod = timeperiod;
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
        if (other.classroomid.equals(classroomid)
                && other.courseid.equals(courseid)
                && other.teacherid.equals(teacherid)
                && other.timeperiod.equals(timeperiod)
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
        result = PRIME * result + (teacherid == null ? 0 : teacherid.hashCode());
        result = PRIME * result + (courseid == null ? 0 : courseid.hashCode());
        result = PRIME * result + (classroomid ==null ? 0 : classroomid.hashCode());
        result = PRIME * result + (timeperiod == null ? 0 : timeperiod.hashCode());
        result = PRIME * result + (weekday == null ? 0 : weekday.hashCode());
        return result;
    }
}
