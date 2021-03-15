package com.edu.neu.studyapp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.neu.studyapp.entity.Question;
import com.edu.neu.studyapp.vo.QuestionVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface QuestionMapper extends BaseMapper<Question> {
    @Select("SELECT *\n" +
            "FROM question AS q NATURAL JOIN test_question AS tq\n" +
            "WHERE q.quest_id = tq.quest_id")
    public List<QuestionVO> findAllQuestionVO();
}
