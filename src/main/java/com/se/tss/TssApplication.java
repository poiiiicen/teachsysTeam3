package com.se.tss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.se.tss.infomgr"})
//@ComponentScan(basePackageClasses = ForumUserService.class)
//@EntityScan("com.se.tss.infomgr.model")
//@EnableJpaRepositories("com.se.tss.infomgr.model")
@EnableJpaAuditing
public class TssApplication {

    public static void main(String[] args) {
        SpringApplication.run(TssApplication.class, args);
    }
}
