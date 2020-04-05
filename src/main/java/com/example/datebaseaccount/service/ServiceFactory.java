/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.service;

import static com.example.datebaseaccount.dao.DaoFactoryNew.getCustomerDao;
import com.example.datebaseaccount.dto.CustomerToDtoConverter;

/**
 *
 * @author slava
 */
public class ServiceFactory {
    private static CustomerToDtoConverter customerToDtoConverter;
    public static CustomerToDtoConverter getCustomerToDtoConverter(){
        if(customerToDtoConverter==null){
            customerToDtoConverter = new CustomerToDtoConverter();
        }
        return customerToDtoConverter;
    }
    private static DigestService digestService;
    public static DigestService getDigestService(){
        if(digestService==null){
            digestService = new DigestService();
        }
        return digestService;
    }
    private static SecurityService securityService;
    public static SecurityService getSecurityService(){
        if(securityService==null){
            securityService = new SecurityService(getCustomerDao(),getCustomerToDtoConverter(),getDigestService());
        }
        return securityService;
    }
    
}
