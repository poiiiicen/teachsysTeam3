package com.se.tss.CourseArrangeMgr.Controller;

import com.se.tss.CourseArrangeMgr.Dao.ReturnDao.ClassRoomResultChart;
import com.se.tss.CourseArrangeMgr.logic.ClassRoomResultChartLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class ClassRoomResultController {
    @Autowired
    ClassRoomResultChartLogic classRoomResultChartLogic;

    @RequestMapping(value = "/CourseForClassroomList", method = RequestMethod.GET)
    public List<ClassRoomResultChart> getClassRoomChart(@RequestParam("place") String place,
                                                        @RequestParam("roomNumber") String roomNumber) {
        return classRoomResultChartLogic.getClassRoomResultChartList(place, roomNumber);
    }

    @RequestMapping(value = "/CourseForClassroomAdd", method = RequestMethod.POST)
    public List<ClassRoomResultChart> classroomCourseAdd(@RequestParam("place") String place,
                                                         @RequestParam("roomNumber") String roomNumber,
                                                         @RequestParam("courseName") String courseName,
                                                         @RequestParam("teacherName") String teacherName,
                                                         @RequestParam("time") String time){
        return classRoomResultChartLogic.addCourse(place, roomNumber, courseName, teacherName, time);
    }

    @RequestMapping(value = "/CourseForClassroomDelete", method = RequestMethod.POST)
    public List<ClassRoomResultChart> classroomCourseDelete(@RequestParam("place") String place,
                                                            @RequestParam("roomNumber") String roomNumber,
                                                            @RequestParam("roomId") String roomId,
                                                            @RequestParam("courseId") String courseId,
                                                            @RequestParam("teacherId") String teacherId){
        return classRoomResultChartLogic.deleteCourse(place, roomNumber, roomId, courseId, teacherId);
    }

    @RequestMapping(value = "/CourseForClassroomUpdate", method = RequestMethod.POST)
    public List<ClassRoomResultChart> classroomCourseUpdate(@RequestParam("roomId") String roomId,
                                                            @RequestParam("courseId") String courseId,
                                                            @RequestParam("teacherId") String teacherId,
                                                            @RequestParam("time") String time,
                                                            @RequestParam("place") String place,
                                                            @RequestParam("roomNumber") String roomNumber){
        return classRoomResultChartLogic.updateCourse(place, roomNumber, roomId, courseId, teacherId, time);
    }
}
