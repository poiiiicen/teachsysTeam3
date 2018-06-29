package com.se.tss.forum.Service;

import com.se.tss.forum.Entity.PostEntity;
import com.se.tss.forum.Entity.SessionEntity;
import com.se.tss.forum.Entity.UserEntity;
import com.se.tss.forum.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostService extends JpaRepository<PostEntity, String> {
    PostEntity findByTopic(String topic);
    PostEntity findByPid(Integer pid);
    List<PostEntity> findByCreatorOrderByCreateTimeDesc(UserEntity u);
    List<PostEntity> findAllBySessionOrderByCreateTimeDesc(SessionEntity s);
    List<PostEntity> findByContentContainingOrderByLastReplyTimeDesc(String key);
}