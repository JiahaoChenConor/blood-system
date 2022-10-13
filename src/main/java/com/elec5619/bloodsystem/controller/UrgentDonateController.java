package com.elec5619.bloodsystem.controller;

import com.elec5619.bloodsystem.domain.*;
import com.elec5619.bloodsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * The type Urgent Donate controller.
 */

@Controller
public class UrgentDonateController {

    /**
     * The Message record service.
     */
    @Autowired
    MessageRecordService messageRecordService;

    /**
     * The Email service.
     */
    @Autowired
    EmailService emailService;

    /**
     * The Sms service.
     */
    @Autowired
    SmsService smsService;

    /**
     * The History record service.
     */
    @Autowired
    HistoryRecordService historyRecordService;

    /**
     * The Account service.
     */
    @Autowired
    AccountService accountService;

    /**
     * The UrgentPost service
     */
    @Autowired
    UrgentPostService urgentPostService;

    private UrgentPost urgentPost;

    private HistoryRecord donate;

    private MessageRecord messageRecord;


    @GetMapping("/urgentDonate")
    public String urgentDonate(Model model,
                               @RequestParam(name="urgentId", required = false) Long urgentId){
        donate = new HistoryRecord();
        messageRecord = new MessageRecord();
        urgentPost = urgentPostService.findUrgentPostById(urgentId);

        donate.setHistoryType(HistoryType.DONATE);

        Account curUser = accountService.getAccountByEmail(accountService.getCurrentUserEmail());

        donate.setAccount(curUser);

        accountService.addCurrentUser(model);

        donate.setMeasure(urgentPost.getMeasure());

        donate.setBloodType(urgentPost.getBloodType());

        donate.setLocation(urgentPost.getLocation());

        donate.setDate(urgentPost.getDate());

        model.addAttribute("cc", Double.toString(donate.getMeasure()));
        model.addAttribute("bloodType", donate.getBloodType().toString());
        model.addAttribute("location", donate.getLocation());
        model.addAttribute("date", donate.getDate());

        return "urgent-donate-step1";

    }
}
