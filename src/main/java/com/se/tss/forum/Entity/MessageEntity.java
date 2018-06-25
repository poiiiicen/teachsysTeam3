package com.se.tss.forum.Entity;

import com.se.tss.forum.Models.Message;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bbs_message")
public class MessageEntity {
    @Id
    @GeneratedValue
    private Integer mid;

    @ManyToOne(optional = false)
    private UserEntity sender;

    @ManyToOne(optional = false)
    private UserEntity receiver;

    @Column(length = 512, nullable = false)
    private String message;

    @Column()
    private Timestamp sendTime;

    public MessageEntity(){}

    public MessageEntity(UserEntity sender, UserEntity receiver, String message, Timestamp sendTime) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.sendTime = sendTime;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public UserEntity getSender() {
        return sender;
    }

    public void setSender(UserEntity sender) {
        this.sender = sender;
    }

    public UserEntity getReceiver() {
        return receiver;
    }

    public void setReceiver(UserEntity receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }
    public Message getMessageInfo()
    {
        Message m = new Message();
        m.setMid(mid);
        m.setSender_id(sender.getUid());
        m.setSender_name(sender.getName());
        m.setReceiver_id(receiver.getUid());
        m.setReceiver_name(receiver.getName());
        m.setMessage(message);
        m.setSendTime(sendTime);
        return m;
    }
}
