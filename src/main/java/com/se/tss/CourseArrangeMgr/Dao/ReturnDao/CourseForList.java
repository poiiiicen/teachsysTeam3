package com.se.tss.CourseArrangeMgr.Dao.ReturnDao;

public class CourseForList {

    String teacherId;

    String classId;

    String classRoomId;

    int weekday;

    int timeperiod;

    String teacherName;

    String place;

    String roomNumber;

    CourseForList(){}

    public CourseForList(String teacherId, String classId, String classRoomId, int weekday,
                         int timeperiod, String teacherName, String place, String roomNumber) {
        this.teacherId = teacherId;
        this.classId = classId;
        this.classRoomId = classRoomId;
        this.weekday = weekday;
        this.timeperiod = timeperiod;
        this.teacherName = teacherName;
        this.place = place;
        this.roomNumber = roomNumber;
    }


    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(String classRoomId) {
        this.classRoomId = classRoomId;
    }

    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }

    public int getTimeperiod() {
        return timeperiod;
    }

    public void setTimeperiod(int timeperiod) {
        this.timeperiod = timeperiod;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }


    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

}
