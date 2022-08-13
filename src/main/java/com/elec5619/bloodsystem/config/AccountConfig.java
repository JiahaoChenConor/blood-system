package com.elec5619.bloodsystem.config;

import com.elec5619.bloodsystem.dao.AccountRepository;
import com.elec5619.bloodsystem.entity.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AccountConfig {

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository){
        return args -> {
            Account chen = new Account(
                    "chen",
                    "chen@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)

            );


            Account zhang = new Account(
                    "zhang",
                    "zhang@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            accountRepository.saveAll(List.of(chen, zhang));
        };
    }
}
