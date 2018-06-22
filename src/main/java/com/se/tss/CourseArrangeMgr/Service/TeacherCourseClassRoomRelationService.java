package com.se.tss.CourseArrangeMgr.Service;

import com.se.tss.CourseArrangeMgr.Dao.TeacherCourseClassRoomRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TeacherCourseClassRoomRelationService extends JpaRepository<TeacherCourseClassRoomRelation, String> {

    @Transactional
    @Query(value = "insert into teacher_course_class_room_relation(teacherid,courseid,classroomid,weekday, timeperiod) values(?1, ?2, ?3, ?4, ?5)",nativeQuery=true)
    @Modifying
    void doInsert(String teacherid, String courseid, String classroomid, Integer weekday, Integer timeperiod);

    @Transactional
    @Query(value="delete from teacher_course_class_room_relation where teacherid=?1 and courseid=?2 and classRoomid=?3",nativeQuery=true)
    @Modifying
    void doDelete(String teacherid, String courseid, String classroomid);

    @Transactional
    @Query(value="truncate table teacher_course_class_room_relation",nativeQuery=true)
    @Modifying
    void DeleteAll();

    List<TeacherCourseClassRoomRelation> findAllByTeacherid(String teacherId);

    List<TeacherCourseClassRoomRelation> findAllByCourseid(String courseid);

    List<TeacherCourseClassRoomRelation> findAllByClassroomid(String classroomid);

    TeacherCourseClassRoomRelation findOneByClassroomidAndTeacheridAndCourseid(String classroomid, String teacherid, String courseid);
}
