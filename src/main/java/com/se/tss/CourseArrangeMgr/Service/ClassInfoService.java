package com.se.tss.CourseArrangeMgr.Service;

import com.se.tss.CourseArrangeMgr.Dao.ClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassInfoService extends JpaRepository<ClassInfo, String> {

     List<ClassInfo>  findAllByEquipment(String equipment);

     ClassInfo findOneById(final String id);

     @Query(value = "select name from class where  id= ?1 limit 1",nativeQuery=true)
     String getNameById(String classId);

     @Query(value = "select id from class where  teacherid = ?1 and name= ?2 limit 1",nativeQuery=true)
     String getIdByTeacherIdAndName(String teacherId,String name);

     @Query(value = "select * from class where  teacherid = ?1 ",nativeQuery=true)
     List<ClassInfo> findAllByTeacherId(String teacherId);

     @Query(value = "select teacherid from class where  name = ?1 ",nativeQuery=true)
     List<String> findAllByName(String name);

}
