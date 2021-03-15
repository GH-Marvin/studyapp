package com.edu.neu.studyapp.service.impl;

import com.edu.neu.studyapp.service.ChoiceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChoiceServiceImplTest {
    @Autowired
    private ChoiceService choiceService;
    @Test
    void findAllByQuestId() {
        choiceService.findAllByQuestId(10001);
        int i = 0;
    }
}