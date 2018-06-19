package com.se.tss.CourseArrangeMgr.logic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeasibilityLogicTest {

    @Autowired
    FeasibilityLogic feasibilityLogic;

    @Test
    public void feasibilityLogicTest(){
        Assert.assertEquals("", feasibilityLogic.Feasibility("0123", "123456", "123", 2,2));
        Assert.assertEquals("教室的设备无法满足课程需求", feasibilityLogic.Feasibility("0123", "654321", "123", 2,3));
        Assert.assertEquals("教师时间冲突", feasibilityLogic.Feasibility("0123", "123456", "123", 0, 0));
        Assert.assertEquals("教室时间冲突", feasibilityLogic.Feasibility("013", "123456", "123", 0 , 0));
    }
}
