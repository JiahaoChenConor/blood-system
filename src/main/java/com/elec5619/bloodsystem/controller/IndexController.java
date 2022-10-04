package com.elec5619.bloodsystem.controller;


import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.HistoryRecord;
import com.elec5619.bloodsystem.entity.MessageRecord;
import com.elec5619.bloodsystem.entity.Provider;
import com.elec5619.bloodsystem.security.PasswordValidation;
import com.elec5619.bloodsystem.service.AccountService;
import com.elec5619.bloodsystem.service.HistoryRecordService;
import com.elec5619.bloodsystem.service.MessageRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.elec5619.bloodsystem.status.RegisterStatus.*;

@Controller
public class IndexController {

    @Autowired
    HistoryRecordService historyRecordService;
    @Autowired
    AccountService accountService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Autowired
    MessageRecordService messageRecordService;

    @RequestMapping("/")
    public String index(Model model) {
        List<HistoryRecord> historyRecords = historyRecordService.getUrgentRequestRecordInWaitingList();
        Map<String, List<HistoryRecord>> messages = new HashMap<>() {{
            put("history", historyRecords);
        }};

        model.addAttribute("history", messages);


        return "index";
    }

    @RequestMapping("/faq")
    public String faq(Model model) {


        return "faq";
    }

    @RequestMapping("/about")
    public String about(Model model) {

        return "about";
    }

    @RequestMapping("/faq-user")
    public String faqUser(Model model) {
        accountService.addCurrentUser(model);
        return "faq-user";
    }

    @RequestMapping("/about-user")
    public String aboutUser(Model model) {
        accountService.addCurrentUser(model);
        return "about-user";
    }




    @GetMapping("/login")
    // required=false, since if param not exists, there is error.
    public String login(@RequestParam(required=false) boolean loginError,
                        Model model)
    {
        model.addAttribute("loginError", loginError);
        return "login";
    }




    @GetMapping("/index-user")
    public String indexAfterLogin(Model model){

        accountService.addCurrentUser(model);
        List<HistoryRecord> historyRecords = historyRecordService.getUrgentRequestRecordInWaitingList();
        Map<String, List<HistoryRecord>> messages = new HashMap<>() {{
            put("history", historyRecords);
        }};

        model.addAttribute("history", messages);

        return "index-user";
    }

    @GetMapping("/index-admin")
    public String indexAfterLoginAdmin(Model model){

        accountService.addCurrentUser(model);

        List<Account> accounts = accountService.getAllAccounts();

        Map<String, List<Account>> messages = new HashMap<>() {{
            put("users", accounts);
        }};

        model.addAttribute("users", messages);

        return "index-admin";
    }

    @GetMapping("/logout")
    public String indexAfterLogout(){
        return "index";
    }

    @GetMapping("/register")
    public String redirectRegisterPage(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@Param("email") String email,
                            @Param("password") String password,
                           @Param("rePassword") String rePassword,
                           Model model){

        if (email == null || password == null || rePassword == null
            || email.isEmpty() || password.isEmpty() || rePassword.isEmpty()){
            model.addAttribute("registerStatus", EMPTY_ERROR.toString());
            return "register";
        }

        if (!PasswordValidation.isValid(password)){
            model.addAttribute("registerStatus", PASSWORD_NOT_VALID.toString());
            return "register";
        }
        if (!password.equals(rePassword)){
            model.addAttribute("registerStatus", PASSWORD_NOT_SAME.toString());
            return "register";
        }

        if (accountService.accountExists(email)){
            model.addAttribute("registerStatus", EMAIL_EXISTS.toString());
            return "register";
        }


        Account account = new Account();
        account.setEmail(email);
        account.setPassword(passwordEncoder.encode(password));


        accountService.register(account);

        model.addAttribute("registerStatus", SUCCESS_REGISTER.toString());

        return "login";
    }


    @RequestMapping(value = "/user")
    public Principal user(Principal principal) {
        return principal;
    }


}
