package com.edu.neu.studyapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.neu.studyapp.entity.Choice;
import com.edu.neu.studyapp.entity.Question;
import com.edu.neu.studyapp.mapper.ChoiceMapper;
import com.edu.neu.studyapp.mapper.QuestionMapper;
import com.edu.neu.studyapp.service.ChoiceService;
import com.edu.neu.studyapp.service.QuestionService;
import com.edu.neu.studyapp.vo.AnswerSheetResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ChoiceServiceImpl implements ChoiceService {
    @Autowired
    private ChoiceMapper choiceMapper;
    @Autowired
    private QuestionService questionService;
    @Override
    public List<Choice> findAllByQuestId(Integer id) {
        return choiceMapper.selectList(new QueryWrapper<Choice>().eq("quest_id",id));
    }

    @Override
    public Choice findById(Integer id) {
        return choiceMapper.selectOne(new QueryWrapper<Choice>().eq("opt_id",id));
    }

    @Override
    public AnswerSheetResultVO getSingleMapScore(Map<Integer, Integer> singleMap) {
        AnswerSheetResultVO answerSheetResultVO = new AnswerSheetResultVO();
        int score = 0;
        int pass = 0;
        int fail = 0;
        String singleResult = "";
        if(singleMap.size()!= 0){
            for(Integer quest_id: singleMap.keySet()){
                singleResult = singleResult + quest_id + ":";
                if(findById(singleMap.get(quest_id)).getIsAnswer()==1){
                    score+=questionService.findById(quest_id).getScore();
                    singleResult = singleResult + "1;";
                    pass++;
                }else {
                    singleResult = singleResult + "0;";
                    fail++;
                }
            }
        }
        answerSheetResultVO.setScore(score);
        answerSheetResultVO.setAnswersheetResult(singleResult);
        answerSheetResultVO.setPassNum(pass);
        answerSheetResultVO.setFailNum(fail);
        return answerSheetResultVO;
    }

    @Override
    public AnswerSheetResultVO getMultipleMapScore( Map<Integer, List<Integer>> multipleMap) {
        AnswerSheetResultVO answerSheetResultVO = new AnswerSheetResultVO();
        int score = 0;
        int pass = 0;
        int fail = 0;
        String multipleResult = "";
        boolean flag = true;
        if(multipleMap.size()!= 0){
            for(Integer quest_id: multipleMap.keySet()){
                multipleResult = multipleResult + quest_id + ":";
                System.out.println("------for判断内列表大小---"+multipleMap.get(quest_id).size()+"-------");
                if(multipleMap.get(quest_id).size()!=findChoicesByQuestId(quest_id).size()){
                    flag = false;
                }else {
                    for(Integer opt_id:multipleMap.get(quest_id)){
                        if(findById(opt_id).getIsAnswer()==0){
                            flag = false;
                            break;
                        }
                    }
                }

                if(flag==true){
                    multipleResult = multipleResult + "1;";
                    score+=questionService.findById(quest_id).getScore();
                    pass++;
                }else if(flag == false) {
                    multipleResult = multipleResult + "0;";
                    fail++;
                }
                flag = true;
            }
        }
        answerSheetResultVO.setScore(score);
        answerSheetResultVO.setAnswersheetResult(multipleResult);
        answerSheetResultVO.setPassNum(pass);
        answerSheetResultVO.setFailNum(fail);
        return answerSheetResultVO;
    }

    @Override
    public List<Choice> findChoicesByQuestId(Integer id) {
        List<Choice> checkedList = new ArrayList<>();
        for(Choice choice:choiceMapper.selectList(new QueryWrapper<Choice>().eq("quest_id",id))){
            if (choice.getIsAnswer()==1){
                checkedList.add(choice);
            }
        }
        System.out.println("------多选正确列表大小---"+checkedList.size()+"-------");
        return checkedList;
    }
}
