package com.se.tss.forum.Controller;

import com.se.tss.forum.Service.AdminService;
import com.se.tss.Public.Adm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/")
        public String test(){
            return "hello world!";
        }

        @RequestMapping(value = "/testdbconnection")
        public  List<Adm> dbconnect(){
        return adminService.findAll();
    }
}
