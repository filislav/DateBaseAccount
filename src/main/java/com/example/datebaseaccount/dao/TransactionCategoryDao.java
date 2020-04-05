/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.dao;

import com.example.datebaseaccount.dao.domain.TransactionCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

/**
 *
 * @author slava
 */
public class TransactionCategoryDao implements Dao<TransactionCategory,Integer>{
    private final DataSource dataSource;
    public TransactionCategoryDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public TransactionCategory findById(Integer id) {
        TransactionCategory transactionCategory = null;
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement("select * "
                    + "from transaction_category where id=?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                transactionCategory = setTransactionCategory(rs);
            }
            
        }catch(SQLException e){
            System.err.println("Ошибка в SQL запросе findByAll TrasactionCategoryDao");
        }
        return transactionCategory;
    }

    @Override
    public List<TransactionCategory> findByAll() {
        TransactionCategory transactionCategory = null;
        List<TransactionCategory> transCatList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement("select*from transaction_category;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                transactionCategory = setTransactionCategory(rs);
                transCatList.add(transactionCategory);
            }
        }catch(SQLException e){
            System.err.println("Ошибка в SQl запросе findByAll TransactionCategory");
        }
        return transCatList;
    }

    @Override
    public TransactionCategory insert(TransactionCategory domain) {
        TransactionCategory transactionCategory = setTransactionCategory(domain);
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement("insert into transaction_category (name) values (?);");
            ps.setString(1,transactionCategory.getName());
            ps.executeUpdate();            
        }catch(SQLException e){
            System.err.println("Ошибка в SQL запросе insert TransactionCategory");
        }
        return transactionCategory;
    }

    @Override
    public TransactionCategory update(TransactionCategory domain) {
        TransactionCategory transactionCategory = setTransactionCategory(domain);
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement("update transaction_category set name = ? where id =?;");
            ps.setString(1,transactionCategory.getName());
            ps.setInt(2, transactionCategory.getId());
            ps.executeUpdate();
        }catch(SQLException e){
            System.err.println("Ошибка в SQL запросе update TransactionCategory");
        }
        return transactionCategory;
    }

    @Override
    public boolean delete(Integer id) {
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement("delete from transaction_category where id = ?;");
            ps.setInt(1,id);
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Ошибка в SQL запросе delete TransactionCategory");
            return false;
        }
    }
    public static TransactionCategory setTransactionCategory(ResultSet rs) throws SQLException{
        TransactionCategory transactionCategory = new TransactionCategory();
        transactionCategory.setId(rs.getInt("id"));
        transactionCategory.setName(rs.getString("name"));
        return transactionCategory;
    }
    public static TransactionCategory setTransactionCategory(TransactionCategory domain){
        TransactionCategory transactionCategory = new TransactionCategory();
        transactionCategory.setId(domain.getId());
        transactionCategory.setName(domain.getName());
        return transactionCategory;
    }
}
