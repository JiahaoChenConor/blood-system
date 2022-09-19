package com.elec5619.bloodsystem.dao;

import com.elec5619.bloodsystem.entity.Privilege;
import com.elec5619.bloodsystem.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    @Override
    <S extends Profile> S save(S entity);


    @Modifying
    @Query("UPDATE Profile p set p.firstName = ?1 WHERE p.profileId = ?2")
    void updateFirstNameById(String firstName, Long id);



}
