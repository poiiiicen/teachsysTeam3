package com.se.tss.forum.Service;


import com.se.tss.Public.BBSTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface TopicService extends JpaRepository<BBSTopic, String> {
    List<BBSTopic> findByTsid(int sid);
}

