package com.se.tss.CourseArrangeMgr.Service;

import com.se.tss.CourseArrangeMgr.Dao.ClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassInfoService extends JpaRepository<ClassInfo, String> {

     List<ClassInfo>  findAllByEquipment(String equipment);

     public ClassInfo findOneById(final String id);
}
