package com.se.tss.Public;

import javax.persistence.*;

@Entity
@Table(name="BBSUser")
public class BBSUser{
    @Id
    @Column(name = "UName")
    private  String UName;
    @Column(name = "UPassword")
    private  String UPwd;
    @Column(name="UEmail")
    private String UEmail;
    @Column(name = "UBirthday")
    private  String UBirthday;
    @Column(name = "USex")
    private  String USex;
    @Column(name="URegdata")
    private String URegdata;

    public String getUName() {
        return UName;
    }
    public void setUName(String UName) {
        this.UName = UName;
    }
    public String getUPwd() {
        return UPwd;
    }
    public void setUPwd(String UPwd) {
        this.UPwd = UPwd;
    }
    public String getUEmail() {
        return UEmail;
    }
    public void setUEmail(String UEmail) {
        this.UEmail = UEmail;
    }
    public String getUBirthday() {
        return UBirthday;
    }
    public void setUBirthday(String uBirthday) {
        this.UBirthday = uBirthday;
    }
    public String getUSex() {
        return UBirthday;
    }
    public void setUSex(String uSex) {
        this.USex= uSex;
    }
    public String getURegdata() {
        return URegdata;
    }
    public void setURegdata(String uRegData) {
        this.URegdata = uRegData;
    }

}