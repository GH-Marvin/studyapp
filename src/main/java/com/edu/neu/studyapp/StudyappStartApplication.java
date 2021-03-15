package com.edu.neu.studyapp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class StudyappStartApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(StudyappApplication.class);
    }
    //这个类继承至SpringBoorServletInitializer,并覆盖了其configuer方法
}
