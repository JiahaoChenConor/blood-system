package com.elec5619.bloodsystem.auth;

import com.elec5619.bloodsystem.security.ApplicationUserRole;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao{
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByName(String username) {
        return getApplicationsUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }


    private List<ApplicationUser> getApplicationsUsers(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(

                new ApplicationUser("anansmith@gmail.com",
                        passwordEncoder.encode("password"),
                        ApplicationUserRole.NORMAL_USER.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true),


                new ApplicationUser("linda@gmail.com",
                        passwordEncoder.encode("password"),
                        ApplicationUserRole.ADMIN.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true)


        );

        return applicationUsers;
    }
}