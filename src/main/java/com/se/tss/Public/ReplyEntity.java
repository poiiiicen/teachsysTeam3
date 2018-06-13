package com.se.tss.Public;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reply")
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
}
