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
    public List<ClassRoomInfo> AllClassRoom(){
        return classRoomInfoService.findAll();
    }

    @RequestMapping(value = "/AllTeacher", method = RequestMethod.GET)
    public List<TeacherInfo> AllTeacher(){
        return teacherInfoService.findAll();
    }

    @RequestMapping(value = "/AllCourse", method = RequestMethod.GET)
    public List<ClassInfo> AllCourse(){
        return classInfoService.findAll();
    }

    @RequestMapping(value = "/AllCourseByTeacherId", method = RequestMethod.GET)
    public List<ClassInfo> AllCourseByTeacherId(String teacherId){
        return classInfoService.findAllByTeacherId(teacherId);
    }
}
