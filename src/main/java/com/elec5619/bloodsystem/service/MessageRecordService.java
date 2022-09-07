package com.elec5619.bloodsystem.service;

import com.elec5619.bloodsystem.dao.MessageRecordRepository;
import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.MessageRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageRecordService {
    @Autowired
    MessageRecordRepository messageRecordRepository;


    public MessageRecord saveMessageRecord(MessageRecord messageRecord){
        return messageRecordRepository.save(messageRecord);
    }


    public List<MessageRecord> findAllMessagesByReceiver(String receiver){
        return messageRecordRepository.findAllByReceiver(receiver);
    }





}
