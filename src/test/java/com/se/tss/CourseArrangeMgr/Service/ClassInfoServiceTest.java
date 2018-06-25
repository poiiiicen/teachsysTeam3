package com.se.tss.CourseArrangeMgr.Service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassInfoServiceTest {

    @Autowired
    ClassInfoService classInfoService;

    @Test
    public void test (){
        String name = classInfoService.getNameById("123456");
        Assert.assertEquals("计算机基础",name);
    }

}