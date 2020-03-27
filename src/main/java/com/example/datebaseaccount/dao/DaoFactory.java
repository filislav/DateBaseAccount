/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.dao;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author slava
 */
public class DaoFactory {
    private static DataSource dataSource;
    public static DataSource getDataSource(){
        if(dataSource==null){
            HikariDataSource ds = new HikariDataSource();
            ds.setJdbcUrl("jdbc:postgresql://localhost:5432/user_count");
            ds.setUsername("postgres");
            ds.setPassword("ytxtcnm91");
            dataSource = ds;
        }
        return dataSource;
    }
    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException ex) {
            System.err.println("Ошибка подключения к базе данных");
            return null;
        }
    }
    private DaoFactory(){
    }
}
