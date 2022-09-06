package com.elec5619.bloodsystem.dao;

import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.BloodType;
import com.elec5619.bloodsystem.entity.HistoryRecord;
import com.elec5619.bloodsystem.entity.HistoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HistoryRecordRepository
        extends JpaRepository<HistoryRecord, Integer> {

    @Override
    List<HistoryRecord> findAll();

    @Override
    <S extends HistoryRecord> S save(S entity);


    @Query("SELECT r FROM HistoryRecord r WHERE r.bloodType = ?1 and r.historyType = ?2")
    List<HistoryRecord> findHistoryRecordByBloodTypeAndHistoryType(BloodType bloodType, HistoryType historyType);
}
