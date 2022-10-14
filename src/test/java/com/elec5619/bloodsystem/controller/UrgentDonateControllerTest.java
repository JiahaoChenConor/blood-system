package com.elec5619.bloodsystem.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
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
import com.elec5619.bloodsystem.domain.UrgentPost;
import com.elec5619.bloodsystem.service.AccountService;
import com.elec5619.bloodsystem.service.EmailService;
import com.elec5619.bloodsystem.service.HistoryRecordService;
import com.elec5619.bloodsystem.service.MessageRecordService;
import com.elec5619.bloodsystem.service.SmsService;
import com.elec5619.bloodsystem.service.UrgentPostService;

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

@ContextConfiguration(classes = {UrgentDonateController.class})
@ExtendWith(SpringExtension.class)
class UrgentDonateControllerTest {
    @MockBean
    private AccountService accountService;

    @MockBean
    private EmailService emailService;

    @MockBean
    private HistoryRecordService historyRecordService;

    @MockBean
    private MessageRecordService messageRecordService;

    @MockBean
    private SmsService smsService;

    @Autowired
    private UrgentDonateController urgentDonateController;

    @MockBean
    private UrgentPostService urgentPostService;

    /**
     * Method under test: {@link UrgentDonateController#urgentDonate(Model, Long)}
     */
    @Test
    void testUrgentDonate() throws Exception {
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
        when(accountService.getAccountByEmail((String) any())).thenReturn(account);
        when(accountService.getCurrentUserEmail()).thenReturn("jane.doe@example.org");
        doNothing().when(accountService).addCurrentUser((Model) any());

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
        when(historyRecordService.findHistoryRecordById(anyLong())).thenReturn(historyRecord);

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

        UrgentPost urgentPost = new UrgentPost();
        urgentPost.setAccount(account2);
        urgentPost.setBloodType(BloodType.A);
        urgentPost.setContent("Not all who wander are lost");
        urgentPost.setCorrespondHistoryRecordId(123L);
        urgentPost.setDate("2020-03-01");
        urgentPost.setLocation("Location");
        urgentPost.setMatched(true);
        urgentPost.setMeasure(10.0d);
        urgentPost.setUrgentId(123L);
        when(urgentPostService.findUrgentPostById(anyLong())).thenReturn(urgentPost);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/urgentDonate");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("urgentId", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(urgentDonateController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(4))
                .andExpect(MockMvcResultMatchers.model().attributeExists("bloodType", "cc", "date", "location"))
                .andExpect(MockMvcResultMatchers.view().name("urgent-donate-step1"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("urgent-donate-step1"));
    }


    /**
     * Method under test: {@link UrgentDonateController#urgentDonateStep2(Model)}
     */
    @Test
    void testUrgentDonateStep2() throws Exception {
        doNothing().when(accountService).addCurrentUser((Model) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/urgentDonate/step2");
        MockMvcBuilders.standaloneSetup(urgentDonateController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("urgent-donate-step2"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("urgent-donate-step2"));
    }

    /**
     * Method under test: {@link UrgentDonateController#urgentDonateStep2(Model)}
     */
    @Test
    void testUrgentDonateStep22() throws Exception {
        doNothing().when(accountService).addCurrentUser((Model) any());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/urgentDonate/step2");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(urgentDonateController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("urgent-donate-step2"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("urgent-donate-step2"));
    }
}

