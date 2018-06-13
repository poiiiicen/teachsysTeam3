package com.se.tss.forum.Controller;

import com.se.tss.Public.PostEntity;
import com.se.tss.Public.SessionEntity;
import com.se.tss.forum.Service.PostService;
import com.se.tss.forum.Service.ReplyService;
import com.se.tss.forum.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class PostController {
    @Autowired
    SessionService sessionService;
    @Autowired
    ReplyService replyService;
    @Autowired
    PostService postService;
    @RequestMapping(value = "/session/{sname}")
    public List<PostEntity> dispSession(@PathVariable String sname){
        SessionEntity s = sessionService.findByName(sname);
        List<PostEntity> postEntities = s.getPostEntities();
        return postEntities;
    }
    @RequestMapping(value = "/topic/{sid}")
    public List<PostEntity> dispTopic(@PathVariable String sid){
        Optional<SessionEntity> s = sessionService.findById(sid);
        return s.get().getPostEntities();
    }
}