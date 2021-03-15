package com.edu.neu.studyapp.service;

import com.edu.neu.studyapp.entity.Choice;
import com.edu.neu.studyapp.vo.AnswerSheetResultVO;

import java.util.List;
import java.util.Map;

public interface ChoiceService {
    public List<Choice> findAllByQuestId(Integer id);
    public Choice findById(Integer id);
    public AnswerSheetResultVO getSingleMapScore(Map<Integer,Integer> singleMap);
    public AnswerSheetResultVO getMultipleMapScore(Map<Integer,List<Integer>> multipleMap);
    public List<Choice> findChoicesByQuestId(Integer id);
}
