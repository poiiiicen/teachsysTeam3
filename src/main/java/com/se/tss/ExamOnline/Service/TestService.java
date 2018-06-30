package com.se.tss.ExamOnline.Service;

import com.se.tss.ExamOnline.Domain.*;
import com.se.tss.ExamOnline.Repository.ExamRepository;
import com.se.tss.ExamOnline.Repository.TestGradeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service(value = "testService")
public class TestService {
    @Resource
    private TestGradeRepository testGradeRepository;
    @Resource
    private ExamService examService;

    public List<Exam> findExamByCoursesAndPublishTrue(List<String> courses) {
        if (courses == null) return examService.findExam(null, null, null, new Date(), true, null);
        List<Exam> exams = new ArrayList<>();
        for (String course : courses) {
            exams.addAll(examService.findExam(course, null, null, new Date(), true, null));
        }
        return exams;
    }

    public List<Question> findQuestionByExamId(Integer id) {
        List<Question> questions = examService.getAllQuestionsByExamId(id);
        for (Question question : questions) {
            question.setAnswer(0);
        }
        return questions;
    }

    public TestGrade findTestGradeByExamIdAndStudentId(Integer eid, Integer sid) {
        return testGradeRepository.findFirstByExamIdAndAndStudentId(eid, sid);
    }

    public void storeSheet(Answer answer, Integer sid) {
        TestGrade testGrade = findTestGradeByExamIdAndStudentId(answer.getExamId(), sid);
        if (testGrade == null) {
            testGrade = new TestGrade();
            testGrade.setExamId(answer.getExamId());
            testGrade.setStudentId(sid);
            testGrade.setGrade(null);
        }
        if (testGrade.getGrade() != null) return;
        Date date = new Date();
        Exam exam = examService.findExamById(answer.getExamId());
        if (date.getTime() > exam.getEndTime().getTime() || answer.getCommit()) {
            testGrade.setGrade(calcGrade(answer, exam.getSelectionGrade(), exam.getJudgementGrade()));
        }
        testGrade.setAnswer(answer.getAnswer());
        testGradeRepository.save(testGrade);
    }

    private Double calcGrade(Answer answer, Double selectionGrade, Double judegementGrade) {
        List<Question> questions = examService.getAllQuestionsByExamId(answer.getExamId());
        Double grade = 0.0;
        for (Integer i = 0; i < questions.size(); ++i) {
            if (answer.getAnswer().get(i).equals(questions.get(i).getAnswer())) {
                grade += questions.get(i).getType() == QuestionType.SELECTION ? selectionGrade : judegementGrade;
            }
        }
        return grade;
    }

}
