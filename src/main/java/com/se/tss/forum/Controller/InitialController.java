package com.se.tss.forum.Controller;

import com.se.tss.forum.Entity.*;
import com.se.tss.forum.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Calendar;

@CrossOrigin
@RestController
public class InitialController {
    @Autowired
    ForumUserService userService;
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

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 8);
        Timestamp now = new Timestamp(calendar.getTimeInMillis());
        userService.save(new UserEntity( 1 , "zz", "Student", null, null, null, null, null, null));
        userService.save(new UserEntity( 2 , "kira", "Admin", null, null, null, null, null, null));
        userService.save(new UserEntity( 3 , "zzzzzzz", "Student", null, null, null, null, null, null));
        userService.save(new UserEntity( 4 , "小明", "Student", null, null, null, null, null, null));
        userService.save(new UserEntity( 5 , "翁凯", "Teacher", null, null, null, null, null, null));
        userService.save(new UserEntity( 13 , "陈大头", "Student", null, null, null, null, null, null));
        userService.save(new UserEntity( 49 , "小花", "Student", null, null, null, null, null, null));
        userService.save(new UserEntity( 50 , "Sam", "Student", null, null, null, null, null, null));

        sessionService.save(new SessionEntity("S001","教师答疑", "您在课程、作业上遇到的问题，可以在本版块向老师提问", 0, 0,null));
        sessionService.save(new SessionEntity("S002","心灵之约", "您在生活、情感上遇到的问题，可以在本版块进行吐槽", 0, 0,null));
        sessionService.save(new SessionEntity("S003","开怀一笑", "您在任何地方发现的一些欢乐，不放在本版块分享给大家", 0, 0,null));
        UserEntity user1 = userService.findByName("小明");
        postService.save(new PostEntity(sessionService.findByName("教师答疑"), "topic1", "test context of topic1", user1, now, null, 0, 0, user1, now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        postService.save(new PostEntity(sessionService.findByName("教师答疑"), "topic2", "test context of topic2", user1, now, null, 0, 0, user1, now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        postService.save(new PostEntity(sessionService.findByName("教师答疑"), "topic3", "test context of topic3", user1, now, null, 0, 0, user1, now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        postService.save(new PostEntity(sessionService.findByName("教师答疑"), "topic4", "test context of topic4", user1, now, null, 0, 0, user1, now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        postService.save(new PostEntity(sessionService.findByName("教师答疑"), "topic5", "test context of topic5", user1, now, null, 0, 0, user1, now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        postService.save(new PostEntity(sessionService.findByName("心灵之约"), "topic6", "test context of topic6", user1, now, null, 0, 0, user1, now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        postService.save(new PostEntity(sessionService.findByName("心灵之约"), "topic7", "test context of topic7", user1, now, null, 0, 0, user1, now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        postService.save(new PostEntity(sessionService.findByName("心灵之约"), "topic8", "test context of topic8", user1, now, null, 0, 0, user1, now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        postService.save(new PostEntity(sessionService.findByName("心灵之约"), "topic9", "test context of topic9", user1, now, null, 0, 0, user1, now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        postService.save(new PostEntity(sessionService.findByName("心灵之约"), "topic10", "test context of topic10", user1, now, null, 0, 0, user1, now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        postService.save(new PostEntity(sessionService.findByName("开怀一笑"), "topic11", "test context of topic11", user1, now, null, 0, 0, user1, now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        postService.save(new PostEntity(sessionService.findByName("开怀一笑"), "topic12", "test context of topic12", user1, now, null, 0, 0, user1, now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        postService.save(new PostEntity(sessionService.findByName("开怀一笑"), "topic13", "test context of topic13", user1, now, null, 0, 0, user1, now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        postService.save(new PostEntity(sessionService.findByName("开怀一笑"), "topic14", "test context of topic14", user1, now, null, 0, 0, user1, now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        postService.save(new PostEntity(sessionService.findByName("开怀一笑"), "topic15", "test context of topic15", user1, now, null, 0, 0, user1, now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());

        user1 = userService.findByName("翁凯");
        replyService.save(new ReplyEntity(postService.findByTopic("topic1"), user1, "I am a test reply of topic1 count 1", now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        replyService.save(new ReplyEntity(postService.findByTopic("topic1"), user1, "I am a test reply of topic1 count 2", now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        replyService.save(new ReplyEntity(postService.findByTopic("topic1"), user1, "I am a test reply of topic1 count 3", now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        noticeService.save(new NoticeEntity(user1, "notice 1", "test content of notice 1", now, now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        noticeService.save(new NoticeEntity(user1, "notice 2", "test content of notice 2", now, now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        noticeService.save(new NoticeEntity(user1, "notice 3", "test content of notice 3", now, now));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        messageService.save(new MessageEntity(user1, userService.findByName("zz"),  "一个来自小明的问候 给zz", now, true, true));
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        now = new Timestamp(calendar.getTimeInMillis());
        messageService.save(new MessageEntity(userService.findByName("陈大头"), user1,  "一个来自陈大头的问候 给小刚", now, true, true));
        return "initial successfully";
    }
    @RequestMapping(value = "/clear")
    public String clear() {
        userService.deleteAll();
        sessionService.deleteAll();
        postService.deleteAll();
        noticeService.deleteAll();
        messageService.deleteAll();
        replyService.deleteAll();
        return "clear successfully";
    }
}
