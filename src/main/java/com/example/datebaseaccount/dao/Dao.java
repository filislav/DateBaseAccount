/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.dao;

import java.util.List;

/**
 *
 * @author slava
 */
public interface Dao<DOMAIN,ID> {
    DOMAIN findById(ID id);
    List<DOMAIN> findByAll();
    DOMAIN insert(DOMAIN domain);
    DOMAIN update(DOMAIN domain);
    boolean delete(ID id);
}
