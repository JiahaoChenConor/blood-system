package com.elec5619.bloodsystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/index-user")
    public String indexAfterLogin(){
        return "index-user";
    }

    @GetMapping("/logout")
    public String indexAfterLogout(){
        return "index";
    }
}
