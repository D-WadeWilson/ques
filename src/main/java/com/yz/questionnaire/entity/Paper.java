package com.yz.questionnaire.entity;

import java.io.Serializable;

/**
 * (Paper)实体类
 *
 * @author makejava
 * @since 2020-05-26 16:45:58
 */
public class Paper implements Serializable {
    private static final long serialVersionUID = -72127990772982501L;
    
    private Integer id;
    /**
    * 试卷序号 1 2 3 4 5 6
    */
    private Integer number;


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

}