package com.se.tss.forum.Service;

import com.se.tss.Public.Adm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminService extends JpaRepository<Adm, String> {

}

