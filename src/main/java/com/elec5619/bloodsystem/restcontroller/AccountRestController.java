package com.elec5619.bloodsystem.restcontroller;

import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/account")
public class AccountRestController {

    private final AccountService accountService;

    @Autowired
    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAccounts(){
       return accountService.getAccounts();
    }

    @PostMapping
    public void registerNewUser(@RequestBody Account account){
        accountService.addAccounts(account);
    }

    @DeleteMapping(path = "{accountId}")
    public void deleteAccount(@PathVariable("accountId") Long AccountId){
        accountService.deleteAccount(AccountId);
    }

    @PutMapping(path = "{accountId}")
    public void updateAccount(@PathVariable("accountId") Long accountId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){

        accountService.updateAccount(accountId, name, email);

    }
}
