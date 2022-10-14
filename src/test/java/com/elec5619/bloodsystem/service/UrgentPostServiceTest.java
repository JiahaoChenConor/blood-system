package com.elec5619.bloodsystem.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.elec5619.bloodsystem.dao.UrgentPostRepository;
import com.elec5619.bloodsystem.domain.Account;
import com.elec5619.bloodsystem.domain.BloodType;
import com.elec5619.bloodsystem.domain.Gender;
import com.elec5619.bloodsystem.domain.HealthInfo;
import com.elec5619.bloodsystem.domain.Profile;
import com.elec5619.bloodsystem.domain.Provider;
import com.elec5619.bloodsystem.domain.UrgentPost;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UrgentPostService.class})
@ExtendWith(SpringExtension.class)
class UrgentPostServiceTest {
    @MockBean
    private UrgentPostRepository urgentPostRepository;

    @Autowired
    private UrgentPostService urgentPostService;

    /**
     * Method under test: {@link UrgentPostService#saveUrgentPost(UrgentPost)}
     */
    @Test
    void testSaveUrgentPost() {
        HealthInfo healthInfo = new HealthInfo();
        healthInfo.setAge(1);
        healthInfo.setBloodType(BloodType.A);
        healthInfo.setHealthInfoId(123L);

        Profile profile = new Profile();
        profile.setDateOfBirth("2020-03-01");
        profile.setFirstName("Jane");
        profile.setGender(Gender.MALE);
        profile.setLastName("Doe");
        profile.setMobileNum("Mobile Num");
        profile.setProfileId(123L);

        Account account = new Account();
        account.setEmail("jane.doe@example.org");
        account.setHealthInfo(healthInfo);
        account.setHistoryRecords(new ArrayList<>());
        account.setId(123L);
        account.setMessageRecords(new ArrayList<>());
        account.setPassword("iloveyou");
        account.setProfile(profile);
        account.setProvider(Provider.LOCAL);
        account.setRoles(new ArrayList<>());

        UrgentPost urgentPost = new UrgentPost();
        urgentPost.setAccount(account);
        urgentPost.setBloodType(BloodType.A);
        urgentPost.setContent("Not all who wander are lost");
        urgentPost.setCorrespondHistoryRecordId(123L);
        urgentPost.setDate("2020-03-01");
        urgentPost.setLocation("Location");
        urgentPost.setMatched(true);
        urgentPost.setMeasure(10.0d);
        urgentPost.setUrgentId(123L);
        when(urgentPostRepository.save((UrgentPost) any())).thenReturn(urgentPost);

        HealthInfo healthInfo1 = new HealthInfo();
        healthInfo1.setAge(1);
        healthInfo1.setBloodType(BloodType.A);
        healthInfo1.setHealthInfoId(123L);

        Profile profile1 = new Profile();
        profile1.setDateOfBirth("2020-03-01");
        profile1.setFirstName("Jane");
        profile1.setGender(Gender.MALE);
        profile1.setLastName("Doe");
        profile1.setMobileNum("Mobile Num");
        profile1.setProfileId(123L);

        Account account1 = new Account();
        account1.setEmail("jane.doe@example.org");
        account1.setHealthInfo(healthInfo1);
        account1.setHistoryRecords(new ArrayList<>());
        account1.setId(123L);
        account1.setMessageRecords(new ArrayList<>());
        account1.setPassword("iloveyou");
        account1.setProfile(profile1);
        account1.setProvider(Provider.LOCAL);
        account1.setRoles(new ArrayList<>());

        UrgentPost urgentPost1 = new UrgentPost();
        urgentPost1.setAccount(account1);
        urgentPost1.setBloodType(BloodType.A);
        urgentPost1.setContent("Not all who wander are lost");
        urgentPost1.setCorrespondHistoryRecordId(123L);
        urgentPost1.setDate("2020-03-01");
        urgentPost1.setLocation("Location");
        urgentPost1.setMatched(true);
        urgentPost1.setMeasure(10.0d);
        urgentPost1.setUrgentId(123L);
        assertSame(urgentPost, urgentPostService.saveUrgentPost(urgentPost1));
        verify(urgentPostRepository).save((UrgentPost) any());
    }

