package com.se.tss.ExamOnline.Repository;

import com.se.tss.ExamOnline.Domain.TestGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository("testGradeRepository")
public interface TestGradeRepository extends JpaRepository<TestGrade, Integer>, JpaSpecificationExecutor<TestGrade> {
}
