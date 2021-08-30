package com.example.BillTracker.controllers;

import com.example.BillTracker.data.BillRepository;
import com.example.BillTracker.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;

@Controller
@RequestMapping("bill")

public class BillController {

    @Autowired
    private BillRepository billRepository;

    @GetMapping("create-bill")
    public String displayCreateBillForm(Model model) {
        model.addAttribute(new Bill());
        return "bill/create-bill";
    }

    @PostMapping("create-bill")
    public String processCreateBillForm(@ModelAttribute @Valid Bill newBill, Errors errors, Model model) {

        if(errors.hasErrors()) {
            return "bill/create-bill";
        }

        billRepository.save(newBill);
        model.addAttribute("bill", billRepository.findAll());
        return "dashboard";
    }


}
