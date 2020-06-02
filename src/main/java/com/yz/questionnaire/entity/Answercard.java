package com.yz.questionnaire.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Answercard)实体类
 *
 * @author makejava
 * @since 2020-06-01 17:35:36
 */
public class Answercard implements Serializable {
    private static final long serialVersionUID = -66761851269491835L;
    
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
    /**
    * 添加时间
    */
    private Date addtime;


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

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

}