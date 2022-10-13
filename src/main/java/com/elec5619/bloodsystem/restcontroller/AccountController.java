package com.elec5619.bloodsystem.restcontroller;


import com.elec5619.bloodsystem.domain.Account;
import com.elec5619.bloodsystem.domain.HistoryRecord;
import com.elec5619.bloodsystem.domain.HistoryType;
import com.elec5619.bloodsystem.dto.ApiLoginRquestDTO;
import com.elec5619.bloodsystem.dto.DonateReuqestDTO;
import com.elec5619.bloodsystem.dto.HistoryRecordResponseDTO;
import com.elec5619.bloodsystem.dto.MessageRecordResponseDTO;
import com.elec5619.bloodsystem.mapper.HistoryRecordMapper;
import com.elec5619.bloodsystem.mapper.MessageRecordMapper;
import com.elec5619.bloodsystem.security.PasswordConfig;
import com.elec5619.bloodsystem.service.AccountService;
import com.elec5619.bloodsystem.service.HistoryRecordService;
import com.elec5619.bloodsystem.service.MessageRecordService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * The type Account controller.
 */
@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    PasswordConfig passwordConfig;

    /**
     * The Account service.
     */
    @Autowired
    AccountService accountService;


    @Autowired
    MessageRecordService messageRecordService;


    @Autowired
    HistoryRecordService historyRecordService;
    private Account checkAuth(String token){
        List<Account> accounts = accountService.getAllAccounts();
        for (Account account : accounts){
            String encode = DigestUtils.md5Hex(account.getEmail() + account.getPassword());
            if (encode.equals(token)){
                return account;
            }
        }
        return null;
    }


    @PostMapping("/login")
    public String generateToken(@RequestBody ApiLoginRquestDTO apiLoginRquestDTO) throws URISyntaxException {
        Account account = accountService.getAccountByEmail(apiLoginRquestDTO.getEmail());

        PasswordEncoder passwordEncoder = passwordConfig.passwordEncoder();

        if (passwordEncoder.matches(apiLoginRquestDTO.getPassword(), account.getPassword())){
            return DigestUtils.md5Hex(apiLoginRquestDTO.getEmail() + account.getPassword());
        }
        throw new ResponseStatusException(NOT_FOUND, "Unable to find account");
    }


    @PostMapping("/donate")
    public String donateApi(@RequestBody DonateReuqestDTO donateReuqestDTO,
                              @RequestParam(name = "Authorization") String auth)
            throws URISyntaxException {

        Account account = checkAuth(auth);
        if (account == null){
            throw new ResponseStatusException(UNAUTHORIZED, "You do not have the permission");
        }

        HistoryRecord donate = new HistoryRecord();
        donate.setAccount(account);
        donate.setHistoryType(HistoryType.DONATE);
        donate.setBloodType(donateReuqestDTO.getBloodType());
        donate.setDate(donateReuqestDTO.getDate());
        donate.setLocation(donateReuqestDTO.getLocation());
        donate.setMatched(false);

        historyRecordService.saveHistoryRecord(donate);

        return "Ok";
    }

    @GetMapping("/messages")
    public List<MessageRecordResponseDTO> messageRecordsApi(@RequestParam(name = "Authorization") String auth){
        Account account = checkAuth(auth);

        if (account == null){
            throw new ResponseStatusException(UNAUTHORIZED, "You do not have the permission");
        }

        return messageRecordService.findAllMessagesByReceiver(account.getEmail())
                .stream()
                .map(MessageRecordMapper::map).toList();
    }

    @GetMapping("/history")
    public List<HistoryRecordResponseDTO> historyRecordsApi(@RequestParam(name = "Authorization") String auth){
        Account account = checkAuth(auth);

        if (account == null){
            throw new ResponseStatusException(UNAUTHORIZED, "You do not have the permission");
        }

        return historyRecordService.findUserHistoryRecord(account)
                .stream()
                .map(HistoryRecordMapper::map).toList();
    }
}
