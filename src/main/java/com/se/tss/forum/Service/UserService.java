package com.se.tss.forum.Service;

import com.se.tss.Public.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserService extends JpaRepository<UserEntity, String>{
    UserEntity findByName(String name);
}
