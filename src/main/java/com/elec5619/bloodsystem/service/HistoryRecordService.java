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


@Service
public class HistoryRecordService {

    @Autowired
    HistoryRecordRepository historyRecordRepository;


    @Autowired
    AccountService accountService;
    public HistoryRecord saveHistoryRecord(HistoryRecord historyRecord){
        return historyRecordRepository.save(historyRecord);
    }


    public List<HistoryRecord> getMatchDonateRecord(BloodType bloodType){
        List<HistoryRecord> historyRecords = historyRecordRepository.findHistoryRecordByBloodTypeAndHistoryType(bloodType, HistoryType.DONATE);
        // add some filter
        Account curr = accountService.getCurrentAccount();
        historyRecords = historyRecords.stream().filter(historyRecord1 -> !historyRecord1.getMatched()).
                filter(historyRecord -> !historyRecord.getAccount().getEmail().equals(curr.getEmail())).
                collect(Collectors.toList());

        return historyRecords;
    }

    public List<HistoryRecord> findUserHistoryRecord(Account account){
        return historyRecordRepository.findHistoryRecordByAccount(account);
    }

    public HistoryRecord findHistoryRecordById(long id){
        return historyRecordRepository.findById(id).get();
    }

    public void updateHistoryRecordStatus(long id, boolean matched){
        historyRecordRepository.updateHistoryRecordStatus(matched, id);
    }

    public  List<HistoryRecord> getUrgentRequestRecordInWaitingList(){
        List<HistoryRecord> historyRecords = historyRecordRepository.findAll();
        // add some filter
        historyRecords = historyRecords.stream().filter(h->h.getHistoryType().equals(HistoryType.URGENT)).collect(Collectors.toList());
        historyRecords = historyRecords.stream().filter(h->!h.getHasMatchers()).collect(Collectors.toList());
        return historyRecords;
    }

}
