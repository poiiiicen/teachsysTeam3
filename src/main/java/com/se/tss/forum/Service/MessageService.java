package com.se.tss.forum.Service;

import com.se.tss.Public.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageService extends JpaRepository<MessageEntity, String> {
}
