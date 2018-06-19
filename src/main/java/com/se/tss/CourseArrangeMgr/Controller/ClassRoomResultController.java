package com.se.tss.CourseArrangeMgr.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.tss.CourseArrangeMgr.Dao.ClassRoomResultChart;
import com.se.tss.CourseArrangeMgr.logic.ClassRoomResultChartLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class ClassRoomResultController {
    @Autowired
    ClassRoomResultChartLogic classRoomResultChartLogic;

    @RequestMapping(value = "/ClassRoomChart", method = RequestMethod.GET)
    public String getClassRoomChart(@RequestParam("place") String place,
                                    @RequestParam("roomNumber") String roomNumber) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(classRoomResultChartLogic.getClassRoomResultChartList(place, roomNumber));
        return s;
    }
}
