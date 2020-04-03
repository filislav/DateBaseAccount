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
public class TransactionDto {
    private Integer id;
    private Integer sumTran;
    private Integer countId;
    private Date date;

    public TransactionDto(Integer id, Integer sumTran, Integer countId, Date date) {
        this.id = id;
        this.sumTran = sumTran;
        this.countId = countId;
        this.date = date;
    }

    public TransactionDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSumTran() {
        return sumTran;
    }

    public void setSumTran(Integer sumTran) {
        this.sumTran = sumTran;
    }

    public Integer getCountId() {
        return countId;
    }

    public void setCountId(Integer countId) {
        this.countId = countId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TransactionDto{" + "id=" + id + ", sumTran=" + sumTran + ", countId=" + countId + ", date=" + date + '}';
    }
    
    
            
}
