package com.elec5619.bloodsystem.service;


import com.elec5619.bloodsystem.dao.ProfileRepository;
import com.elec5619.bloodsystem.entity.Gender;
import com.elec5619.bloodsystem.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public Profile saveProfile(Profile profile){
        return profileRepository.save(profile);
    }

    public void updateFirstNameById(Long profileId, String firstName){
        profileRepository.updateFirstNameById(firstName, profileId);
    }

    public void updateLastNameById(Long profileId, String lastName){
        profileRepository.updateLastNameById(lastName, profileId);
    }


    public void updateDateOfBirthById(Long profileId, String dateOfBirth){
        profileRepository.updateDateOfBirthById(dateOfBirth, profileId);
    }

    public void updateMobileNumById(Long profileId, String mobileNum){
        profileRepository.updateMobileNumById(mobileNum, profileId);
    }

    public void updateGenderById(Long profileId, Gender gender){
        profileRepository.updateGenderById(gender, profileId);
    }




}
