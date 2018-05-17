package com.se.tss.forum.Service;

import com.se.tss.Public.BBSUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserService extends JpaRepository<BBSUser, String>{
}
