package com.imugen.domain;

import java.util.Date;

/**
 * @author Daniel Liu 2020/3/12 19:54
 */
public class Account {
    private String name;
    
    private Double money;

    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Account{" + "name='" + name + '\'' + ", money=" + money + ", date=" + date + '}';
    }
}