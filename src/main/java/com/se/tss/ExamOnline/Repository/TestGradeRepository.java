package com.se.tss.ExamOnline.Repository;

import com.se.tss.ExamOnline.Domain.TestGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("testGradeRepository")
public interface TestGradeRepository extends JpaRepository<TestGrade, Integer>, JpaSpecificationExecutor<TestGrade> {
    TestGrade findFirstByExamIdAndAndStudentId(Integer eid, Integer sid);

    List<TestGrade> findAllByStudentId(Integer sid);
}
