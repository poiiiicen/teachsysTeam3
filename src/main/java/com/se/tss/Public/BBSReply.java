package com.se.tss.Public;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bbs_reply")
public class BBSReply{
    @Id
    @Column(name="rid")
    private String rid;
    @Column(name="rtid")
    private String rtid;
    @Column(name="rsid")
    private String rsid;
    @Column(name="ruid")
    private String ruid;
    @Column(name="rcontent")
    private String rcontent;
    @Column(name="rtime")
    private String rtime;

    public String getRid() {
        return rid;
    }

    public String getRsid() {
        return rsid;
    }

    public String getRtid() {
        return rtid;
    }

    public String getRuid() {
        return ruid;
    }

    public String getRcontent() {
        return rcontent;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public void setRsid(String rsid) {
        this.rsid = rsid;
    }

    public void setRtid(String rtid) {
        this.rtid = rtid;
    }

    public void setRuid(String ruid) {
        this.ruid = ruid;
    }

    public void setRcontent(String rcontent) {
        this.rcontent = rcontent;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

}
