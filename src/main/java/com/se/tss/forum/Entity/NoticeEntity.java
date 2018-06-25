package com.se.tss.forum.Entity;

import com.se.tss.forum.Models.Notice;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bbs_notice")
public class NoticeEntity {
    @Id
    @GeneratedValue
    private Integer nid;

    @ManyToOne(optional = false)
    private UserEntity creator;

    @Column(length = 128, nullable = false)
    private String topic;

    @Column(length = 512, nullable = false)
    private String content;

    @Column(nullable = false)
    private Timestamp createTime;

    @Column(nullable = false)
    private Timestamp modifiedTime;
    public NoticeEntity(){}
    public NoticeEntity(UserEntity creator, String topic, String content, Timestamp createTime, Timestamp modifiedTime) {

        this.creator = creator;
        this.topic = topic;
        this.content = content;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public UserEntity getCreator() {
        return creator;
    }

    public void setCreator(UserEntity creator) {
        this.creator = creator;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Notice getNotice()
    {
        Notice n = new Notice();
        n.setNid(nid);
        n.setTopic(topic);
        n.setContent(content);
        n.setCreate_time(createTime);
        n.setCreator_uid(creator.getUid());
        n.setCreator_uname(creator.getName());
        n.setModified_time(modifiedTime);
        return n;
    }
}
