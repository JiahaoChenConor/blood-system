package com.elec5619.bloodsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.elec5619.bloodsystem.dao.HistoryRecordRepository;
import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.BloodType;
import com.elec5619.bloodsystem.entity.Gender;
import com.elec5619.bloodsystem.entity.HealthInfo;
import com.elec5619.bloodsystem.entity.HistoryRecord;
import com.elec5619.bloodsystem.entity.HistoryType;
import com.elec5619.bloodsystem.entity.MessageRecord;
import com.elec5619.bloodsystem.entity.Profile;
import com.elec5619.bloodsystem.entity.Provider;

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

@ContextConfiguration(classes = {HistoryRecordService.class})
@ExtendWith(SpringExtension.class)
class HistoryRecordServiceTest {
    @MockBean
    private AccountService accountService;

    @MockBean
    private HistoryRecordRepository historyRecordRepository;

    @Autowired
    private HistoryRecordService historyRecordService;

    /**
     * Method under test: {@link HistoryRecordService#saveHistoryRecord(HistoryRecord)}
     */
    @Test
    void testSaveHistoryRecord() {
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

        HistoryRecord historyRecord = new HistoryRecord();
        historyRecord.setAccount(account);
        historyRecord.setBloodType(BloodType.A);
        historyRecord.setContent("Not all who wander are lost");
        historyRecord.setDate("2020-03-01");
        historyRecord.setHasMatchers(true);
        historyRecord.setHistoryId(123L);
        historyRecord.setHistoryType(HistoryType.DONATE);
        historyRecord.setLocation("Location");
        historyRecord.setMatched(true);
        historyRecord.setMeasure(10.0d);
        historyRecord.setMessagesInHistory(new ArrayList<>());
        when(historyRecordRepository.save((HistoryRecord) any())).thenReturn(historyRecord);

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

        HistoryRecord historyRecord1 = new HistoryRecord();
        historyRecord1.setAccount(account1);
        historyRecord1.setBloodType(BloodType.A);
        historyRecord1.setContent("Not all who wander are lost");
        historyRecord1.setDate("2020-03-01");
        historyRecord1.setHasMatchers(true);
        historyRecord1.setHistoryId(123L);
        historyRecord1.setHistoryType(HistoryType.DONATE);
        historyRecord1.setLocation("Location");
        historyRecord1.setMatched(true);
        historyRecord1.setMeasure(10.0d);
        historyRecord1.setMessagesInHistory(new ArrayList<>());
        assertSame(historyRecord, historyRecordService.saveHistoryRecord(historyRecord1));
        verify(historyRecordRepository).save((HistoryRecord) any());
    }

