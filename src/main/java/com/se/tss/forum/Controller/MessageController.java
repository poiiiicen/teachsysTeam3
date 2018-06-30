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
    public Message createMessage(@RequestBody Message m) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setSender(userService.findByUid(m.getSender_id()));
        messageEntity.setReceiver(userService.findByUid(m.getReceiver_id()));
        messageEntity.setMessage(m.getMessage());
        messageEntity.setSendTime(getBeijingTime());
        messageEntity.setSendView(true);
        messageEntity.setRecvView(true);
        messageService.save(messageEntity);
        m.setMid(messageEntity.getMid());
        return m;
    }
    //得到某用户相关私信
    @RequestMapping(value = "/bbs/message/all/{rid}/{sid}")
    public List<Message> searchMessage(@PathVariable Integer rid, @PathVariable Integer sid){
        UserEntity u1 = userService.findByUid(rid);
        UserEntity u2 = userService.findByUid(sid);
        List<MessageEntity> messageEntities = messageService.findBySenderAndReceiverOrSenderAndReceiverOrderBySendTime(u1, u2, u2, u1);
        List<Message> messages = new ArrayList<>();
        for(MessageEntity me: messageEntities)
        {
            Message m = me.getMessageInfo(sid);
            if(m != null)
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
    //查看所有私信
    @RequestMapping(value = "/bbs/message/all")
    public List<Message> getMessage(){
        List<MessageEntity> messageEntities = messageService.findAll();
        List<Message> messages = new ArrayList<>();
        for(MessageEntity me: messageEntities)
        {
            Message m = me.getMessageInfo();
            messages.add(m);
        }
        return messages;
    }
    //删除某条私信
    @RequestMapping(value = "/bbs/message/delete/{mid}/{uid}")
    public Message deleteMessage(@PathVariable Integer mid, @PathVariable Integer uid){
        UserEntity u1 = userService.findByUid(uid);
        MessageEntity messageEntity = messageService.findByMid(mid);
        Message message = messageEntity.getMessageInfo(uid);
        if(messageEntity.getSender().getUid() == uid)
            messageEntity.setSendView(false);
        else if(messageEntity.getReceiver().getUid() == uid)
            messageEntity.setRecvView(false);
        messageService.save(messageEntity);
        if(!messageEntity.isSendView() && !messageEntity.isRecvView())
            messageService.delete(messageEntity);
        return message;
    }

}