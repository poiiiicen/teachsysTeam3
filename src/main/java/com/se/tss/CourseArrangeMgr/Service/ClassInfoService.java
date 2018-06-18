package com.se.tss.CourseArrangeMgr.Service;

import com.se.tss.CourseArrangeMgr.Dao.ClassRoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassInfoService extends JpaRepository<ClassRoomInfo, String> {

}
