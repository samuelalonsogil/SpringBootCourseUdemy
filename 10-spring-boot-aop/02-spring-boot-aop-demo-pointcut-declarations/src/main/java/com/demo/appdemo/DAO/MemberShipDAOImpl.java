package com.demo.appdemo.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShipDAOImpl implements MemberShipDAO{
    @Override
    public boolean addSilly() {
        System.out.println(getClass() + " : DOING MY DB WORK: ADDING SILLY");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + " : SLEEPY TIME!");
    }

}

