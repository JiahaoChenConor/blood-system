package com.elec5619.bloodsystem.controller;

import com.elec5619.bloodsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    @Autowired
    AccountService accountService;

    @GetMapping("/profile")
    public String profilePage(Model model){
        accountService.addCurrentUser(model);
        return "profile";
    }

}
