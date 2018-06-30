package com.se.tss.ExamOnline.Service;

import com.se.tss.ExamOnline.Domain.Question;
import com.se.tss.ExamOnline.Repository.QuestionLibRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service(value = "questionQueryService")
public class QuestionService {
    @Resource
    private QuestionLibRepository questionLibRepository;

    public List<Question> findQuestion(String course, Integer type, String description, String[] tags) {
        return questionLibRepository.findAll((Specification<Question>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(criteriaBuilder.equal(root.get("visible").as(Boolean.class), true));
            list.add(criteriaBuilder.equal(root.get("course").as(String.class), course));
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

    public void addQuestion(Question question, Integer id) {
        question.setId(id);
        question.setVisible(true);
        questionLibRepository.save(question);
    }

    public Integer modifyQuestion(Question question, Integer id) {
        if (deleteQuestionById(question.getId())) {
            try {
                addQuestion(question, id);
            } catch (DataIntegrityViolationException e) {
                recoverQuestionById(question.getId());
                return 2;
            }
            return 0;
        } else {
            return 1;
        }
    }

    private void recoverQuestionById(Integer id) {
        @NotNull
        Question question = questionLibRepository.findQuestionById(id);
        question.setVisible(true);
        questionLibRepository.save(question);
    }

    public boolean deleteQuestionById(Integer id) {
        @NotNull
        Question question = questionLibRepository.findQuestionById(id);
        if (!question.isVisible()) return false;
        question.setVisible(false);
        questionLibRepository.save(question);
        return true;
    }

    public Integer queryMaxId() {
        return questionLibRepository.maxId();
    }
}
