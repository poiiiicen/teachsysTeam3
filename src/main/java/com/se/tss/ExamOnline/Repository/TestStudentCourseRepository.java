package com.se.tss.ExamOnline.Repository;

import com.se.tss.ExamOnline.Domain.TestStudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("testStudentCourseRepository")
public interface TestStudentCourseRepository extends JpaRepository<TestStudentCourse, Integer> {
    @Query(value = " select course from test_student_course where student_id = ?1 ", nativeQuery = true)
    List<String> findCourseByStudentId(Integer id);
    //List<String> findCourseByStudentId(Integer id);
}
