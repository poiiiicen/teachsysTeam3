package com.se.tss.forum.Controller;

import com.se.tss.forum.Entity.MessageEntity;
import com.se.tss.forum.Entity.UserEntity;
import com.se.tss.forum.Models.Message;
import com.se.tss.forum.Service.MessageService;
import com.se.tss.forum.Service.PostService;
import com.se.tss.forum.Service.ForumUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.se.tss.forum.TimeManager.getBeijingTime;

//@CrossOrigin
@RestController
public class MessageController {
    @Autowired
    MessageService messageService;
    @Autowired
    PostService postService;
    @Autowired
    ForumUserService userService;
    //创建私信
    //传入：sender_id receiver_id message
    @RequestMapping(value = "bbs/message/create")
    public Message createNotice(@RequestBody Message m) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setSender(userService.findByUid(m.getSender_id()));
        messageEntity.setReceiver(userService.findByUid(m.getReceiver_id()));
        messageEntity.setMessage(m.getMessage());
        messageEntity.setSendTime(getBeijingTime());
        messageService.save(messageEntity);
        m.setMid(messageEntity.getMid());
        return m;
    }
    //得到某用户相关私信
    @RequestMapping(value = "/bbs/message/all/{uid1}/{uid2}")
    public List<Message> searchPost(@PathVariable Integer uid1, @PathVariable Integer uid2){
        UserEntity u1 = userService.findByUid(uid1);
        UserEntity u2 = userService.findByUid(uid2);
        List<MessageEntity> messageEntities = messageService.findBySenderAndReceiverOrSenderAndReceiverOrderBySendTime(u1, u2, u2, u1);
        List<Message> messages = new ArrayList<>();
        for(MessageEntity me: messageEntities)
        {
            Message m = me.getMessageInfo();
            messages.add(m);
        }
        if(messages.size() == 0)
        {
           MessageEntity me = new MessageEntity();
           me.setSender(u2);
           me.setReceiver(u1);
           Message m = me.setEmptyMessage();
           messages.add(m);
        }
        return messages;
    }

}