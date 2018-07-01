package com.se.tss.infomgr.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.se.tss.forum.Entity.UserEntity;
import com.se.tss.forum.Service.ForumUserService;
import com.se.tss.infomgr.annotation.AdminRequired;
import com.se.tss.infomgr.annotation.CurrentUser;
import com.se.tss.infomgr.model.User;
import com.se.tss.infomgr.model.UserRepository;
import com.se.tss.infomgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/admin")
public class AdminApi {
    private final UserRepository userRepository;
    private final UserService userService;
    @Autowired
    ForumUserService forumUserService;
    @Autowired
    public AdminApi(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @AdminRequired
    @GetMapping("/infoall")
    public Object infoAll(@CurrentUser User currentUser) {
        JSONObject jsonObject = new JSONObject();
        if (userRepository.findAuthorityById(currentUser.getId()).equals("Admin")) {
            jsonObject.put("users", userRepository.findAllUsers());
            jsonObject.put("authorities", userRepository.findAllAuthorities());
        } else {
            jsonObject.put("error", "请以管理员身份登录");
        }
        return jsonObject;
    }

    @AdminRequired
    @GetMapping("/info/{id}")
    public Object findById(@PathVariable int id) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", userRepository.getFullOneById(id));
        jsonObject.put("authority", userRepository.findAuthorityById(id));
        return jsonObject;
    }

    @AdminRequired
    @PostMapping("/update/{id}")
    public Object userInfo(@RequestBody JSONObject request, @PathVariable int id) {
        User userInDB = userRepository.getFullOneById(id);
        return userService.update(userInDB, request);
    }

    @AdminRequired
    @GetMapping("/delete/{id}")
    public Object deleteUser(@PathVariable int id) {
        JSONObject jsonObject = new JSONObject();
        userRepository.deleteById(id);
        UserEntity bbsUser = forumUserService.findByUid(id);
        forumUserService.delete(bbsUser);
        jsonObject.put("message", "success");
        return jsonObject;
    }

    @AdminRequired
    @PostMapping("/add")
    public Object add(@RequestParam(value = "userInfo") MultipartFile file) {
        JSONObject ret = new JSONObject();
        if (file.isEmpty()) {
            ret.put("error", "文件不能为空");
            return ret;
        }
        try {
            String content = new String(file.getBytes());
            JSONObject jsonObject = JSON.parseObject(content);
            userService.add(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ret.put("message", "success");
        return ret;
    }
}
