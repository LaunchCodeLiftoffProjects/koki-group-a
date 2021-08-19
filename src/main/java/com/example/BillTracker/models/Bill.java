package com.example.BillTracker.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public  class Bill {

    private int id;
    private double amount;
    private String name;
    private Date date;
    private String billDueDate;
    private String type;

    public Bill(double amount, String name, Date date, String billDueDate, String type) {
        this.amount = amount;
        this.name = name;
        this.date = date;
        this.billDueDate = billDueDate;
        this.type = type;
    }

    public Bill(double amount, String name, String billDueDate, String type) {
        this.amount = amount;
        this.name = name;
        this.billDueDate = billDueDate;
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

    public String getBillDueDate() {
        return billDueDate;
    }

    public void setBillDueDate(String billDueDate) {
        this.billDueDate = billDueDate;
    }

    public LocalDate convertDateStringToDate(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        LocalDate dueDate = LocalDate.parse(stringDate, formatter);
        return dueDate;
    }

}
