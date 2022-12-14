package com.elec5619.bloodsystem.service;

import com.elec5619.bloodsystem.domain.Account;
import com.elec5619.bloodsystem.domain.Privilege;
import com.elec5619.bloodsystem.domain.Role;
import com.elec5619.bloodsystem.dao.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class is used for filtering by user role and authorities
 * load the user details during authentication
 * The filter is implemented in `Security/ApplicationSecurityConfig`
 */
@Service
@Transactional  // WARNING: this is necessary!
public class AccountDetailService implements UserDetailsService {

    /**
     * The Account repository.
     */
    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Account account = accountRepository.findAccountByEmail(email);
        if (account == null){
            throw new UsernameNotFoundException("user name not found");
        }

        return new User(
                account.getEmail(), account.getPassword(), true, true, true,
                true, getAuthorities(account.getRoles()));
    }


    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }


    private List<String> getPrivileges(Collection<Role> roles) {

        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            privileges.add(role.getName());
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }


}
