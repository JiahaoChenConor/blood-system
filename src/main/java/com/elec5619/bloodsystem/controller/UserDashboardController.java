package com.elec5619.bloodsystem.controller;


import com.elec5619.bloodsystem.entity.MessageRecord;
import com.elec5619.bloodsystem.service.MessageRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserDashboardController {
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

}
