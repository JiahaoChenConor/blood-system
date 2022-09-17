package com.elec5619.bloodsystem.service;

import com.elec5619.bloodsystem.dao.HistoryRecordRepository;
import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.BloodType;
import com.elec5619.bloodsystem.entity.HistoryRecord;
import com.elec5619.bloodsystem.entity.HistoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HistoryRecordService {

    @Autowired
    HistoryRecordRepository historyRecordRepository;


    public HistoryRecord saveHistoryRecord(HistoryRecord historyRecord){
        return historyRecordRepository.save(historyRecord);
    }


    public List<HistoryRecord> getMatchDonateRecord(BloodType bloodType){
        return historyRecordRepository.findHistoryRecordByBloodTypeAndHistoryType(bloodType, HistoryType.DONATE);
    }

    public List<HistoryRecord> findUserHistoryRecord(Account account){
        return historyRecordRepository.findHistoryRecordByAccount(account);
    }


}
