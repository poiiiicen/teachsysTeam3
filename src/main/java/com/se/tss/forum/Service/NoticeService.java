package com.se.tss.forum.Service;

import com.se.tss.forum.Entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeService extends JpaRepository<NoticeEntity, String> {
    NoticeEntity findByNid(Integer nid);

}