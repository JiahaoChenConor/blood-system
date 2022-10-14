package com.elec5619.bloodsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.elec5619.bloodsystem.dao.MessageRecordRepository;
import com.elec5619.bloodsystem.domain.Account;
import com.elec5619.bloodsystem.domain.BloodType;
import com.elec5619.bloodsystem.domain.Gender;
import com.elec5619.bloodsystem.domain.HealthInfo;
import com.elec5619.bloodsystem.domain.HistoryRecord;
import com.elec5619.bloodsystem.domain.HistoryType;
import com.elec5619.bloodsystem.domain.MessageRecord;
import com.elec5619.bloodsystem.domain.Profile;
import com.elec5619.bloodsystem.domain.Provider;
import com.elec5619.bloodsystem.domain.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MessageRecordService.class})
@ExtendWith(SpringExtension.class)
class MessageRecordServiceTest {
    @MockBean
    private MessageRecordRepository messageRecordRepository;

    @Autowired
    private MessageRecordService messageRecordService;

    /**
     * Method under test: {@link MessageRecordService#saveMessageRecord(MessageRecord)}
     */
    @Test
    void testSaveMessageRecord() {
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

        MessageRecord messageRecord = new MessageRecord();
        messageRecord.setAccount(account);
        messageRecord.setContent("Not all who wander are lost");
        messageRecord.setDate("2020-03-01");
        messageRecord.setHaveRead(true);
        messageRecord.setHistoryRecord(historyRecord);
        messageRecord.setMessageId(123L);
        messageRecord.setReceiver("Receiver");
        messageRecord.setSender("Sender");
        messageRecord.setSubject(Subject.NORMAL_CASE);
        when(messageRecordRepository.save((MessageRecord) any())).thenReturn(messageRecord);

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

        HealthInfo healthInfo3 = new HealthInfo();
        healthInfo3.setAge(1);
        healthInfo3.setBloodType(BloodType.A);
        healthInfo3.setHealthInfoId(123L);

        Profile profile3 = new Profile();
        profile3.setDateOfBirth("2020-03-01");
        profile3.setFirstName("Jane");
        profile3.setGender(Gender.MALE);
        profile3.setLastName("Doe");
        profile3.setMobileNum("Mobile Num");
        profile3.setProfileId(123L);

        Account account3 = new Account();
        account3.setEmail("jane.doe@example.org");
        account3.setHealthInfo(healthInfo3);
        account3.setHistoryRecords(new ArrayList<>());
        account3.setId(123L);
        account3.setMessageRecords(new ArrayList<>());
        account3.setPassword("iloveyou");
        account3.setProfile(profile3);
        account3.setProvider(Provider.LOCAL);
        account3.setRoles(new ArrayList<>());

        HistoryRecord historyRecord1 = new HistoryRecord();
        historyRecord1.setAccount(account3);
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

        MessageRecord messageRecord1 = new MessageRecord();
        messageRecord1.setAccount(account2);
        messageRecord1.setContent("Not all who wander are lost");
        messageRecord1.setDate("2020-03-01");
        messageRecord1.setHaveRead(true);
        messageRecord1.setHistoryRecord(historyRecord1);
        messageRecord1.setMessageId(123L);
        messageRecord1.setReceiver("Receiver");
        messageRecord1.setSender("Sender");
        messageRecord1.setSubject(Subject.NORMAL_CASE);
        assertSame(messageRecord, messageRecordService.saveMessageRecord(messageRecord1));
        verify(messageRecordRepository).save((MessageRecord) any());
    }

    /**
     * Method under test: {@link MessageRecordService#findAllMessagesByReceiver(String)}
     */
    @Test
    void testFindAllMessagesByReceiver() {
        ArrayList<MessageRecord> messageRecordList = new ArrayList<>();
        when(messageRecordRepository.findAllByReceiver((String) any())).thenReturn(messageRecordList);
        List<MessageRecord> actualFindAllMessagesByReceiverResult = messageRecordService
                .findAllMessagesByReceiver("Receiver");
        assertSame(messageRecordList, actualFindAllMessagesByReceiverResult);
        assertTrue(actualFindAllMessagesByReceiverResult.isEmpty());
        verify(messageRecordRepository).findAllByReceiver((String) any());
    }

