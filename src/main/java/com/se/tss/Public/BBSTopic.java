package com.se.tss.Public;

import javax.persistence.*;

@Entity
@Table(name="bbs_topic")
public class BBSTopic {
    @Id
    @Column(name="tid")
    private String tid;
    @Column(name="tsid")
    private int tsid;
    @Column(name="tuid")
    private String tuid;
    @Column(name="treply_count")
    private String treply_count;
    @Column(name="ttopic")
    private String ttopic;
    @Column(name="tcontent")
    private String tcontent;
    @Column(name="ttime")
    private String ttime;
    @Column(name="tclick_count")
    private String tclick_count;
    @Column(name="tlast_reply_user_id")
    private String tlast_reply_user_id;
    @Column(name="tlast_reply_time")
    private String tlast_reply_time;

    public String getTid() {
        return tid;
    }

    public int getTsid() {
        return tsid;
    }

    public String getTuid() {
        return tuid;
    }

    public String getTreply_count() {
        return treply_count;
    }

    public String getTtopic() {
        return ttopic;
    }

    public String getTtime() {
        return ttime;
    }

    public String getTcontent() {
        return tcontent;
    }

    public String getTlast_reply_time() {
        return tlast_reply_time;
    }

    public String getTlast_reply_user_id() {
        return tlast_reply_user_id;
    }

    public String getTclick_count() {
        return tclick_count;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public void setTsid(int tsid) {
        this.tsid = tsid;
    }

    public void setTuid(String tuid) {
        this.tuid = tuid;
    }

    public void setTcontent(String tcontent) {
        this.tcontent = tcontent;
    }

    public void setTtopic(String ttopic) {
        this.ttopic = ttopic;
    }

    public void setTtime(String ttime) {
        this.ttime = ttime;
    }

    public void setTlast_reply_time(String tlast_reply_time) {
        this.tlast_reply_time = tlast_reply_time;
    }

    public void setTlast_reply_user_id(String tlast_reply_user_id) {
        this.tlast_reply_user_id = tlast_reply_user_id;
    }

    public void setTreply_count(String treply_count) {
        this.treply_count = treply_count;
    }

    public void setTclick_count(String tclick_count) {
        this.tclick_count = tclick_count;
    }
}