    /**
     * Method under test: {@link HistoryRecordService#getMatchDonateRecord(BloodType)}
     */
    @Test
    void testGetMatchDonateRecord() {
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
        when(accountService.getCurrentAccount()).thenReturn(account);
        when(historyRecordRepository.findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(), (HistoryType) any()))
                .thenReturn(new ArrayList<>());
        assertTrue(historyRecordService.getMatchDonateRecord(BloodType.A).isEmpty());
        verify(accountService).getCurrentAccount();
        verify(historyRecordRepository).findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(),
                (HistoryType) any());
    }

    /**
     * Method under test: {@link HistoryRecordService#getMatchDonateRecord(BloodType)}
     */
    @Test
    void testGetMatchDonateRecord2() {
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
        when(accountService.getCurrentAccount()).thenReturn(account);

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

        HistoryRecord historyRecord = new HistoryRecord();
        historyRecord.setAccount(account1);
        historyRecord.setBloodType(BloodType.A);
        historyRecord.setContent("Not all who wander are lost");
        historyRecord.setDate("2020-03-01");
        historyRecord.setHasMatchers(true);
        historyRecord.setHistoryId(123L);
        historyRecord.setHistoryType(HistoryType.DONATE);
        historyRecord.setLocation("Location");
        historyRecord.setMatched(true);
        historyRecord.setMeasure(10.0d);
        historyRecord.setMessagesInHistory(new ArrayList<>());

        ArrayList<HistoryRecord> historyRecordList = new ArrayList<>();
        historyRecordList.add(historyRecord);
        when(historyRecordRepository.findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(), (HistoryType) any()))
                .thenReturn(historyRecordList);
        assertTrue(historyRecordService.getMatchDonateRecord(BloodType.A).isEmpty());
        verify(accountService).getCurrentAccount();
        verify(historyRecordRepository).findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(),
                (HistoryType) any());
    }

    /**
     * Method under test: {@link HistoryRecordService#getMatchDonateRecord(BloodType)}
     */
    @Test
    void testGetMatchDonateRecord3() {
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
        when(accountService.getCurrentAccount()).thenReturn(account);

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

        HistoryRecord historyRecord = new HistoryRecord();
        historyRecord.setAccount(account1);
        historyRecord.setBloodType(BloodType.A);
        historyRecord.setContent("Not all who wander are lost");
        historyRecord.setDate("2020-03-01");
        historyRecord.setHasMatchers(true);
        historyRecord.setHistoryId(123L);
        historyRecord.setHistoryType(HistoryType.DONATE);
        historyRecord.setLocation("Location");
        historyRecord.setMatched(true);
        historyRecord.setMeasure(10.0d);
        historyRecord.setMessagesInHistory(new ArrayList<>());

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

        HistoryRecord historyRecord1 = new HistoryRecord();
        historyRecord1.setAccount(account2);
        historyRecord1.setBloodType(BloodType.A);
        historyRecord1.setContent("Not all who wander are lost");
        historyRecord1.setDate("2020-03-01");
        historyRecord1.setHasMatchers(true);
        historyRecord1.setHistoryId(123L);
        historyRecord1.setHistoryType(HistoryType.DONATE);
        historyRecord1.setLocation("Location");
        historyRecord1.setMatched(true);
        historyRecord1.setMeasure(10.0d);
        historyRecord1.setMessagesInHistory(new ArrayList<>());

        ArrayList<HistoryRecord> historyRecordList = new ArrayList<>();
        historyRecordList.add(historyRecord1);
        historyRecordList.add(historyRecord);
        when(historyRecordRepository.findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(), (HistoryType) any()))
                .thenReturn(historyRecordList);
        assertTrue(historyRecordService.getMatchDonateRecord(BloodType.A).isEmpty());
        verify(accountService).getCurrentAccount();
        verify(historyRecordRepository).findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(),
                (HistoryType) any());
    }

    /**
     * Method under test: {@link HistoryRecordService#getMatchDonateRecord(BloodType)}
     */
    @Test
    void testGetMatchDonateRecord4() {
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
        when(accountService.getCurrentAccount()).thenReturn(account);
        when(historyRecordRepository.findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(), (HistoryType) any()))
                .thenReturn(new ArrayList<>());
        assertTrue(historyRecordService.getMatchDonateRecord(BloodType.B).isEmpty());
        verify(accountService).getCurrentAccount();
        verify(historyRecordRepository).findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(),
                (HistoryType) any());
    }

    /**
     * Method under test: {@link HistoryRecordService#getMatchDonateRecord(BloodType)}
     */
    @Test
    void testGetMatchDonateRecord5() {
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
        when(accountService.getCurrentAccount()).thenReturn(account);
        when(historyRecordRepository.findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(), (HistoryType) any()))
                .thenReturn(new ArrayList<>());
        assertTrue(historyRecordService.getMatchDonateRecord(BloodType.AB).isEmpty());
        verify(accountService).getCurrentAccount();
        verify(historyRecordRepository).findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(),
                (HistoryType) any());
    }

    /**
     * Method under test: {@link HistoryRecordService#getMatchDonateRecord(BloodType)}
     */
    @Test
    void testGetMatchDonateRecord6() {
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
        when(accountService.getCurrentAccount()).thenReturn(account);
        when(historyRecordRepository.findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(), (HistoryType) any()))
                .thenReturn(new ArrayList<>());
        assertTrue(historyRecordService.getMatchDonateRecord(BloodType.O).isEmpty());
        verify(accountService).getCurrentAccount();
        verify(historyRecordRepository).findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(),
                (HistoryType) any());
    }

    /**
     * Method under test: {@link HistoryRecordService#findUserHistoryRecord(Account)}
     */
    @Test
    void testFindUserHistoryRecord() {
        ArrayList<HistoryRecord> historyRecordList = new ArrayList<>();
        when(historyRecordRepository.findHistoryRecordByAccount((Account) any())).thenReturn(historyRecordList);

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
        List<HistoryRecord> actualFindUserHistoryRecordResult = historyRecordService.findUserHistoryRecord(account);
        assertSame(historyRecordList, actualFindUserHistoryRecordResult);
        assertTrue(actualFindUserHistoryRecordResult.isEmpty());
        verify(historyRecordRepository).findHistoryRecordByAccount((Account) any());
    }

    /**
     * Method under test: {@link HistoryRecordService#findHistoryRecordById(long)}
     */
    @Test
    void testFindHistoryRecordById() {
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

        HistoryRecord historyRecord = new HistoryRecord();
        historyRecord.setAccount(account);
        historyRecord.setBloodType(BloodType.A);
        historyRecord.setContent("Not all who wander are lost");
        historyRecord.setDate("2020-03-01");
        historyRecord.setHasMatchers(true);
        historyRecord.setHistoryId(123L);
        historyRecord.setHistoryType(HistoryType.DONATE);
        historyRecord.setLocation("Location");
        historyRecord.setMatched(true);
        historyRecord.setMeasure(10.0d);
        historyRecord.setMessagesInHistory(new ArrayList<>());
        Optional<HistoryRecord> ofResult = Optional.of(historyRecord);
        when(historyRecordRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(historyRecord, historyRecordService.findHistoryRecordById(123L));
        verify(historyRecordRepository).findById((Long) any());
    }


    /**
     * Method under test: {@link HistoryRecordService#updateHistoryRecordStatus(long, boolean)}
     */
    @Test
    void testUpdateHistoryRecordStatus() {
        doNothing().when(historyRecordRepository).updateHistoryRecordStatus(anyBoolean(), anyLong());
        historyRecordService.updateHistoryRecordStatus(123L, true);
        verify(historyRecordRepository).updateHistoryRecordStatus(anyBoolean(), anyLong());
        assertTrue(historyRecordService.getUrgentRequestRecordInWaitingList().isEmpty());
    }

    /**
     * Method under test: {@link HistoryRecordService#getUrgentRequestRecordInWaitingList()}
     */
    @Test
    void testGetUrgentRequestRecordInWaitingList() {
        when(historyRecordRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(historyRecordService.getUrgentRequestRecordInWaitingList().isEmpty());
        verify(historyRecordRepository).findAll();
    }

    /**
     * Method under test: {@link HistoryRecordService#getUrgentRequestRecordInWaitingList()}
     */
    @Test
    void testGetUrgentRequestRecordInWaitingList2() {
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

        HistoryRecord historyRecord = new HistoryRecord();
        historyRecord.setAccount(account);
        historyRecord.setBloodType(BloodType.A);
        historyRecord.setContent("Not all who wander are lost");
        historyRecord.setDate("2020-03-01");
        historyRecord.setHasMatchers(true);
        historyRecord.setHistoryId(123L);
        historyRecord.setHistoryType(HistoryType.DONATE);
        historyRecord.setLocation("Location");
        historyRecord.setMatched(true);
        historyRecord.setMeasure(10.0d);
        historyRecord.setMessagesInHistory(new ArrayList<>());

        ArrayList<HistoryRecord> historyRecordList = new ArrayList<>();
        historyRecordList.add(historyRecord);
        when(historyRecordRepository.findAll()).thenReturn(historyRecordList);
        assertTrue(historyRecordService.getUrgentRequestRecordInWaitingList().isEmpty());
        verify(historyRecordRepository).findAll();
    }

    /**
     * Method under test: {@link HistoryRecordService#getUrgentRequestRecordInWaitingList()}
     */
    @Test
    void testGetUrgentRequestRecordInWaitingList3() {
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

        HistoryRecord historyRecord = new HistoryRecord();
        historyRecord.setAccount(account);
        historyRecord.setBloodType(BloodType.A);
        historyRecord.setContent("Not all who wander are lost");
        historyRecord.setDate("2020-03-01");
        historyRecord.setHasMatchers(true);
        historyRecord.setHistoryId(123L);
        historyRecord.setHistoryType(HistoryType.DONATE);
        historyRecord.setLocation("Location");
        historyRecord.setMatched(true);
        historyRecord.setMeasure(10.0d);
        historyRecord.setMessagesInHistory(new ArrayList<>());

        HealthInfo healthInfo1 = new HealthInfo();
        healthInfo1.setAge(5);
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

        HistoryRecord historyRecord1 = new HistoryRecord();
        historyRecord1.setAccount(account1);
        historyRecord1.setBloodType(BloodType.A);
        historyRecord1.setContent("Not all who wander are lost");
        historyRecord1.setDate("2020-03-01");
        historyRecord1.setHasMatchers(true);
        historyRecord1.setHistoryId(123L);
        historyRecord1.setHistoryType(HistoryType.DONATE);
        historyRecord1.setLocation("Location");
        historyRecord1.setMatched(true);
        historyRecord1.setMeasure(10.0d);
        historyRecord1.setMessagesInHistory(new ArrayList<>());

        ArrayList<HistoryRecord> historyRecordList = new ArrayList<>();
        historyRecordList.add(historyRecord1);
        historyRecordList.add(historyRecord);
        when(historyRecordRepository.findAll()).thenReturn(historyRecordList);
        assertTrue(historyRecordService.getUrgentRequestRecordInWaitingList().isEmpty());
        verify(historyRecordRepository).findAll();
    }

    /**
     * Method under test: {@link HistoryRecordService#getUrgentRequestRecordInWaitingList()}
     */
    @Test
    void testGetUrgentRequestRecordInWaitingList4() {
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
        HistoryRecord historyRecord = mock(HistoryRecord.class);
        when(historyRecord.getMatched()).thenReturn(true);
        when(historyRecord.getHistoryType()).thenReturn(HistoryType.URGENT);
        doNothing().when(historyRecord).setAccount((Account) any());
        doNothing().when(historyRecord).setBloodType((BloodType) any());
        doNothing().when(historyRecord).setContent((String) any());
        doNothing().when(historyRecord).setDate((String) any());
        doNothing().when(historyRecord).setHasMatchers((Boolean) any());
        doNothing().when(historyRecord).setHistoryId((Long) any());
        doNothing().when(historyRecord).setHistoryType((HistoryType) any());
        doNothing().when(historyRecord).setLocation((String) any());
        doNothing().when(historyRecord).setMatched((Boolean) any());
        doNothing().when(historyRecord).setMeasure((Double) any());
        doNothing().when(historyRecord).setMessagesInHistory((List<MessageRecord>) any());
        historyRecord.setAccount(account);
        historyRecord.setBloodType(BloodType.A);
        historyRecord.setContent("Not all who wander are lost");
        historyRecord.setDate("2020-03-01");
        historyRecord.setHasMatchers(true);
        historyRecord.setHistoryId(123L);
        historyRecord.setHistoryType(HistoryType.DONATE);
        historyRecord.setLocation("Location");
        historyRecord.setMatched(true);
        historyRecord.setMeasure(10.0d);
        historyRecord.setMessagesInHistory(new ArrayList<>());

        ArrayList<HistoryRecord> historyRecordList = new ArrayList<>();
        historyRecordList.add(historyRecord);
        when(historyRecordRepository.findAll()).thenReturn(historyRecordList);
        assertTrue(historyRecordService.getUrgentRequestRecordInWaitingList().isEmpty());
        verify(historyRecordRepository).findAll();
        verify(historyRecord).getHistoryType();
        verify(historyRecord).getMatched();
        verify(historyRecord).setAccount((Account) any());
        verify(historyRecord).setBloodType((BloodType) any());
        verify(historyRecord).setContent((String) any());
        verify(historyRecord).setDate((String) any());
        verify(historyRecord).setHasMatchers((Boolean) any());
        verify(historyRecord).setHistoryId((Long) any());
        verify(historyRecord).setHistoryType((HistoryType) any());
        verify(historyRecord).setLocation((String) any());
        verify(historyRecord).setMatched((Boolean) any());
        verify(historyRecord).setMeasure((Double) any());
        verify(historyRecord).setMessagesInHistory((List<MessageRecord>) any());
    }

    /**
     * Method under test: {@link HistoryRecordService#getUrgentRequestRecordInWaitingList()}
     */
    @Test
    void testGetUrgentRequestRecordInWaitingList5() {
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
        HistoryRecord historyRecord = mock(HistoryRecord.class);
        when(historyRecord.getMatched()).thenReturn(false);
        when(historyRecord.getHistoryType()).thenReturn(HistoryType.URGENT);
        doNothing().when(historyRecord).setAccount((Account) any());
        doNothing().when(historyRecord).setBloodType((BloodType) any());
        doNothing().when(historyRecord).setContent((String) any());
        doNothing().when(historyRecord).setDate((String) any());
        doNothing().when(historyRecord).setHasMatchers((Boolean) any());
        doNothing().when(historyRecord).setHistoryId((Long) any());
        doNothing().when(historyRecord).setHistoryType((HistoryType) any());
        doNothing().when(historyRecord).setLocation((String) any());
        doNothing().when(historyRecord).setMatched((Boolean) any());
        doNothing().when(historyRecord).setMeasure((Double) any());
        doNothing().when(historyRecord).setMessagesInHistory((List<MessageRecord>) any());
        historyRecord.setAccount(account);
        historyRecord.setBloodType(BloodType.A);
        historyRecord.setContent("Not all who wander are lost");
        historyRecord.setDate("2020-03-01");
        historyRecord.setHasMatchers(true);
        historyRecord.setHistoryId(123L);
        historyRecord.setHistoryType(HistoryType.DONATE);
        historyRecord.setLocation("Location");
        historyRecord.setMatched(true);
        historyRecord.setMeasure(10.0d);
        historyRecord.setMessagesInHistory(new ArrayList<>());

        ArrayList<HistoryRecord> historyRecordList = new ArrayList<>();
        historyRecordList.add(historyRecord);
        when(historyRecordRepository.findAll()).thenReturn(historyRecordList);
        assertEquals(1, historyRecordService.getUrgentRequestRecordInWaitingList().size());
        verify(historyRecordRepository).findAll();
        verify(historyRecord).getHistoryType();
        verify(historyRecord).getMatched();
        verify(historyRecord).setAccount((Account) any());
        verify(historyRecord).setBloodType((BloodType) any());
        verify(historyRecord).setContent((String) any());
        verify(historyRecord).setDate((String) any());
        verify(historyRecord).setHasMatchers((Boolean) any());
        verify(historyRecord).setHistoryId((Long) any());
        verify(historyRecord).setHistoryType((HistoryType) any());
        verify(historyRecord).setLocation((String) any());
        verify(historyRecord).setMatched((Boolean) any());
        verify(historyRecord).setMeasure((Double) any());
        verify(historyRecord).setMessagesInHistory((List<MessageRecord>) any());
    }
}

