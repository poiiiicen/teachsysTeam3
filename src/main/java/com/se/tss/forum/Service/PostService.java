package com.se.tss.forum.Service;

import com.se.tss.Public.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostService extends JpaRepository<Post, String>{
}

