package com.se.tss.CourseArrangeMgr.Service;

import com.se.tss.CourseArrangeMgr.Dao.TeacherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherInfoService extends JpaRepository<TeacherInfo, String> {
    TeacherInfo findTeacherInfoById(String id);

    @Query(value = "select name from teacher where  id= ?1",nativeQuery=true)
    String findNanme(String id);

    @Query(value = "select id from teacher where  name= ?1 limit 1",nativeQuery=true)
    String findIdByName(String name);
}
