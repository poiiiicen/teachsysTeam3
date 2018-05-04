package com.se.tss.Public;

import javax.persistence.*;

@Entity
@Table(name="Adm")
public class Adm {
    @Id
    @Column(name="id")
    private String id;
    @Column(name = "password")
    private  String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
