package com.demo.appdemo.DAO;

import com.demo.appdemo.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean vip);

    boolean doWork();
}
