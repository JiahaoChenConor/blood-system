package com.elec5619.bloodsystem.controller;

import com.elec5619.bloodsystem.domain.*;
import com.elec5619.bloodsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private HistoryRecord request;


    @GetMapping("/urgentDonate")
    public String urgentDonate(Model model,
                               @RequestParam(name="urgentId", required = false) Long urgentId){
        donate = new HistoryRecord();
        messageRecord = new MessageRecord();
        urgentPost = urgentPostService.findUrgentPostById(urgentId);
        request = historyRecordService.findHistoryRecordById(urgentPost.getCorrespondHistoryRecordId());

        donate.setHistoryType(HistoryType.DONATE);

        Account curUser = accountService.getAccountByEmail(accountService.getCurrentUserEmail());

        donate.setAccount(curUser);

        accountService.addCurrentUser(model);

        donate.setMeasure(urgentPost.getMeasure());

        donate.setBloodType(urgentPost.getBloodType());

        donate.setLocation(urgentPost.getLocation());

        donate.setDate(urgentPost.getDate());

        model.addAttribute("cc", Double.toString(request.getMeasure()));
        model.addAttribute("bloodType", request.getBloodType().toString());
        model.addAttribute("location", request.getLocation());
        model.addAttribute("date", request.getDate());

        return "urgent-donate-step1";
    }

    @GetMapping("/urgentDonate/step2")
    public String urgentDonateStep2(Model model){
        accountService.addCurrentUser(model);
        return "urgent-donate-step2";
    }
    @GetMapping("/urgentDonate/confirm")
    public String urgentDonateConfirm(Model model,
                                    @RequestParam(name="message", required = false) String message){
        accountService.addCurrentUser(model);
        // save to db
        if (donate != null
                && donate.getAccount() != null
                && donate.getLocation() != null
                && donate.getDate() != null
                && donate.getMeasure() != null){
            // save to db.
            donate.setMatched(false);
            donate.setHasMatchers(true);
            historyRecordService.updateHistoryRecordHasMatchersStatus(request.getHistoryId(), true);
            urgentPostService.updateUrgentPostStatus(urgentPost.getUrgentId(),true);
            historyRecordService.saveHistoryRecord(donate);
        }

        messageRecord.setSubject(Subject.NORMAL_CASE);
        messageRecord.setHaveRead(false);
        messageRecord.setHistoryRecord(donate);
        messageRecord.setReceiver(request.getAccount().getEmail());
        messageRecord.setAccount(accountService.getAccountByEmail(accountService.getCurrentUserEmail()));
        messageRecord.setSender(accountService.getCurrentUserEmail());
        messageRecord.setContent(message);
        messageRecord.setDate(accountService.getCurDate());
        messageRecordService.saveMessageRecord(messageRecord);

        EmailDetails notifyEmailDetail = new EmailDetails();
        notifyEmailDetail.setRecipient(request.getAccount().getEmail());
        notifyEmailDetail.setSubject("Donator Notification");
        notifyEmailDetail.setMsgBody("Hi, we found a donator for you. Please go back our website and check that.\n"
                + "Donater: "+message);
        emailService.sendSimpleMail(notifyEmailDetail);


        List<UrgentPost> urgentPosts = urgentPostService.getAvailableUrgentPost(accountService.getCurrentAccount());
        Map<String, List<UrgentPost>> messages = new HashMap<>() {{
            put("urgent", urgentPosts);
        }};

        model.addAttribute("urgent", messages);

        return "index-user";
    }


}
