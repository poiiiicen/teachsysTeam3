package com.se.tss.CourseArrangeMgr.Controller;

import com.se.tss.CourseArrangeMgr.Dao.ReturnDao.CourseForList;
import com.se.tss.CourseArrangeMgr.logic.CourseForTeacherLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@RestController
public class AutoArrange {

    @Autowired
    CourseForTeacherLogic courseForTeacherLogic;

    @RequestMapping(value = "/CourseForTeacherList", method = RequestMethod.GET)
    public List<CourseForList> CourseArrangeList(String name){
        return courseForTeacherLogic.CourseArrangeList(name);
    }

}
