package com.se.tss.Public;

import javax.persistence.*;

@Entity
@Table(name="Adm")
public class Adm {

    @Id
    @GeneratedValue
    private Integer aid;

    @Column(length = 32, unique = true, nullable = false)
    private String name;

    @Column(length = 64, nullable = false)
    private String password;
    public Adm() {
    }
    public Adm(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
