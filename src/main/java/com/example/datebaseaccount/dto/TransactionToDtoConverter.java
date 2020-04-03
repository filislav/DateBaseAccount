/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.dto;

import com.example.datebaseaccount.dao.domain.Transaction;

/**
 *
 * @author slava
 */
public class TransactionToDtoConverter implements Converter<TransactionDto,Transaction>{

    @Override
    public TransactionDto convert(Transaction tr) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(tr.getId());
        transactionDto.setSumTran(tr.getSumTran());
        transactionDto.setCountId(tr.getCountId());
        transactionDto.setDate(tr.getDate());
        return transactionDto;
    }
    
}
