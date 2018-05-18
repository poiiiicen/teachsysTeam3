package com.se.tss.Public;

import javax.persistence.*;

@Entity
@Table(name="bbs_user")
public class BBSUser{
    @Id
    @Column(name = "uid")
    private String uid;
    @Column(name = "uname")
    private  String uname;
    @Column(name = "upassword")
    private  String upwd;
    @Column(name="uemail")
    private String uemail;
    @Column(name = "ubirthday")
    private  String ubirthday;
    @Column(name = "usex")
    private  String usex;
    @Column(name="uregdata")
    private String uregdata;
    public String getUid(){return  uid;}
    public void setUid(String UID){this.uid = UID;}
    public String getUname() {
        return uname;
    }
    public void setUname(String UName) {
        this.uname = UName;
    }
    public String getUpwd() {
        return upwd;
    }
    public void setUpwd(String UPwd) {
        this.upwd = UPwd;
    }
    public String getUemail() {
        return uemail;
    }
    public void setUemail(String UEmail) {
        this.uemail = UEmail;
    }
    public String getUbirthday() {
        return ubirthday;
    }
    public void setUbirthday(String uBirthday) {
        this.ubirthday = uBirthday;
    }
    public String getUsex() {
        return usex;
    }
    public void setUsex(String uSex) {
        this.usex = uSex;
    }
    public String getUregdata() {
        return uregdata;
    }
    public void setUregdata(String uRegData) {
        this.uregdata = uRegData;
    }

}