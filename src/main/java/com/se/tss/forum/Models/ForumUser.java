package com.se.tss.forum.Models;

public class ForumUser {
    private Integer uid;
    private String name;
    private String authority;

    public ForumUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ForumUser(Integer uid, String name, String authority) {
        this.uid = uid;
        this.name = name;
        this.authority = authority;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }



    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
