package com.se.tss.ExamOnline.Service;

import com.se.tss.ExamOnline.Repository.ExamRepository;
import com.se.tss.ExamOnline.Repository.TestGradeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "testService")
public class TestService {
    @Resource
    private TestGradeRepository testGradeRepository;
    @Resource
    private ExamRepository examRepository;

}
