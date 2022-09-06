package com.elec5619.bloodsystem.dao;

import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.HistoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HistoryRecordRepository
        extends JpaRepository<HistoryRecord, Integer> {

    @Override
    List<HistoryRecord> findAll();

    @Override
    <S extends HistoryRecord> S save(S entity);
}
