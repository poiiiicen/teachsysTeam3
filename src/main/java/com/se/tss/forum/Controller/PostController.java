package com.se.tss.forum.Controller;

import com.se.tss.forum.Service.PostService;
import com.se.tss.Public.Post;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @RequestMapping(value = "/post")
    public List<Post> dbconnect(){ return postService.findAll(); }
}