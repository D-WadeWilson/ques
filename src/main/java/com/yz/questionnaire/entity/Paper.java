package com.yz.questionnaire.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Paper)实体类
 *
 * @author makejava
 * @since 2020-06-01 17:35:48
 */
public class Paper implements Serializable {
    private static final long serialVersionUID = -29939464756819731L;
    
    private Integer id;
    /**
    * 试卷序号 1 2 3 4 5 6
    */
    private Integer number;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

}