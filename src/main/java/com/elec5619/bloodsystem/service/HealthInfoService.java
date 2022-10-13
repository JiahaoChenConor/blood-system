package com.elec5619.bloodsystem.service;


import com.elec5619.bloodsystem.dao.HealthInfoRepository;
import com.elec5619.bloodsystem.domain.BloodType;
import com.elec5619.bloodsystem.domain.HealthInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Health info service.
 */
@Service
public class HealthInfoService {

    /**
     * The Health info repository.
     */
    @Autowired
    HealthInfoRepository healthInfoRepository;

    /**
     * Save health info health info.
     *
     * @param healthInfo the health info
     * @return the health info
     */
    public HealthInfo saveHealthInfo(HealthInfo healthInfo){
        return healthInfoRepository.save(healthInfo);
    }


    /**
     * Update blood type by id.
     *
     * @param healthInfoId the health info id
     * @param bloodType    the blood type
     */
    public void updateBloodTypeById(Long healthInfoId, BloodType bloodType){
        healthInfoRepository.updateBloodTypeById(bloodType, healthInfoId);
    }

    /**
     * Update age by id.
     *
     * @param healthInfoId the health info id
     * @param age          the age
     */
    public void updateAgeById(Long healthInfoId, Integer age){
        healthInfoRepository.updateAgeById(age, healthInfoId);
    }
}
