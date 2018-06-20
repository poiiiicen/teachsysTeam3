package com.se.tss.CourseArrangeMgr.Controller;

import com.se.tss.CourseArrangeMgr.Dao.ReturnDao.ClassRoomResultChart;
import com.se.tss.CourseArrangeMgr.logic.ClassRoomResultChartLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class ClassRoomResultController {
    @Autowired
    ClassRoomResultChartLogic classRoomResultChartLogic;

    @RequestMapping(value = "/ClassRoomChart", method = RequestMethod.GET)
    public List<ClassRoomResultChart> getClassRoomChart(@RequestParam("place") String place,
                                                        @RequestParam("roomNumber") String roomNumber) {
        return classRoomResultChartLogic.getClassRoomResultChartList(place, roomNumber);
    }
}
