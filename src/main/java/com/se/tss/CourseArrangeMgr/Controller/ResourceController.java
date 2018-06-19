package com.se.tss.CourseArrangeMgr.Controller;


import com.se.tss.CourseArrangeMgr.Dao.ClassRoomInfo;
import com.se.tss.CourseArrangeMgr.Service.ClassRoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class ResourceController {
    @Autowired
    ClassRoomInfoService  classRoomInfoService;


    @RequestMapping(value = "/ResourseGet", method = RequestMethod.GET)
    public List<ClassRoomInfo> listAll(){
        return classRoomInfoService.findAll();
    }

    @RequestMapping(value = "/ResourseAdd", method = RequestMethod.POST)
    public String doInsert(String place, String roomnumber, Integer capacity,String equipment){
        try{
            System.out.print(capacity);
            classRoomInfoService.doInsert(place+roomnumber,place,roomnumber,capacity,equipment);
            return "success";
        } catch (Exception e){
            return "fail";
        }
    }

    @RequestMapping(value = "/ResourseDelete", method = RequestMethod.POST)
    public String doDelete(String place, String roomnumber){
        try{
            System.out.print(roomnumber);
            classRoomInfoService.doDelete(place,roomnumber);
            return "success!";
        }catch(Exception e){
            return "failed!";
        }

    }
    @RequestMapping(value = "/ResourseUpdate", method = RequestMethod.POST)
    public String doUpdate(String place, String roomnumber, Integer capacity,String equipment){
        try{
            classRoomInfoService.doDelete(place,roomnumber);
            classRoomInfoService.doInsert(place+roomnumber,place,roomnumber,capacity,equipment);
            return "success!";
        }catch(Exception e){
            return "failed!";
        }
    }

}
