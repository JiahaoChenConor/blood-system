package com.elec5619.bloodsystem.dao;

import com.elec5619.bloodsystem.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface AccountRepository
        extends JpaRepository<Account, Integer> {

    // This is jbql and to be more explicit, you can comment out below row, "Account" is our class

    @Query("SELECT s FROM Account s WHERE s.email = ?1")
    Account findAccountByEmail(String email);

    @Query("SELECT s FROM Account s WHERE s.id = ?1")
    Account findById(Long id);
}
