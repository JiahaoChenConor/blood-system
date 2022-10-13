package com.elec5619.bloodsystem.controller;

import com.elec5619.bloodsystem.domain.*;
import com.elec5619.bloodsystem.service.AccountService;
import com.elec5619.bloodsystem.service.EmailService;
import com.elec5619.bloodsystem.service.HistoryRecordService;
import com.elec5619.bloodsystem.service.MessageRecordService;
import com.elec5619.bloodsystem.service.SmsService;
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
 * The type Request controller.
 */
@Controller
public class RequestController {
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

    private HistoryRecord request;
    private MessageRecord messageRecord;

    /**
     * Request string.
     *
     * @param model the model
     * @return the string
     */
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

    /**
     * Request step two string.
     *
     * @param model     the model
     * @param bloodType the blood type
     * @param cc        the cc
     * @return the string
     */
    @GetMapping("/book/request-step2")
    public String requestStepTwo(Model model,
                                @RequestParam(name="bloodType", required = false) String bloodType,
                                @RequestParam(name="cc", required = false) String cc)
    {

        if (cc != null){
            request.setMeasure(Double.parseDouble(cc));
        }

        if (bloodType != null){
            switch (bloodType) {
                case "A" -> request.setBloodType(BloodType.A);
                case "B" -> request.setBloodType(BloodType.B);
                case "AB" -> request.setBloodType(BloodType.AB);
                case "O" -> request.setBloodType(BloodType.O);
            }
        }

        accountService.addCurrentUser(model);
        return "request-step2";
    }

    /**
     * Request step three string.
     *
     * @param model    the model
     * @param location the location
     * @return the string
     */
    @GetMapping("/book/request-step3")
    public String requestStepThree(Model model,
                                  @RequestParam(name="location", required = false) String location)
    {

        if (location != null){
            request.setLocation(location);
        }

        accountService.addCurrentUser(model);
        return "request-step3";
    }

    /**
     * Request step four string.
     *
     * @param model   the model
     * @param subject the subject
     * @return the string
     */
    @GetMapping("/book/request-step4")
    public String requestStepFour(Model model,
                                @RequestParam(name="subject", required = false) String subject)
    {

        if (subject != null){
            switch (subject) {
                case "Urgent-request":
                    System.out.println("THIS CASE IS URGENT URGENT URGENT");
                    messageRecord.setSubject(Subject.URGENT_REQUEST);
                    request.setHistoryType(HistoryType.URGENT);
                    System.out.println("Subject is " + messageRecord.getSubject());
                    break;
                case "Blood-Request":
                    messageRecord.setSubject(Subject.BLOOD_REQUEST);
                    request.setHistoryType(HistoryType.REQUEST);
            }
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


    /**
     * Exist matchers string.
     *
     * @param model the model
     * @return the string
     */
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


    /**
     * Request step confirm string.
     *
     * @param model   the model
     * @param message the message
     * @return the string
     */
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

                    if (matchedDonate.getProfile() != null && matchedDonate.getProfile().getMobileNum() != null){
                        String number = matchedDonate.getProfile().getMobileNum();
                        if (!number.isEmpty()){
                            number ="+61" + number.substring(1);
                            if (Objects.equals(messageRecord.getSubject().toString(), "urgent request")) {
                                smsService.sendSMS("You have urgent blood request: " + message, number);
                            } else {
                                System.out.println("Case is not urgent " + messageRecord.getSubject());
                            }
                        } else {
                            System.out.println("Mobile number is not provided");
                        }
                    }else {
                        System.out.println("Mobile number is not set");
                    }

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

    /**
     * Return index string.
     *
     * @param model the model
     * @return the string
     */
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
