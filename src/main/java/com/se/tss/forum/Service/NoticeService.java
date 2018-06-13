package com.se.tss.forum.Service;

import com.se.tss.Public.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeService extends JpaRepository<NoticeEntity, String> {

}