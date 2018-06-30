package com.se.tss.ExamOnline.Service;

import com.se.tss.ExamOnline.Domain.GradeResponseBody;
import com.se.tss.ExamOnline.Domain.TestGrade;
import com.se.tss.ExamOnline.Repository.TestGradeRepository;
import com.se.tss.ExamOnline.Repository.TestStudentCourseRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
}
