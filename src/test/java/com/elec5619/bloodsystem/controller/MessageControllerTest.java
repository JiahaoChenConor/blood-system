package com.elec5619.bloodsystem.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.elec5619.bloodsystem.domain.Account;
import com.elec5619.bloodsystem.domain.BloodType;
import com.elec5619.bloodsystem.domain.EmailDetails;
import com.elec5619.bloodsystem.domain.Gender;
import com.elec5619.bloodsystem.domain.HealthInfo;
import com.elec5619.bloodsystem.domain.HistoryRecord;
import com.elec5619.bloodsystem.domain.HistoryType;
import com.elec5619.bloodsystem.domain.MessageRecord;
import com.elec5619.bloodsystem.domain.Profile;
import com.elec5619.bloodsystem.domain.Provider;
import com.elec5619.bloodsystem.domain.Subject;
import com.elec5619.bloodsystem.service.AccountService;
import com.elec5619.bloodsystem.service.EmailService;
import com.elec5619.bloodsystem.service.HistoryRecordService;
import com.elec5619.bloodsystem.service.MessageRecordService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

@ContextConfiguration(classes = {MessageController.class})
@ExtendWith(SpringExtension.class)
class MessageControllerTest {
    @MockBean
    private AccountService accountService;

    @MockBean
    private EmailService emailService;

    @MockBean
    private HistoryRecordService historyRecordService;

    @Autowired
    private MessageController messageController;

    @MockBean
    private MessageRecordService messageRecordService;



    /**
     * Method under test: {@link MessageController#reply(Model, String, String)}
     */
    @Test
    void testReply() throws Exception {
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
        doNothing().when(accountService).addCurrentUser((Model) any());
        when(emailService.sendSimpleMail((EmailDetails) any())).thenReturn("Send Simple Mail");

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

        HistoryRecord historyRecord = new HistoryRecord();
        historyRecord.setAccount(account2);
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
        messageRecord.setAccount(account1);
        messageRecord.setContent("Not all who wander are lost");
        messageRecord.setDate("2020-03-01");
        messageRecord.setHaveRead(true);
        messageRecord.setHistoryRecord(historyRecord);
        messageRecord.setMessageId(123L);
        messageRecord.setReceiver("Receiver");
        messageRecord.setSender("Sender");
        messageRecord.setSubject(Subject.BLOOD_REQUEST);

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

        HealthInfo healthInfo4 = new HealthInfo();
        healthInfo4.setAge(1);
        healthInfo4.setBloodType(BloodType.A);
        healthInfo4.setHealthInfoId(123L);

        Profile profile4 = new Profile();
        profile4.setDateOfBirth("2020-03-01");
        profile4.setFirstName("Jane");
        profile4.setGender(Gender.MALE);
        profile4.setLastName("Doe");
        profile4.setMobileNum("Mobile Num");
        profile4.setProfileId(123L);

        Account account4 = new Account();
        account4.setEmail("jane.doe@example.org");
        account4.setHealthInfo(healthInfo4);
        account4.setHistoryRecords(new ArrayList<>());
        account4.setId(123L);
        account4.setMessageRecords(new ArrayList<>());
        account4.setPassword("iloveyou");
        account4.setProfile(profile4);
        account4.setProvider(Provider.LOCAL);
        account4.setRoles(new ArrayList<>());

        HistoryRecord historyRecord1 = new HistoryRecord();
        historyRecord1.setAccount(account4);
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
        messageRecord1.setAccount(account3);
        messageRecord1.setContent("Not all who wander are lost");
        messageRecord1.setDate("2020-03-01");
        messageRecord1.setHaveRead(true);
        messageRecord1.setHistoryRecord(historyRecord1);
        messageRecord1.setMessageId(123L);
        messageRecord1.setReceiver("Receiver");
        messageRecord1.setSender("Sender");
        messageRecord1.setSubject(Subject.BLOOD_REQUEST);
        when(messageRecordService.saveMessageRecord((MessageRecord) any())).thenReturn(messageRecord1);
        when(messageRecordService.findMessageById((Long) any())).thenReturn(messageRecord);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/messages/{messageId}/reply", "42")
                .param("message", "foo");
        MockMvcBuilders.standaloneSetup(messageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("index-user"));
    }

    /**
     * Method under test: {@link MessageController#specificMessage(String, Model)}
     */
    @Test
    void testSpecificMessage() throws Exception {
        doNothing().when(accountService).addCurrentUser((Model) any());

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
        messageRecord.setSubject(Subject.BLOOD_REQUEST);
        doNothing().when(messageRecordService).setMessageAsRead((Long) any());
        when(messageRecordService.findMessageById((Long) any())).thenReturn(messageRecord);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/messages/{messageId}", "42");
        MockMvcBuilders.standaloneSetup(messageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("message"))
                .andExpect(MockMvcResultMatchers.view().name("specific-message"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("specific-message"));
    }
}

