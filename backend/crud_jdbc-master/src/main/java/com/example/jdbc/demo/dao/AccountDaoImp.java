package com.example.jdbc.demo.dao;


//import com.example.jdbc.demo.model.Account;
import com.example.jdbc.demo.model.AccountMapper;
import com.example.jdbc.demo.model.AccountResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class AccountDaoImp implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<AccountResult> getAll() {
        String sql = "select * from Account order by id asc";
        List<AccountResult> Account = jdbcTemplate.query(sql, new AccountMapper());
        return Account;
    }

    @Override
    public AccountResult getAccountByUsername(char username) {
        String sql2 = "select * from user where username = ?";
        AccountResult Account2 = jdbcTemplate.queryForObject(sql2, new Object[]{username}, new AccountMapper());
        return Account2;
    }


    @Override
    public int lastestInput() {
        String sql2 = "SELECT currval(pg_get_serial_sequence('Account','id'))";
        int id = jdbcTemplate.queryForObject(sql2, Integer.class);
        return id;
    }
}