package com.example.jdbc.demo.service;

import com.example.jdbc.demo.model.Account;
import com.example.jdbc.demo.model.AccountResult;

import java.util.List;

public interface AccountService {
    List<AccountResult> getAll();
    AccountResult getAccountByUsername(char username);
    void addAccount(Account account);
    void updateAccount(Account account, int nik);
    void deleteAccountByNik(int nik);
    int lastestInput();

}
