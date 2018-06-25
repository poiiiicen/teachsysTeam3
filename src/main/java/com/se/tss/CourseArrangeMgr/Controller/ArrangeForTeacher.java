package com.se.tss.CourseArrangeMgr.Controller;

import com.se.tss.CourseArrangeMgr.Dao.ReturnDao.CourseForList;
import com.se.tss.CourseArrangeMgr.Dao.TeacherCourseClassRoomRelation;
import com.se.tss.CourseArrangeMgr.Service.ClassInfoService;
import com.se.tss.CourseArrangeMgr.Service.ClassRoomInfoService;
import com.se.tss.CourseArrangeMgr.Service.TeacherCourseClassRoomRelationService;
import com.se.tss.CourseArrangeMgr.Service.TeacherInfoService;
import com.se.tss.CourseArrangeMgr.logic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@Controller
@RestController
public class ArrangeForTeacher {

    @Autowired
    CourseForTeacherLogic courseForTeacherLogic;
    @Autowired
    ClassRoomInfoService classRoomInfoService;
    @Autowired
    AddLogic addLogic;
    @Autowired
    DeleteLogic deleteLogic;
    @Autowired
    FeasibilityLogic feasibilityLogic;
    @Autowired
    TimeTransformLogic timeTransformLogic;
    @Autowired
    TeacherInfoService teacherInfoService;
    @Autowired
    ClassInfoService classInfoService;
    @Autowired
    ArrangeClassLogic arrangeClassLogic;
    @Autowired
    TeacherCourseClassRoomRelationService teacherCourseClassRoomRelationService;

    @RequestMapping(value = "/CourseForTeacherList", method = RequestMethod.GET)
    public List<CourseForList> CourseArrangeList(String name){
        return courseForTeacherLogic.CourseArrangeList(name);
    }

    @RequestMapping(value = "/CourseForTeacherUpdate", method = RequestMethod.POST)
    public List<CourseForList> TeacherUpdate(String teacherId,String courseId, String place,
                                             String roomNumber,String time,String name,String roomId){
        Map<String, Integer> timeMap=timeTransformLogic.transformTime(time);
        int weekday=timeMap.get("weekday");
        int period=timeMap.get("timeperiod");
        String classRoomId=classRoomInfoService.getIdByPlaceAndRoomNumber(place,roomNumber);
        TeacherCourseClassRoomRelation old =teacherCourseClassRoomRelationService.findOneByClassroomidAndTeacheridAndCourseid(classRoomId,teacherId,courseId);
        deleteLogic.Delete(teacherId,courseId,roomId);
        String result=feasibilityLogic.Feasibility(teacherId,courseId,classRoomId,weekday,period);
        if(!result.equals("")){
            teacherCourseClassRoomRelationService.doInsert(teacherId, courseId, roomId, old.getWeekday(), old.getWeekday());
            List<CourseForList> list=courseForTeacherLogic.CourseArrangeList(name);
            if(list.isEmpty()){
                list.add(new CourseForList());
            }
            list.get(list.size()-1).setStatus(result);
            return  list;
        }
        addLogic.Add(teacherId,courseId,classRoomId,weekday,period);
        return courseForTeacherLogic.CourseArrangeList(name);
    }

    @RequestMapping(value = "/CourseForTeacherDelete", method = RequestMethod.POST)
    public List<CourseForList> TeacherDelete(String teacherId,String courseId, String place,
                                             String roomNumber,String time,String name,String roomId){
        deleteLogic.Delete(teacherId,courseId,roomId);
        return courseForTeacherLogic.CourseArrangeList(name);
    }

    @RequestMapping(value = "/CourseForTeacherAdd", method = RequestMethod.POST)
    public List<CourseForList> TeacherAdd(String teacherName,String courseName, String place,
                                             String roomNumber,String time){
        String teacherId=teacherInfoService.findIdByName(teacherName);
        String courseId=classInfoService.getIdByTeacherIdAndName(teacherId,courseName);
        String classRoomId=classRoomInfoService.getIdByPlaceAndRoomNumber(place,roomNumber);
        Map<String, Integer> timeMap=timeTransformLogic.transformTime(time);
        int weekday=timeMap.get("weekday");
        int period=timeMap.get("timeperiod");
        String result=feasibilityLogic.Feasibility(teacherId,courseId,classRoomId,weekday,period);
        if(!result.equals("")){
            List<CourseForList> list=courseForTeacherLogic.CourseArrangeList(teacherName);
            if(list.isEmpty()){
                list.add(new CourseForList());
            }
            list.get(list.size()-1).setStatus(result);
            return  list;
        }
        addLogic.Add(teacherId,courseId,classRoomId,weekday,period);
        return courseForTeacherLogic.CourseArrangeList(teacherName);
    }

    @RequestMapping(value = "/ArrangeCourse", method = RequestMethod.GET)
    public String ArrangeCourse(){
        try{
            teacherCourseClassRoomRelationService.DeleteAll();
            arrangeClassLogic.Arrange();
            return "success!";
        }catch (Exception e){
            return  "fail!";
        }


    }

}
