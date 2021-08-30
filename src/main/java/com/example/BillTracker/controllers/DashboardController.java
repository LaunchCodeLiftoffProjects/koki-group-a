package com.example.BillTracker.controllers;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DashboardController {


    //test version
    @GetMapping("dashboard")
    public String dashboard(Model model) {
        String test = "hello world!";
        Gson gson = new Gson();
        String jsonTest = gson.toJson(test);
        model.addAttribute("test", jsonTest);

        return "profile";
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