    /**
     * Method under test: {@link UrgentPostService#getUserUrgentPost(Account)}
     */
    @Test
    void testGetUserUrgentPost() {
        ArrayList<UrgentPost> urgentPostList = new ArrayList<>();
        when(urgentPostRepository.findUrgentPostByAccount((Account) any())).thenReturn(urgentPostList);

        HealthInfo healthInfo = new HealthInfo();
        healthInfo.setAge(1);
        healthInfo.setBloodType(BloodType.A);
        healthInfo.setHealthInfoId(123L);

        Profile profile = new Profile();
        profile.setDateOfBirth("2020-03-01");
        profile.setFirstName("Jane");
        profile.setGender(Gender.MALE);
        profile.setLastName("Doe");
        profile.setMobileNum("Mobile Num");
        profile.setProfileId(123L);

        Account account = new Account();
        account.setEmail("jane.doe@example.org");
        account.setHealthInfo(healthInfo);
        account.setHistoryRecords(new ArrayList<>());
        account.setId(123L);
        account.setMessageRecords(new ArrayList<>());
        account.setPassword("iloveyou");
        account.setProfile(profile);
        account.setProvider(Provider.LOCAL);
        account.setRoles(new ArrayList<>());
        List<UrgentPost> actualUserUrgentPost = urgentPostService.getUserUrgentPost(account);
        assertSame(urgentPostList, actualUserUrgentPost);
        assertTrue(actualUserUrgentPost.isEmpty());
        verify(urgentPostRepository).findUrgentPostByAccount((Account) any());
    }

