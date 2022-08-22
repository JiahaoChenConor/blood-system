package com.elec5619.bloodsystem.auth;


import java.util.Optional;

public interface ApplicationUserDao {
    public Optional<ApplicationUser> selectApplicationUserByName(String name);

}
