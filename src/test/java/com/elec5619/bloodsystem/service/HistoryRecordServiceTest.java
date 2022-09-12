package com.elec5619.bloodsystem.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.elec5619.bloodsystem.dao.HistoryRecordRepository;
import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.BloodType;
import com.elec5619.bloodsystem.entity.HistoryRecord;
import com.elec5619.bloodsystem.entity.HistoryType;

import java.util.ArrayList;
import java.util.List;

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
    private HistoryRecordRepository historyRecordRepository;

    @Autowired
    private HistoryRecordService historyRecordService;

    /**
     * Method under test: {@link HistoryRecordService#saveHistoryRecord(HistoryRecord)}
     */
    @Test
    void testSaveHistoryRecord() {
        Account account = new Account();
        account.setEmail("jane.doe@example.org");
        account.setId(123L);
        account.setPassword("iloveyou");
        account.setRoles(new ArrayList<>());

        HistoryRecord historyRecord = new HistoryRecord();
        historyRecord.setAccount(account);
        historyRecord.setBloodType(BloodType.A);
        historyRecord.setDate("2020-03-01");
        historyRecord.setHistoryId(123L);
        historyRecord.setHistoryType(HistoryType.DONATE);
        historyRecord.setLocation("Location");
        historyRecord.setMatched(true);
        historyRecord.setMeasure(10.0d);
        historyRecord.setMessagesInHistory(new ArrayList<>());

        when(historyRecordRepository.save((HistoryRecord) any())).thenReturn(historyRecord);

        Account account1 = new Account();
        account1.setEmail("jane.doe@example.org");
        account1.setId(123L);
        account1.setPassword("iloveyou");
        account1.setRoles(new ArrayList<>());

        HistoryRecord historyRecord1 = new HistoryRecord();
        historyRecord1.setAccount(account1);
        historyRecord1.setBloodType(BloodType.A);
        historyRecord1.setDate("2020-03-01");
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
        ArrayList<HistoryRecord> historyRecordList = new ArrayList<>();
        when(historyRecordRepository.findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(), (HistoryType) any()))
                .thenReturn(historyRecordList);
        List<HistoryRecord> actualMatchDonateRecord = historyRecordService.getMatchDonateRecord(BloodType.A);
        assertSame(historyRecordList, actualMatchDonateRecord);
        assertTrue(actualMatchDonateRecord.isEmpty());
        verify(historyRecordRepository).findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(), (HistoryType) any());
    }

    /**
     * Method under test: {@link HistoryRecordService#getMatchDonateRecord(BloodType)}
     */
    @Test
    void testGetMatchDonateRecord2() {
        ArrayList<HistoryRecord> historyRecordList = new ArrayList<>();
        when(historyRecordRepository.findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(), (HistoryType) any()))
                .thenReturn(historyRecordList);
        List<HistoryRecord> actualMatchDonateRecord = historyRecordService.getMatchDonateRecord(BloodType.B);
        assertSame(historyRecordList, actualMatchDonateRecord);
        assertTrue(actualMatchDonateRecord.isEmpty());
        verify(historyRecordRepository).findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(), (HistoryType) any());
    }

    /**
     * Method under test: {@link HistoryRecordService#getMatchDonateRecord(BloodType)}
     */
    @Test
    void testGetMatchDonateRecord3() {
        ArrayList<HistoryRecord> historyRecordList = new ArrayList<>();
        when(historyRecordRepository.findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(), (HistoryType) any()))
                .thenReturn(historyRecordList);
        List<HistoryRecord> actualMatchDonateRecord = historyRecordService.getMatchDonateRecord(BloodType.AB);
        assertSame(historyRecordList, actualMatchDonateRecord);
        assertTrue(actualMatchDonateRecord.isEmpty());
        verify(historyRecordRepository).findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(), (HistoryType) any());
    }

    /**
     * Method under test: {@link HistoryRecordService#getMatchDonateRecord(BloodType)}
     */
    @Test
    void testGetMatchDonateRecord4() {
        ArrayList<HistoryRecord> historyRecordList = new ArrayList<>();
        when(historyRecordRepository.findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(), (HistoryType) any()))
                .thenReturn(historyRecordList);
        List<HistoryRecord> actualMatchDonateRecord = historyRecordService.getMatchDonateRecord(BloodType.O);
        assertSame(historyRecordList, actualMatchDonateRecord);
        assertTrue(actualMatchDonateRecord.isEmpty());
        verify(historyRecordRepository).findHistoryRecordByBloodTypeAndHistoryType((BloodType) any(), (HistoryType) any());
    }
}

