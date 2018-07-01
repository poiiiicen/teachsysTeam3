package com.se.tss.ExamOnline.Service;

import com.se.tss.ExamOnline.Domain.*;
import com.se.tss.ExamOnline.Repository.ExamQuestionRepository;
import com.se.tss.ExamOnline.Repository.ExamRepository;
import com.se.tss.ExamOnline.Repository.QuestionLibRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service(value = "examService")
public class ExamService {
    @Resource
    private QuestionLibRepository questionLibRepository;
    @Resource
    private QuestionService questionService;
    @Resource
    private ExamRepository examRepository;
    @Resource
    private ExamQuestionRepository examQuestionRepository;

    private Lock lock = new ReentrantLock();

    public List<Exam> findExamBefore(String course, String name, Date startTime, Date endTime, Boolean publish, Boolean over) {
        return examRepository.findAll((Specification<Exam>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(criteriaBuilder.equal(root.get("visible").as(Boolean.class), true));
            if (course != null && !"".equals(course)) {
                list.add(criteriaBuilder.equal(root.get("course").as(String.class), course));
            }
            if (name != null && !"".equals(name)) {
                list.add(criteriaBuilder.like(root.get("name").as(String.class), "%" + name + "%"));
            }
            if (startTime != null) {
                list.add(criteriaBuilder.greaterThanOrEqualTo(root.get("startTime").as(Date.class), startTime));
            }
            if (endTime != null) {
                list.add(criteriaBuilder.lessThanOrEqualTo(root.get("endTime").as(Date.class), endTime));
            }
            if (publish != null) {
                list.add(criteriaBuilder.equal(root.get("publish").as(Boolean.class), publish));
            }
            if (over != null) {
                list.add(criteriaBuilder.equal(root.get("over").as(Boolean.class), over));
            }
            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        });
    }

    public List<Exam> findExam(String course, String name, Date startTime, Date endTime, Boolean publish, Boolean over) {
        return examRepository.findAll((Specification<Exam>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(criteriaBuilder.equal(root.get("visible").as(Boolean.class), true));
            if (course != null && !"".equals(course)) {
                list.add(criteriaBuilder.equal(root.get("course").as(String.class), course));
            }
            if (name != null && !"".equals(name)) {
                list.add(criteriaBuilder.like(root.get("name").as(String.class), "%" + name + "%"));
            }
            if (startTime != null) {
                list.add(criteriaBuilder.greaterThanOrEqualTo(root.get("startTime").as(Date.class), startTime));
            }
            if (endTime != null) {
                list.add(criteriaBuilder.greaterThanOrEqualTo(root.get("endTime").as(Date.class), endTime));
            }
            if (publish != null) {
                list.add(criteriaBuilder.equal(root.get("publish").as(Boolean.class), publish));
            }
            if (over != null) {
                list.add(criteriaBuilder.equal(root.get("over").as(Boolean.class), over));
            }
            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        });
    }

    public Exam findExamById(Integer id) {
        return examRepository.findExamById(id);
    }

    public String findCourseById(Integer id) {
        Exam exam = examRepository.findExamById(id);
        if (exam == null) return null;
        return exam.getCourse();
    }

    public List<Question> getAllQuestionsByExamId(Integer id) {
        List<Integer> questionIds = examQuestionRepository.findQuestionIdByExamId(id);
        List<Question> questions = questionLibRepository.findAllByVisibleTrueAndIdIn(questionIds);
        return questions;
    }

    public void addExamWithQuestions(ExamRequestBody examRequestBody) {
        Exam exam = examRequestBody.getExam();
        lock.lock();
        try {
            exam.setId(examRepository.maxId() + 1);
            exam.setVisible(true);
            examRepository.save(exam);
            for (Integer questionId :
                    examRequestBody.getQuestionIds()) {
                ExamQuestion examQuestion = new ExamQuestion();
                examQuestion.setExamId(exam.getId());
                examQuestion.setQuestionId(questionId);
                examQuestionRepository.save(examQuestion);
            }
        } catch (Exception ignore) {

        } finally {
            lock.unlock();
        }
    }

    public void addExamWithoutQuestion(ExamRequestBody examRequestBody) {
        Exam exam = examRequestBody.getExam();
        lock.lock();
        try {
            exam.setId(examRepository.maxId() + 1);
            exam.setVisible(true);
            examRepository.save(exam);
            List<Question> selection = questionService.findQuestion(exam.getCourse(), QuestionType.SELECTION, null, null);
            List<Question> judgement = questionService.findQuestion(exam.getCourse(), QuestionType.JUDGEMENT, null, null);
            List<Integer> questionIds = new ArrayList<>();
            Random random = new Random();
            for (Integer i = 0; i < examRequestBody.getSelectionNum(); i++) {
                questionIds.add(selection.get(random.nextInt(selection.size())).getId());
            }
            for (Integer i = 0; i < examRequestBody.getJudgementNum(); i++) {
                questionIds.add(judgement.get(random.nextInt(judgement.size())).getId());
            }
            for (Integer questionId :
                    questionIds) {
                ExamQuestion examQuestion = new ExamQuestion();
                examQuestion.setExamId(exam.getId());
                examQuestion.setQuestionId(questionId);
                examQuestionRepository.save(examQuestion);
            }
        } catch (Exception ignored) {

        } finally {
            lock.unlock();
        }
    }

    public void modifyExam(ExamRequestBody examRequestBody) {
        Exam exam = examRepository.findExamById(examRequestBody.getExam().getId());
        exam.setVisible(false);
        examRepository.save(exam);
        addExamWithQuestions(examRequestBody);
    }

    public Boolean deleteExam(Integer id) {
        Exam exam = examRepository.findExamById(id);
        if (!exam.getVisible()) {
            return false;
        } else exam.setVisible(false);
        return true;
    }

}
