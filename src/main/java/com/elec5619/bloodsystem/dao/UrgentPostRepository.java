package com.elec5619.bloodsystem.dao;

import com.elec5619.bloodsystem.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.elec5619.bloodsystem.domain.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Transactional
@Repository
public interface UrgentPostRepository
        extends JpaRepository<UrgentPost, Integer> {

    @Override
    List<UrgentPost> findAll();

    @Query("SELECT r FROM UrgentPost r WHERE r.urgentId= ?1")
    Optional<UrgentPost> findById(Long id);

    @Override
    <S extends UrgentPost> S save(S entity);

    @Query("SELECT r FROM UrgentPost r WHERE r.account = ?1")
    List<UrgentPost> findUrgentPostByAccount(Account account);

    @Modifying
    @Query("UPDATE UrgentPost r set r.matched = ?1 WHERE r.urgentId = ?2")
    void updateUrgentPostStatus(boolean matched, long id);
}
