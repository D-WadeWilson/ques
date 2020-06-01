package com.yz.questionnaire.entity;

import java.io.Serializable;

/**
 * (Question)实体类
 *
 * @author makejava
 * @since 2020-05-26 16:46:31
 */
public class Question implements Serializable {
    private static final long serialVersionUID = -22316850185748660L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 题号
    */
    private Integer themeno;
    /**
    * 对应试卷编号
    */
    private Integer paperno;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getThemeno() {
        return themeno;
    }

    public void setThemeno(Integer themeno) {
        this.themeno = themeno;
    }

    public Integer getPaperno() {
        return paperno;
    }

    public void setPaperno(Integer paperno) {
        this.paperno = paperno;
    }

}