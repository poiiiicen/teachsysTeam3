package com.se.tss.forum.Models;

public class ForumUser {
    private Integer uid;
    private String uname;
    private String authority;

    public ForumUser(Integer uid, String uname, String authority) {
        this.uid = uid;
        this.uname = uname;
        this.authority = authority;
    }
}
