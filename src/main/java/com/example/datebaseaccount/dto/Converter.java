/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.dto;

/**
 *
 * @author slava
 * @param <Object1>
 * @param <Object2>
 */
public interface Converter <Object1,Object2>{
    public Object1 convert(Object2 ob);
}
