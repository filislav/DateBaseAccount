/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.dao.domain;

import com.example.datebaseaccount.service.DigestService;
import com.example.datebaseaccount.service.ServiceFactory;

/**
 *
 * @author slava
 */
public class Customer {
    private Integer id;
    private String name;
    private String email;
    private String password;

    public Customer() {
    }

    public Customer(String name,String email, String password) {
        DigestService ds = ServiceFactory.getDigestService();
        this.name = name;
        this.email = email;
        this.password = ds.digest(password);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", email=" + email
                + ", password=" + password + '}';
    }
    
    
    
}
