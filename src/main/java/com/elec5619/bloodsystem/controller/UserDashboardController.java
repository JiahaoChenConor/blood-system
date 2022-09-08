package com.elec5619.bloodsystem.controller;


import com.elec5619.bloodsystem.entity.EmailDetails;
import com.elec5619.bloodsystem.entity.MessageRecord;
import com.elec5619.bloodsystem.service.EmailService;
import com.elec5619.bloodsystem.service.MessageRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserDashboardController {
    @Autowired
    EmailService emailService;

    @Autowired
    Helper helper;

    @Autowired
    MessageRecordService messageRecordService;


    @GetMapping("/messages")
    public String allMessages(Model model){

        helper.addCurrentUser(model);

        List<MessageRecord> messageRecordList = messageRecordService.findAllMessagesByReceiver(helper.getCurrentUserEmail());

        Map<String, List<MessageRecord>> messages = new HashMap<>() {{
            put("messages", messageRecordList);
        }};

        model.addAttribute("messages", messages);
        return "messages";
    }


    @GetMapping("/messages/{messageId}")
    public String specificMessage(@PathVariable String messageId, Model model){
        helper.addCurrentUser(model);

        MessageRecord messageRecord = messageRecordService.findMessageById(Long.parseLong(messageId));

        model.addAttribute("message", messageRecord.getContent());

        return "specific-message";
    }


    @GetMapping("messages/{messageId}/reply")
    public String toReplyPage(@PathVariable String messageId, Model model){
        helper.addCurrentUser(model);

        model.addAttribute("messageId", messageId);

        return "reply";
    }

    @PostMapping("/messages/{messageId}/reply")
    @ResponseBody
    public String reply(Model model,
                        @RequestParam(name = "message") String message,
                        @PathVariable String messageId){
        helper.addCurrentUser(model);

        // send email
        MessageRecord originalMessage = messageRecordService.findMessageById(Long.parseLong(messageId));


        MessageRecord reply = new MessageRecord(originalMessage.getReceiver(),
                                                originalMessage.getSender(),
                                                originalMessage.getSubject(),
                                                message,
                                                getCurDate(),
                                                helper.getCurrentAccount(),
                                                originalMessage.getHistoryRecord());

        messageRecordService.saveMessageRecord(reply);
        System.out.println("save to db2");

        // send email through third-party gmail
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient(reply.getReceiver());
        emailDetails.setSubject(reply.getSubject().toString());
        emailDetails.setMsgBody(message);
        emailService.sendSimpleMail(emailDetails);


        return "index-user";
    }


    private String getCurDate(){
        // default cur time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }



}
