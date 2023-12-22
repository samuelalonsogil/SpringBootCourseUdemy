package com.demo.appdemo.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShipDAOImpl implements MemberShipDAO{
    @Override
    public void addSilly() {
        System.out.println(getClass() + " : DOING MY DB WORK: ADDING SILLY");
    }

}

