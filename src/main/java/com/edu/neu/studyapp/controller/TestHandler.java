package com.edu.neu.studyapp.controller;


import com.edu.neu.studyapp.entity.Choice;
import com.edu.neu.studyapp.entity.Question;
import com.edu.neu.studyapp.entity.Test;
import com.edu.neu.studyapp.entity.UserTest;
import com.edu.neu.studyapp.service.ChoiceService;
import com.edu.neu.studyapp.service.QuestionService;
import com.edu.neu.studyapp.service.TestService;
import com.edu.neu.studyapp.service.UserTestService;
import com.edu.neu.studyapp.vo.UserTestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestHandler {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private TestService testService;
    @Autowired
    private ChoiceService choiceService;
    @Autowired
    private UserTestService userTestService;


    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url) {
        return url;
    }


    @GetMapping("/findAll")
    public List<Test> findAll(){
        return testService.findAll();
    }

    @GetMapping("/findQuestionsByTestId/{test_id}")
    @ResponseBody
    public List<Question> findByTestId(@PathVariable("test_id") String test_id){
        return questionService.findByTestId(Integer.valueOf(test_id));
    }

    @GetMapping("/findChoicesById/{quest_id}")
    @ResponseBody
    public Map<String,List<Choice>> findChoicesByQuestId(@PathVariable("quest_id") String quest_id){
        List<Choice> choiceList = choiceService.findAllByQuestId(Integer.valueOf(quest_id));
        String type = questionService.findTypeById(Integer.valueOf(quest_id));
        Map<String,List<Choice>> map = new HashMap<>();
        map.put(type,choiceList);
        return map;
    }
    @GetMapping("/initTestPage/{user_id}")
    @ResponseBody
    public UserTestVO initTestPage(@PathVariable("user_id") String user_id){
        UserTest userTest = userTestService.findById(Integer.valueOf(user_id));
        Test test = testService.findById(userTest.getHistory());
        return new UserTestVO(userTest.getUtId(),userTest.getUserId(),userTest.getPassNum(),userTest.getFailNum(),userTest.getNotryNum(),test);
    }


}
