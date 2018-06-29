package com.se.tss.forum.Service;

import com.se.tss.forum.Entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionService extends JpaRepository<SessionEntity, String> {
    SessionEntity findByName(String name);
    SessionEntity findBySid(String sid);

}

