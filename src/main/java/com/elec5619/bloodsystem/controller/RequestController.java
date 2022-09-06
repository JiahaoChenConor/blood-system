package com.elec5619.bloodsystem.controller;

import com.elec5619.bloodsystem.entity.*;
import com.elec5619.bloodsystem.service.AccountService;
import com.elec5619.bloodsystem.service.HistoryRecordService;
import com.elec5619.bloodsystem.service.MessageRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class RequestController {
    @Autowired
    MessageRecordService messageRecordService;


    @Autowired
    HistoryRecordService historyRecordService;

    @Autowired
    AccountService accountService;


    private HistoryRecord request;
    private MessageRecord messageRecord;

    @GetMapping("/book/request")
    public String donate(Model model)
    {
        request = new HistoryRecord();
        messageRecord = new MessageRecord();

        request.setHistoryType(HistoryType.REQUEST);

        Account curUser = accountService.getAccountByEmail(getCurrentUserEmail());
        request.setAccount(curUser);

        addCurrentUser(model);
        return "request-step1";
    }

    @GetMapping("/book/request-step2")
    public String donateStepTwo(Model model,
                                @RequestParam(name="bloodType", required = false) String bloodType,
                                @RequestParam(name="cc", required = false) String cc)
    {

        if (cc != null){
            request.setMeasure(Double.parseDouble(cc));
        }else{
            request.setMeasure(null);
        }

        if (bloodType != null){
            switch (bloodType) {
                case "A" -> request.setBloodType(BloodType.A);
                case "B" -> request.setBloodType(BloodType.B);
                case "AB" -> request.setBloodType(BloodType.AB);
                case "O" -> request.setBloodType(BloodType.O);
            }
        }else{
            request.setBloodType(null);
        }

        addCurrentUser(model);
        return "request-step2";
    }

    @GetMapping("/book/request-step3")
    public String donateStepThree(Model model,
                                  @RequestParam(name="location", required = false) String location)
    {

        request.setLocation(location);
        addCurrentUser(model);
        return "request-step3";
    }

    @GetMapping("/book/request-step4")
    public String donateStepFour(Model model,
                                @RequestParam(name="subject", required = false) String subject)
    {

        if (subject != null){
            switch (subject) {
                case "Urgent-request" -> messageRecord.setSubject(Subject.URGENT_REQUEST);
                case "Blood-Request" -> messageRecord.setSubject(Subject.BLOOD_REQUEST);
            }
        }else{
            messageRecord.setSubject(null);
        }

        addCurrentUser(model);
        return "request-step4";
    }

    @PostMapping("/book/request-confirm")
    @ResponseBody
    public String donateStepConfirm(Model model,
                                    @RequestParam(name="message") String message){

        System.out.println(message);

        request.setDate(getCurDate());
        if (request != null
                && request.getAccount() != null
                && request.getLocation() != null
                && request.getMeasure() != null){
            System.out.println("save to db");
            // save to db.
            HistoryRecord historyRecord = historyRecordService.saveHistoryRecord(request);

            // find matchers
            List<HistoryRecord> donates = historyRecordService.getMatchDonateRecord(request.getBloodType());



            if (donates.size() == 0){
                System.out.println("No matcher");
            }else {

                // filter nearest and most recent donate
                Account matchedDonate = donates.get(0).getAccount();
                // then save message to db
                if (messageRecord != null && messageRecord.getSubject() != null){ // more checking
                    // subject already set
                    messageRecord.setContent(message);
                    messageRecord.setHistoryRecord(historyRecord);
                    messageRecord.setReceiver(matchedDonate.getEmail());
                    messageRecord.setAccount(accountService.getAccountByEmail(getCurrentUserEmail()));
                    messageRecord.setSender(getCurrentUserEmail());
                    messageRecord.setDate(getCurDate());

                    messageRecordService.saveMessageRecord(messageRecord);
                    System.out.println("save to db2");
                }
            }
        }


        addCurrentUser(model);

        return "";
    }

    @GetMapping("/book/request-confirm")
    public String returnIndex(Model model)
    {

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

    private String getCurrentUserEmail(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails)principal).getUsername();
        } else {
            throw new IllegalStateException("No user details");
        }
    }

    private String getCurDate(){
        // default cur time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
