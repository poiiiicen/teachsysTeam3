package com.se.tss.ExamOnline.Repository;

import com.se.tss.ExamOnline.Domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionLibRepository extends JpaRepository<Question, Integer> {
}
