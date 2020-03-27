/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author slava
 */
public class DigestService {
    public String digest(String password){
        return DigestUtils.md5Hex(password);
    }
    
}
