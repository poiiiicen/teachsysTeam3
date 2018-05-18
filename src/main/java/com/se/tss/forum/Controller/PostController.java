package com.se.tss.forum.Controller;

import com.se.tss.CourseArrange.Service.AdminService;
import com.se.tss.Public.Adm;
import com.se.tss.Public.BBSSession;
import com.se.tss.Public.BBSTopic;
import com.se.tss.forum.Service.ReplyService;
import com.se.tss.forum.Service.SessionService;
import com.se.tss.forum.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.HTMLDocument;
import java.util.List;

@CrossOrigin
@RestController
public class PostController {
    @Autowired
    SessionService sessionService;
    @Autowired
    TopicService topicService;
    @Autowired
    ReplyService replyService;

    @RequestMapping(value = "/session/name/{sid}")
    public String dispSession(@PathVariable String sid){
        return "TEST";//sessionService.getOne(sid).getSname();
    }
    @RequestMapping(value = "/topic/{sid}")
    public List<BBSTopic> dispTopic(@PathVariable int sid){
        return topicService.findByTsid(sid);
    }
}