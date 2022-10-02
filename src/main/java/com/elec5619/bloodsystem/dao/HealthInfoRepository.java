package com.elec5619.bloodsystem.dao;


import com.elec5619.bloodsystem.entity.BloodType;
import com.elec5619.bloodsystem.entity.HealthInfo;
import com.elec5619.bloodsystem.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface HealthInfoRepository extends JpaRepository<HealthInfo, Integer> {

    @Override
    <S extends HealthInfo> S save(S entity);


    @Modifying
    @Query("UPDATE HealthInfo p set p.bloodType = ?1 WHERE p.healthInfoId = ?2")
    void updateBloodTypeById(BloodType bloodType, Long id);

    @Modifying
    @Query("UPDATE HealthInfo p set p.age = ?1 WHERE p.healthInfoId = ?2")
    void updateAgeById(Integer age, Long profileId);
}
