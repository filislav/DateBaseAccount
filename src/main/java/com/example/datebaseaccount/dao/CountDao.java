/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount.dao;

import com.example.datebaseaccount.dao.domain.Count;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author slava
 */
public class CountDao implements Dao<Count,Integer> {
   private final DataSource dataSource;
   
   public CountDao(DataSource dataSource){
       this.dataSource = dataSource;
   }
    
    @Override
    public Count findById(Integer id) {
        Count count = null;
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement("select*from "
                    + "count where id=?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                count = setCount(rs);
            }
        }catch(SQLException e){
            System.err.println("Ошибка в запросе findById Count");
        }
        return count;
    }

    @Override
    public List<Count> findByAll() {
        List<Count> countList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement("select * from count;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Count count = setCount(rs);
                countList.add(count);
            }
        }catch(SQLException e){
            System.err.println("Ошибка в запросе findByAll Count");
        }
        return countList;
    }

    @Override
    public Count insert(Count domain) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Count count = null;
        try(Connection connection = dataSource.getConnection()){
            count = setCount(domain);
            PreparedStatement ps = connection.prepareStatement("insert into "
                    + "count(name,sum,user_id,date)values(?,?,?,?);");
            ps.setString(1, count.getName());
            ps.setInt(2, count.getSum());
            ps.setInt(3, count.getUserId());
            ps.setDate(4, convDateToSQLDate(count.getDate()));
            ps.executeUpdate();
            System.out.println("Добавление в базу прошло успешно");
        }catch(SQLException e){
            System.err.println("Ошибка в запросе insert Count");
        }
        return count;
    }

    @Override
    public Count update(Count domain) {
        Count count = null;
        try(Connection connection = dataSource.getConnection()){
            count = setCount(domain);
            PreparedStatement ps = connection.prepareStatement("update count "
                    + "set name=?,sum=?,user_id=?,date =? where id = ?;");
            ps.setString(1,count.getName());
            ps.setInt(2,count.getSum());
            ps.setInt(3, count.getUserId());
            ps.setDate(4,convDateToSQLDate(count.getDate()));
            ps.setInt(5, count.getId());
            ps.executeUpdate();
        }catch(SQLException e){
            System.err.println("Ошибка SQL запроса update Count");
        }
        return count;
    }

    @Override
    public boolean delete(Integer id) {
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement("delete from "
                    + "count where id=?;");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Ошибка SQL запроса delete Count");
            return false;
        }
    }
    public static Count setCount(Count domain){
        Count count = new Count();
        count.setId(domain.getId());
        count.setName(domain.getName());
        count.setSum(domain.getSum());
        count.setUserId(domain.getUserId());
        count.setDate(domain.getDate());
        return count;
    }
    public static Count setCount(ResultSet rs)throws SQLException{
        Count count = new Count();
        count.setId(rs.getInt("id"));
        count.setName(rs.getString("name"));
        count.setSum(rs.getInt("sum"));
        count.setUserId(rs.getInt("user_id"));
        count.setDate(rs.getDate("date"));
        return count;
    }
    public static java.sql.Date convDateToSQLDate(java.util.Date date){
        java.sql.Date sDate = new java.sql.Date(date.getTime());
        return sDate;
    }
}
