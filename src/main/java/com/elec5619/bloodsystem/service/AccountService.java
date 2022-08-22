package com.elec5619.bloodsystem.service;

import com.elec5619.bloodsystem.dao.AccountRepository;
import com.elec5619.bloodsystem.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Objects;
import java.util.Optional;


// similar with @Component
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    public void addAccounts(Account account) {
        Optional<Account> accountOptional =
                accountRepository.findAccountByEmail(account.getEmail());
        if (accountOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }

        accountRepository.save(account);
    }

    public void deleteAccount(Long accountId) {
        accountRepository.findById(accountId);


        boolean exists = accountRepository.existsById(accountId);
        if (!exists){
            throw new IllegalStateException("" +
                    "account with id " + accountId + "does not exists");
        }

        accountRepository.deleteById(accountId);
    }


    @Transactional
    public void updateAccount(Long accountId, String name, String email) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalStateException(
                        "account with id " + accountId + "dose not exists"
                ));


        if (name != null && name.length() > 0 && !Objects.equals(account.getName(), name)){
            account.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(account.getEmail(), email)){
            Optional<Account> accountOptional = accountRepository.findAccountByEmail(email);

            if (accountOptional.isPresent()){
                throw  new IllegalStateException("Email taken");
            }

            account.setEmail(email);
        }


    }
}
