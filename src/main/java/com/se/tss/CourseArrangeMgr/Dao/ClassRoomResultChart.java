package com.se.tss.CourseArrangeMgr.Dao;

public class ClassRoomResultChart {
    private String place;
    private String roomNumber;
    private Integer capacity;
    private String className;
    private Integer weekday;
    private Integer timePeriod;
    private String teacherName;

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
}
