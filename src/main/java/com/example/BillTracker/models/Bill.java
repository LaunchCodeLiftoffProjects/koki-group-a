package com.example.BillTracker.models;

import java.util.Date;

public abstract class Bill {

    private int id;
    private double amount;
    private String name;
    private Date date;
    private String type;

    public Bill(double amount, String name, Date date, String type) {
        this.amount = amount;
        this.name = name;
        this.date = date;
        this.type = type;
    }

    public Bill() {};

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
