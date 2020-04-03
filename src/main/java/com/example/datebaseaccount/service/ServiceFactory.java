/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.service;

/**
 *
 * @author slava
 */
public class ServiceFactory {
    private static DigestService digestService;
    public static DigestService getDigestService(){
        if(digestService==null){
            digestService = new DigestService();
        }
        return digestService;
    }
    
}