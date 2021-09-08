package com.example.BillTracker.controllers;

import com.example.BillTracker.data.BillRepository;
import com.example.BillTracker.data.UserRepository;
import com.example.BillTracker.models.Bill;
import com.example.BillTracker.models.User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class DashboardController {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("dashboard")
    //public String dashboard(Model model) {
    public String dashboard(@RequestParam(required = false) Integer id, Model model) {
        Gson gson = new Gson();

        if (id == null) {
            model.addAttribute("bill", billRepository.findAll());
        } else {
            Optional<User> bills = userRepository.findById(id);
            if (bills.isEmpty()) {
                model.addAttribute("title", "No bills yet");
            } else {
                User userBills = bills.get();
                model.addAttribute("bill", userBills.getBills());
            }
        }

        String billDataJson = gson.toJson(billRepository.findAll());
        model.addAttribute("billDataJson", billDataJson);
       // model.addAttribute("bill", billRepository.findAll());
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
