package com.elec5619.bloodsystem.service;


import com.elec5619.bloodsystem.dao.ProfileRepository;
import com.elec5619.bloodsystem.domain.Gender;
import com.elec5619.bloodsystem.domain.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Profile service.
 */
@Service
public class ProfileService {

    /**
     * The Profile repository.
     */
    @Autowired
    ProfileRepository profileRepository;

    /**
     * Save profile profile.
     *
     * @param profile the profile
     * @return the profile
     */
    public Profile saveProfile(Profile profile){
        return profileRepository.save(profile);
    }

    /**
     * Update first name by id.
     *
     * @param profileId the profile id
     * @param firstName the first name
     */
    public void updateFirstNameById(Long profileId, String firstName){
        profileRepository.updateFirstNameById(firstName, profileId);
    }

    /**
     * Update last name by id.
     *
     * @param profileId the profile id
     * @param lastName  the last name
     */
    public void updateLastNameById(Long profileId, String lastName){
        profileRepository.updateLastNameById(lastName, profileId);
    }


    /**
     * Update date of birth by id.
     *
     * @param profileId   the profile id
     * @param dateOfBirth the date of birth
     */
    public void updateDateOfBirthById(Long profileId, String dateOfBirth){
        profileRepository.updateDateOfBirthById(dateOfBirth, profileId);
    }

    /**
     * Update mobile num by id.
     *
     * @param profileId the profile id
     * @param mobileNum the mobile num
     */
    public void updateMobileNumById(Long profileId, String mobileNum){
        profileRepository.updateMobileNumById(mobileNum, profileId);
    }

    /**
     * Update gender by id.
     *
     * @param profileId the profile id
     * @param gender    the gender
     */
    public void updateGenderById(Long profileId, Gender gender){
        profileRepository.updateGenderById(gender, profileId);
    }




}
