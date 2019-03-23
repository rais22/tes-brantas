package com.example.jdbc.demo.dao;

//import com.example.jdbc.demo.model.Account;
import com.example.jdbc.demo.model.AccountResult;

import java.util.List;

public interface AccountDao {
    List<AccountResult> getAll();
    AccountResult getAccountByUsername(char username);
    int lastestInput();

}