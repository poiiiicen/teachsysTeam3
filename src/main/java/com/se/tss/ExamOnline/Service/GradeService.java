package com.se.tss.ExamOnline.Service;

import com.se.tss.ExamOnline.Domain.Exam;
import com.se.tss.ExamOnline.Domain.GradeResponseBody;
import com.se.tss.ExamOnline.Domain.TestGrade;
import com.se.tss.ExamOnline.Repository.TestGradeRepository;
import com.se.tss.ExamOnline.Repository.TestStudentCourseRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service(value = "gradeService")
public class GradeService {
    @Resource
    private TestGradeRepository testGradeRepository;
    @Resource
    private TestStudentCourseRepository testStudentCourseRepository;
    @Resource
    private ExamService examService;

    public List<GradeResponseBody.ExamGrade> getHistoryGrade(Integer sid) {
        List<TestGrade> testGrades = testGradeRepository.findAllByStudentId(sid);
        List<GradeResponseBody.ExamGrade> examGrades = new ArrayList<>();
        for (TestGrade testGrade : testGrades) {
            if (testGrade.getGrade() == null) continue;
            GradeResponseBody.ExamGrade examGrade = new GradeResponseBody.ExamGrade();
            examGrade.setExam(examService.findExamById(testGrade.getExamId()));
            examGrade.setGrade(testGrade.getGrade());
            examGrades.add(examGrade);
        }
        return examGrades;
    }

    public List<Exam> getExams(List<String> courses) {
        if (courses == null) return examService.findExamBefore(null, null, null, new Date(), true, null);
        List<Exam> exams = new ArrayList<>();
        for (String course : courses) {
            exams.addAll(examService.findExamBefore(course, null, null, new Date(), true, null));
        }
        return exams;
    }

    public GradeResponseBody.ExamGrade getStatistic(Integer eid) {
        GradeResponseBody.ExamGrade examGrade = new GradeResponseBody.ExamGrade();
        examGrade.setAvgGrade(testGradeRepository.avgGradeByExamId(eid));
        examGrade.setMaxGrade(testGradeRepository.maxGradeByExamId(eid));
        examGrade.setMinGrade(testGradeRepository.minGradeByExamId(eid));
        examGrade.setMinGrade(testGradeRepository.minGradeByExamId(eid));
        return examGrade;
    }
}
