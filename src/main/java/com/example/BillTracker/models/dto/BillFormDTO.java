package com.example.BillTracker.models.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BillFormDTO {


    private double amount;


    private String name;


    private String billDueDate;


    private String type;

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

    public String getBillDueDate() {
        return billDueDate;
    }

    public void setBillDueDate(String billDueDate) {
        this.billDueDate = billDueDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
