package com.yz.questionnaire.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Question)实体类
 *
 * @author makejava
 * @since 2020-06-01 17:35:58
 */
public class Question implements Serializable {
    private static final long serialVersionUID = 657207565087677832L;
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

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

}