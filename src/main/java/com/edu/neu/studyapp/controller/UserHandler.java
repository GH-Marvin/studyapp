package com.edu.neu.studyapp.controller;


import com.edu.neu.studyapp.entity.*;
import com.edu.neu.studyapp.service.*;
import com.edu.neu.studyapp.util.AnswerSheetUtil;
import com.edu.neu.studyapp.util.KeyUtil;
import com.edu.neu.studyapp.util.ResultUtil;
import com.edu.neu.studyapp.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserService userService;
    @Autowired
    private AnswerFormService answerFormService;
    @Autowired
    private ChoiceService choiceService;
    @Autowired
    private UserTestService userTestService;
    @Autowired
    private TestService testService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private PointRecordService pointRecordService;

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url) {
        return url;
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultVO<String> login(@RequestBody UserVO userVO) {
        User user = userService.findByUserName(userVO.getUsername());
        if(user != null){
            if(userVO.getPassword().equals(user.getPassword())){
                int id = user.getUserId();
                return ResultUtil.success(userInfoService.findByUserId(id));
            }else {
                return ResultUtil.fail("账号或密码有误！");
            }
        }else {
            return ResultUtil.fail("没有该账户！");
        }
    }
    @PostMapping("/register")
    @ResponseBody
    public ResultVO<String> register(@RequestBody UserVO userVO){
        if(userService.findByUserName(userVO.getUsername())==null){
            User user = new User();
            user.setUsername(userVO.getUsername());
            user.setPassword(userVO.getPassword());
            userService.addUser(user);
            Userinfo userinfo = new Userinfo();
            userinfo.setUserId(userService.findByUserName(userVO.getUsername()).getUserId());
            userinfo.setNickname("注册用户"+userinfo.getUserId());
            userinfo.setUserIcon("https://ss0.baidu.com/6ON1bjeh1BF3odCf/it/u=3729172494,2390572203&fm=27&gp=0.jpg");
            userinfo.setPoint(10000);
            UserTest userTest = new UserTest();
            userInfoService.addUserInfo(userinfo);
            userTest.setUserId(userinfo.getUserId());
            userTest.setPassNum(0);
            userTest.setFailNum(0);
            userTest.setNotryNum(0);
            userTest.setHistory(-1);
            userTestService.insertUserTest(userTest);
            PointRecord pointRecord = new PointRecord();
            pointRecord.setUserId(userinfo.getUserId());
            pointRecord.setGainPoint(10000);
            pointRecord.setEventName("注册成功");
            pointRecord.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime()));
            pointRecordService.insert(pointRecord);
            return ResultUtil.success(userinfo);
        }else {
            return ResultUtil.fail("该用户名已注册！");
        }
    }

    @PostMapping("/submitToScore")
    @ResponseBody
    public AnswerForm submitToScore(@RequestBody AnswerFormVO answerFormVO){
        AnswerForm answerForm = new AnswerForm();
        answerForm.setAnswersheet(answerFormVO.getAnswersheet());
        AnswerSheetUtil.initMap(answerFormVO.getAnswersheet());
        AnswerSheetResultVO a1 = choiceService.getSingleMapScore(AnswerSheetUtil.singleMap);
        AnswerSheetResultVO a2 = choiceService.getMultipleMapScore(AnswerSheetUtil.multipleMap);
        Integer total_score = a1.getScore()+a2.getScore();
        answerForm.setScore(total_score);
        answerForm.setAnswersheetResult(AnswerSheetUtil.sort(a1.getAnswersheetResult()+a2.getAnswersheetResult()));
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime());
        answerForm.setSaveTime(time);
        answerForm.setFormId(KeyUtil.createUniqueKey());
        answerForm.setTestId(answerFormVO.getTest_id());
        answerForm.setUserId(answerFormVO.getUser_id());
        answerFormService.addAnswerForm(answerForm);
        AnswerSheetUtil.clear();
        int user_id = answerFormVO.getUser_id();
        if(user_id != -1){
            UserTest userTest = userTestService.findById(user_id);
            int total_num = testService.findById(answerFormVO.getTest_id()).getQuestNum();
            int fail = total_num - a1.getPassNum() - a2.getPassNum();
            userTest.setPassNum(userTest.getPassNum()+a1.getPassNum()+a2.getPassNum());
            userTest.setFailNum(userTest.getFailNum()+fail);
            userTest.setNotryNum(userTest.getNotryNum()+total_num);
            userTest.setHistory(answerFormVO.getTest_id());
            userTestService.update(userTest);
        }
        //TODO
        return answerForm;
    }

    @GetMapping("/findUserInfoByNickName/{nickName}")
    @ResponseBody
    public Userinfo findChoicesByQuestId(@PathVariable("nickName") String nickName){
        return userInfoService.findByNickName(nickName);
    }

    @PostMapping("/getScoreList")
    @ResponseBody
    public List<AnswerForm> getScoreList(@RequestBody ScoreListVO scoreListVO){
        int user_id = Integer.valueOf(scoreListVO.getUser_id());
        int test_id = Integer.valueOf(scoreListVO.getTest_id());
        List<AnswerForm> answerFormList = new ArrayList<>();
        answerFormList = answerFormService.findByUserIdTestId(user_id,test_id);
        return answerFormList;

    }

    @PostMapping("/update")
    @ResponseBody
    public Userinfo update(@RequestBody UserInfoVO userInfoVO){
        return userInfoService.update(userInfoVO);
    }

    @GetMapping("/judgeNickName/{nickname}")
    @ResponseBody
    public String judgeNickName(@PathVariable("nickname") String nickname){
        Userinfo userinfo = userInfoService.findByNickName(nickname);
        if(userinfo==null){
            return "success";
        }else {
            return "该昵称已被使用，请重新输入！";
        }
    }
    @GetMapping("/findUserInfoById/{user_id}")
    @ResponseBody
    public Userinfo findById(@PathVariable("user_id") String user_id){
        return userInfoService.findByUserId(Integer.valueOf(user_id));
    }
    @GetMapping("/findPointsByUserId/{user_id}")
    @ResponseBody
    public List<PointRecord> findPointsById(@PathVariable("user_id") String user_id){
        return pointRecordService.findByUserId(Integer.valueOf(user_id));
    }
    @PostMapping("/submitPoints")
    @ResponseBody
    public void submitPoints(@RequestBody PointRecordVO pointRecordVO){
        PointRecord pointRecord = new PointRecord();
        pointRecord.setCreateTime(pointRecordVO.getTime());
        pointRecord.setEventName(pointRecordVO.getEvent_name());
        pointRecord.setGainPoint(Integer.valueOf(pointRecordVO.getGain_point()));
        pointRecord.setUserId(Integer.valueOf(pointRecordVO.getUser_id()));
        Userinfo userinfo = userInfoService.findByUserId(Integer.valueOf(pointRecordVO.getUser_id()));
        int point = userinfo.getPoint() + Integer.valueOf(pointRecordVO.getGain_point());
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setInput(String.valueOf(point));
        userInfoVO.setUser_id(pointRecordVO.getUser_id());
        userInfoVO.setCol("point");
        userInfoService.update(userInfoVO);
        pointRecordService.insert(pointRecord);
    }
}
