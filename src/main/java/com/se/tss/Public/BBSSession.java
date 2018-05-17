package com.se.tss.Public;


import javax.persistence.*;

@Entity
@Table(name="BBSSession")
public class BBSSession{
    @Id
    @Column(name="SID")
    private String SID;
    @Column(name = "SName")
    private  String SName;
    @Column(name = "SProfile")
    private  String SProfile;
    @Column(name="STopicCount")
    private String STopicCount;
    @Column(name = "SClickCount")
    private  String SClickCount;

    public String getSID() {
        return SID;
    }
    public void setSID(String SID) {
        this.SID = SID;
    }
    public String getSName() {
        return SName;
    }
    public void setSName(String SName) {
        this.SName = SName;
    }
    public String getSProfile() {
        return SProfile;
    }
    public void setSProfile(String SProfile) {
        this.SProfile = SProfile;
    }
    public String getSTopicCount() {
        return STopicCount;
    }
    public void setSTopicCount(String STopicCount) {
        this.STopicCount = STopicCount;
    }
    public String getSClickCount() {
        return SClickCount;
    }
    public void setSClickCount(String SClickCount) {
        this.SClickCount= SClickCount;
    }
}