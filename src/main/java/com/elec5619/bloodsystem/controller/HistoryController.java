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
 * The type History controller.
 */
@Controller
public class HistoryController {
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
     * All history string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/history")
    public String allHistory(Model model){

        accountService.addCurrentUser(model);

        List<HistoryRecord> historyRecords = historyRecordService.findUserHistoryRecord(accountService.getCurrentAccount());

        Map<String, List<HistoryRecord>> messages = new HashMap<>() {{
            put("history", historyRecords);
        }};

        model.addAttribute("history", messages);

        return "history";
    }


    /**
     * Change history status string.
     *
     * @param matched the matched
     * @param id      the id
     * @return the string
     */
    @PostMapping("/history")
    @ResponseBody
    public String changeHistoryStatus(@RequestParam(name = "matched") String matched,
                                      @RequestParam(name = "recordId") String id){
        long recordId = Long.parseLong(id);

        if (matched != null && matched.equals("true")){
            historyRecordService.updateHistoryRecordStatus(recordId, true);
            return "change";
        }else if (matched != null && matched.equals("false")){
            historyRecordService.updateHistoryRecordStatus(recordId, false);
            return "change";
        }

        return "nothing";
    }


}
