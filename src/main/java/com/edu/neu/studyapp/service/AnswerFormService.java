package com.edu.neu.studyapp.service;

import com.edu.neu.studyapp.entity.AnswerForm;
import com.edu.neu.studyapp.vo.AnswerFormVO;

import java.util.List;

public interface AnswerFormService {
    public AnswerForm findById(Integer id);
    public void addAnswerForm(AnswerForm answerForm);
    public List<AnswerForm> findByUserIdTestId(Integer user_id,Integer test_id);
}
