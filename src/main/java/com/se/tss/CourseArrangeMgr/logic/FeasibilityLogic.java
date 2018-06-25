package com.se.tss.CourseArrangeMgr.logic;

import com.se.tss.CourseArrangeMgr.Dao.ClassInfo;
import com.se.tss.CourseArrangeMgr.Dao.ClassRoomInfo;
import com.se.tss.CourseArrangeMgr.Dao.TeacherCourseClassRoomRelation;
import com.se.tss.CourseArrangeMgr.Service.ClassInfoService;
import com.se.tss.CourseArrangeMgr.Service.ClassRoomInfoService;
import com.se.tss.CourseArrangeMgr.Service.TeacherCourseClassRoomRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Configuration
public class FeasibilityLogic {

    @Autowired
    private ClassInfoService classInfoService;

    @Autowired
    private ClassRoomInfoService classRoomInfoService;

    @Autowired
    private TeacherCourseClassRoomRelationService teacherCourseClassRoomRelationService;
    //在某一个教室的某一个时间段插入一门课程是否可行逻辑检验
    public String Feasibility(String teacherId, String courseId, String classRoomId,
                              int weekday,  //一周五天可上课
                              int timePeriod) ////每天5个时间段，有的时间段是两节课，有的三节课
    {

        //course 要求和 classRoom 是否冲突
        ClassRoomInfo classRoomInfo = classRoomInfoService.findOneById(classRoomId);
        ClassInfo classInfo = classInfoService.findOneById(courseId);
        if(classInfo.getEquipment() != null){
            if(!classInfo.getEquipment().equals(classRoomInfo.getEquipment()))
                return "教室的设备无法满足课程需求";
        }

        //教师时间是否冲突
        List<TeacherCourseClassRoomRelation> relations = teacherCourseClassRoomRelationService.findAllByTeacherid(teacherId);
        for(TeacherCourseClassRoomRelation relation : relations){
            if(relation.getWeekday().equals(weekday) && relation.getTimeperiod().equals(timePeriod)){
                return "教师时间冲突";
            } else if(relation.getCourseid().equals(courseId)){
                return "已经存在这门课了";
            }
        }
        relations = teacherCourseClassRoomRelationService.findAllByCourseid(courseId);
        for(TeacherCourseClassRoomRelation relation : relations){
            if(relation.getWeekday().equals(weekday) && relation.getTimeperiod().equals(timePeriod)){
                return "教室时间冲突";
            }
        }
        return ""; //可行返回空串
    }
}
