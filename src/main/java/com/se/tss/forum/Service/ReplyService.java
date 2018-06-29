package com.se.tss.forum.Service;


import com.se.tss.forum.Entity.ReplyEntity;
import com.se.tss.forum.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyService extends JpaRepository<ReplyEntity, String> {
    List<ReplyEntity> findByCreatorOrderByReplyTimeDesc(UserEntity u);
}

