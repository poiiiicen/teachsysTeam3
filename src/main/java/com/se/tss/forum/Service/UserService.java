package com.se.tss.forum.Service;

import com.se.tss.Public.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserService extends JpaRepository<Users, String>{
}
