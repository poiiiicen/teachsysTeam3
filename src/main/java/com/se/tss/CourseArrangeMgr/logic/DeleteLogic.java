package com.se.tss.CourseArrangeMgr.logic;


import com.se.tss.CourseArrangeMgr.Service.TeacherCourseClassRoomRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class DeleteLogic {
    //增加某一个教室某一个时间段上课的信息
    //需要对数据库做修改
    //为主逻辑提供方法
    @Autowired
    TeacherCourseClassRoomRelationService teacherCourseClassRoomRelationService;

    public void Delete(String teacherId,String courseId,String classRoomId){
        teacherCourseClassRoomRelationService.doDelete(teacherId,courseId,classRoomId);
    }


}
