package com.se.tss.CourseArrangeMgr.Controller;

import com.se.tss.CourseArrangeMgr.Dao.ClassRoomInfo;
import com.se.tss.CourseArrangeMgr.Dao.ReturnDao.CourseForList;
import com.se.tss.CourseArrangeMgr.Dao.TeacherCourseClassRoomRelation;
import com.se.tss.CourseArrangeMgr.Service.ClassInfoService;
import com.se.tss.CourseArrangeMgr.Service.ClassRoomInfoService;
import com.se.tss.CourseArrangeMgr.Service.TeacherCourseClassRoomRelationService;
import com.se.tss.CourseArrangeMgr.Service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Controller
@RestController
public class AutoArrange {

    @Autowired
    TeacherCourseClassRoomRelationService teacherCourseClassRoomRelationService;
    @Autowired
    TeacherInfoService teacherInfoService;
    @Autowired
    ClassRoomInfoService classRoomInfoService;
    @Autowired
    ClassInfoService classInfoService;

    @RequestMapping(value = "/CourseArrangeList", method = RequestMethod.POST)
    public List<CourseForList> CourseArrangeList(String name){
        List<CourseForList> courseList = new ArrayList<CourseForList>();
        String teacherId=teacherInfoService.findIdByName(name);
        List<TeacherCourseClassRoomRelation> teacherCourseClassRoomRelations = teacherCourseClassRoomRelationService.findAllByTeacherid(teacherId);
        for(TeacherCourseClassRoomRelation teacherCourseClassRoomRelation:teacherCourseClassRoomRelations){
            String classId=teacherCourseClassRoomRelation.getCourseid();
            String className = classInfoService.getNameById(classId);
            String classRoomId=teacherCourseClassRoomRelation.getClassroomid();
            int timePerid=teacherCourseClassRoomRelation.getTimeperiod();
            int weekday=teacherCourseClassRoomRelation.getWeekday();
            String teacherName=teacherInfoService.findNanme(teacherId);
            ClassRoomInfo classRoomInfo=classRoomInfoService.findOneById(classRoomId);
            String place=classRoomInfo.getPlace();
            String roomNumber=classRoomInfo.getRoomnumber();
            CourseForList courseForList =new CourseForList(teacherId,classId,classRoomId,weekday,timePerid,teacherName,place,roomNumber,className);
            courseList.add(courseForList);
        }
        return courseList;
    }

    @RequestMapping(value = "/CourseArrangeTable", method = RequestMethod.GET)
    public void CourseArrangeTable(String courseName){

    }
}
