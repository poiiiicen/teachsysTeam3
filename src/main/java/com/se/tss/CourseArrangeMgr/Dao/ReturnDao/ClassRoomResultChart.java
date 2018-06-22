package com.se.tss.CourseArrangeMgr.Dao.ReturnDao;

public class ClassRoomResultChart {
    private String place;
    private String roomNumber;
    private Integer capacity;
    private String className;
    private Integer weekday;
    private Integer timePeriod;
    private String teacherName;
    private String teacherId;
    private String classId;
    private String classRoomId;
    private String time;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public String getClassRoomId() {
        return classRoomId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setClassRoomId(String classRoomId) {
        this.classRoomId = classRoomId;
    }

    public String getClassId() {
        return classId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public Integer getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(Integer timePeriod) {
        this.timePeriod = timePeriod;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getClassName() {
        return className;
    }

    public String getPlace() {
        return place;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String format() {
        String day="";
        String segment="";
        switch(weekday){
            case 0: day="周一" ; break;
            case 1: day="周二" ; break;
            case 2: day="周三" ; break;
            case 3: day="周四" ; break;
            case 4: day="周五" ; break;
        }
        switch(timePeriod){
            case 0: segment="1，2节" ; break;
            case 1: segment="3，4，5节" ; break;
            case 2: segment="6，7，8节" ; break;
            case 3: segment="9，10节" ; break;
            case 4: segment="11，12，13节" ; break;
        }
        return day+segment;
    }
}
