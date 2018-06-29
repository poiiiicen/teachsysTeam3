package com.se.tss.forum.Models;

import java.sql.Timestamp;

public class Reply {
    private Integer rid;
    private String sid;
    private Integer uid;
    private Integer pid;
    private String uname;
    private String topic;
    private String reply_content;
    private Timestamp reply_time;
    /*
    private Integer post_pid;
    private String post_ptopic;
    private Integer creator_uid;
    private String creator_uname;
    */
    public Reply() {
    }
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    public Timestamp getReply_time() {
        return reply_time;
    }

    public void setReply_time(Timestamp reply_time) {
        this.reply_time = reply_time;
    }
}

