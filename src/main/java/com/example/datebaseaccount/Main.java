/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datebaseaccount;

import com.example.datebaseaccount.dao.CountDao;
import com.example.datebaseaccount.dao.CustomerDao;
import com.example.datebaseaccount.dao.TransactionCategoryDao;
import com.example.datebaseaccount.dao.TransactionDao;
import com.example.datebaseaccount.dao.domain.Count;
import com.example.datebaseaccount.dao.domain.Customer;
import com.example.datebaseaccount.dao.domain.Transaction;
import com.example.datebaseaccount.dao.domain.TransactionCategory;
import java.util.Date;
import java.sql.SQLException;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author slava
 */
public class Main {
    public static void main(String[] args) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    CustomerDao customerDao = CustomerDao.getCustomerDao();
    CountDao countDao = CountDao.getCountDao();
    TransactionDao transactionDao = TransactionDao.getTransactionDao();
    TransactionCategoryDao transactionCategoryDao = TransactionCategoryDao.getTransactionCategoryDao();
        System.out.println(transactionDao.sumTransactionCount(3));
        
    }
}