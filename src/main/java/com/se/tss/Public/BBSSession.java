package com.se.tss.Public;


import javax.persistence.*;

@Entity
@Table(name="bbs_session")
public class BBSSession{
    @Id
    @Column(name="sid")
    private String sid;
    @Column(name = "sname")
    private  String sname;
    @Column(name = "sprofile")
    private  String sprofile;
    @Column(name="stopic_count")
    private String stopic_count;
    @Column(name = "sclick_count")
    private  String sclick_count;

    public String getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public String getSprofile() {
        return sprofile;
    }

    public String getSclick_count() {
        return sclick_count;
    }

    public String getStopic_count() {
        return stopic_count;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSprofile(String sprofile) {
        this.sprofile = sprofile;
    }

    public void setStopic_count(String stopic_count) {
        this.stopic_count = stopic_count;
    }

    public void setSclick_count(String sclick_count) {
        this.sclick_count = sclick_count;
    }
}