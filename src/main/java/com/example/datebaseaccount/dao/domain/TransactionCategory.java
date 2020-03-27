/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.dao.domain;

/**
 *
 * @author slava
 */
public class TransactionCategory {
    private Integer id;
    private String name;

    public TransactionCategory(String name) {
        this.name = name;
    }

    public TransactionCategory() {
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

    @Override
    public String toString() {
        return "TransactionCategory{" + "id=" + id + ", name=" + name + '}';
    }
    
}
