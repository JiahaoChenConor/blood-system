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

@Transactional
@Repository
public interface MessageRecordRepository extends JpaRepository<MessageRecord, Integer> {

    @Override
    List<MessageRecord> findAll();


    @Override
    <S extends MessageRecord> S save(S entity);

    @Query ("SELECT m FROM MessageRecord m WHERE m.receiver = ?1")
    List<MessageRecord> findAllByReceiver(String receiver);


    @Query ("SELECT m FROM MessageRecord m WHERE m.messageId = ?1")
    Optional<MessageRecord> findById(Long id);

    @Modifying
    @Query("DELETE FROM MessageRecord m where m.messageId=?1")
    void deleteById(Long id);
}
