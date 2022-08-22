package com.elec5619.bloodsystem.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {


    // here we use interface, so we can switch among different db (Mysql, mariaDB)
    private final ApplicationUserDao applicationUserDao;

    @Autowired
    // qualifier specify the implementation by @Repository("fake")
    public ApplicationUserService(@Qualifier("fake") ApplicationUserDao applicationUserDao){
        this.applicationUserDao = applicationUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserDao.selectApplicationUserByName(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("username " + username + " not found")));
    }
}
