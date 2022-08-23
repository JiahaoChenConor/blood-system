package com.elec5619.bloodsystem.service;

import com.elec5619.bloodsystem.dao.AccountRepository;
import com.elec5619.bloodsystem.dao.RoleRepository;
import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RoleRepository roleRepository;




    public Account getAccountById(int id){
        return accountRepository.findById(id);
    }

    public Account getAccountByEmail(String email){
        return accountRepository.findAccountByEmail(email);
    }


    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public boolean accountExists(String email){
        return getAccountByEmail(email) != null;
    }


    public Account register(Account account){
        if (accountExists(account.getEmail())){
            throw new IllegalStateException("There is an account with that email address: " + account.getEmail());
        }

        Role userRole = roleRepository.findByName("ROLE_USER");
        account.setRoles(List.of(userRole));
        return accountRepository.save(account);
    }




}
