package com.se.tss.ExamOnline.Repository;

import com.se.tss.ExamOnline.Domain.ExamQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("examQuestionRepository")
public interface ExamQuestionRepository extends JpaRepository<ExamQuestion, Integer>, JpaSpecificationExecutor<ExamQuestion> {
    @Query(value = " select question_id from exam_question where exam_id = ?1 ", nativeQuery = true)
    List<Integer> findQuestionIdByExamId(Integer id);
}
