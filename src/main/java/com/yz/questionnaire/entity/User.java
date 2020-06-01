package com.yz.questionnaire.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-05-27 12:09:21
 */
public class User implements Serializable {
    private static final long serialVersionUID = 942762392925882072L;
    
    private Integer id;
    /**
    * 姓名
    */
    private String name;
    /**
    * 负责人
    */
    private String manager;
    /**
    * 联系人
    */
    private String linkman;
    /**
    * 电话
    */
    private String phone;
    /**
    * 工作单位
    */
    private String company;
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
    private String lobor;


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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getLobor() {
        return lobor;
    }

    public void setLobor(String lobor) {
        this.lobor = lobor;
    }

}