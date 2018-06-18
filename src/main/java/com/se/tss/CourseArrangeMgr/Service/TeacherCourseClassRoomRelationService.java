package com.se.tss.CourseArrangeMgr.Service;

import com.se.tss.CourseArrangeMgr.Dao.TeacherCourseClassRoomRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherCourseClassRoomRelationService extends JpaRepository<TeacherCourseClassRoomRelation, String> {

}
