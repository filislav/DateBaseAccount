/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.dto;

import com.example.datebaseaccount.dao.domain.Customer;

/**
 *
 * @author slava
 */
public class CustomerToDtoConverter implements Converter<CustomerDto,Customer>{

    @Override
    public CustomerDto convert(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPassword(customer.getPassword());
        return customerDto;
    }
    
}
