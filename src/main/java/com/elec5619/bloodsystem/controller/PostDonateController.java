package com.elec5619.bloodsystem.controller;

import com.elec5619.bloodsystem.domain.HistoryRecord;
import com.elec5619.bloodsystem.domain.MessageRecord;
import com.elec5619.bloodsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;

public class PostDonateController {
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

    private HistoryRecord donate;

    private MessageRecord messageRecord;


}
