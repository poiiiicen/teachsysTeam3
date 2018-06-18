package com.se.tss.CourseArrangeMgr.Service;

import com.se.tss.CourseArrangeMgr.Dao.TeacherCourseClassRoomRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TeacherCourseClassRoomRelationService extends JpaRepository<TeacherCourseClassRoomRelation, String> {

    @Transactional
    @Query(value = "insert into teacherCourseClassRoomRelation(teacherId,courseId,classRoomId,weekday, timePeriod) values(?1, ?2, ?3, ?4, ?5)",nativeQuery=true)
    @Modifying
    void doInsert(String teacherId, String courseId, String classRoomId, Integer weekday, Integer timePeriod);
}
