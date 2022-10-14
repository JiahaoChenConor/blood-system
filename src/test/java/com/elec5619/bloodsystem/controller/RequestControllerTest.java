package com.elec5619.bloodsystem.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.elec5619.bloodsystem.domain.Account;
import com.elec5619.bloodsystem.domain.BloodType;
import com.elec5619.bloodsystem.domain.Gender;
import com.elec5619.bloodsystem.domain.HealthInfo;
import com.elec5619.bloodsystem.domain.Profile;
import com.elec5619.bloodsystem.domain.Provider;
import com.elec5619.bloodsystem.service.AccountService;
import com.elec5619.bloodsystem.service.EmailService;
import com.elec5619.bloodsystem.service.HistoryRecordService;
import com.elec5619.bloodsystem.service.MessageRecordService;
import com.elec5619.bloodsystem.service.SmsService;
import com.elec5619.bloodsystem.service.UrgentPostService;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
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
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

@ContextConfiguration(classes = {RequestController.class})
@ExtendWith(SpringExtension.class)
class RequestControllerTest {
    @MockBean
    private AccountService accountService;

    @MockBean
    private EmailService emailService;

    @MockBean
    private HistoryRecordService historyRecordService;

    @MockBean
    private MessageRecordService messageRecordService;

    @Autowired
    private RequestController requestController;

    @MockBean
    private SmsService smsService;

    @MockBean
    private UrgentPostService urgentPostService;


    /**
     * Method under test: {@link RequestController#request(Model)}
     */
    @Test
    void testRequest() throws Exception {
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
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/book/request");
        MockMvcBuilders.standaloneSetup(requestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("request-step1"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("request-step1"));
    }



    /**
     * Method under test: {@link RequestController#returnIndex(Model)}
     */
    @Test
    void testReturnIndex() throws Exception {
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
        when(urgentPostService.getAvailableUrgentPost((Account) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/book/request-confirm");
        MockMvcBuilders.standaloneSetup(requestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("urgent"))
                .andExpect(MockMvcResultMatchers.view().name("index-user"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("index-user"));
    }
}

