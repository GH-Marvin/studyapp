package com.edu.neu.studyapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.edu.neu.studyapp.mapper")
public class StudyappApplication  {

    public static void main(String[] args) {
        SpringApplication.run(StudyappApplication.class, args);
    }

}
