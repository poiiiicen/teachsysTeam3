package com.se.tss.forum.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.se.tss.forum.Models.Reply;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bbs_reply")
@JsonIgnoreProperties(value = { "post", "creator"})
public class ReplyEntity {
    @Id
    @GeneratedValue
    private Integer rid;

    @ManyToOne(optional = false)
    private PostEntity post;

    @ManyToOne(optional = false)
    private UserEntity creator;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Timestamp replyTime;
    public ReplyEntity(){}
    public ReplyEntity(PostEntity post, UserEntity creator, String content, Timestamp replyTime) {
        this.post = post;
        this.creator = creator;
        this.content = content;
        this.replyTime = replyTime;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public UserEntity getCreator() {
        return creator;
    }

    public void setCreator(UserEntity creator) {
        this.creator = creator;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Timestamp replyTime) {
        this.replyTime = replyTime;
    }

    public Reply getReply()
    {
        Reply reply = new Reply();
        reply.setRid(rid);
        reply.setPid(post.getPid());
        reply.setReply_content(content);
        reply.setTopic(post.getTopic());
        reply.setUid(creator.getUid());
        reply.setUname(creator.getName());
        reply.setSid(post.getSession().getSid());
        reply.setReply_time(replyTime);
        return reply;
    }
}
