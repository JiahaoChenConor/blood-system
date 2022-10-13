package com.elec5619.bloodsystem.service;

import com.elec5619.bloodsystem.dao.MessageRecordRepository;
import com.elec5619.bloodsystem.domain.MessageRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * The type Message record service.
 */
@Service
public class MessageRecordService {
    /**
     * The Message record repository.
     */
    @Autowired
    MessageRecordRepository messageRecordRepository;


    /**
     * Save message record message record.
     *
     * @param messageRecord the message record
     * @return the message record
     */
    public MessageRecord saveMessageRecord(MessageRecord messageRecord){
        return messageRecordRepository.save(messageRecord);
    }


    /**
     * Find all messages by receiver list.
     *
     * @param receiver the receiver
     * @return the list
     */
    public List<MessageRecord> findAllMessagesByReceiver(String receiver){
        return messageRecordRepository.findAllByReceiver(receiver);
    }

    /**
     * Find message by id message record.
     *
     * @param id the id
     * @return the message record
     */
    public MessageRecord findMessageById(Long id){
        Optional<MessageRecord> messageRecord = messageRecordRepository.findById(id);
        return messageRecord.orElse(null);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    public void deleteById(Long id){
        messageRecordRepository.deleteById(id);
    }

    /**
     * Set message as read.
     *
     * @param id the id
     */
    public void setMessageAsRead(Long id){
        messageRecordRepository.updateMessageRecordHaveRead(true, id);
    }

    /**
     * New messages int.
     *
     * @param email the email
     * @return the int
     */
    public int newMessages(String email){
        List<MessageRecord> allMessages = findAllMessagesByReceiver(email);
        List<MessageRecord> unread = allMessages.stream().filter(messageRecord -> !messageRecord.getHaveRead()).toList();
        return unread.size();
    }



}
