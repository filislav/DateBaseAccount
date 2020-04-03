/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.dto;

import com.example.datebaseaccount.dao.domain.TransactionCategory;

/**
 *
 * @author slava
 */
public class TransactionCategoryToDtoConverter implements Converter<TransactionCategoryDto,TransactionCategory>{

    @Override
    public TransactionCategoryDto convert(TransactionCategory tc) {
        TransactionCategoryDto transCatToDto = new TransactionCategoryDto();
        transCatToDto.setId(tc.getId());
        transCatToDto.setName(tc.getName());
        return transCatToDto;
    }
    
}
