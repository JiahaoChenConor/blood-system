package com.elec5619.bloodsystem.dao;

import com.elec5619.bloodsystem.entity.BloodType;
import com.elec5619.bloodsystem.entity.HistoryRecord;
import com.elec5619.bloodsystem.entity.MessageRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRecordRepository extends JpaRepository<MessageRecord, Integer> {

    @Override
    List<MessageRecord> findAll();


    @Override
    <S extends MessageRecord> S save(S entity);


}
