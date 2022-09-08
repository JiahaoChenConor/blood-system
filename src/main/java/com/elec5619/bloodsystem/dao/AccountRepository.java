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
//    @Query(value="select r.name from Role ur inner join (Role r, User u) on(ur.roleId = r.id  and ur.userId = u.id) where u.email = ?1", nativeQuery = true)
//    List<String> findRolesByEmail(String email);
//
//
//    @Query(value="select * from User u where not exists(select * from UserRole ur inner join Role r on(ur.roleId = r.id and (r.name='ROLE_DOCTOR' OR r.name='ROLE_ADMIN')) where ur.userId = u.id)", nativeQuery = true)
//    List<Account> findAccounts();
}
