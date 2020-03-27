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
public class Transaction {
    private Integer id;
    private Integer sumTran;
    private Integer countId;
    private Integer transactionCatId;
    private Date date;

    public Transaction() {
    }

    public Transaction(Integer sumTran, Integer countId, Integer transactionCatId, Date date) {
        this.sumTran = sumTran;
        this.countId = countId;
        this.transactionCatId = transactionCatId;
        this.date = date;
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

    public Integer getTransactionCatId() {
        return transactionCatId;
    }

    public void setTransactionCatId(Integer transactionCatId) {
        this.transactionCatId = transactionCatId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", sumTran=" + sumTran +
                ", countId=" + countId + ", transactionCatId=" 
                + transactionCatId + ", date=" + date + '}';
    }
    
    
}
