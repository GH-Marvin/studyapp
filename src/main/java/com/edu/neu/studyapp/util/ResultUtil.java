package com.edu.neu.studyapp.util;


import com.edu.neu.studyapp.vo.ResultVO;

public class ResultUtil {
    public static ResultVO success(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO fail(String error) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg(error);
        resultVO.setData(null);
        return resultVO;
    }
}
