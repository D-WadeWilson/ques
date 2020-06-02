package com.yz.questionnaire.controller;



import com.google.gson.Gson;
import com.yz.questionnaire.entity.Answercard;
import com.yz.questionnaire.entity.Paper;
import com.yz.questionnaire.entity.Question;
import com.yz.questionnaire.entity.User;
import com.yz.questionnaire.service.AnswercardService;
import com.yz.questionnaire.service.PaperService;
import com.yz.questionnaire.service.QuestionService;
import com.yz.questionnaire.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Answercard)表控制层
 *
 * @author makejava
 * @since 2020-05-26 11:59:04
 */
@RestController
@RequestMapping("question")
public class QuestionnaireController {
    /**
     * 服务对象
     */
    @Autowired
    private AnswercardService answercardService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserService userService;

    /**
     *
     *
     * @param
     * @return 储存数据
     */
    @PostMapping("save")
    @SneakyThrows
    public String saveQuestion(@RequestParam(value = "data",required = false)String data) {
        Gson gson = new Gson();
        Map<String, String> map = new HashMap<String, String>();
        map = gson.fromJson(data, map.getClass());
        System.out.println(data);

        User user = saveUser(map);  // 存储参加问卷的用户
        saveAnswerCard(map, user);  //存储答题卡信息
        return "success";
    }

    public void saveAnswerCard(Map<String, String> map, User user) {
        Question question = new Question();
        question.setPaperno(map.get("type")!=null?Integer.valueOf(map.get("type")):null);
        List<Question> questionList = questionService.queryAll(question);   //跟据试卷号获取答案表

        Paper paper =  new Paper();
        paper.setNumber(map.get("type")!=null?Integer.valueOf(map.get("type")):null);
        List<Paper> paperList = paperService.queryAll(paper);       //跟据type获得对应试卷

        Answercard answercard0 =new Answercard();
        answercard0.setPaperid(paperList!=null?paperList.get(0).getId():null);
        answercard0.setUserid(user.getId());
        List<Answercard> answercardList = answercardService.queryAll(answercard0);


        for (int i = 0; i <questionList.size() ; i++) {
            Answercard answercard =new Answercard();
            if(answercardList.size()>0){
                answercard = answercardList.get(i);
                answercard.setAnswer(map.get("Q"+(i+1)));
                answercard.setAddtime(new Date());
                answercardService.update(answercard);
            } else {
                answercard.setPaperid(paperList!=null?paperList.get(0).getId():null);
                answercard.setQuestionid(questionList.get(i).getId());
                answercard.setAnswer(map.get("Q"+(i+1)));
                answercard.setUserid(user.getId());
                answercard.setAddtime(new Date());
                answercardService.insert(answercard);
            }


        }
    }

    public User saveUser(Map<String, String> map) {
        User user = new User();
        user.setName(map.get("name"));
        user.setPhone(map.get("phone"));
        List<User> userList = userService.queryAll(user);
        if(userList.size()>0){
            user = userList.get(0);
        }
        user.setCompany(map.get("company"));
        user.setCity(map.get("city"));
        user.setTown(map.get("town"));
        user.setHouse(map.get("house"));
        user.setType(map.get("type")!=null?Integer.valueOf(map.get("type")):null);
        user.setManager(map.get("manager"));
        user.setLinkman(map.get("linkman"));
        user.setLobor(map.get("lobor"));
        user.setAddtime(new Date());
        if(userList.size()>0){
            userService.update(user);
        }else {
            userService.insert(user);
        }
        return user;
    }


}