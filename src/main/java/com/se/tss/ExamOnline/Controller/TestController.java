package com.se.tss.ExamOnline.Controller;

import com.se.tss.ExamOnline.Service.TestService;
import com.se.tss.infomgr.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam/test")
public class TestController {
    private final TestService testService;
    private final UserRepository userRepository;

    @Autowired
    public TestController(TestService testService, UserRepository userRepository) {
        this.testService = testService;
        this.userRepository = userRepository;
    }
}
