package com.demo.appdemo.DAO;

import com.demo.appdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public List<Account> findAccounts(boolean tripWire) {

        /* for academic purposes simulate an exception */
        if (tripWire){
            throw new RuntimeException(" No soup for you !! ");
        }

        ArrayList<Account> accounts = new ArrayList<Account>();

        /* crete sample accounts */
        Account account01 = new Account("samu","iron");
        Account account02 = new Account("noa","bronze");
        Account account03 = new Account("zoe","silver");
        Account account04 = new Account("antia","gold");

        /* add them to our accounts list */
        accounts.add(account01);
        accounts.add(account02);
        accounts.add(account03);
        accounts.add(account04);

        return accounts;
    }

    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public void addAccount(Account account, boolean vip) {
        System.out.println(getClass() + " : DOING MY DB WORK: ADDING AN ACCOUNT");

    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " :DOING WORK");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + " : GETNAME");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " : setNAME");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " : GETservice");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " : setService");
        this.serviceCode = serviceCode;
    }
}
