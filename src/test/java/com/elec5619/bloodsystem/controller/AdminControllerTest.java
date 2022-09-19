package com.elec5619.bloodsystem.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.BloodType;
import com.elec5619.bloodsystem.entity.Gender;
import com.elec5619.bloodsystem.entity.HealthInfo;
import com.elec5619.bloodsystem.entity.HistoryRecord;
import com.elec5619.bloodsystem.entity.HistoryType;
import com.elec5619.bloodsystem.entity.MessageRecord;
import com.elec5619.bloodsystem.entity.Profile;
import com.elec5619.bloodsystem.entity.Subject;
import com.elec5619.bloodsystem.service.AccountService;
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

@ContextConfiguration(classes = {AdminController.class})
@ExtendWith(SpringExtension.class)
class AdminControllerTest {
    @MockBean
    private AccountService accountService;

    @Autowired
    private AdminController adminController;

    @MockBean
    private MessageRecordService messageRecordService;

    /**
     * Method under test: {@link AdminController#deleteMessage(String)}
     */
    @Test
    void testDeleteMessage() throws Exception {
        doNothing().when(messageRecordService).deleteById((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/delete")
                .param("messageId", "42");
        MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("success"));
    }

    /**
     * Method under test: {@link AdminController#specificMessage(String, Model)}
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
        account1.setRoles(new ArrayList<>());

        HistoryRecord historyRecord = new HistoryRecord();
        historyRecord.setAccount(account1);
        historyRecord.setBloodType(BloodType.A);
        historyRecord.setDate("2020-03-01");
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
        when(messageRecordService.findMessageById((Long) any())).thenReturn(messageRecord);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/messages/{messageId}", "42");
        MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("message"))
                .andExpect(MockMvcResultMatchers.view().name("admin-specific-message"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("admin-specific-message"));
    }

    /**
     * Method under test: {@link AdminController#userMessages(String, Model)}
     */
    @Test
    void testUserMessages() throws Exception {
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
        account.setRoles(new ArrayList<>());
        when(accountService.getAccountById((Long) any())).thenReturn(account);
        doNothing().when(accountService).addCurrentUser((Model) any());
        when(messageRecordService.findAllMessagesByReceiver((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/user-message/{userId}", "42");
        MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("messages"))
                .andExpect(MockMvcResultMatchers.view().name("admin-user-message"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("admin-user-message"));
    }
}

