package com.demo.appdemo.DAO;

import com.demo.appdemo.Account;

import java.util.List;

public interface AccountDAO {

    /* add a new method */
    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);

    void addAccount(Account account, boolean vip);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);


}
