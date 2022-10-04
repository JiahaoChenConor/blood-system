package com.elec5619.bloodsystem.service;

import com.elec5619.bloodsystem.dao.HistoryRecordRepository;
import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.BloodType;
import com.elec5619.bloodsystem.entity.HistoryRecord;
import com.elec5619.bloodsystem.entity.HistoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * The type History record service.
 */
@Service
public class HistoryRecordService {

    /**
     * The History record repository.
     */
    @Autowired
    HistoryRecordRepository historyRecordRepository;


    /**
     * The Account service.
     */
    @Autowired
    AccountService accountService;

    /**
     * Save history record history record.
     *
     * @param historyRecord the history record
     * @return the history record
     */
    public HistoryRecord saveHistoryRecord(HistoryRecord historyRecord){
        return historyRecordRepository.save(historyRecord);
    }


    /**
     * Get match donate record list.
     *
     * @param bloodType the blood type
     * @return the list
     */
    public List<HistoryRecord> getMatchDonateRecord(BloodType bloodType){
        List<HistoryRecord> historyRecords = historyRecordRepository.findHistoryRecordByBloodTypeAndHistoryType(bloodType, HistoryType.DONATE);
        // add some filter
        Account curr = accountService.getCurrentAccount();
        historyRecords = historyRecords.stream().filter(historyRecord1 -> !historyRecord1.getMatched()).
                filter(historyRecord -> !historyRecord.getAccount().getEmail().equals(curr.getEmail())).
                collect(Collectors.toList());

        return historyRecords;
    }

    /**
     * Find user history record list.
     *
     * @param account the account
     * @return the list
     */
    public List<HistoryRecord> findUserHistoryRecord(Account account){
        return historyRecordRepository.findHistoryRecordByAccount(account);
    }

    /**
     * Find history record by id history record.
     *
     * @param id the id
     * @return the history record
     */
    public HistoryRecord findHistoryRecordById(long id){
        return historyRecordRepository.findById(id).get();
    }

    /**
     * Update history record status.
     *
     * @param id      the id
     * @param matched the matched
     */
    public void updateHistoryRecordStatus(long id, boolean matched){
        historyRecordRepository.updateHistoryRecordStatus(matched, id);
    }

    /**
     * Get urgent request record in waiting list list.
     *
     * @return the list
     */
    public  List<HistoryRecord> getUrgentRequestRecordInWaitingList(){
        List<HistoryRecord> historyRecords = historyRecordRepository.findAll();
        // add some filter
        historyRecords = historyRecords.stream().filter(h->h.getHistoryType().equals(HistoryType.URGENT)).collect(Collectors.toList());
        historyRecords = historyRecords.stream().filter(h->!h.getMatched()).collect(Collectors.toList());
        return historyRecords;
    }

}
