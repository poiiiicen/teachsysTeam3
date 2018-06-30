package com.se.tss.ExamOnline.Service;

import com.se.tss.ExamOnline.Repository.TestStudentCourseRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "testStudentCourseService")
public class TestStudentCourseService {
    @Resource
    private TestStudentCourseRepository testStudentCourseRepository;

    public List<String> findCoursesByStudentId(Integer id) {
        return testStudentCourseRepository.findCourseByStudentId(id);
    }
}
