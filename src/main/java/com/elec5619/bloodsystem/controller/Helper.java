package com.elec5619.bloodsystem.controller;

import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class Helper {

    @Autowired
     AccountService accountService;


    public void addCurrentUser(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            model.addAttribute("username", username.split("@")[0]);
        } else {
            throw new IllegalStateException("No user details");
        }
    }

    public String getCurrentUserEmail(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails)principal).getUsername();
        } else {
            throw new IllegalStateException("No user details");
        }
    }

    public String getCurDate(){
        // default cur time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }


    public Account getCurrentAccount(){
        return accountService.getAccountByEmail(getCurrentUserEmail());
    }
}
