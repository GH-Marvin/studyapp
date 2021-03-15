package com.edu.neu.studyapp.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.neu.studyapp.entity.Question;
import com.edu.neu.studyapp.mapper.QuestionMapper;
import com.edu.neu.studyapp.service.QuestionService;
import com.edu.neu.studyapp.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;


    @Override
    public List<Question> findByTestId(Integer id) {
        List<Question> list = new ArrayList<>();
        for(QuestionVO q: questionMapper.findAllQuestionVO()){
            if(q.getTestId() == id){
                Question question = new Question(q.getQuestId(),q.getTitle(),q.getScore(),q.getType());
                list.add(question);
            }
        }
        return list;
    }

    @Override
    public String findTypeById(Integer id) {
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        return questionMapper.selectOne(queryWrapper.eq("quest_id",id)).getType();
    }

    @Override
    public Question findById(Integer id) {
        return questionMapper.selectOne(new QueryWrapper<Question>().eq("quest_id",id));
    }

    @Override
    public List<Question> findAll() {
        return questionMapper.selectList(null);
    }
}
