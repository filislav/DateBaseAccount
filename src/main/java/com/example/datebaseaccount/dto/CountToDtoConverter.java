/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.dto;

import com.example.datebaseaccount.dao.domain.Count;

/**
 *
 * @author slava
 */
public class CountToDtoConverter implements Converter<CountDto,Count>{

    @Override
    public CountDto convert(Count count) {
        CountDto countDto = new CountDto();
        countDto.setId(count.getId());
        countDto.setName(count.getName());
        countDto.setSum(count.getSum());
        countDto.setUserId(count.getUserId());
        countDto.setDate(count.getDate());
        return countDto;
    }
    
}
