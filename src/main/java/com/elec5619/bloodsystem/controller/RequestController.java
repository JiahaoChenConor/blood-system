package com.elec5619.bloodsystem.controller;

import com.elec5619.bloodsystem.entity.*;
import com.elec5619.bloodsystem.service.AccountService;
import com.elec5619.bloodsystem.service.EmailService;
import com.elec5619.bloodsystem.service.HistoryRecordService;
import com.elec5619.bloodsystem.service.MessageRecordService;
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
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Controller
public class RequestController {
    @Autowired
    MessageRecordService messageRecordService;

    @Autowired
    EmailService emailService;

    @Autowired
    HistoryRecordService historyRecordService;

    @Autowired
    AccountService accountService;

    private HistoryRecord request;
    private MessageRecord messageRecord;

    @GetMapping("/book/request")
    public String request(Model model)
    {
        request = new HistoryRecord();
        messageRecord = new MessageRecord();

        request.setHistoryType(HistoryType.REQUEST);

        Account curUser = accountService.getAccountByEmail(accountService.getCurrentUserEmail());
        request.setAccount(curUser);

        accountService.addCurrentUser(model);
        return "request-step1";
    }

    @GetMapping("/book/request-step2")
    public String requestStepTwo(Model model,
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

        accountService.addCurrentUser(model);
        return "request-step2";
    }

    @GetMapping("/book/request-step3")
    public String requestStepThree(Model model,
                                  @RequestParam(name="location", required = false) String location)
    {

        request.setLocation(location);
        accountService.addCurrentUser(model);
        return "request-step3";
    }

    @GetMapping("/book/request-step4")
    public String requestStepFour(Model model,
                                @RequestParam(name="subject", required = false) String subject)
    {

        if (subject != null){
            switch (subject) {
                case "Urgent-request":
                    messageRecord.setSubject(Subject.URGENT_REQUEST);
                    request.setHistoryType(HistoryType.URGENT);
                case "Blood-Request":
                    messageRecord.setSubject(Subject.BLOOD_REQUEST);
            }
        }else{
            messageRecord.setSubject(null);
        }


        accountService.addCurrentUser(model);

        String hasFound;

        List<HistoryRecord> donates = historyRecordService.getMatchDonateRecord(request.getBloodType());

        if(donates.size() == 0){
            hasFound = "false";
        }else{
            hasFound = "true";
        }

        model.addAttribute("hasFound", hasFound);
        return "request-step4";
    }


    @PostMapping("/book/getMatchers")
    @ResponseBody
    public String existMatchers(Model model){
        // find matchers
        List<HistoryRecord> donates = historyRecordService.getMatchDonateRecord(request.getBloodType());

        if (donates.size() == 0) {
            System.out.println("called ");
            return "false";
        }
        else {return "true";}
    }



    @PostMapping("/book/request-confirm")
    @ResponseBody
    public String requestStepConfirm(Model model,
                                    @RequestParam(name="message") String message){

        System.out.println(message);

        request.setDate(accountService.getCurDate());
        if (request != null
                && request.getAccount() != null
                && request.getLocation() != null
                && request.getMeasure() != null){
            System.out.println("save to db");
            // save to db.
            request.setMatched(false);
            request.setContent(message);
            // find matchers
            List<HistoryRecord> donates = historyRecordService.getMatchDonateRecord(request.getBloodType());


            if (donates.size() == 0){
                request.setHasMatchers(false);
                historyRecordService.saveHistoryRecord(request);

            }else {
                request.setHasMatchers(true);
                HistoryRecord historyRecord = historyRecordService.saveHistoryRecord(request);

                // filter nearest and most recent donate
                Account matchedDonate = donates.get(0).getAccount();
                // then save message to db
                if (messageRecord != null && messageRecord.getSubject() != null){ // more checking
                    // subject already set
                    // TODO: better to set before and check it is not null in if
                    messageRecord.setHaveRead(false);
                    messageRecord.setHistoryRecord(historyRecord);

                    long historyRecordId = messageRecord.getHistoryRecord().getHistoryId();
                    messageRecord.setContent("[The matched donated ID: " + historyRecordId + " ]\n"
                            + message);

                    messageRecord.setReceiver(matchedDonate.getEmail());
                    messageRecord.setAccount(accountService.getAccountByEmail(accountService.getCurrentUserEmail()));
                    messageRecord.setSender(accountService.getCurrentUserEmail());
                    messageRecord.setDate(accountService.getCurDate());

                    messageRecordService.saveMessageRecord(messageRecord);
                    System.out.println("save to db2");

                    // send email through third-party gmail
                    EmailDetails emailDetails = new EmailDetails();
                    emailDetails.setRecipient(matchedDonate.getEmail());
                    emailDetails.setSubject(messageRecord.getSubject().toString());
                    emailDetails.setMsgBody(messageRecord.getContent());
                    emailService.sendSimpleMail(emailDetails);
                    // TODO: mark both of them(history record) as finished
                }
            }
        }


        accountService.addCurrentUser(model);

        return "success";
    }

    @GetMapping("/book/request-confirm")
    public String returnIndex(Model model)
    {

        accountService.addCurrentUser(model);

        List<HistoryRecord> historyRecords = historyRecordService.getUrgentRequestRecordInWaitingList();
        Map<String, List<HistoryRecord>> messages = new HashMap<>() {{
            put("history", historyRecords);
        }};

        model.addAttribute("history", messages);

        return "index-user";
    }


}
