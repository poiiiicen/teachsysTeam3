package com.se.tss.CourseArrangeMgr.logic;

import com.se.tss.CourseArrangeMgr.Dao.*;
import com.se.tss.CourseArrangeMgr.Dao.ReturnDao.ClassRoomResultChart;
import com.se.tss.CourseArrangeMgr.Service.ClassInfoService;
import com.se.tss.CourseArrangeMgr.Service.ClassRoomInfoService;
import com.se.tss.CourseArrangeMgr.Service.TeacherCourseClassRoomRelationService;
import com.se.tss.CourseArrangeMgr.Service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Configuration
public class ClassRoomResultChartLogic {

    @Autowired
    ClassRoomInfoService classRoomInfoService;

    @Autowired
    TeacherCourseClassRoomRelationService teacherCourseClassRoomRelationService;

    @Autowired
    ClassInfoService classInfoService;

    @Autowired
    TeacherInfoService teacherInfoService;
    public List<ClassRoomResultChart> getClassRoomResultChartList(final String place, final String roomNumber){
        List<ClassRoomResultChart> classRoomResultChartList = new ArrayList<>();
        ClassRoomInfo classRoomInfo = classRoomInfoService.findOneByPlaceAndRoomnumber(place, roomNumber);
        if(classRoomInfo == null)
            return Collections.emptyList();
        List<TeacherCourseClassRoomRelation> teacherCourseClassRoomRelations
                = teacherCourseClassRoomRelationService.findAllByClassroomid(classRoomInfo.getId());
        for(TeacherCourseClassRoomRelation relation : teacherCourseClassRoomRelations){
            ClassInfo classInfo = classInfoService.findOneById(relation.getCourseid());
            TeacherInfo teacherInfo = teacherInfoService.findTeacherInfoById(relation.getTeacherid());
            if(classInfo == null || teacherInfo == null){
                continue;
            }
            ClassRoomResultChart cell = new ClassRoomResultChart();
            cell.setCapacity(classRoomInfo.getCapacity());
            cell.setPlace(place);
            cell.setRoomNumber(roomNumber);
            cell.setTeacherName(teacherInfo.getName());
            cell.setTimePeriod(relation.getTimeperiod());
            cell.setWeekday(relation.getWeekday());
            cell.setClassName(classInfo.getName());
            cell.setClassId(classInfo.getId());
            cell.setTeacherId(teacherInfo.getId());
            cell.setClassRoomId(classRoomInfo.getId());
            classRoomResultChartList.add(cell);
        }
        return classRoomResultChartList;
    }
}
