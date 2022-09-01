package com.elec5619.bloodsystem.controller;


import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.security.PasswordValidation;
import com.elec5619.bloodsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.regex.Pattern;

import static com.elec5619.bloodsystem.status.RegisterStatus.*;

@Controller


public class IndexController {



    @Autowired
    AccountService accountService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping("/")
    public String index() {
        return "index";
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
    public String indexAfterLogin(){
        return "index-user";
    }

    @GetMapping("/index-admin")
    public String indexAfterLoginAdmin(){
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

        return "register";
    }



}
