package com.se.tss.CourseArrangeMgr.logic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArrangeClassLogicTest {
    @Autowired
    private ArrangeClassLogic arrangeClassLogic;

    @Test
    public void test(){
        if(arrangeClassLogic==null)
        System.out.print(":1");
        arrangeClassLogic.Arrange();
    }

}