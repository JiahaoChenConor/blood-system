package com.elec5619.bloodsystem.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.BloodType;
import com.elec5619.bloodsystem.entity.Gender;
import com.elec5619.bloodsystem.entity.HealthInfo;
import com.elec5619.bloodsystem.entity.Profile;
import com.elec5619.bloodsystem.entity.Provider;
import com.elec5619.bloodsystem.service.AccountService;
import com.elec5619.bloodsystem.service.HistoryRecordService;

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
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

@ContextConfiguration(classes = {DonateController.class})
@ExtendWith(SpringExtension.class)
class DonateControllerTest {
    @MockBean
    private AccountService accountService;

    @Autowired
    private DonateController donateController;

    @MockBean
    private HistoryRecordService historyRecordService;





    /**
     * Method under test: {@link DonateController#donate(Model)}
     */
    @Test
    void testDonate() throws Exception {
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
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/book/donate");
        MockMvcBuilders.standaloneSetup(donateController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("donate-step1"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("donate-step1"));
    }


    /**
     * Method under test: {@link DonateController#donateStepConfirm(Model)}
     */
    @Test
    void testDonateStepConfirm() throws Exception {
        doNothing().when(accountService).addCurrentUser((Model) any());
        when(historyRecordService.getUrgentRequestRecordInWaitingList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/book/donate-confirm");
        MockMvcBuilders.standaloneSetup(donateController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("history"))
                .andExpect(MockMvcResultMatchers.view().name("index-user"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("index-user"));
    }

    /**
     * Method under test: {@link DonateController#donateStepConfirm(Model)}
     */
    @Test
    void testDonateStepConfirm2() throws Exception {
        doNothing().when(accountService).addCurrentUser((Model) any());
        when(historyRecordService.getUrgentRequestRecordInWaitingList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/book/donate-confirm");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(donateController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("history"))
                .andExpect(MockMvcResultMatchers.view().name("index-user"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("index-user"));
    }
}

