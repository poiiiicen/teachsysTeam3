package com.se.tss.Public;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
@JsonIgnoreProperties(value = { "session", "creator","lastReplier"})
public class PostEntity {
    @Id
    @GeneratedValue
    private Integer pid;

    @ManyToOne(optional = false)
    private SessionEntity session;

    @Column(length = 128, nullable = false)
    private String topic;

    @Column(length = 512, nullable = false)
    private String content;

    @ManyToOne(optional = false)
    private UserEntity creator;

    @Column(nullable = false)
    private Timestamp createTime;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReplyEntity> replyEntities = new ArrayList<>();

    @Column(nullable = false)
    private Integer replyCount;

    @Column(nullable = false)
    private Integer clickCount;

    @ManyToOne(optional = false)
    private UserEntity lastReplier;

    @Column()
    private Timestamp lastReplyTime;
    public PostEntity(){}
    public PostEntity(SessionEntity session, String topic, String content, UserEntity creator, Timestamp createTime, List<ReplyEntity> replyEntities, Integer replyCount, Integer clickCount, UserEntity lastReplier, Timestamp lastReplyTime) {
        this.session = session;
        this.topic = topic;
        this.content = content;
        this.creator = creator;
        this.createTime = createTime;
        this.replyEntities = replyEntities;
        this.replyCount = replyCount;
        this.clickCount = clickCount;
        this.lastReplier = lastReplier;
        this.lastReplyTime = lastReplyTime;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
    @JsonIgnore
    public SessionEntity getSession() {
        return session;
    }
    @JsonIgnore
    public void setSession(SessionEntity session) {
        this.session = session;
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

    public UserEntity getCreator() {
        return creator;
    }

    public void setCreator(UserEntity creator) {
        this.creator = creator;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public List<ReplyEntity> getReplyEntities() {
        return replyEntities;
    }

    public void setReplyEntities(List<ReplyEntity> replyEntities) {
        this.replyEntities = replyEntities;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public UserEntity getLastReplier() {
        return lastReplier;
    }

    public void setLastReplier(UserEntity lastReplier) {
        this.lastReplier = lastReplier;
    }

    public Timestamp getLastReplyTime() {
        return lastReplyTime;
    }

    public void setLastReplyTime(Timestamp lastReplyTime) {
        this.lastReplyTime = lastReplyTime;
    }
}
