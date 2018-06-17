package com.se.tss.forum.Controller.SelectClass;


import com.se.tss.forum.Service.ClassRoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResourceController {
    @Autowired
    ClassRoomInfoService  classRoomInfoService;

    @RequestMapping(value = "/ResourseAdd", method = RequestMethod.POST)
    public String doInsert(String place, String roomNumber, int capacity,String equipment){
        if(classRoomInfoService.findByPlaceAndRoomNumber(place,roomNumber).isEmpty()){
            classRoomInfoService.doInsert(place,roomNumber,capacity,equipment);
            return "success!";
        }
        return "failed!";
    }

    @RequestMapping(value = "/ResourseDelete", method = RequestMethod.POST)
    public String doDelete(String place, String roomNumber, int capacity){
        if(!classRoomInfoService.findByPlaceAndRoomNumber(place,roomNumber).isEmpty()){
            classRoomInfoService.doDelete(place,roomNumber);
            return "success!";
        }
        else {
            return "failed!";
        }
    }

    @RequestMapping(value = "/ResourseUpdate", method = RequestMethod.POST)
    public String doUpdate(String place, String roomNumber, int capacity,String equipment){
        if(classRoomInfoService.findByPlaceAndRoomNumber(place,roomNumber).isEmpty()){
            classRoomInfoService.doInsert(place,roomNumber,capacity,equipment);
            return "success!";
        }
        else {
            classRoomInfoService.doUpdate(place,roomNumber,capacity,equipment);
            return "success!";
        }
    }

}
