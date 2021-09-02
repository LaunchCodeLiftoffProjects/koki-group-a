package com.example.BillTracker.controllers;

import com.example.BillTracker.data.BillRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DashboardController {

    @Autowired
    private BillRepository billRepository;

    @GetMapping("dashboard")
    public String dashboard(Model model) {
        Gson gson = new Gson();
        String billDataJson = gson.toJson(billRepository.findAll());
        model.addAttribute("billDataJson", billDataJson);
        model.addAttribute("bill", billRepository.findAll());
        return "dashboard"; }

    @GetMapping("create-bill")
    public String createBill() {
        return "bill/create-bill";
    }

    @PostMapping("dashboard")
    public String deleteBill(@RequestParam(required = false) int[] billIds) {

        if (billIds !=null) {
            for (int id : billIds) {
                billRepository.deleteById(id);
            }
        }
        return "redirect:/dashboard";
    }


}
