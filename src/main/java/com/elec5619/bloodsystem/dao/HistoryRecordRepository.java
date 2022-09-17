package com.elec5619.bloodsystem.dao;

import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.BloodType;
import com.elec5619.bloodsystem.entity.HistoryRecord;
import com.elec5619.bloodsystem.entity.HistoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface HistoryRecordRepository
        extends JpaRepository<HistoryRecord, Integer> {

    @Override
    List<HistoryRecord> findAll();

    @Query("SELECT r FROM HistoryRecord r WHERE r.historyId= ?1")
    Optional<HistoryRecord> findById(Long id);

    @Override
    <S extends HistoryRecord> S save(S entity);


    @Query("SELECT r FROM HistoryRecord r WHERE r.bloodType = ?1 and r.historyType = ?2")
    List<HistoryRecord> findHistoryRecordByBloodTypeAndHistoryType(BloodType bloodType, HistoryType historyType);

    @Query("SELECT r FROM HistoryRecord r WHERE r.account = ?1")
    List<HistoryRecord> findHistoryRecordByAccount(Account account);

    @Modifying
    @Query("UPDATE HistoryRecord r set r.matched = ?1 WHERE r.historyId = ?2")
    void updateHistoryRecordStatus(boolean matched, long id);

}
