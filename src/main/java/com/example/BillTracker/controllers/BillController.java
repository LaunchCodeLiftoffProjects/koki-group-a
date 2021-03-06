package com.example.BillTracker.controllers;

import com.example.BillTracker.data.BillRepository;
import com.example.BillTracker.data.UserRepository;
import com.example.BillTracker.models.Bill;
import com.example.BillTracker.models.User;
import com.example.BillTracker.models.dto.BillFormDTO;
import com.example.BillTracker.models.dto.LoginFormDTO;
import com.example.BillTracker.services.BillService;
import com.example.BillTracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("bill")

public class BillController {

    @Autowired
    private UserService userService;

    @Autowired
    private BillService billService;

    @GetMapping("create-bill")
    public String displayCreateBillForm(Model model) {
        model.addAttribute(new Bill());
        model.addAttribute(new BillFormDTO());
        return "bill/create-bill";
    }

    @PostMapping("create-bill")
    public String processCreateBillForm(@ModelAttribute @Valid BillFormDTO billFormDTO,
                                        Errors errors, HttpServletRequest request) {

        if(errors.hasErrors()) {
            return "bill/create-bill";
        }

        HttpSession session = request.getSession();
        User theUser = userService.getUserFromSession(session);

        Bill newBill = new Bill(billFormDTO.getAmount(), billFormDTO.getBillDueDate(),
                billFormDTO.getName(), billFormDTO.getType(), theUser);

        billService.saveBill(newBill);

        return "redirect:/dashboard";
    }
}
