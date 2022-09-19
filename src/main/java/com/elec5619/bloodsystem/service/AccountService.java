package com.elec5619.bloodsystem.service;

import com.elec5619.bloodsystem.dao.AccountRepository;
import com.elec5619.bloodsystem.dao.RoleRepository;
import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.Profile;
import com.elec5619.bloodsystem.entity.Role;
import com.elec5619.bloodsystem.security.CustomOAuth2User;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    MessageRecordService messageRecordService;


    public Account getAccountById(Long id){
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


    public void addCurrentUser(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            model.addAttribute("username", username.split("@")[0]);

            // add attribute about new messages
            int unreadMessages = messageRecordService.newMessages(username);
            model.addAttribute("newMessages", unreadMessages);

        } else if (principal instanceof CustomOAuth2User) {
            String email = ((CustomOAuth2User)principal).getEmail();
            model.addAttribute("username", email.split("@")[0]);

            // add attribute about new messages
            int unreadMessages = messageRecordService.newMessages(email);
            model.addAttribute("newMessages", unreadMessages);

        }else{
            throw new IllegalStateException("No user details");
        }
    }

    public String getCurrentUserEmail(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails)principal).getUsername();
        } else if (principal instanceof CustomOAuth2User) {
            return ((CustomOAuth2User)principal).getEmail();
        }else {
            throw new IllegalStateException("No user details");
        }
    }


    public String getCurDate(){
        // default cur time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }


    public Account getCurrentAccount(){
        return getAccountByEmail(getCurrentUserEmail());
    }

    public void setProfile(Profile profile, Long accountId){
        accountRepository.setProfileId(profile, accountId);
    }


    public void processOAuthPostLogin(String email) {
        Account account = new Account();
        account.setEmail(email);

        if (!accountExists(account.getEmail())){
            Role userRole = roleRepository.findByName("ROLE_USER");
            account.setRoles(List.of(userRole));
            accountRepository.save(account);
        }
    }
}
