package com.se.tss.CourseArrangeMgr.logic;

import com.se.tss.CourseArrangeMgr.Dao.*;
import com.se.tss.CourseArrangeMgr.Dao.ReturnDao.ClassRoomResultChart;
import com.se.tss.CourseArrangeMgr.Dao.ReturnDao.CourseForList;
import com.se.tss.CourseArrangeMgr.Service.ClassInfoService;
import com.se.tss.CourseArrangeMgr.Service.ClassRoomInfoService;
import com.se.tss.CourseArrangeMgr.Service.TeacherCourseClassRoomRelationService;
import com.se.tss.CourseArrangeMgr.Service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
    FeasibilityLogic feasibilityLogic;

    @Autowired
    TeacherInfoService teacherInfoService;

    @Autowired
    TimeTransformLogic timeTransformLogic;

    @Autowired
    DeleteLogic deleteLogic;
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
            cell.setTime(cell.format());
            classRoomResultChartList.add(cell);
        }
        return classRoomResultChartList;
    }

    public List<ClassRoomResultChart> addCourse( String place, String roomNumber,String courseName,String teacherName, String time){
        String teacherId=teacherInfoService.findIdByName(teacherName);
        String courseId=classInfoService.getIdByTeacherIdAndName(teacherId,courseName);
        String classRoomId=classRoomInfoService.getIdByPlaceAndRoomNumber(place,roomNumber);
        Map<String, Integer> timeMap=timeTransformLogic.transformTime(time);
        int weekday=timeMap.get("weekday");
        int period=timeMap.get("timeperiod");
        String result=feasibilityLogic.Feasibility(teacherId,courseId,classRoomId,weekday,period);
        if(!result.equals("")){
            List<ClassRoomResultChart> list = getClassRoomResultChartList(place,roomNumber);
            if(list.isEmpty()){
                list.add(new ClassRoomResultChart());
            }
            list.get(list.size()-1).setStatus(result);
            return list;
        }
        teacherCourseClassRoomRelationService.doInsert(teacherId, courseId, classRoomId, weekday, period);
        return getClassRoomResultChartList(place, roomNumber);
    }

    public List<ClassRoomResultChart> deleteCourse(String place, String roomNumber, String classroomId, String courseId, String teacherId){
        deleteLogic.Delete(teacherId,courseId, classroomId);
        return getClassRoomResultChartList(place, roomNumber);
    }

    public List<ClassRoomResultChart> updateCourse(String place, String roomNumber, String roomId, String courseId, String teacherId, String time){

        TeacherCourseClassRoomRelation teacherCourseClassRoomRelation = teacherCourseClassRoomRelationService.findOneByClassroomidAndTeacheridAndCourseid(roomId, teacherId, courseId);
        teacherCourseClassRoomRelationService.doDelete(teacherId, courseId, roomId);
        Map<String, Integer> timeMap=timeTransformLogic.transformTime(time);
        int weekday=timeMap.get("weekday");
        int period=timeMap.get("timeperiod");
        String result=feasibilityLogic.Feasibility(teacherId,courseId,roomId,weekday,period);
        if(!result.equals("")){
            teacherCourseClassRoomRelationService.doInsert(teacherId, courseId, roomId, teacherCourseClassRoomRelation.getWeekday(), teacherCourseClassRoomRelation.getWeekday());
            List<ClassRoomResultChart> list = getClassRoomResultChartList(place,roomNumber);
            if(list.isEmpty()){
                list.add(new ClassRoomResultChart());
            }
            list.get(list.size()-1).setStatus(result);
            return list;
        }
        teacherCourseClassRoomRelationService.doInsert(teacherId, courseId, roomId, weekday, period);
        return getClassRoomResultChartList(place, roomNumber);
    }

}
