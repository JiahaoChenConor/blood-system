package com.elec5619.bloodsystem.dao;

import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.HealthInfo;
import com.elec5619.bloodsystem.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * The interface Account repository.
 */
@Repository
@Transactional
public interface AccountRepository
        extends JpaRepository<Account, Integer> {

    // This is jbql and to be more explicit, you can comment out below row, "Account" is our class

    /**
     * Find account by email account.
     *
     * @param email the email
     * @return the account
     */
    @Query("SELECT s FROM Account s WHERE s.email = ?1")
    Account findAccountByEmail(String email);

    /**
     * Find by id account.
     *
     * @param id the id
     * @return the account
     */
    @Query("SELECT s FROM Account s WHERE s.id = ?1")
    Account findById(Long id);

    @Query("SELECT s FROM Account s")
    List<Account> findAll();

    /**
     * Sets profile id.
     *
     * @param profile   the profile
     * @param AccountId the account id
     */
    @Modifying
    @Query("UPDATE Account a set a.profile=?1 WHERE a.id=?2")
    void setProfileId(Profile profile, Long AccountId);

    /**
     * Sets health info id.
     *
     * @param healthInfo the health info
     * @param AccountId  the account id
     */
    @Modifying
    @Query("UPDATE Account a set a.healthInfo=?1 WHERE a.id=?2")
    void setHealthInfoId(HealthInfo healthInfo, Long AccountId);

}
