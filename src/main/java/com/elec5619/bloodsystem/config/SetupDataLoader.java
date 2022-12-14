package com.elec5619.bloodsystem.config;

import com.elec5619.bloodsystem.dao.AccountRepository;
import com.elec5619.bloodsystem.dao.PrivilegeRepository;
import com.elec5619.bloodsystem.dao.RoleRepository;
import com.elec5619.bloodsystem.domain.Account;
import com.elec5619.bloodsystem.domain.Privilege;
import com.elec5619.bloodsystem.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * The type Setup data loader.
 */
@Component
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    /**
     * The Already setup.
     */
    boolean alreadySetup = false;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);


        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        Account account = new Account();

        account.setPassword(passwordEncoder.encode("admin"));
        account.setEmail("admin@admin.com");


        account.setRoles(List.of(adminRole));

        accountRepository.save(account);


        Role userRole = roleRepository.findByName("ROLE_USER");
        Account accountUser = new Account();

        accountUser.setPassword(passwordEncoder.encode("Password123"));
        accountUser.setEmail("jiahaochen775@gmail.com");

        accountUser.setRoles(List.of(userRole));



        accountRepository.save(accountUser);
        alreadySetup = true;
    }

    /**
     * Create privilege if not found privilege.
     *
     * @param name the name
     * @return the privilege
     */
    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    /**
     * Create role if not found role.
     *
     * @param name       the name
     * @param privileges the privileges
     * @return the role
     */
    @Transactional
    Role createRoleIfNotFound(
            String name,
            Collection<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}
