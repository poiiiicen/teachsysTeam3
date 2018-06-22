package com.se.tss.CourseArrangeMgr.Controller;


import com.se.tss.CourseArrangeMgr.Dao.ClassInfo;
import com.se.tss.CourseArrangeMgr.Dao.ClassRoomInfo;
import com.se.tss.CourseArrangeMgr.Dao.TeacherInfo;
import com.se.tss.CourseArrangeMgr.Service.ClassInfoService;
import com.se.tss.CourseArrangeMgr.Service.ClassRoomInfoService;
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
public class TableController {

    @Autowired
    ClassRoomInfoService classRoomInfoService;
    @Autowired
    TeacherInfoService teacherInfoService;
    @Autowired
    ClassInfoService classInfoService;

    @RequestMapping(value = "/AllClassRoom", method = RequestMethod.GET)
    public List<ClassRoomInfo> AllClassRoom(String place){
        return classRoomInfoService.findByPlace(place);
    }

    @RequestMapping(value = "/AllTeacher", method = RequestMethod.GET)
    public List<TeacherInfo> AllTeacher(){
        return teacherInfoService.findAll();
    }

    @RequestMapping(value = "/AllCourse", method = RequestMethod.GET)
    public List<ClassInfo> AllCourse(){
        return classInfoService.findAll();
    }

    @RequestMapping(value = "/AllCourseByTeacherName", method = RequestMethod.GET)
    public List<ClassInfo> AllCourseByTeacherName(String name){
        String id=teacherInfoService.findIdByName(name);
        return classInfoService.findAllByTeacherId(id);
    }

    @RequestMapping(value = "/AllTeacherForOneCourse", method = RequestMethod.GET)
    public List<String> AllTeacherForOneCourse(String courseName){
        List<String> teacherId=classInfoService.findAllByName(courseName);
        List<String> teacherName=new ArrayList<>();
        for(String s:teacherId){
            String ss=teacherInfoService.findNanme(s);
            if(ss!=null)
                teacherName.add(ss);
        }
        return  teacherName;
    }
}
