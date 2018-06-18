package com.se.tss.CourseArrangeMgr.Service;

import com.se.tss.CourseArrangeMgr.Dao.TeacherInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherInfoService extends JpaRepository<TeacherInfo, String> {
}
