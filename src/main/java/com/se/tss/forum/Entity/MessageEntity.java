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

    @Column()
    private boolean sendView;

    @Column()
    private boolean recvView;

    public MessageEntity(){}

    public MessageEntity(UserEntity sender, UserEntity receiver, String message, Timestamp sendTime, boolean sendView, boolean recvView) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.sendTime = sendTime;
        this.sendView = sendView;
        this.recvView = recvView;
    }

    public boolean isSendView() {
        return sendView;
    }

    public void setSendView(boolean sendView) {
        this.sendView = sendView;
    }

    public boolean isRecvView() {
        return recvView;
    }

    public void setRecvView(boolean recvView) {
        this.recvView = recvView;
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
    public Message getMessageInfo(Integer sid)
    {
        if((sid == sender.getUid() && sendView) || (sid == receiver.getUid() && recvView))
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
        else
            return null;
    }
    public Message getMessageInfo()
    {
        return new Message(mid, sender.getUid(), sender.getName(), receiver.getUid(), receiver.getName(), message, sendTime);
    }
    public Message setEmptyMessage()
    {
        Message m = new Message();
        m.setMid(0);
        m.setSender_id(sender.getUid());
        m.setSender_name(sender.getName());
        m.setReceiver_id(receiver.getUid());
        m.setReceiver_name(receiver.getName());
        return m;
    }
}
