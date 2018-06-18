package com.se.tss.CourseArrangeMgr.logic;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class FeasibilityLogic {
    //在某一个教室的某一个时间段插入一门课程是否可行逻辑检验
    public String Feasibility(String teacherId, String courseId, String classRoomId,
                              int weekday,  //一周七天可上课
                              int timePeriod) ////每天5个时间段，有的时间段是两节课，有的三节课
    {
        return ""; //可行返回空串
    }
}
