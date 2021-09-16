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

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class DashboardController {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private UserRepository userRepository;

    private static final String userSessionKey = "user";

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }

        return user.get();
    }

//    @GetMapping("dashboard")
//    public String dashboard(HttpSession session, Model model) {
//
//        Integer userId = (Integer) session.getAttribute(userSessionKey);
//
//        Optional<User> optUser = userRepository.findById(userId);
//        if (optUser.isPresent()) {
//            User user = (User) optUser.get();
//            if (user.getBills() == null) {
//                model.addAttribute("title", "No bills yet");
//            } else {
//                User theUser = getUserFromSession(session);
//                Gson gson = new Gson();
//                String billDataJson = gson.toJson(theUser.getBills());
//                model.addAttribute("billDataJson", billDataJson);
//                model.addAttribute("bill", theUser.getBills());
//            }
//        }
//        return "dashboard"; }

    @GetMapping("dashboard")
    public String dashboard(Model model) {

//        User user = getUserFromSession(session);
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
