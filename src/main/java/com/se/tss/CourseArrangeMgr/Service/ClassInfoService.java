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
}
