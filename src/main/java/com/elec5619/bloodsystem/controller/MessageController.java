package com.elec5619.bloodsystem.controller;


import com.elec5619.bloodsystem.entity.EmailDetails;
import com.elec5619.bloodsystem.entity.HistoryRecord;
import com.elec5619.bloodsystem.entity.MessageRecord;
import com.elec5619.bloodsystem.service.AccountService;
import com.elec5619.bloodsystem.service.EmailService;
import com.elec5619.bloodsystem.service.HistoryRecordService;
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

/**
 * The type Message controller.
 */
@Controller
public class MessageController {
    /**
     * The Email service.
     */
    @Autowired
    EmailService emailService;

    /**
     * The Account service.
     */
    @Autowired
    AccountService accountService;

    /**
     * The Message record service.
     */
    @Autowired
    MessageRecordService messageRecordService;

    /**
     * The History record service.
     */
    @Autowired
    HistoryRecordService historyRecordService;


    /**
     * All messages string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/messages")
    public String allMessages(Model model){

        accountService.addCurrentUser(model);

        List<MessageRecord> messageRecordList = messageRecordService.findAllMessagesByReceiver(accountService.getCurrentUserEmail());

        Map<String, List<MessageRecord>> messages = new HashMap<>() {{
            put("messages", messageRecordList);
        }};

        model.addAttribute("messages", messages);
        return "messages";
    }


    /**
     * Specific message string.
     *
     * @param messageId the message id
     * @param model     the model
     * @return the string
     */
    @GetMapping("/messages/{messageId}")
    public String specificMessage(@PathVariable String messageId, Model model){
        accountService.addCurrentUser(model);

        MessageRecord messageRecord = messageRecordService.findMessageById(Long.parseLong(messageId));

        // set message as already read
        messageRecordService.setMessageAsRead(messageRecord.getMessageId());

        model.addAttribute("message", messageRecord.getContent());

        return "specific-message";
    }


    /**
     * To reply page string.
     *
     * @param messageId the message id
     * @param model     the model
     * @return the string
     */
    @GetMapping("messages/{messageId}/reply")
    public String toReplyPage(@PathVariable String messageId, Model model){
        accountService.addCurrentUser(model);

        model.addAttribute("messageId", messageId);

        return "reply";
    }

    /**
     * Reply string.
     *
     * @param model     the model
     * @param message   the message
     * @param messageId the message id
     * @return the string
     */
    @PostMapping("/messages/{messageId}/reply")
    @ResponseBody
    public String reply(Model model,
                        @RequestParam(name = "message") String message,
                        @PathVariable String messageId){
        accountService.addCurrentUser(model);

        // send email
        MessageRecord originalMessage = messageRecordService.findMessageById(Long.parseLong(messageId));


        MessageRecord reply = new MessageRecord(originalMessage.getReceiver(),
                                                originalMessage.getSender(),
                                                originalMessage.getSubject(),
                                                message,
                                                getCurDate(),
                                                accountService.getCurrentAccount(),
                                                originalMessage.getHistoryRecord(), false);

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
