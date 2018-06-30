package com.se.tss.forum.Controller;

import com.se.tss.forum.Entity.UserEntity;
import com.se.tss.forum.Models.ForumUser;
import com.se.tss.forum.Service.ForumUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class UserController {
    @Autowired
    ForumUserService userService;

    @RequestMapping(value = "/bbs/user/{uid}")
    public ForumUser getUser(@PathVariable Integer uid) {
        UserEntity u = userService.findByUid(uid);
        ForumUser user = u.getUser();
        return user;
    }

}

