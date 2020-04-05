/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.dao;

import static com.example.datebaseaccount.dao.CountDao.setCount;
import com.example.datebaseaccount.dao.domain.Count;
import com.example.datebaseaccount.dao.domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

/**
 *
 * @author slava
 */
public class CustomerDao implements Dao<Customer,Integer> {
    private final DataSource dataSource;
    
    public CustomerDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public Customer findById(Integer id) {
        Customer customer = null;
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement("select*from "
                    + "customer where id=?;");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                customer = setCustomer(rs);
            }
        }catch(SQLException e){
            System.err.println("Ошибка в SQL запросе findById, проверяй");
        }
        return customer;
    }
    public Customer findByEmail(String email){
        Customer customer = null;
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement("select*from customer where email=?;");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                customer = setCustomer(rs);
            }
        }catch(SQLException e){
            System.err.println("Ошибка в SQL запросе findByEmail");
        }
        return customer;
    }
    @Override
    public List<Customer> findByAll() {
        List<Customer> custList = new ArrayList<>();
        Customer customer =null;
        try(Connection connection = dataSource.getConnection()){
        PreparedStatement ps = connection.prepareStatement("select * "
                + "from customer;");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            customer = setCustomer(rs);
            custList.add(customer);
        }
        }catch(SQLException e){
            System.err.println("Ошибка в SQL запросе, проверяй");
        }
        return custList;
    }

    @Override
    public Customer insert(Customer domain) {
        Customer customer = new Customer();
        try(Connection connection = dataSource.getConnection()){
        customer = setCustomer(domain);
            PreparedStatement psInsert = connection.prepareStatement("insert "
                    + "into customer(name,email,password)values(?,?,?);");
            psInsert.setString(1,customer.getName());
            psInsert.setString(2,customer.getEmail());
            psInsert.setString(3,customer.getPassword());
            psInsert.executeUpdate();
            System.out.println("Добавление пользователя в базу прошло успешно");
        }catch(SQLException e){
            System.err.println("Ошибка SQL запроса, проверяй");
        }
        return customer;
    }

    @Override
    public Customer update(Customer domain) {
        Customer customer = new Customer();
        try(Connection connection  = dataSource.getConnection()){
        customer = setCustomer(domain);
            PreparedStatement ps = connection.prepareStatement("update customer "
                    + "set name=? , email=?, password = ? where id=?;");
            ps.setString(1, domain.getName());
            ps.setString(2, domain.getEmail());
            ps.setString(3, domain.getPassword());
            ps.setInt(4, domain.getId());
            ps.executeUpdate();
        }catch(SQLException e){
            System.err.println("Ошибка SQL запроса при апдейте пользователя");
        }
        System.out.println("Update прошел успешно");
        
        return customer;
    }

    @Override
    public boolean delete(Integer id) {
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement("delete from "
                    + "customer where id=?;");
            ps.setInt(1,id);
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Ошибка SQL запроса delete, проверяй");
            return false;
        }
    }
    public static Customer setCustomer(ResultSet rs) throws SQLException{
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setEmail(rs.getString("email"));
        customer.setPassword(rs.getString("password"));
        return customer;
    }
    public static Customer setCustomer(Customer domain) throws SQLException{
        Customer customer = new Customer();
        customer.setId(domain.getId());
        customer.setName(domain.getName());
        customer.setEmail(domain.getEmail());
        customer.setPassword(domain.getPassword());
        return customer;
    }
    public Map<Integer,List<Count>> customerCounts(Integer id){
        Map<Integer,List<Count>> countMap = new HashMap<>();
        List<Count>countList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement("select co.id, "
                    + "co.name, co.sum,co.user_id,co.date from customer as cu "
                    + "inner join count as co on co.user_id=cu.id where cu.id=?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Count count = setCount(rs);
                countList.add(count);
            }
            countMap.put(id, countList);
            System.out.println("В мапу положили");
        }catch(SQLException e){
            System.err.println("Ошибка в SQL запросе customerCounts");
        }
        return countMap;
    }
}
