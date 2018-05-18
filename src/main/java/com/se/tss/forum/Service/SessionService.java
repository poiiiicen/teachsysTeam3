package com.se.tss.forum.Service;

import com.se.tss.Public.BBSSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionService extends JpaRepository<BBSSession, String> {
}

