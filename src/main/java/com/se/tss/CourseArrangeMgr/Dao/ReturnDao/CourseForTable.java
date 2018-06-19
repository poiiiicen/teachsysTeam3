package com.se.tss.CourseArrangeMgr.Dao.ReturnDao;

public class CourseForTable {
    String teacherId;

    String classId;

    String classRoomId;

    int weekday;

    int timeperiod;

    String teacherName;

    String place;

    String roomNumber;

    String time;

    public CourseForTable(String teacherId, String classId, String classRoomId, int weekday,
                          int timeperiod, String teacherName, String place, String roomNumber) {
        this.teacherId = teacherId;
        this.classId = classId;
        this.classRoomId = classRoomId;
        this.weekday = weekday;
        this.timeperiod = timeperiod;
        this.teacherName = teacherName;
        this.place = place;
        this.roomNumber = roomNumber;
        this.time=format();
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String format() {
        String day="";
        String segment="";
        switch(weekday){
            case 1: day="周一" ; break;
            case 2: day="周二" ; break;
            case 3: day="周三" ; break;
            case 4: day="周四" ; break;
            case 5: day="周五" ; break;
        }
        switch(timeperiod){
            case 1: segment="1，2节" ; break;
            case 2: segment="3，4，5节" ; break;
            case 3: segment="6，7，8节" ; break;
            case 4: segment="9，10节" ; break;
            case 5: segment="11，12，13节" ; break;
        }
        return day+segment;
    }

}