    /**
     * Method under test: {@link UrgentPostService#findUrgentPostById(long)}
     */
    @Test
    void testFindUrgentPostById() {
        HealthInfo healthInfo = new HealthInfo();
        healthInfo.setAge(1);
        healthInfo.setBloodType(BloodType.A);
        healthInfo.setHealthInfoId(123L);

        Profile profile = new Profile();
        profile.setDateOfBirth("2020-03-01");
        profile.setFirstName("Jane");
        profile.setGender(Gender.MALE);
        profile.setLastName("Doe");
        profile.setMobileNum("Mobile Num");
        profile.setProfileId(123L);

        Account account = new Account();
        account.setEmail("jane.doe@example.org");
        account.setHealthInfo(healthInfo);
        account.setHistoryRecords(new ArrayList<>());
        account.setId(123L);
        account.setMessageRecords(new ArrayList<>());
        account.setPassword("iloveyou");
        account.setProfile(profile);
        account.setProvider(Provider.LOCAL);
        account.setRoles(new ArrayList<>());

        UrgentPost urgentPost = new UrgentPost();
        urgentPost.setAccount(account);
        urgentPost.setBloodType(BloodType.A);
        urgentPost.setContent("Not all who wander are lost");
        urgentPost.setCorrespondHistoryRecordId(123L);
        urgentPost.setDate("2020-03-01");
        urgentPost.setLocation("Location");
        urgentPost.setMatched(true);
        urgentPost.setMeasure(10.0d);
        urgentPost.setUrgentId(123L);
        Optional<UrgentPost> ofResult = Optional.of(urgentPost);
        when(urgentPostRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(urgentPost, urgentPostService.findUrgentPostById(123L));
        verify(urgentPostRepository).findById((Long) any());
    }


    /**
     * Method under test: {@link UrgentPostService#updateUrgentPostStatus(long, boolean)}
     */
    @Test
    void testUpdateUrgentPostStatus() {
        doNothing().when(urgentPostRepository).updateUrgentPostStatus(anyBoolean(), anyLong());
        urgentPostService.updateUrgentPostStatus(123L, true);
        verify(urgentPostRepository).updateUrgentPostStatus(anyBoolean(), anyLong());
        assertTrue(urgentPostService.getAllUrgentPost().isEmpty());
    }

    /**
     * Method under test: {@link UrgentPostService#getAllUrgentPost()}
     */
    @Test
    void testGetAllUrgentPost() {
        ArrayList<UrgentPost> urgentPostList = new ArrayList<>();
        when(urgentPostRepository.findAll()).thenReturn(urgentPostList);
        List<UrgentPost> actualAllUrgentPost = urgentPostService.getAllUrgentPost();
        assertSame(urgentPostList, actualAllUrgentPost);
        assertTrue(actualAllUrgentPost.isEmpty());
        verify(urgentPostRepository).findAll();
    }

    /**
     * Method under test: {@link UrgentPostService#getAvailableUrgentPost(Account)}
     */
    @Test
    void testGetAvailableUrgentPost() {
        when(urgentPostRepository.findAll()).thenReturn(new ArrayList<>());

        HealthInfo healthInfo = new HealthInfo();
        healthInfo.setAge(1);
        healthInfo.setBloodType(BloodType.A);
        healthInfo.setHealthInfoId(123L);

        Profile profile = new Profile();
        profile.setDateOfBirth("2020-03-01");
        profile.setFirstName("Jane");
        profile.setGender(Gender.MALE);
        profile.setLastName("Doe");
        profile.setMobileNum("Mobile Num");
        profile.setProfileId(123L);

        Account account = new Account();
        account.setEmail("jane.doe@example.org");
        account.setHealthInfo(healthInfo);
        account.setHistoryRecords(new ArrayList<>());
        account.setId(123L);
        account.setMessageRecords(new ArrayList<>());
        account.setPassword("iloveyou");
        account.setProfile(profile);
        account.setProvider(Provider.LOCAL);
        account.setRoles(new ArrayList<>());
        assertTrue(urgentPostService.getAvailableUrgentPost(account).isEmpty());
        verify(urgentPostRepository).findAll();
    }

    /**
     * Method under test: {@link UrgentPostService#getAvailableUrgentPost(Account)}
     */
    @Test
    void testGetAvailableUrgentPost2() {
        HealthInfo healthInfo = new HealthInfo();
        healthInfo.setAge(1);
        healthInfo.setBloodType(BloodType.A);
        healthInfo.setHealthInfoId(123L);

        Profile profile = new Profile();
        profile.setDateOfBirth("2020-03-01");
        profile.setFirstName("Jane");
        profile.setGender(Gender.MALE);
        profile.setLastName("Doe");
        profile.setMobileNum("Mobile Num");
        profile.setProfileId(123L);

        Account account = new Account();
        account.setEmail("jane.doe@example.org");
        account.setHealthInfo(healthInfo);
        account.setHistoryRecords(new ArrayList<>());
        account.setId(123L);
        account.setMessageRecords(new ArrayList<>());
        account.setPassword("iloveyou");
        account.setProfile(profile);
        account.setProvider(Provider.LOCAL);
        account.setRoles(new ArrayList<>());

        UrgentPost urgentPost = new UrgentPost();
        urgentPost.setAccount(account);
        urgentPost.setBloodType(BloodType.A);
        urgentPost.setContent("Not all who wander are lost");
        urgentPost.setCorrespondHistoryRecordId(123L);
        urgentPost.setDate("2020-03-01");
        urgentPost.setLocation("Location");
        urgentPost.setMatched(true);
        urgentPost.setMeasure(10.0d);
        urgentPost.setUrgentId(123L);

        ArrayList<UrgentPost> urgentPostList = new ArrayList<>();
        urgentPostList.add(urgentPost);
        when(urgentPostRepository.findAll()).thenReturn(urgentPostList);

        HealthInfo healthInfo1 = new HealthInfo();
        healthInfo1.setAge(1);
        healthInfo1.setBloodType(BloodType.A);
        healthInfo1.setHealthInfoId(123L);

        Profile profile1 = new Profile();
        profile1.setDateOfBirth("2020-03-01");
        profile1.setFirstName("Jane");
        profile1.setGender(Gender.MALE);
        profile1.setLastName("Doe");
        profile1.setMobileNum("Mobile Num");
        profile1.setProfileId(123L);

        Account account1 = new Account();
        account1.setEmail("jane.doe@example.org");
        account1.setHealthInfo(healthInfo1);
        account1.setHistoryRecords(new ArrayList<>());
        account1.setId(123L);
        account1.setMessageRecords(new ArrayList<>());
        account1.setPassword("iloveyou");
        account1.setProfile(profile1);
        account1.setProvider(Provider.LOCAL);
        account1.setRoles(new ArrayList<>());
        assertTrue(urgentPostService.getAvailableUrgentPost(account1).isEmpty());
        verify(urgentPostRepository).findAll();
    }

    /**
     * Method under test: {@link UrgentPostService#getAvailableUrgentPost(Account)}
     */
    @Test
    void testGetAvailableUrgentPost3() {
        HealthInfo healthInfo = new HealthInfo();
        healthInfo.setAge(1);
        healthInfo.setBloodType(BloodType.A);
        healthInfo.setHealthInfoId(123L);

        Profile profile = new Profile();
        profile.setDateOfBirth("2020-03-01");
        profile.setFirstName("Jane");
        profile.setGender(Gender.MALE);
        profile.setLastName("Doe");
        profile.setMobileNum("Mobile Num");
        profile.setProfileId(123L);

        Account account = new Account();
        account.setEmail("jane.doe@example.org");
        account.setHealthInfo(healthInfo);
        account.setHistoryRecords(new ArrayList<>());
        account.setId(123L);
        account.setMessageRecords(new ArrayList<>());
        account.setPassword("iloveyou");
        account.setProfile(profile);
        account.setProvider(Provider.LOCAL);
        account.setRoles(new ArrayList<>());

        UrgentPost urgentPost = new UrgentPost();
        urgentPost.setAccount(account);
        urgentPost.setBloodType(BloodType.A);
        urgentPost.setContent("Not all who wander are lost");
        urgentPost.setCorrespondHistoryRecordId(123L);
        urgentPost.setDate("2020-03-01");
        urgentPost.setLocation("Location");
        urgentPost.setMatched(true);
        urgentPost.setMeasure(10.0d);
        urgentPost.setUrgentId(123L);

        HealthInfo healthInfo1 = new HealthInfo();
        healthInfo1.setAge(1);
        healthInfo1.setBloodType(BloodType.A);
        healthInfo1.setHealthInfoId(123L);

        Profile profile1 = new Profile();
        profile1.setDateOfBirth("2020-03-01");
        profile1.setFirstName("Jane");
        profile1.setGender(Gender.MALE);
        profile1.setLastName("Doe");
        profile1.setMobileNum("Mobile Num");
        profile1.setProfileId(123L);

        Account account1 = new Account();
        account1.setEmail("jane.doe@example.org");
        account1.setHealthInfo(healthInfo1);
        account1.setHistoryRecords(new ArrayList<>());
        account1.setId(123L);
        account1.setMessageRecords(new ArrayList<>());
        account1.setPassword("iloveyou");
        account1.setProfile(profile1);
        account1.setProvider(Provider.LOCAL);
        account1.setRoles(new ArrayList<>());

        UrgentPost urgentPost1 = new UrgentPost();
        urgentPost1.setAccount(account1);
        urgentPost1.setBloodType(BloodType.A);
        urgentPost1.setContent("Not all who wander are lost");
        urgentPost1.setCorrespondHistoryRecordId(123L);
        urgentPost1.setDate("2020-03-01");
        urgentPost1.setLocation("Location");
        urgentPost1.setMatched(true);
        urgentPost1.setMeasure(10.0d);
        urgentPost1.setUrgentId(123L);

        ArrayList<UrgentPost> urgentPostList = new ArrayList<>();
        urgentPostList.add(urgentPost1);
        urgentPostList.add(urgentPost);
        when(urgentPostRepository.findAll()).thenReturn(urgentPostList);

        HealthInfo healthInfo2 = new HealthInfo();
        healthInfo2.setAge(1);
        healthInfo2.setBloodType(BloodType.A);
        healthInfo2.setHealthInfoId(123L);

        Profile profile2 = new Profile();
        profile2.setDateOfBirth("2020-03-01");
        profile2.setFirstName("Jane");
        profile2.setGender(Gender.MALE);
        profile2.setLastName("Doe");
        profile2.setMobileNum("Mobile Num");
        profile2.setProfileId(123L);

        Account account2 = new Account();
        account2.setEmail("jane.doe@example.org");
        account2.setHealthInfo(healthInfo2);
        account2.setHistoryRecords(new ArrayList<>());
        account2.setId(123L);
        account2.setMessageRecords(new ArrayList<>());
        account2.setPassword("iloveyou");
        account2.setProfile(profile2);
        account2.setProvider(Provider.LOCAL);
        account2.setRoles(new ArrayList<>());
        assertTrue(urgentPostService.getAvailableUrgentPost(account2).isEmpty());
        verify(urgentPostRepository).findAll();
    }

    /**
     * Method under test: {@link UrgentPostService#getAvailableUrgentPost(Account)}
     */
    @Test
    void testGetAvailableUrgentPost4() {
        HealthInfo healthInfo = new HealthInfo();
        healthInfo.setAge(1);
        healthInfo.setBloodType(BloodType.A);
        healthInfo.setHealthInfoId(123L);

        Profile profile = new Profile();
        profile.setDateOfBirth("2020-03-01");
        profile.setFirstName("Jane");
        profile.setGender(Gender.MALE);
        profile.setLastName("Doe");
        profile.setMobileNum("Mobile Num");
        profile.setProfileId(123L);

        Account account = new Account();
        account.setEmail("jane.doe@example.org");
        account.setHealthInfo(healthInfo);
        account.setHistoryRecords(new ArrayList<>());
        account.setId(123L);
        account.setMessageRecords(new ArrayList<>());
        account.setPassword("iloveyou");
        account.setProfile(profile);
        account.setProvider(Provider.LOCAL);
        account.setRoles(new ArrayList<>());

        HealthInfo healthInfo1 = new HealthInfo();
        healthInfo1.setAge(1);
        healthInfo1.setBloodType(BloodType.A);
        healthInfo1.setHealthInfoId(123L);

        Profile profile1 = new Profile();
        profile1.setDateOfBirth("2020-03-01");
        profile1.setFirstName("Jane");
        profile1.setGender(Gender.MALE);
        profile1.setLastName("Doe");
        profile1.setMobileNum("Mobile Num");
        profile1.setProfileId(123L);

        Account account1 = new Account();
        account1.setEmail("jane.doe@example.org");
        account1.setHealthInfo(healthInfo1);
        account1.setHistoryRecords(new ArrayList<>());
        account1.setId(123L);
        account1.setMessageRecords(new ArrayList<>());
        account1.setPassword("iloveyou");
        account1.setProfile(profile1);
        account1.setProvider(Provider.LOCAL);
        account1.setRoles(new ArrayList<>());
        UrgentPost urgentPost = mock(UrgentPost.class);
        when(urgentPost.getAccount()).thenReturn(account1);
        when(urgentPost.getMatched()).thenReturn(false);
        doNothing().when(urgentPost).setAccount((Account) any());
        doNothing().when(urgentPost).setBloodType((BloodType) any());
        doNothing().when(urgentPost).setContent((String) any());
        doNothing().when(urgentPost).setCorrespondHistoryRecordId((Long) any());
        doNothing().when(urgentPost).setDate((String) any());
        doNothing().when(urgentPost).setLocation((String) any());
        doNothing().when(urgentPost).setMatched((Boolean) any());
        doNothing().when(urgentPost).setMeasure((Double) any());
        doNothing().when(urgentPost).setUrgentId((Long) any());
        urgentPost.setAccount(account);
        urgentPost.setBloodType(BloodType.A);
        urgentPost.setContent("Not all who wander are lost");
        urgentPost.setCorrespondHistoryRecordId(123L);
        urgentPost.setDate("2020-03-01");
        urgentPost.setLocation("Location");
        urgentPost.setMatched(true);
        urgentPost.setMeasure(10.0d);
        urgentPost.setUrgentId(123L);

        ArrayList<UrgentPost> urgentPostList = new ArrayList<>();
        urgentPostList.add(urgentPost);
        when(urgentPostRepository.findAll()).thenReturn(urgentPostList);

        HealthInfo healthInfo2 = new HealthInfo();
        healthInfo2.setAge(1);
        healthInfo2.setBloodType(BloodType.A);
        healthInfo2.setHealthInfoId(123L);

        Profile profile2 = new Profile();
        profile2.setDateOfBirth("2020-03-01");
        profile2.setFirstName("Jane");
        profile2.setGender(Gender.MALE);
        profile2.setLastName("Doe");
        profile2.setMobileNum("Mobile Num");
        profile2.setProfileId(123L);

        Account account2 = new Account();
        account2.setEmail("jane.doe@example.org");
        account2.setHealthInfo(healthInfo2);
        account2.setHistoryRecords(new ArrayList<>());
        account2.setId(123L);
        account2.setMessageRecords(new ArrayList<>());
        account2.setPassword("iloveyou");
        account2.setProfile(profile2);
        account2.setProvider(Provider.LOCAL);
        account2.setRoles(new ArrayList<>());
        assertTrue(urgentPostService.getAvailableUrgentPost(account2).isEmpty());
        verify(urgentPostRepository).findAll();
        verify(urgentPost).getAccount();
        verify(urgentPost).getMatched();
        verify(urgentPost).setAccount((Account) any());
        verify(urgentPost).setBloodType((BloodType) any());
        verify(urgentPost).setContent((String) any());
        verify(urgentPost).setCorrespondHistoryRecordId((Long) any());
        verify(urgentPost).setDate((String) any());
        verify(urgentPost).setLocation((String) any());
        verify(urgentPost).setMatched((Boolean) any());
        verify(urgentPost).setMeasure((Double) any());
        verify(urgentPost).setUrgentId((Long) any());
    }
}

