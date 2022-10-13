package com.elec5619.bloodsystem.service;

import com.elec5619.bloodsystem.dao.AccountRepository;
import com.elec5619.bloodsystem.dao.RoleRepository;
import com.elec5619.bloodsystem.domain.*;
import com.elec5619.bloodsystem.security.CustomOAuth2User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * The type Account service.
 */
@Service
@Transactional
public class AccountService {

    /**
     * The Account repository.
     */
    @Autowired
    AccountRepository accountRepository;

    /**
     * The Role repository.
     */
    @Autowired
    RoleRepository roleRepository;

    /**
     * The Message record service.
     */
    @Autowired
    MessageRecordService messageRecordService;


    /**
     * Get account by id account.
     *
     * @param id the id
     * @return the account
     */
    public Account getAccountById(Long id){
        return accountRepository.findById(id);
    }

    /**
     * Get account by email account.
     *
     * @param email the email
     * @return the account
     */
    public Account getAccountByEmail(String email){
        return accountRepository.findAccountByEmail(email);
    }


    /**
     * Get all accounts list.
     *
     * @return the list
     */
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    /**
     * Account exists boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public boolean accountExists(String email){
        return getAccountByEmail(email) != null;
    }


    /**
     * Register account.
     *
     * @param account the account
     * @return the account
     */
    public Account register(Account account){
        if (accountExists(account.getEmail())){
            throw new IllegalStateException("There is an account with that email address: " + account.getEmail());
        }

        Role userRole = roleRepository.findByName("ROLE_USER");
        account.setRoles(List.of(userRole));
        return accountRepository.save(account);
    }


    /**
     * Add current user.
     *
     * @param model the model
     */
    public void addCurrentUser(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            model.addAttribute("username", username.split("@")[0]);

            // add attribute about new messages
            int unreadMessages = messageRecordService.newMessages(username);
            model.addAttribute("newMessages", unreadMessages);

        }

        else if (principal instanceof CustomOAuth2User) {
            String email = ((CustomOAuth2User)principal).getEmail();
            model.addAttribute("username", email.split("@")[0]);

            // add attribute about new messages
            int unreadMessages = messageRecordService.newMessages(email);
            model.addAttribute("newMessages", unreadMessages);

        }

        else{
            throw new IllegalStateException("No user details");
        }
    }

    /**
     * Get current user email string.
     *
     * @return the string
     */
    public String getCurrentUserEmail(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails)principal).getUsername();
        }

        else if (principal instanceof CustomOAuth2User) {
            return ((CustomOAuth2User)principal).getEmail();
        }

        else {
            throw new IllegalStateException("No user details");
        }
    }


    /**
     * Get cur date string.
     *
     * @return the string
     */
    public String getCurDate(){
        // default cur time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }


    /**
     * Get current account account.
     *
     * @return the account
     */
    public Account getCurrentAccount(){
        return getAccountByEmail(getCurrentUserEmail());
    }

    /**
     * Set profile.
     *
     * @param profile   the profile
     * @param accountId the account id
     */
    public void setProfile(Profile profile, Long accountId){
        accountRepository.setProfileId(profile, accountId);
    }

    /**
     * Set health info.
     *
     * @param healthInfo the health info
     * @param accountId  the account id
     */
    public void setHealthInfo(HealthInfo healthInfo, Long accountId){
        accountRepository.setHealthInfoId(healthInfo, accountId);
    }

    /**
     * Process o auth post login.
     *
     * @param email the email
     */
    public void processOAuthPostLogin(String email) {
        Account account = new Account();
        account.setEmail(email);
        account.setProvider(Provider.GOOGLE);
        if (!accountExists(account.getEmail())){
            Role userRole = roleRepository.findByName("ROLE_USER");
            account.setRoles(List.of(userRole));
            accountRepository.save(account);
        }
    }
}
