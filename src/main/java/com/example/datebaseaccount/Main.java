/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount;

import com.example.datebaseaccount.dao.CountDao;
import com.example.datebaseaccount.dao.CustomerDao;
import com.example.datebaseaccount.dao.DaoFactoryNew;
import com.example.datebaseaccount.dao.TransactionCategoryDao;
import com.example.datebaseaccount.dao.TransactionDao;
import com.example.datebaseaccount.dao.domain.Count;
import com.example.datebaseaccount.dao.domain.Customer;
import com.example.datebaseaccount.dao.domain.Transaction;
import com.example.datebaseaccount.dao.domain.TransactionCategory;
import com.example.datebaseaccount.dto.CustomerDto;
import com.example.datebaseaccount.service.DigestService;
import com.example.datebaseaccount.service.SecurityService;
import com.example.datebaseaccount.service.ServiceFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author slava
 */
public class Main {
    public static void main(String[] args) {    
//        CustomerDao customerDao = DaoFactoryNew.getCustomerDao();
//        customerDao.insert(new Customer("Ivan","ivan91@gmail.com","tree")); 
//        SecurityService ss = ServiceFactory.getSecurityService();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Веедите адресс электронной почты");
//        String email = scanner.nextLine();
//        System.out.println("Веедите пароль");
//        String password = scanner.nextLine();
//        CustomerDto customerDto = ss.auth(email,password);
//        if(customerDto==null){
//            CustomerDto customerNew = ss.registration();
//            System.out.println(customerNew);
//        }
//        System.out.printf("Поздравляем %s, вы вошли в базу данных\n",customerDto.getName());
//        System.out.println(customerDto);
          CountDao countDao = DaoFactoryNew.getCountDao();
        try {
            countDao.makeTransactionNegative(2,3,50, 1);
        } catch (ParseException ex) {
            System.out.println("Парсинг даты не прошел");
        }
    }
}