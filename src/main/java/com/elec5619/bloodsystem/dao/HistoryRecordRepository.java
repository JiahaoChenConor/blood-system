package com.elec5619.bloodsystem.dao;

import com.elec5619.bloodsystem.domain.Account;
import com.elec5619.bloodsystem.domain.BloodType;
import com.elec5619.bloodsystem.domain.HistoryRecord;
import com.elec5619.bloodsystem.domain.HistoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * The interface History record repository.
 */
@Transactional
@Repository
public interface HistoryRecordRepository
        extends JpaRepository<HistoryRecord, Integer> {

    @Override
    List<HistoryRecord> findAll();

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @Query("SELECT r FROM HistoryRecord r WHERE r.historyId= ?1")
    Optional<HistoryRecord> findById(Long id);

    @Override
    <S extends HistoryRecord> S save(S entity);


    /**
     * Find history record by blood type and history type list.
     *
     * @param bloodType   the blood type
     * @param historyType the history type
     * @return the list
     */
    @Query("SELECT r FROM HistoryRecord r WHERE r.bloodType = ?1 and r.historyType = ?2")
    List<HistoryRecord> findHistoryRecordByBloodTypeAndHistoryType(BloodType bloodType, HistoryType historyType);

    /**
     * Find history record by account list.
     *
     * @param account the account
     * @return the list
     */
    @Query("SELECT r FROM HistoryRecord r WHERE r.account = ?1")
    List<HistoryRecord> findHistoryRecordByAccount(Account account);

    /**
     * Update history record status.
     *
     * @param matched the matched
     * @param id      the id
     */
    @Modifying
    @Query("UPDATE HistoryRecord r set r.matched = ?1 WHERE r.historyId = ?2")
    void updateHistoryRecordStatus(boolean matched, long id);

    @Modifying
    @Query("UPDATE HistoryRecord r set r.hasMatchers = ?1 WHERE r.historyId = ?2")
    void updateHistoryRecordHasMatchersStatus(boolean matched, long id);
}
