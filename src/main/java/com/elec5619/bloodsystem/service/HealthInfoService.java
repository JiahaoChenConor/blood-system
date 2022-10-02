package com.elec5619.bloodsystem.service;


import com.elec5619.bloodsystem.dao.HealthInfoRepository;
import com.elec5619.bloodsystem.entity.BloodType;
import com.elec5619.bloodsystem.entity.HealthInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthInfoService {

    @Autowired
    HealthInfoRepository healthInfoRepository;

    public HealthInfo saveHealthInfo(HealthInfo healthInfo){
        return healthInfoRepository.save(healthInfo);
    }


    public void updateBloodTypeById(Long healthInfoId, BloodType bloodType){
        healthInfoRepository.updateBloodTypeById(bloodType, healthInfoId);
    }

    public void updateAgeById(Long healthInfoId, Integer age){
        healthInfoRepository.updateAgeById(age, healthInfoId);
    }
}
