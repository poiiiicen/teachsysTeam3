package com.se.tss.Public;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "message")
public class MessageEntity {
    @Id
    @GeneratedValue
    private Integer mid;

    @ManyToOne(optional = false)
    private UserEntity sender;

    @ManyToOne(optional = false)
    private UserEntity receiver;

    @Column(length = 128, nullable = false)
    private String topic;

    @Column(length = 512, nullable = false)
    private String content;

    @Column()
    private Timestamp sendTime;

    public MessageEntity(){}
    public MessageEntity(UserEntity sender, UserEntity receiver, String topic, String content, Timestamp sendTime) {

        this.sender = sender;
        this.receiver = receiver;
        this.topic = topic;
        this.content = content;
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }
}
