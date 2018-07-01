package com.se.tss.ExamOnline.Repository;

import com.se.tss.ExamOnline.Domain.TestGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("testGradeRepository")
public interface TestGradeRepository extends JpaRepository<TestGrade, Integer>, JpaSpecificationExecutor<TestGrade> {
    TestGrade findFirstByExamIdAndAndStudentId(Integer eid, Integer sid);

    List<TestGrade> findAllByStudentId(Integer sid);

    List<TestGrade> findAllByExamId(Integer eid);

    @Query(value = " select max(grade) from test_grade where exam_id = ?1 and grade is not null ", nativeQuery = true)
    Double maxGradeByExamId(Integer eid);

    @Query(value = " select min(grade) from test_grade where exam_id = ?1 and grade is not null ", nativeQuery = true)
    Double minGradeByExamId(Integer eid);

    @Query(value = " select avg(grade) from test_grade where exam_id = ?1 and grade is not null ", nativeQuery = true)
    Double avgGradeByExamId(Integer eid);
}
