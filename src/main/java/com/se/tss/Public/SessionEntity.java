package com.se.tss.Public;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "session")
public class SessionEntity {
    @Id
    @GeneratedValue
    private Integer sid;

    @Column(length = 64, unique = true, nullable = false)
    private String name;

    @Column()
    private String profile;

    @Column()
    private Integer topicCount;

    @Column()
    private Integer clickCount;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostEntity> postEntities = new ArrayList<>();

    public SessionEntity(){}
    public SessionEntity(String name, String profile, Integer topicCount, Integer clickCount) {
        this.name = name;
        this.profile = profile;
        this.topicCount = topicCount;
        this.clickCount = clickCount;
    }

    public List<PostEntity> getPostEntities() {
        return postEntities;
    }

    public void setPostEntities(List<PostEntity> postEntities) {
        this.postEntities = postEntities;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Integer getTopicCount() {
        return topicCount;
    }

    public void setTopicCount(Integer topicCount) {
        this.topicCount = topicCount;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }
}
