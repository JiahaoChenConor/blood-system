package com.elec5619.bloodsystem.dao;

import com.elec5619.bloodsystem.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepository
        extends JpaRepository<Account, Long> {

    // This is jbql and to be more explicit, you can comment out below row, "Account" is our class

    @Query("SELECT s FROM Account s WHERE s.email = ?1")
    Optional<Account> findAccountByEmail(String email);
}
