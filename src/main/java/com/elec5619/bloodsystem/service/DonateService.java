package com.elec5619.bloodsystem.service;

import com.elec5619.bloodsystem.dao.HistoryRecordRepository;
import com.elec5619.bloodsystem.entity.HistoryRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DonateService {

    @Autowired
    HistoryRecordRepository historyRecordRepository;


    public HistoryRecord saveDonateRequest(HistoryRecord historyRecord){
        return historyRecordRepository.save(historyRecord);
    }
}
