package com.yz.questionnaire.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (UserExportDTO)实体类
 *
 * @author makejava
 * @since 2020-06-01 17:36:05
 */
public class UserExportDTO  {
//    private static final long serialVersionUID = -35114586709964516L;
    
    private Integer id;
    /**
    * 姓名
     */
    private String name;


    /**
    * 电话
    */
    private String phone;

    /**
    * 市
    */
    private String city;
    /**
    * 县
    */
    private String town;
    /**
    * 小区
    */
    private String house;
    /**
    * 类型
    */
    private Integer type;




    /**
     * 工会
     */
    private String answer;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


}