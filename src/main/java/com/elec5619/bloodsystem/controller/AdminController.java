package com.elec5619.bloodsystem.controller;


import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.MessageRecord;
import com.elec5619.bloodsystem.service.AccountService;
import com.elec5619.bloodsystem.service.MessageRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    AccountService accountService;

    @Autowired
    MessageRecordService messageRecordService;

    @Autowired
    Helper helper;

    @GetMapping("/admin/user-message/{userId}")
    public String userMessages(@PathVariable String userId, Model model){
        helper.addCurrentUser(model);


        Account account = accountService.getAccountById(Long.parseLong(userId));

        List<MessageRecord> messageRecordList = messageRecordService.findAllMessagesByReceiver(account.getEmail());

        Map<String, List<MessageRecord>> messages = new HashMap<>() {{
            put("messages", messageRecordList);
        }};

        model.addAttribute("messages", messages);

        return "admin-user-message";
    }

    @GetMapping("/admin/messages/{messageId}")
    public String specificMessage(@PathVariable String messageId, Model model){
        helper.addCurrentUser(model);

        MessageRecord messageRecord = messageRecordService.findMessageById(Long.parseLong(messageId));

        model.addAttribute("message", messageRecord.getContent());

        return "admin-specific-message";
    }

    @PostMapping("/admin/delete")
    @ResponseBody
    public String deleteMessage(@RequestParam(name = "messageId") String messageId){

        messageRecordService.deleteById(Long.parseLong(messageId));

        return "success";
    }

}
