package com.elec5619.bloodsystem.restcontroller;


import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Account controller.
 */
@RestController
@RequestMapping("/api/v1")
public class AccountController {
    /**
     * The Account service.
     */
    @Autowired
    AccountService accountService;

    /**
     * All accounts list.
     *
     * @return the list
     */
    @GetMapping("/allUsers")
    public List<Account> allAccounts(){
        return accountService.getAllAccounts();
    }
}
