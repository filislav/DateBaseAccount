/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.dao.domain;

import java.util.Date;

/**
 *
 * @author slava
 */
public class Count {
    private Integer id;
    private String name;
    private Integer sum;
    private Integer userId;
    private Date date;

    public Count() {
    }

    public Count(String name, Integer sum, Integer userId, Date date) {
        this.name = name;
        this.sum = sum;
        this.userId = userId;
        this.date = date;
        System.err.println("constructor date: "+date);
    }

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

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDate() {
   
        return date;
    }

    public void setDate(Date date) {
       
        this.date = date;
    }

    @Override
    public String toString() {
        return "Count{" + "id=" + id + ", name=" + name + ", sum=" + sum + ", userId=" + userId + ", date=" + date + '}';
    }
    
    
}

