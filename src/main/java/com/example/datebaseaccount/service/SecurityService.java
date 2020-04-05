/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.service;

import com.example.datebaseaccount.dao.CustomerDao;
import com.example.datebaseaccount.dao.domain.Customer;
import com.example.datebaseaccount.dto.CustomerDto;
import com.example.datebaseaccount.dto.CustomerToDtoConverter;

/**
 *
 * @author slava
 */
public class SecurityService {
    private final CustomerDao customerDao;
    private final CustomerToDtoConverter customerToDtoConverter;
    private final DigestService digestService;
    
    public SecurityService(CustomerDao customerDao, CustomerToDtoConverter customerToDtoConverter,DigestService digestService){
        this.customerDao = customerDao;
        this.customerToDtoConverter = customerToDtoConverter;
        this.digestService = digestService;
    }
    public CustomerDto auth(String email, String password){
        Customer customer = customerDao.findByEmail(email);
        if(customer!=null){
            String digestHash = digestService.digest(password);
            if(digestHash.equals(customer.getPassword())){
                return customerToDtoConverter.convert(customer);
            }else{
                System.out.println("Такого пользователя не существует");
            }
        }
        return null;
    }
    
}
