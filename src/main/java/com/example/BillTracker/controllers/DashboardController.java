package com.example.BillTracker.controllers;

import com.example.BillTracker.data.BillRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DashboardController {

    @Autowired
    private BillRepository billRepository;

    //test version
    @GetMapping("dashboard")
    public String dashboard(Model model) {
        Gson gson = new Gson();
        String billDataJson = gson.toJson(billRepository.findAll());
        model.addAttribute("billDataJson", billDataJson);
        return "dashboard";
    }

    //create a bill
    @GetMapping("create-bill")
    public String createBill() {
        return "bill/create-bill";
    }

//    //import name, db info
//        @GetMapping("dashboard")
//        //need mapping annotation
//        public String displayDashboard(@RequestParam String name, Model model) {
//            //replace attribute name with variable name in template
//            model.addAttribute("firstName", name);
//        return "index/dashboard";
//    }

}
