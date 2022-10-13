package com.elec5619.bloodsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.elec5619.bloodsystem.dao.AccountRepository;
import com.elec5619.bloodsystem.domain.Account;
import com.elec5619.bloodsystem.domain.BloodType;
import com.elec5619.bloodsystem.domain.Gender;
import com.elec5619.bloodsystem.domain.HealthInfo;
import com.elec5619.bloodsystem.domain.HistoryRecord;
import com.elec5619.bloodsystem.domain.MessageRecord;
import com.elec5619.bloodsystem.domain.Profile;
import com.elec5619.bloodsystem.domain.Provider;
import com.elec5619.bloodsystem.domain.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AccountDetailService.class})
@ExtendWith(SpringExtension.class)
class AccountDetailServiceTest {
    @Autowired
    private AccountDetailService accountDetailService;

    @MockBean
    private AccountRepository accountRepository;

    /**
     * Method under test: {@link AccountDetailService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
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
        UserDetails actualLoadUserByUsernameResult = accountDetailService.loadUserByUsername("jane.doe@example.org");
        assertTrue(actualLoadUserByUsernameResult.getAuthorities().isEmpty());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("jane.doe@example.org", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(accountRepository).findAccountByEmail((String) any());
    }



    /**
     * Method under test: {@link AccountDetailService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername3() throws UsernameNotFoundException {
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

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        role.setPrivileges(new ArrayList<>());
        role.setUsers(new ArrayList<>());

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role);
        Account account = mock(Account.class);
        when(account.getEmail()).thenReturn("jane.doe@example.org");
        when(account.getPassword()).thenReturn("iloveyou");
        when(account.getRoles()).thenReturn(roleList);
        doNothing().when(account).setEmail((String) any());
        doNothing().when(account).setHealthInfo((HealthInfo) any());
        doNothing().when(account).setHistoryRecords((List<HistoryRecord>) any());
        doNothing().when(account).setId((Long) any());
        doNothing().when(account).setMessageRecords((List<MessageRecord>) any());
        doNothing().when(account).setPassword((String) any());
        doNothing().when(account).setProfile((Profile) any());
        doNothing().when(account).setProvider((Provider) any());
        doNothing().when(account).setRoles((Collection<Role>) any());
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
        UserDetails actualLoadUserByUsernameResult = accountDetailService.loadUserByUsername("jane.doe@example.org");
        assertEquals(1, actualLoadUserByUsernameResult.getAuthorities().size());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("jane.doe@example.org", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(accountRepository).findAccountByEmail((String) any());
        verify(account).getEmail();
        verify(account).getPassword();
        verify(account).getRoles();
        verify(account).setEmail((String) any());
        verify(account).setHealthInfo((HealthInfo) any());
        verify(account).setHistoryRecords((List<HistoryRecord>) any());
        verify(account).setId((Long) any());
        verify(account).setMessageRecords((List<MessageRecord>) any());
        verify(account).setPassword((String) any());
        verify(account).setProfile((Profile) any());
        verify(account).setProvider((Provider) any());
        verify(account).setRoles((Collection<Role>) any());
    }
}

