package com.se.tss.ExamOnline.Service;

import com.se.tss.ExamOnline.Domain.Question;
import com.se.tss.ExamOnline.Repository.QuestionLibRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.validation.constraints.NotNull;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "questionQueryService")
public class QuestionService {
    @Resource
    private QuestionLibRepository questionLibRepository;

    public List<Question> findQuestion(Integer type, String description, String[] tags) {
        return questionLibRepository.findAll((Specification<Question>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(criteriaBuilder.equal(root.get("visible").as(Boolean.class), true));
            if (type != null) {
                list.add(criteriaBuilder.equal(root.get("type").as(Integer.class), type));
            }
            if (description != null && !"".equals(description)) {
                list.add(criteriaBuilder.like(root.get("description").as(String.class), "%" + description + "%"));
            }
            // TODO: add tag search
            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        });
    }

    public String findCourseById(Integer id) {
        Question question = questionLibRepository.findQuestionById(id);
        if (question == null) return null;
        return questionLibRepository.findQuestionById(id).getCourse();
    }

    public void addQuestion(Question question) {
        questionLibRepository.save(question);
    }

    public boolean deleteQuestionById(Integer id) {
        @NotNull
        Question question = questionLibRepository.findQuestionById(id);
        if (!question.getVisible()) return false;
        question.setVisible(false);
        questionLibRepository.save(question);
        return true;
    }

    public Integer queryMaxId() {
        return questionLibRepository.maxId();
    }
}
