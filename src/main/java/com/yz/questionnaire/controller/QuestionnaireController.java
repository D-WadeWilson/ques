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
import java.math.BigDecimal;
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
     * @param  data
     * @return 储存问卷数据
     */
    @PostMapping("save")
    @SneakyThrows
    public String saveQuestion(@RequestParam(value = "data",required = false)String data) {
        Map<String, String> map = getDataMap(data);
        User user = saveUser(map);  // 存储参加问卷的用户
        saveAnswerCard(map, user);  //存储答题卡信息
        return "success";
    }

    /**
     * 根据省市区查询用户数量 ，查询各个指标
     * @param data
     * @return
     */
    @PostMapping("selectAnalyzeData")
    public Map<String,String> selectData(@RequestParam(value = "data",required = false)String data){

        Map<String, String> map = getDataMap(data);
        List userList = userService.queryCountUser(map);

        BigDecimal wrongrate = BigDecimal.valueOf(0.00);
        BigDecimal leakageassessmentrate = BigDecimal.valueOf(0.00);
        BigDecimal falseregressionrate = BigDecimal.valueOf(0.00);
        BigDecimal leakagerate = BigDecimal.valueOf(0.00);
        BigDecimal comparison = BigDecimal.valueOf(0.00);
        BigDecimal pairingrate = BigDecimal.valueOf(0.00);
        BigDecimal exactrate = BigDecimal.valueOf(0.00);
        BigDecimal pleasedrate = BigDecimal.valueOf(0.00);
        try {
            wrongrate = answercardService.queryErrorEvaluate(map);
            leakageassessmentrate = answercardService.queryMissEvaluate(map);
            falseregressionrate = answercardService.queryErrorExit(map);
            leakagerate = answercardService.queryMissExit(map);
            comparison = answercardService.queryInfoComparison(map);
            pairingrate = answercardService.queryPairingrate(map);
            exactrate = answercardService.queryExactrate(map);
            pleasedrate = answercardService.queryPleasedrate(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap<String, String> resultMap = new HashMap<>();
        resultMap.put("type1", String.valueOf(userList.get(0)));
        resultMap.put("type2", String.valueOf(userList.get(1)));
        resultMap.put("type3", String.valueOf(userList.get(2)));
        resultMap.put("type4", String.valueOf(userList.get(3)));
        resultMap.put("wrongrate", String.valueOf(wrongrate));
        resultMap.put("leakageassessmentrate", String.valueOf(leakageassessmentrate));
        resultMap.put("falseregressionrate", String.valueOf(falseregressionrate));
        resultMap.put("leakagerate", String.valueOf(leakagerate));
        resultMap.put("comparison", String.valueOf(comparison));
        resultMap.put("pairingrate", String.valueOf(pairingrate));
        resultMap.put("exactrate", String.valueOf(exactrate));
        resultMap.put("pleasedrate", String.valueOf(pleasedrate));


        return resultMap;
    }

//
//    /**
//     * 错评率
//     * @return
//     */
//    @PostMapping("errorEval")
//    @SneakyThrows
//    public String errorEval(@RequestParam(value = "data",required = false)String data){
//
//        Map<String, String> map = getDataMap(data);
//        BigDecimal wrongrate = answercardService.queryErrorEvaluate(map);
//        return "{wrongrate:"+wrongrate+"}";
//    }
//
//    /**
//     * 漏评率
//     * @return
//     */
//    @PostMapping("missEval")
//    @SneakyThrows
//    public String missEval(){
//        BigDecimal leakageassessmentrate = answercardService.queryMissEvaluate();
//        return "{leakageassessmentrate:"+leakageassessmentrate+"}";
//    }
//
//    /**
//     * 错退率
//     * @return
//     */
//    @PostMapping("errorExit")
//    @SneakyThrows
//    public String errorExit(){
//        BigDecimal falseregressionrate = answercardService.queryErrorExit();
//        return "{falseregressionrate:"+falseregressionrate+"}";
//    }
//
//    /**
//     * 漏退率
//     * @return
//     */
//    @PostMapping("missExit")
//    @SneakyThrows
//    public String missExit(){
//        BigDecimal leakagerate = answercardService.queryMissExit();
//        return "{leakagerate:"+leakagerate+"}";
//    }
//
//    /**
//     * 信息对比率
//     * @return
//     */
//    @PostMapping("infoComparison")
//    @SneakyThrows
//    public String infoComparison(){
//        BigDecimal comparison = answercardService.queryInfoComparison();
//        return "{comparison:"+comparison+"}";
//    }
//
//    /**
//     * 结对帮扶覆盖率
//     * @return
//     */
//    @PostMapping("pairingRate")
//    @SneakyThrows
//    public String pairingRate(){
//        BigDecimal pairingrate = answercardService.queryPairingrate();
//        return "{pairingrate:"+pairingrate+"}";
//    }
//
//    /**
//     * 帮扶方式精准率
//     * @return
//     */
//    @PostMapping("exactRate")
//    @SneakyThrows
//    public String queryExactrate(){
//        BigDecimal exactrate = answercardService.queryExactrate();
//        return "{exactrate:"+exactrate+"}";
//    }
//
//    /**
//     * 帮扶工作满意度
//     * @return
//     */
//    @PostMapping("pleasedRate")
//    @SneakyThrows
//    public String pleasedRate(){
//        BigDecimal pleasedrate = answercardService.queryPleasedrate();
//        return "{pleasedrate:"+pleasedrate+"}";
//    }



    private Map<String, String> getDataMap(@RequestParam(value = "data", required = false) String data) {
        Gson gson = new Gson();
        Map<String, String> map = new HashMap<String, String>();
        map = gson.fromJson(data, map.getClass());
        System.out.println(data);
        return map;
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