package com.elec5619.bloodsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.elec5619.bloodsystem.dao.AccountRepository;
import com.elec5619.bloodsystem.dao.RoleRepository;
import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.BloodType;
import com.elec5619.bloodsystem.entity.Gender;
import com.elec5619.bloodsystem.entity.HealthInfo;
import com.elec5619.bloodsystem.entity.Profile;
import com.elec5619.bloodsystem.entity.Provider;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {AccountService.class})
@ExtendWith(SpringExtension.class)
class AccountServiceTest {
    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @MockBean
    private MessageRecordService messageRecordService;

    @MockBean
    private RoleRepository roleRepository;

    /**
     * Method under test: {@link AccountService#getAccountById(Long)}
     */
    @Test
    void testGetAccountById() {
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
        when(accountRepository.findById((Long) any())).thenReturn(account);
        assertSame(account, accountService.getAccountById(123L));
        verify(accountRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link AccountService#getAccountById(Long)}
     */
    @Test
    void testGetAccountById2() {
        when(accountRepository.findById((Long) any())).thenThrow(new IllegalStateException("foo"));
        assertThrows(IllegalStateException.class, () -> accountService.getAccountById(123L));
        verify(accountRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link AccountService#getAccountByEmail(String)}
     */
    @Test
    void testGetAccountByEmail() {
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
        when(accountRepository.findAccountByEmail((String) any())).thenReturn(account);
        assertSame(account, accountService.getAccountByEmail("jane.doe@example.org"));
        verify(accountRepository).findAccountByEmail((String) any());
    }

    /**
     * Method under test: {@link AccountService#getAccountByEmail(String)}
     */
    @Test
    void testGetAccountByEmail2() {
        when(accountRepository.findAccountByEmail((String) any())).thenThrow(new IllegalStateException("foo"));
        assertThrows(IllegalStateException.class, () -> accountService.getAccountByEmail("jane.doe@example.org"));
        verify(accountRepository).findAccountByEmail((String) any());
    }

    /**
     * Method under test: {@link AccountService#getAllAccounts()}
     */
    @Test
    void testGetAllAccounts() {
        ArrayList<Account> accountList = new ArrayList<>();
        when(accountRepository.findAll()).thenReturn(accountList);
        List<Account> actualAllAccounts = accountService.getAllAccounts();
        assertSame(accountList, actualAllAccounts);
        assertTrue(actualAllAccounts.isEmpty());
        verify(accountRepository).findAll();
    }

    /**
     * Method under test: {@link AccountService#getAllAccounts()}
     */
    @Test
    void testGetAllAccounts2() {
        when(accountRepository.findAll()).thenThrow(new IllegalStateException("foo"));
        assertThrows(IllegalStateException.class, () -> accountService.getAllAccounts());
        verify(accountRepository).findAll();
    }

    /**
     * Method under test: {@link AccountService#accountExists(String)}
     */
    @Test
    void testAccountExists() {
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
        when(accountRepository.findAccountByEmail((String) any())).thenReturn(account);
        assertTrue(accountService.accountExists("jane.doe@example.org"));
        verify(accountRepository).findAccountByEmail((String) any());
    }

    /**
     * Method under test: {@link AccountService#accountExists(String)}
     */
    @Test
    void testAccountExists2() {
        when(accountRepository.findAccountByEmail((String) any())).thenThrow(new IllegalStateException("foo"));
        assertThrows(IllegalStateException.class, () -> accountService.accountExists("jane.doe@example.org"));
        verify(accountRepository).findAccountByEmail((String) any());
    }

    /**
     * Method under test: {@link AccountService#register(Account)}
     */
    @Test
    void testRegister() {
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
        when(accountRepository.findAccountByEmail((String) any())).thenReturn(account);

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
        assertThrows(IllegalStateException.class, () -> accountService.register(account1));
        verify(accountRepository).findAccountByEmail((String) any());
    }

    /**
     * Method under test: {@link AccountService#register(Account)}
     */
    @Test
    void testRegister2() {
        when(accountRepository.findAccountByEmail((String) any())).thenThrow(new IllegalStateException("ROLE_USER"));

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
        assertThrows(IllegalStateException.class, () -> accountService.register(account));
        verify(accountRepository).findAccountByEmail((String) any());
    }



    /**
     * Method under test: {@link AccountService#setProfile(Profile, Long)}
     */
    @Test
    void testSetProfile() {
        doNothing().when(accountRepository).setProfileId((Profile) any(), (Long) any());

        Profile profile = new Profile();
        profile.setDateOfBirth("2020-03-01");
        profile.setFirstName("Jane");
        profile.setGender(Gender.MALE);
        profile.setLastName("Doe");
        profile.setMobileNum("Mobile Num");
        profile.setProfileId(123L);
        accountService.setProfile(profile, 1234567890L);
        verify(accountRepository).setProfileId((Profile) any(), (Long) any());
        assertEquals("2020-03-01", profile.getDateOfBirth());
        assertEquals(123L, profile.getProfileId().longValue());
        assertEquals("Mobile Num", profile.getMobileNum());
        assertEquals("Doe", profile.getLastName());
        assertEquals(Gender.MALE, profile.getGender());
        assertEquals("Jane", profile.getFirstName());
        assertTrue(accountService.getAllAccounts().isEmpty());
    }

    /**
     * Method under test: {@link AccountService#setProfile(Profile, Long)}
     */
    @Test
    void testSetProfile2() {
        doThrow(new IllegalStateException("foo")).when(accountRepository).setProfileId((Profile) any(), (Long) any());

        Profile profile = new Profile();
        profile.setDateOfBirth("2020-03-01");
        profile.setFirstName("Jane");
        profile.setGender(Gender.MALE);
        profile.setLastName("Doe");
        profile.setMobileNum("Mobile Num");
        profile.setProfileId(123L);
        assertThrows(IllegalStateException.class, () -> accountService.setProfile(profile, 1234567890L));
        verify(accountRepository).setProfileId((Profile) any(), (Long) any());
    }

    /**
     * Method under test: {@link AccountService#setHealthInfo(HealthInfo, Long)}
     */
    @Test
    void testSetHealthInfo() {
        doNothing().when(accountRepository).setHealthInfoId((HealthInfo) any(), (Long) any());

        HealthInfo healthInfo = new HealthInfo();
        healthInfo.setAge(1);
        healthInfo.setBloodType(BloodType.A);
        healthInfo.setHealthInfoId(123L);
        accountService.setHealthInfo(healthInfo, 1234567890L);
        verify(accountRepository).setHealthInfoId((HealthInfo) any(), (Long) any());
        assertEquals(1, healthInfo.getAge().intValue());
        assertEquals(123L, healthInfo.getHealthInfoId().longValue());
        assertEquals(BloodType.A, healthInfo.getBloodType());
        assertTrue(accountService.getAllAccounts().isEmpty());
    }

    /**
     * Method under test: {@link AccountService#setHealthInfo(HealthInfo, Long)}
     */
    @Test
    void testSetHealthInfo2() {
        doThrow(new IllegalStateException("foo")).when(accountRepository)
                .setHealthInfoId((HealthInfo) any(), (Long) any());

        HealthInfo healthInfo = new HealthInfo();
        healthInfo.setAge(1);
        healthInfo.setBloodType(BloodType.A);
        healthInfo.setHealthInfoId(123L);
        assertThrows(IllegalStateException.class, () -> accountService.setHealthInfo(healthInfo, 1234567890L));
        verify(accountRepository).setHealthInfoId((HealthInfo) any(), (Long) any());
    }

    /**
     * Method under test: {@link AccountService#processOAuthPostLogin(String)}
     */
    @Test
    void testProcessOAuthPostLogin() {
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
        when(accountRepository.findAccountByEmail((String) any())).thenReturn(account);
        accountService.processOAuthPostLogin("jane.doe@example.org");
        verify(accountRepository).findAccountByEmail((String) any());
    }

    /**
     * Method under test: {@link AccountService#processOAuthPostLogin(String)}
     */
    @Test
    void testProcessOAuthPostLogin2() {
        when(accountRepository.findAccountByEmail((String) any())).thenThrow(new IllegalStateException("ROLE_USER"));
        assertThrows(IllegalStateException.class, () -> accountService.processOAuthPostLogin("jane.doe@example.org"));
        verify(accountRepository).findAccountByEmail((String) any());
    }
}

