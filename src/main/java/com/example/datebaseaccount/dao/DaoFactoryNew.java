/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.dao;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

/**
 *
 * @author slava
 */
public class DaoFactoryNew {
    private static CustomerDao customerDao;
    public static CustomerDao getCustomerDao(){
        if(customerDao==null){
            customerDao = new CustomerDao(getDataSource());
        }
        return customerDao;
    }
    
    private static CountDao countDao;
    public static CountDao getCountDao(){
        if(countDao==null){
            countDao = new CountDao(getDataSource());
        }
        return countDao;
    } 
    
    private static TransactionDao transactionDao;
    public static TransactionDao getTransactionDao(){
        if(transactionDao == null){
            transactionDao = new TransactionDao(getDataSource());
        }
        return transactionDao;
    } 
    
    private static TransactionCategoryDao transactionCategoryDao;
    public static TransactionCategoryDao getTransactionCategoryDao(){
    if(transactionCategoryDao == null){
         transactionCategoryDao = new TransactionCategoryDao(getDataSource());
    }
    return transactionCategoryDao;
    }
    
    private static DataSource dataSource;
    public static DataSource getDataSource(){
        if(dataSource==null){
            HikariDataSource ds = new HikariDataSource();
            ds.setJdbcUrl("jdbc:postgresql://localhost:5432/user_count");
            ds.setUsername("slava");
            ds.setPassword("ytxtcnm91");
            dataSource = ds;
            System.out.println("Соединение установленно");
        }
        return dataSource;
    }
    
}
