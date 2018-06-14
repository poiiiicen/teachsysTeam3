package com.se.tss.forum.Controller;

import com.se.tss.Public.*;
import com.se.tss.forum.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@CrossOrigin
@RestController
public class InitialController {
    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;
    @Autowired
    SessionService sessionService;
    @Autowired
    PostService postService;
    @Autowired
    ReplyService replyService;
    @Autowired
    MessageService messageService;
    @Autowired
    NoticeService noticeService;

    @RequestMapping(value = "/init")
    public String init() {
        adminService.save(new Adm("admin","admin"));
        userService.save(new UserEntity("user1", "user1", null, null, null, null, null, null));
        userService.save(new UserEntity("user2", "user2", null, null, null, null, null, null));
        UserEntity user1 = userService.findByName("user1");
        Timestamp now = new Timestamp(System.currentTimeMillis());
        sessionService.save(new SessionEntity("教师答疑", "您在课程、作业上遇到的问题，可以在本版块向老师提问", 0, 0));
        sessionService.save(new SessionEntity("心灵之约", "您在生活、情感上遇到的问题，可以在本版块进行吐槽", 0, 0));
        sessionService.save(new SessionEntity("开怀一笑", "您在任何地方发现的一些欢乐，不放在本版块分享给大家", 0, 0));
        postService.save(new PostEntity(sessionService.findByName("教师答疑"), "topic1", "test context of topic1", user1, now, null, 0, 0, user1, now));
        postService.save(new PostEntity(sessionService.findByName("教师答疑"), "topic2", "test context of topic2", user1, now, null, 0, 0, user1, now));
        postService.save(new PostEntity(sessionService.findByName("教师答疑"), "topic3", "test context of topic3", user1, now, null, 0, 0, user1, now));
        postService.save(new PostEntity(sessionService.findByName("教师答疑"), "topic4", "test context of topic4", user1, now, null, 0, 0, user1, now));
        postService.save(new PostEntity(sessionService.findByName("教师答疑"), "topic5", "test context of topic5", user1, now, null, 0, 0, user1, now));
        postService.save(new PostEntity(sessionService.findByName("心灵之约"), "topic6", "test context of topic6", user1, now, null, 0, 0, user1, now));
        postService.save(new PostEntity(sessionService.findByName("心灵之约"), "topic7", "test context of topic7", user1, now, null, 0, 0, user1, now));
        postService.save(new PostEntity(sessionService.findByName("心灵之约"), "topic8", "test context of topic8", user1, now, null, 0, 0, user1, now));
        postService.save(new PostEntity(sessionService.findByName("心灵之约"), "topic9", "test context of topic9", user1, now, null, 0, 0, user1, now));
        postService.save(new PostEntity(sessionService.findByName("心灵之约"), "topic10", "test context of topic10", user1, now, null, 0, 0, user1, now));
        postService.save(new PostEntity(sessionService.findByName("开怀一笑"), "topic11", "test context of topic11", user1, now, null, 0, 0, user1, now));
        postService.save(new PostEntity(sessionService.findByName("开怀一笑"), "topic12", "test context of topic12", user1, now, null, 0, 0, user1, now));
        postService.save(new PostEntity(sessionService.findByName("开怀一笑"), "topic13", "test context of topic13", user1, now, null, 0, 0, user1, now));
        postService.save(new PostEntity(sessionService.findByName("开怀一笑"), "topic14", "test context of topic14", user1, now, null, 0, 0, user1, now));
        postService.save(new PostEntity(sessionService.findByName("开怀一笑"), "topic15", "test context of topic15", user1, now, null, 0, 0, user1, now));
        replyService.save(new ReplyEntity(postService.findByTopic("topic1"), user1, "I am a test reply of topic1 count 1", now));
        replyService.save(new ReplyEntity(postService.findByTopic("topic1"), user1, "I am a test reply of topic1 count 2", now));
        replyService.save(new ReplyEntity(postService.findByTopic("topic1"), user1, "I am a test reply of topic1 count 3", now));
        noticeService.save(new NoticeEntity(user1, "notice 1", "test content of notice 1", now, now));
        noticeService.save(new NoticeEntity(user1, "notice 2", "test content of notice 2", now, now));
        noticeService.save(new NoticeEntity(user1, "notice 3", "test content of notice 3", now, now));
        messageService.save(new MessageEntity(user1, userService.findByName("user2"), "hello", "a hello message from user1", now));
        messageService.save(new MessageEntity(userService.findByName("user2"), user1, "hello", "a hello message from user2", now));
        return "initial successfully";
    }

}
