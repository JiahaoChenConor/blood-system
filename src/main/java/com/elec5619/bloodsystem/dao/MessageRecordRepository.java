package com.elec5619.bloodsystem.dao;

import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.BloodType;
import com.elec5619.bloodsystem.entity.HistoryRecord;
import com.elec5619.bloodsystem.entity.MessageRecord;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * The interface Message record repository.
 */
@Transactional
@Repository
public interface MessageRecordRepository extends JpaRepository<MessageRecord, Integer> {

    @Override
    List<MessageRecord> findAll();


    @Override
    <S extends MessageRecord> S save(S entity);

    /**
     * Find all by receiver list.
     *
     * @param receiver the receiver
     * @return the list
     */
    @Query ("SELECT m FROM MessageRecord m WHERE m.receiver = ?1")
    List<MessageRecord> findAllByReceiver(String receiver);


    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @Query ("SELECT m FROM MessageRecord m WHERE m.messageId = ?1")
    Optional<MessageRecord> findById(Long id);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @Modifying
    @Query("DELETE FROM MessageRecord m where m.messageId=?1")
    void deleteById(Long id);


    /**
     * Update message record have read.
     *
     * @param read the read
     * @param id   the id
     */
    @Modifying
    @Query("UPDATE MessageRecord m set m.haveRead=?1 WHERE m.messageId=?2")
    void updateMessageRecordHaveRead(Boolean read, Long id);
}