    /**
     * Method under test: {@link MessageRecordService#findMessageById(Long)}
     */
    @Test
    void testFindMessageById() {
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

        MessageRecord messageRecord = new MessageRecord();
        messageRecord.setAccount(account);
        messageRecord.setContent("Not all who wander are lost");
        messageRecord.setDate("2020-03-01");
        messageRecord.setHaveRead(true);
        messageRecord.setHistoryRecord(historyRecord);
        messageRecord.setMessageId(123L);
        messageRecord.setReceiver("Receiver");
        messageRecord.setSender("Sender");
        messageRecord.setSubject(Subject.NORMAL_CASE);
        Optional<MessageRecord> ofResult = Optional.of(messageRecord);
        when(messageRecordRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(messageRecord, messageRecordService.findMessageById(123L));
        verify(messageRecordRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link MessageRecordService#deleteById(Long)}
     */
    @Test
    void testDeleteById() {
        doNothing().when(messageRecordRepository).deleteById((Long) any());
        messageRecordService.deleteById(123L);
        verify(messageRecordRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link MessageRecordService#setMessageAsRead(Long)}
     */
    @Test
    void testSetMessageAsRead() {
        doNothing().when(messageRecordRepository).updateMessageRecordHaveRead((Boolean) any(), (Long) any());
        messageRecordService.setMessageAsRead(123L);
        verify(messageRecordRepository).updateMessageRecordHaveRead((Boolean) any(), (Long) any());
    }

    /**
     * Method under test: {@link MessageRecordService#newMessages(String)}
     */
    @Test
    void testNewMessages() {
        when(messageRecordRepository.findAllByReceiver((String) any())).thenReturn(new ArrayList<>());
        assertEquals(0, messageRecordService.newMessages("jane.doe@example.org"));
        verify(messageRecordRepository).findAllByReceiver((String) any());
    }

    /**
     * Method under test: {@link MessageRecordService#newMessages(String)}
     */
    @Test
    void testNewMessages2() {
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

        MessageRecord messageRecord = new MessageRecord();
        messageRecord.setAccount(account);
        messageRecord.setContent("Not all who wander are lost");
        messageRecord.setDate("2020-03-01");
        messageRecord.setHaveRead(true);
        messageRecord.setHistoryRecord(historyRecord);
        messageRecord.setMessageId(123L);
        messageRecord.setReceiver("Receiver");
        messageRecord.setSender("Sender");
        messageRecord.setSubject(Subject.NORMAL_CASE);

        ArrayList<MessageRecord> messageRecordList = new ArrayList<>();
        messageRecordList.add(messageRecord);
        when(messageRecordRepository.findAllByReceiver((String) any())).thenReturn(messageRecordList);
        assertEquals(0, messageRecordService.newMessages("jane.doe@example.org"));
        verify(messageRecordRepository).findAllByReceiver((String) any());
    }

    /**
     * Method under test: {@link MessageRecordService#newMessages(String)}
     */
    @Test
    void testNewMessages3() {
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

        MessageRecord messageRecord = new MessageRecord();
        messageRecord.setAccount(account);
        messageRecord.setContent("Not all who wander are lost");
        messageRecord.setDate("2020-03-01");
        messageRecord.setHaveRead(true);
        messageRecord.setHistoryRecord(historyRecord);
        messageRecord.setMessageId(123L);
        messageRecord.setReceiver("Receiver");
        messageRecord.setSender("Sender");
        messageRecord.setSubject(Subject.NORMAL_CASE);

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

        HealthInfo healthInfo3 = new HealthInfo();
        healthInfo3.setAge(1);
        healthInfo3.setBloodType(BloodType.A);
        healthInfo3.setHealthInfoId(123L);

        Profile profile3 = new Profile();
        profile3.setDateOfBirth("2020-03-01");
        profile3.setFirstName("Jane");
        profile3.setGender(Gender.MALE);
        profile3.setLastName("Doe");
        profile3.setMobileNum("Mobile Num");
        profile3.setProfileId(123L);

        Account account3 = new Account();
        account3.setEmail("jane.doe@example.org");
        account3.setHealthInfo(healthInfo3);
        account3.setHistoryRecords(new ArrayList<>());
        account3.setId(123L);
        account3.setMessageRecords(new ArrayList<>());
        account3.setPassword("iloveyou");
        account3.setProfile(profile3);
        account3.setProvider(Provider.LOCAL);
        account3.setRoles(new ArrayList<>());

        HistoryRecord historyRecord1 = new HistoryRecord();
        historyRecord1.setAccount(account3);
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

        MessageRecord messageRecord1 = new MessageRecord();
        messageRecord1.setAccount(account2);
        messageRecord1.setContent("Not all who wander are lost");
        messageRecord1.setDate("2020-03-01");
        messageRecord1.setHaveRead(true);
        messageRecord1.setHistoryRecord(historyRecord1);
        messageRecord1.setMessageId(123L);
        messageRecord1.setReceiver("Receiver");
        messageRecord1.setSender("Sender");
        messageRecord1.setSubject(Subject.NORMAL_CASE);

        ArrayList<MessageRecord> messageRecordList = new ArrayList<>();
        messageRecordList.add(messageRecord1);
        messageRecordList.add(messageRecord);
        when(messageRecordRepository.findAllByReceiver((String) any())).thenReturn(messageRecordList);
        assertEquals(0, messageRecordService.newMessages("jane.doe@example.org"));
        verify(messageRecordRepository).findAllByReceiver((String) any());
    }

    /**
     * Method under test: {@link MessageRecordService#newMessages(String)}
     */
    @Test
    void testNewMessages4() {
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
        MessageRecord messageRecord = mock(MessageRecord.class);
        when(messageRecord.getHaveRead()).thenReturn(false);
        doNothing().when(messageRecord).setAccount((Account) any());
        doNothing().when(messageRecord).setContent((String) any());
        doNothing().when(messageRecord).setDate((String) any());
        doNothing().when(messageRecord).setHaveRead((Boolean) any());
        doNothing().when(messageRecord).setHistoryRecord((HistoryRecord) any());
        doNothing().when(messageRecord).setMessageId((Long) any());
        doNothing().when(messageRecord).setReceiver((String) any());
        doNothing().when(messageRecord).setSender((String) any());
        doNothing().when(messageRecord).setSubject((Subject) any());
        messageRecord.setAccount(account);
        messageRecord.setContent("Not all who wander are lost");
        messageRecord.setDate("2020-03-01");
        messageRecord.setHaveRead(true);
        messageRecord.setHistoryRecord(historyRecord);
        messageRecord.setMessageId(123L);
        messageRecord.setReceiver("Receiver");
        messageRecord.setSender("Sender");
        messageRecord.setSubject(Subject.NORMAL_CASE);

        ArrayList<MessageRecord> messageRecordList = new ArrayList<>();
        messageRecordList.add(messageRecord);
        when(messageRecordRepository.findAllByReceiver((String) any())).thenReturn(messageRecordList);
        assertEquals(1, messageRecordService.newMessages("jane.doe@example.org"));
        verify(messageRecordRepository).findAllByReceiver((String) any());
        verify(messageRecord).getHaveRead();
        verify(messageRecord).setAccount((Account) any());
        verify(messageRecord).setContent((String) any());
        verify(messageRecord).setDate((String) any());
        verify(messageRecord).setHaveRead((Boolean) any());
        verify(messageRecord).setHistoryRecord((HistoryRecord) any());
        verify(messageRecord).setMessageId((Long) any());
        verify(messageRecord).setReceiver((String) any());
        verify(messageRecord).setSender((String) any());
        verify(messageRecord).setSubject((Subject) any());
    }
}

