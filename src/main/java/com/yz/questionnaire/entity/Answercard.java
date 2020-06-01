package com.yz.questionnaire.entity;

import java.io.Serializable;

/**
 * (Answercard)实体类
 *
 * @author makejava
 * @since 2020-05-26 11:58:41
 */
public class Answercard implements Serializable {
    private static final long serialVersionUID = -48270800935982717L;
    
    private Integer id;
    /**
    * 用户id
    */
    private Integer userid;
    /**
    * 试卷id
    */
    private Integer paperid;
    /**
    * 题号id
    */
    private Integer questionid;
    /**
    * 答案
    */
    private String answer;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}