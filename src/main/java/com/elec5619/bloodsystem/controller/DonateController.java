package com.elec5619.bloodsystem.controller;

import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.BloodType;
import com.elec5619.bloodsystem.entity.HistoryRecord;
import com.elec5619.bloodsystem.entity.HistoryType;
import com.elec5619.bloodsystem.service.AccountService;
import com.elec5619.bloodsystem.service.HistoryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The type Donate controller.
 */
@Controller
public class DonateController {

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


    private HistoryRecord donate;

    /**
     * Login string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/book")
    public String login(Model model)
    {
        accountService.addCurrentUser(model);
        return "book";
    }


    /**
     * Donate string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/book/donate")
    public String donate(Model model)
    {
        donate = new HistoryRecord();

        donate.setHistoryType(HistoryType.DONATE);

        Account curUser = accountService.getAccountByEmail(accountService.getCurrentUserEmail());

        donate.setAccount(curUser);

        accountService.addCurrentUser(model);
        return "donate-step1";
    }

    /**
     * Donate step two string.
     *
     * @param model     the model
     * @param bloodType the blood type
     * @param cc        the cc
     * @return the string
     */
    @GetMapping("/book/donate-step2")
    public String donateStepTwo(Model model,
                                @RequestParam(name="bloodType", required = false) String bloodType,
                                @RequestParam(name="cc", required = false) String cc)
    {

        if (cc != null){
            donate.setMeasure(Double.parseDouble(cc));
        }


        if (bloodType != null){
            switch (bloodType) {
                case "A" -> donate.setBloodType(BloodType.A);
                case "B" -> donate.setBloodType(BloodType.B);
                case "AB" -> donate.setBloodType(BloodType.AB);
                case "O" -> donate.setBloodType(BloodType.O);
            }
        }

        accountService.addCurrentUser(model);
        return "donate-step2";
    }

    /**
     * Donate step three string.
     *
     * @param model    the model
     * @param location the location
     * @return the string
     */
    @GetMapping("/book/donate-step3")
    public String donateStepThree(Model model,
                                  @RequestParam(name="location", required = false) String location)
                                    // when back, we reset the location into null
                                    // So we can check all in last confirmation
    {
        accountService.addCurrentUser(model);

        if (location != null){
            donate.setLocation(location);
        }
        return "donate-step3";
    }

    /**
     * Donate step four string.
     *
     * @param model the model
     * @param time  the time
     * @return the string
     */
    @GetMapping("/book/donate-step4")
    public String donateStepFour(Model model,
                                 @RequestParam(name="time", required = false) String time)
    {

        if (time != null){
            donate.setDate(time);
        }

        accountService.addCurrentUser(model);
        return "donate-step4";
    }

    /**
     * Donate step confirm string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/book/donate-confirm")
    public String donateStepConfirm(Model model)
    {

        if (donate != null
            && donate.getAccount() != null
            && donate.getLocation() != null
            && donate.getDate() != null
            && donate.getMeasure() != null){
            // save to db.
            donate.setMatched(false);
            historyRecordService.saveHistoryRecord(donate);
        }
        accountService.addCurrentUser(model);

        List<HistoryRecord> historyRecords = historyRecordService.getUrgentRequestRecordInWaitingList();
        Map<String, List<HistoryRecord>> messages = new HashMap<>() {{
            put("history", historyRecords);
        }};

        model.addAttribute("history", messages);
        
        return "index-user";
    }




}
