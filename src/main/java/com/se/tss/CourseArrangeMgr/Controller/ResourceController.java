package com.se.tss.CourseArrangeMgr.Controller;


import com.se.tss.CourseArrangeMgr.Service.ClassRoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class ResourceController {
    @Autowired
    ClassRoomInfoService  classRoomInfoService;

    @RequestMapping(value = "/ResourseAdd", method = RequestMethod.POST)
    public String doInsert(String place, String roomNumber, int capacity,String equipment){
        try{
            classRoomInfoService.doInsert(place+roomNumber,place,roomNumber,capacity,equipment);
            return "success";
        } catch (Exception e){
            return "fail";
        }
    }

    @RequestMapping(value = "/ResourseDelete", method = RequestMethod.POST)
    public String doDelete(String place, String roomNumber){
        try{
            classRoomInfoService.doDelete(place,roomNumber);
            return "success!";
        }catch(Exception e){
            return "failed!";
        }

    }
    @RequestMapping(value = "/ResourseUpdate", method = RequestMethod.POST)
    public String doUpdate(String place, String roomNumber, int capacity,String equipment){
        try{
            classRoomInfoService.doDelete(place,roomNumber);
            classRoomInfoService.doInsert(place+roomNumber,place,roomNumber,capacity,equipment);
            return "success!";
        }catch(Exception e){
            return "failed!";
        }
    }

}
