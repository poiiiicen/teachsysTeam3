package com.se.tss.CourseArrangeMgr.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class AddLogic {
    //删除某一个教室某一个时间段上课的信息
    //需要对数据库做修改
    //为主逻辑提供方法
    @Autowired
    FeasibilityLogic feasibilityLogic;

    public String AddClass(String teacherId,String courseId,String classRoomId,int weekday,int timePeriod){
        String result=feasibilityLogic.Feasibility(teacherId,courseId, classRoomId, weekday, timePeriod);
        if(result==""){   //可以插入课程  持久化处理

        }
        else{

        }
        return  result;
    }
}
