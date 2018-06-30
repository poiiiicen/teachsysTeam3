package com.se.tss.ExamOnline.Repository;

import com.se.tss.ExamOnline.Domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("questionLibRepository")
public interface QuestionLibRepository extends JpaRepository<Question, Integer>, JpaSpecificationExecutor<Question> {
    Question findQuestionById(Integer id);

    @Query(value = " select max(id) from question ", nativeQuery = true)
    Integer maxId();

    List<Question> findAllByVisibleTrueAndIdIn(List<Integer> questionIds);
}
