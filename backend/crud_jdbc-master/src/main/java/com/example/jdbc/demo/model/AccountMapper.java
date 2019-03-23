package com.example.jdbc.demo.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<AccountResult> {
    @Override
    public AccountResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setNik(rs.getInt("nik"));
        account.setUsername(rs.getString("username"));
        account.setPassword(rs.getString("password"));

        AccountResult accountResult = new AccountResult();
        accountResult.setNik(rs.getInt("nik"));
        accountResult.setUsername(rs.getInt("username"));
        accountResult.setPassword(rs.getInt("password"));
        return accountResult;
    }
}