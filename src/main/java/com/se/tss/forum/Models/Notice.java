package com.se.tss.forum.Models;

import java.sql.Timestamp;

public class Notice {
    private Integer nid;
    private String topic;
    private String content;
    private Integer creator_uid;
    private String creator_uname;
    private Timestamp create_time;
    private Timestamp modified_time;

    public Notice() {
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getModified_time() {
        return modified_time;
    }

    public void setModified_time(Timestamp modified_time) {
        this.modified_time = modified_time;
    }

    public String getCreator_uname() {
        return creator_uname;
    }

    public void setCreator_uname(String creator_uname) {
        this.creator_uname = creator_uname;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getCreator_uid() {
        return creator_uid;
    }

    public void setCreator_uid(Integer creator_uid) {
        this.creator_uid = creator_uid;
    }
}
