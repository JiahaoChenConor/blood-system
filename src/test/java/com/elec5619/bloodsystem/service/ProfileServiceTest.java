package com.elec5619.bloodsystem.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.elec5619.bloodsystem.dao.ProfileRepository;
import com.elec5619.bloodsystem.domain.Gender;
import com.elec5619.bloodsystem.domain.Profile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProfileService.class})
@ExtendWith(SpringExtension.class)
class ProfileServiceTest {
    @MockBean
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileService profileService;

    /**
     * Method under test: {@link ProfileService#saveProfile(Profile)}
     */
    @Test
    void testSaveProfile() {
        Profile profile = new Profile();
        profile.setDateOfBirth("2020-03-01");
        profile.setFirstName("Jane");
        profile.setGender(Gender.MALE);
        profile.setLastName("Doe");
        profile.setMobileNum("Mobile Num");
        profile.setProfileId(123L);
        when(profileRepository.save((Profile) any())).thenReturn(profile);

        Profile profile1 = new Profile();
        profile1.setDateOfBirth("2020-03-01");
        profile1.setFirstName("Jane");
        profile1.setGender(Gender.MALE);
        profile1.setLastName("Doe");
        profile1.setMobileNum("Mobile Num");
        profile1.setProfileId(123L);
        assertSame(profile, profileService.saveProfile(profile1));
        verify(profileRepository).save((Profile) any());
    }

    /**
     * Method under test: {@link ProfileService#updateFirstNameById(Long, String)}
     */
    @Test
    void testUpdateFirstNameById() {
        doNothing().when(profileRepository).updateFirstNameById((String) any(), (Long) any());
        profileService.updateFirstNameById(123L, "Jane");
        verify(profileRepository).updateFirstNameById((String) any(), (Long) any());
    }

    /**
     * Method under test: {@link ProfileService#updateLastNameById(Long, String)}
     */
    @Test
    void testUpdateLastNameById() {
        doNothing().when(profileRepository).updateLastNameById((String) any(), (Long) any());
        profileService.updateLastNameById(123L, "Doe");
        verify(profileRepository).updateLastNameById((String) any(), (Long) any());
    }

    /**
     * Method under test: {@link ProfileService#updateDateOfBirthById(Long, String)}
     */
    @Test
    void testUpdateDateOfBirthById() {
        doNothing().when(profileRepository).updateDateOfBirthById((String) any(), (Long) any());
        profileService.updateDateOfBirthById(123L, "2020-03-01");
        verify(profileRepository).updateDateOfBirthById((String) any(), (Long) any());
    }

    /**
     * Method under test: {@link ProfileService#updateMobileNumById(Long, String)}
     */
    @Test
    void testUpdateMobileNumById() {
        doNothing().when(profileRepository).updateMobileNumById((String) any(), (Long) any());
        profileService.updateMobileNumById(123L, "Mobile Num");
        verify(profileRepository).updateMobileNumById((String) any(), (Long) any());
    }

    /**
     * Method under test: {@link ProfileService#updateGenderById(Long, Gender)}
     */
    @Test
    void testUpdateGenderById() {
        doNothing().when(profileRepository).updateGenderById((Gender) any(), (Long) any());
        profileService.updateGenderById(123L, Gender.MALE);
        verify(profileRepository).updateGenderById((Gender) any(), (Long) any());
    }

    /**
     * Method under test: {@link ProfileService#updateGenderById(Long, Gender)}
     */
    @Test
    void testUpdateGenderById2() {
        doNothing().when(profileRepository).updateGenderById((Gender) any(), (Long) any());
        profileService.updateGenderById(123L, Gender.FEMALE);
        verify(profileRepository).updateGenderById((Gender) any(), (Long) any());
    }

    /**
     * Method under test: {@link ProfileService#updateGenderById(Long, Gender)}
     */
    @Test
    void testUpdateGenderById3() {
        doNothing().when(profileRepository).updateGenderById((Gender) any(), (Long) any());
        profileService.updateGenderById(123L, Gender.OTHER);
        verify(profileRepository).updateGenderById((Gender) any(), (Long) any());
    }
}

