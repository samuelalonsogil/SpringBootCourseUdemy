package com.demo.appdemo.DAO;

import com.demo.appdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(Account account, boolean vip) {
        System.out.println(getClass() + " : DOING MY DB WORK: ADDING AN ACCOUNT");

    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " :DOING WORK");
        return false;
    }
}
