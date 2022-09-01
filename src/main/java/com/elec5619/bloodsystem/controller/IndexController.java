package com.elec5619.bloodsystem.controller;


import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
                           @Param("rePassword") String rePassword){
        if (email == null || password == null || rePassword == null){
            System.out.println(email);
            System.out.println(password);
            System.out.println(rePassword);
            throw new IllegalStateException("register null");
        }


        if (!password.equals(rePassword)){
            throw new IllegalStateException("password not the same.");
        }

        Account account = new Account();
        account.setEmail(email);
        account.setPassword(passwordEncoder.encode(password));


        accountService.register(account);

        return "index";
    }



}
