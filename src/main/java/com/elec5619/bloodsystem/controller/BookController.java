package com.elec5619.bloodsystem.controller;

import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.HistoryRecord;
import com.elec5619.bloodsystem.entity.HistoryType;
import com.elec5619.bloodsystem.service.AccountService;
import com.elec5619.bloodsystem.service.DonateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class BookController {


    @Autowired
    DonateService donateService;

    @Autowired
    AccountService accountService;


    private HistoryRecord donate;
    private final double DEFAULT_DONATE = 400.0;

    @GetMapping("/book")
    public String login(Model model)
    {
        addCurrentUser(model);
        return "book";
    }


    @GetMapping("/book/donate")
    public String donate(Model model)
    {
        donate = new HistoryRecord();
        donate.setMeasure(DEFAULT_DONATE);
        donate.setHistoryType(HistoryType.DONATE);

        Account curUser = accountService.getAccountByEmail(getCurrentUser());
        donate.setAccount(curUser);

        addCurrentUser(model);
        return "donate-step1";
    }

    @GetMapping("/book/donate-step2")
    public String donateStepTwo(Model model)
    {
        addCurrentUser(model);
        return "donate-step2";
    }

    @GetMapping("/book/donate-step3")
    public String donateStepThree(Model model,
                                  @RequestParam(name="location", required = false) String location)
                                    // when back, we reset the location into null
                                    // So we can check all in last confirmation
    {

        donate.setLocation(location);
        addCurrentUser(model);
        return "donate-step3";
    }

    @GetMapping("/book/donate-step4")
    public String donateStepFour(Model model,
                                 @RequestParam(name="time", required = false) String time)
    {

        donate.setDate(time);
        System.out.println(time);
        addCurrentUser(model);
        return "donate-step4";
    }

    @GetMapping("/book/donate-confirm")
    public String donateStepConfirm(Model model)
    {

        if (donate != null
            && donate.getAccount() != null
            && donate.getLocation() != null
            && donate.getDate() != null
            && donate.getMeasure() != null){
            // save to db.
            donateService.saveDonateRequest(donate);
        }
        addCurrentUser(model);
        return "index-user";
    }

    private void addCurrentUser(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            model.addAttribute("username", username.split("@")[0]);
        } else {
            throw new IllegalStateException("No user details");
        }
    }

    private String getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails)principal).getUsername();
        } else {
            throw new IllegalStateException("No user details");
        }
    }


}
