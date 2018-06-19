package com.se.tss.CourseArrangeMgr.Service;

import com.se.tss.CourseArrangeMgr.Dao.ClassRoomInfo;
import com.se.tss.CourseArrangeMgr.Dao.ReturnDao.CourseForList;
import com.se.tss.CourseArrangeMgr.Dao.TeacherCourseClassRoomRelation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherCourseForListClassRoomRelationServiceTest {
    @Autowired
    TeacherCourseClassRoomRelationService teacherCourseClassRoomRelationService;
    @Autowired
    TeacherInfoService teacherInfoService;
    @Autowired
    ClassRoomInfoService classRoomInfoService;
    @Autowired
    ClassInfoService classInfoService;

    @Test
    public void test(){
        String teacherId="0123";
        List<TeacherCourseClassRoomRelation> list=teacherCourseClassRoomRelationService.findAllByTeacherid("0123");
        for(TeacherCourseClassRoomRelation teacherCourseClassRoomRelation:list){
            String classId=teacherCourseClassRoomRelation.getCourseid();
            System.out.println(classId);
            String className = classInfoService.getNameById(classId);
            String classRoomId=teacherCourseClassRoomRelation.getClassroomid();
            System.out.println(classRoomId);
            int timePerid=teacherCourseClassRoomRelation.getTimeperiod();
            System.out.println(timePerid);
            int weekday=teacherCourseClassRoomRelation.getWeekday();
            System.out.println(weekday);
            String teacherName=teacherInfoService.findNanme(teacherId);
            ClassRoomInfo classRoomInfo=classRoomInfoService.findOneById(classRoomId);
            String place=classRoomInfo.getPlace();
            System.out.println(place);
            String roomNumber=classRoomInfo.getRoomnumber();
            System.out.println(roomNumber);
            CourseForList courseForList =new CourseForList(teacherId,classId,classRoomId,weekday,timePerid,teacherName,place,roomNumber,className);
           System.out.println(teacherId+classId+classRoomId+weekday+timePerid+teacherName+place+roomNumber);
        }
    }

}