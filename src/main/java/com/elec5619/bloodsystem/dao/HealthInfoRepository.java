package com.elec5619.bloodsystem.dao;


import com.elec5619.bloodsystem.domain.BloodType;
import com.elec5619.bloodsystem.domain.HealthInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The interface Health info repository.
 */
@Repository
@Transactional
public interface HealthInfoRepository extends JpaRepository<HealthInfo, Integer> {

    @Override
    <S extends HealthInfo> S save(S entity);


    /**
     * Update blood type by id.
     *
     * @param bloodType the blood type
     * @param id        the id
     */
    @Modifying
    @Query("UPDATE HealthInfo p set p.bloodType = ?1 WHERE p.healthInfoId = ?2")
    void updateBloodTypeById(BloodType bloodType, Long id);

    /**
     * Update age by id.
     *
     * @param age       the age
     * @param profileId the profile id
     */
    @Modifying
    @Query("UPDATE HealthInfo p set p.age = ?1 WHERE p.healthInfoId = ?2")
    void updateAgeById(Integer age, Long profileId);
}
