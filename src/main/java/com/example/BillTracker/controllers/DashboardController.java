package com.example.BillTracker.controllers;

import com.example.BillTracker.data.BillRepository;
import com.example.BillTracker.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class DashboardController {

    @Autowired
    private BillRepository billRepository;


    @GetMapping("dashboard")
    public String displayAllBills(Model model) {
        model.addAttribute("bill", billRepository.findAll());
        return "dashboard";
    }

    @PostMapping("dashboard")
    public String refreshDisplayAllBills(Model model) {
        model.addAttribute("bill", billRepository.findAll());
        return "dashboard";
    }

//    //create a bill
//    @GetMapping("create-bill")
//    public String createBill() {
//        return "bill/create-bill";
//    }


}
