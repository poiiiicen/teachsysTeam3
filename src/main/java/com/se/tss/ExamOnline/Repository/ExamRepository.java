package com.se.tss.ExamOnline.Repository;

import com.se.tss.ExamOnline.Domain.Exam;
import com.se.tss.ExamOnline.Domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("examRepository")
public interface ExamRepository extends JpaRepository<Exam, Integer>, JpaSpecificationExecutor<Exam> {
    Exam findExamById(Integer id);

    @Query(value = " select max(id) from exam ", nativeQuery = true)
    Integer maxId();
}
