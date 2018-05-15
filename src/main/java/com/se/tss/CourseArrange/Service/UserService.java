package com.se.tss.CourseArrange.Service;

import com.se.tss.Public.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserService extends JpaRepository<Users, String>{
}
