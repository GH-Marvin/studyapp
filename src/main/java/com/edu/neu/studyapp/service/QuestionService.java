package com.edu.neu.studyapp.service;

import com.edu.neu.studyapp.entity.Question;
import com.edu.neu.studyapp.vo.QuestionVO;

import java.util.List;

public interface QuestionService {
    public List<Question> findByTestId(Integer id);
    public String findTypeById(Integer id);
    public Question findById(Integer id);
    public List<Question> findAll();
}
