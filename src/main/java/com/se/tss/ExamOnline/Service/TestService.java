package com.se.tss.ExamOnline.Service;

import com.se.tss.ExamOnline.Domain.Exam;
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

}
