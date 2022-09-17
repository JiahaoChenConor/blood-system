package com.elec5619.bloodsystem.service;


import com.elec5619.bloodsystem.dao.ProfileRepository;
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

}
