/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.dto;

import java.util.Date;

/**
 *
 * @author slava
 */
public class CountDto {
    private Integer id;
    private String name;
    private Integer sum;
    private Integer userId;
    private Date date;

    public CountDto(Integer id, String name, Integer sum, Integer userId, Date date) {
        this.id = id;
        this.name = name;
        this.sum = sum;
        this.userId = userId;
        this.date = date;
    }

    public CountDto() {
    }

    public int getId() {
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

    public int getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public int getUserId() {
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
        return "CountDTO{" + "id=" + id + ", name=" + name + ", sum=" + sum + ", userId=" + userId + ", date=" + date + '}';
    }
    
    
    
}
