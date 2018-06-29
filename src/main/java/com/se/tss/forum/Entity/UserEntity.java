package com.se.tss.forum.Entity;

import com.se.tss.forum.Models.ForumUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bbs_user")
public class UserEntity {
    @Id
    private Integer uid;

    @Column(length = 32, unique = true, nullable = false)
    private String name;

    @Column(length = 32, nullable = false)
    private String authority;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostEntity> createdPost = new ArrayList<>();

    @OneToMany(mappedBy = "lastReplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostEntity> lastRepliedPost = new ArrayList<>();

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReplyEntity> repliedPost = new ArrayList<>();

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MessageEntity> sentMessage = new ArrayList<>();

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MessageEntity> receivedMessage = new ArrayList<>();

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NoticeEntity> noticeEntities = new ArrayList<>();
    public UserEntity(){}

    public UserEntity(Integer uid, String name, String authority, List<PostEntity> createdPost, List<PostEntity> lastRepliedPost, List<ReplyEntity> repliedPost, List<MessageEntity> sentMessage, List<MessageEntity> receivedMessage, List<NoticeEntity> noticeEntities) {
        this.uid = uid;
        this.name = name;
        this.authority = authority;
        this.createdPost = createdPost;
        this.lastRepliedPost = lastRepliedPost;
        this.repliedPost = repliedPost;
        this.sentMessage = sentMessage;
        this.receivedMessage = receivedMessage;
        this.noticeEntities = noticeEntities;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public List<PostEntity> getCreatedPost() {
        return createdPost;
    }

    public void setCreatedPost(List<PostEntity> createdPost) {
        this.createdPost = createdPost;
    }

    public List<PostEntity> getLastRepliedPost() {
        return lastRepliedPost;
    }

    public void setLastRepliedPost(List<PostEntity> lastRepliedPost) {
        this.lastRepliedPost = lastRepliedPost;
    }

    public List<ReplyEntity> getRepliedPost() {
        return repliedPost;
    }

    public void setRepliedPost(List<ReplyEntity> repliedPost) {
        this.repliedPost = repliedPost;
    }

    public List<MessageEntity> getSentMessage() {
        return sentMessage;
    }

    public void setSentMessage(List<MessageEntity> sentMessage) {
        this.sentMessage = sentMessage;
    }

    public List<MessageEntity> getReceivedMessage() {
        return receivedMessage;
    }

    public void setReceivedMessage(List<MessageEntity> receivedMessage) {
        this.receivedMessage = receivedMessage;
    }

    public List<NoticeEntity> getNoticeEntities() {
        return noticeEntities;
    }

    public void setNoticeEntities(List<NoticeEntity> noticeEntities) {
        this.noticeEntities = noticeEntities;
    }
    public ForumUser getUser()
    {
        ForumUser u = new ForumUser(uid, name, authority);
        return u;
    }
}
