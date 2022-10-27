package com.toj.teacheronlinejudge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class TeacherOnlineJudgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeacherOnlineJudgeApplication.class, args);
    }

}
