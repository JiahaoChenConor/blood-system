package com.elec5619.bloodsystem.controller;

import com.elec5619.bloodsystem.service.AccountService;
import com.elec5619.bloodsystem.service.EmailService;
import com.elec5619.bloodsystem.service.HistoryRecordService;
import com.elec5619.bloodsystem.service.MessageRecordService;
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

@ContextConfiguration(classes = {HistoryController.class})
@ExtendWith(SpringExtension.class)
class HistoryControllerTest {
    @MockBean
    private AccountService accountService;

    @MockBean
    private EmailService emailService;

    @Autowired
    private HistoryController historyController;

    @MockBean
    private HistoryRecordService historyRecordService;

    @MockBean
    private MessageRecordService messageRecordService;



    /**
     * Method under test: {@link HistoryController#changeHistoryStatus(String, String)}
     */
    @Test
    void testChangeHistoryStatus() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/history")
                .param("matched", "foo")
                .param("recordId", "42");
        MockMvcBuilders.standaloneSetup(historyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("nothing"));
    }
}

