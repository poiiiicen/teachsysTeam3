package com.se.tss.forum.Controller;

import com.se.tss.Public.BBSUser;
import com.se.tss.forum.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.servlet.http.HttpServletRequest;
@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login/{name}&{pwd}")
    public String login(@PathVariable String name, @PathVariable String pwd) {
        BBSUser u = userService.getOne(name);
        if(u.getUpwd().equals(pwd))
            return "hello, welcome "+name;
        else
            return "oh sorry user name or password is wrong ";
    }

    @RequestMapping(value = "/regist")
    public String regist(HttpServletRequest request )
    {
        BBSUser u = new BBSUser();
        /*;
        u.setUName(request.getParameter("uname"));
        u.setUPwd(request.getParameter("upassword"));
        u.setUEmail(request.getParameter("uemail"));
        u.setUBirthday(request.getParameter("ubirthday"));
        u.setUSex(request.getParameter("usex"));
        u.setURegdata("2018/1/1");*/
        userService.save(u);
        return "regist successfully";
    }

    @RequestMapping(value = "/changepwd/{uid}&{pwd}&{newpwd}")
    public String change_pwd(@PathVariable String uid, @PathVariable String pwd, @PathVariable String newpwd) {
        BBSUser u = userService.getOne(uid);
        if(u.getUpwd().equals(pwd))
        {
            userService.delete(u);
            u.setUpwd(newpwd);
            userService.save(u);
            return "password changed successfully";
        }
        else
            return "oh sorry user name or old password is wrong ";
    }
}

