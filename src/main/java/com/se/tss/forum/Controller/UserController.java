package com.se.tss.forum.Controller;

import com.se.tss.forum.Service.UserService;
import com.se.tss.Public.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login/{name}&{pwd}")
    public String login(@PathVariable String name, @PathVariable String pwd) {
        Users u = userService.getOne(name);
        if(u.getPassword().equals(pwd))
            return "hello, welcome "+name;
        else
            return "oh sorry user name or password is wrong ";
    }
}

