package com.se.tss.CourseArrangeMgr.Controller;

import com.se.tss.CourseArrangeMgr.Dao.ReturnDao.CourseForList;
import com.se.tss.CourseArrangeMgr.Service.ClassRoomInfoService;
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

    @RequestMapping(value = "/CourseForTeacherList", method = RequestMethod.GET)
    public List<CourseForList> CourseArrangeList(String name){
        return courseForTeacherLogic.CourseArrangeList(name);
    }

    @RequestMapping(value = "/CourseForTeacherUpdate", method = RequestMethod.POST)
    public List<CourseForList> TeacherUpdate(String teacherId,String courseId, String place,
                                             String roomNumber,String time,String name){
        Map<String, Integer> timeMap=timeTransformLogic.transformTime(time);
        int weekday=timeMap.get("weekday");
        int period=timeMap.get("timeperiod");
        System.out.println(weekday);
        System.out.println(period);
        String classRoomId=classRoomInfoService.getIdByPlaceAndRoomNumber(place,roomNumber);
        System.out.println(classRoomId);
        String result=feasibilityLogic.Feasibility(teacherId,courseId,classRoomId,weekday,period);
        System.out.println(result);
        if(!result.equals("")){
            List<CourseForList> list=courseForTeacherLogic.CourseArrangeList(name);
            CourseForList courseForList=new CourseForList();
            courseForList.setStatus(result);
            list.add(courseForList);
            return  list;
        }
        deleteLogic.Delete(teacherId,courseId,classRoomId);
        addLogic.Add(teacherId,courseId,classRoomId,weekday,period);
        return courseForTeacherLogic.CourseArrangeList(name);
    }

    @RequestMapping(value = "/CourseForTeacherDelete", method = RequestMethod.POST)
    public List<CourseForList> TeacherDelete(String teacherId,String courseId, String place,
                                             String roomNumber,String time,String name){
        int weekday=0;
        int period=0;
        String classRoomId=classRoomInfoService.getIdByPlaceAndRoomNumber(place,roomNumber);
        deleteLogic.Delete(teacherId,courseId,classRoomId);
        return courseForTeacherLogic.CourseArrangeList(name);
    }

}
