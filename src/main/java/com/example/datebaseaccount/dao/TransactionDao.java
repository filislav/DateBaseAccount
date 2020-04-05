/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.dao;

import com.example.datebaseaccount.dao.domain.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author slava
 */
public class TransactionDao implements Dao<Transaction,Integer> {
    private final DataSource dataSource;
    
    public TransactionDao(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    @Override
    public Transaction findById(Integer id) {
        Transaction transaction = null;
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement("select * "
                    + "from transaction where id=?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                transaction = setTransaction(rs);
            }
            
        }catch(SQLException e){
            System.err.println("Ошибка в SQL запросе findByAll Transaction");
        }
        return transaction;
    }

    @Override
    public List<Transaction> findByAll() {
        List<Transaction> listTrans = new ArrayList<>();
        Transaction transaction = null;
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement("select * "
                    + "from transaction;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                transaction = setTransaction(rs);
                listTrans.add(transaction);
            }
        }catch(SQLException e){
            System.err.println("Ошибка SQL запроса findByAll Transaction");
        }
        return listTrans;
    }

    @Override
    public Transaction insert(Transaction domain) {
        Transaction transaction = null;
        try(Connection connection = dataSource.getConnection()){
            transaction = setTransaction(domain);
            PreparedStatement ps = connection.prepareStatement("insert into "
                    + "transaction (sum_tran,count_id,transaction_cat_id,date)"
                    + "values(?,?,?,?);");
            ps.setInt(1, domain.getSumTran());
            ps.setInt(2, domain.getCountId());
            ps.setInt(3, domain.getTransactionCatId());
            ps.setDate(4, convDateToSQLDate(domain.getDate()));
            ps.executeUpdate();
        }catch(SQLException e){
            System.err.println("Ошибка в SQL запросе insert Transaction");
        }
        return transaction;
    }

    @Override
    public Transaction update(Transaction domain) {
        Transaction transaction = null;
        try(Connection connection = dataSource.getConnection()){
        transaction = setTransaction(domain);
        PreparedStatement ps = connection.prepareStatement("update transaction "
                + "set sum_tran =?,count_id=?,transaction_cat_id=?,date=? where id = ?;");
        ps.setInt(1, domain.getSumTran());
        ps.setInt(2, domain.getCountId());
        ps.setInt(3, domain.getTransactionCatId());
        ps.setDate(4, convDateToSQLDate(domain.getDate()));
        ps.setInt(5, domain.getId());
        ps.executeUpdate();
        }catch(SQLException e){
            System.err.println("Ошибка в SQL запросе update Transaction");
        }
        return transaction;
    }

    @Override
    public boolean delete(Integer id) {
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement("delete from "
                    + "transaction where id =?;");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Ошибка в SQL запросе delete Transaction");
            return false;
        }
    }
    public static java.sql.Date convDateToSQLDate(java.util.Date date){
        java.sql.Date sDate = new java.sql.Date(date.getTime());
        return sDate;
    }
    
    public static Transaction setTransaction(ResultSet rs) throws SQLException{
        Transaction transaction = new Transaction();
        transaction.setId(rs.getInt("id"));
        transaction.setSumTran(rs.getInt("sum_tran"));
        transaction.setCountId(rs.getInt("count_id"));
        transaction.setTransactionCatId(rs.getInt("transaction_cat_id"));
        transaction.setDate(rs.getDate("date"));
        return transaction;
        
    } 
    public static Transaction setTransaction(Transaction domain){
        Transaction transaction = new Transaction();
        transaction.setId(domain.getId());
        transaction.setSumTran(domain.getSumTran());
        transaction.setCountId(domain.getCountId());
        transaction.setTransactionCatId(domain.getTransactionCatId());
        transaction.setDate(domain.getDate());
        return transaction;
    }
    public int sumTransactionCount(Integer countId){
        int sum= 0;
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement("select sum(sum_tran) from transaction where count_id=?;");
            ps.setInt(1, countId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sum = rs.getInt(1);
            }
        }catch(SQLException e){
            System.err.println("Ошибка в SQL запросе sunTransactionUser");
        }       
        return sum;
    }
}
