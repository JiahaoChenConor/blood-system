package com.elec5619.bloodsystem.dao;

import com.elec5619.bloodsystem.entity.Gender;
import com.elec5619.bloodsystem.entity.Privilege;
import com.elec5619.bloodsystem.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * The interface Profile repository.
 */
@Repository
@Transactional
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    @Override
    <S extends Profile> S save(S entity);


    /**
     * Update first name by id.
     *
     * @param firstName the first name
     * @param id        the id
     */
    @Modifying
    @Query("UPDATE Profile p set p.firstName = ?1 WHERE p.profileId = ?2")
    void updateFirstNameById(String firstName, Long id);

    /**
     * Update last name by id.
     *
     * @param lastName  the last name
     * @param profileId the profile id
     */
    @Modifying
    @Query("UPDATE Profile p set p.lastName = ?1 WHERE p.profileId = ?2")
    void updateLastNameById(String lastName, Long profileId);

    /**
     * Update date of birth by id.
     *
     * @param dateOfBirth the date of birth
     * @param profileId   the profile id
     */
    @Modifying
    @Query("UPDATE Profile p set p.dateOfBirth = ?1 WHERE p.profileId = ?2")
    void updateDateOfBirthById(String dateOfBirth, Long profileId);

    /**
     * Update mobile num by id.
     *
     * @param mobileNum the mobile num
     * @param profileId the profile id
     */
    @Modifying
    @Query("UPDATE Profile p set p.mobileNum = ?1 WHERE p.profileId = ?2")
    void updateMobileNumById(String mobileNum, Long profileId);

    /**
     * Update gender by id.
     *
     * @param gender    the gender
     * @param profileId the profile id
     */
    @Modifying
    @Query("UPDATE Profile p set p.gender = ?1 WHERE p.profileId = ?2")
    void updateGenderById(Gender gender, Long profileId);
}
