package com.se.tss.forum.Service;

import com.se.tss.Public.SelectClass.ClassRoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ClassInfoService extends JpaRepository<ClassRoomInfo, String> {

}
