package com.elec5619.bloodsystem.controller;


import com.elec5619.bloodsystem.domain.Account;
import com.elec5619.bloodsystem.domain.HistoryRecord;
import com.elec5619.bloodsystem.domain.UrgentPost;
import com.elec5619.bloodsystem.security.PasswordValidation;
import com.elec5619.bloodsystem.service.AccountService;
import com.elec5619.bloodsystem.service.HistoryRecordService;
import com.elec5619.bloodsystem.service.MessageRecordService;
import com.elec5619.bloodsystem.service.UrgentPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.elec5619.bloodsystem.status.RegisterStatus.*;

/**
 * The type Index controller.
 */
@Controller
public class IndexController {

    /**
     * The History record service.
     */
    @Autowired
    HistoryRecordService historyRecordService;
    /**
     * The Account service.
     */
    @Autowired
    AccountService accountService;

    /**
     * The Password encoder.
     */
    @Autowired
    PasswordEncoder passwordEncoder;


    /**
     * The Message record service.
     */
    @Autowired
    MessageRecordService messageRecordService;

    /**
     * The Urgent post service
     */
    @Autowired
    UrgentPostService urgentPostService;

    /**
     * Index string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping("/")
    public String index(Model model) {

        List<UrgentPost> urgentPosts = urgentPostService.getAllUrgentPost();

        Map<String, List<UrgentPost>> messages = new HashMap<>() {{
            put("urgent", urgentPosts);
        }};


        model.addAttribute("urgent", messages);


        return "index";
    }

    /**
     * Faq string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping("/faq")
    public String faq(Model model) {


        return "faq";
    }

    /**
     * About string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping("/about")
    public String about(Model model) {

        return "about";
    }

    /**
     * Faq user string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping("/faq-user")
    public String faqUser(Model model) {
        accountService.addCurrentUser(model);
        return "faq-user";
    }

    /**
     * About user string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping("/about-user")
    public String aboutUser(Model model) {
        accountService.addCurrentUser(model);
        return "about-user";
    }


    /**
     * Login string.
     *
     * @param loginError the login error
     * @param model      the model
     * @return the string
     */
    @GetMapping("/login")
    // required=false, since if param not exists, there is error.
    public String login(@RequestParam(required=false) boolean loginError,
                        Model model)
    {
        model.addAttribute("loginError", loginError);
        return "login";
    }


    /**
     * Index after login string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/index-user")
    public String indexAfterLogin(Model model){

        accountService.addCurrentUser(model);

        List<UrgentPost> urgentPosts = urgentPostService.getAvailableUrgentPost(accountService.getCurrentAccount());

        Map<String, List<UrgentPost>> messages = new HashMap<>() {{
            put("urgent", urgentPosts);
        }};


        model.addAttribute("urgent", messages);

        return "index-user";
    }

    /**
     * Index after login admin string.
     *
     * @param model the model
     * @return the string
     */
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

    /**
     * Index after logout string.
     *
     * @return the string
     */
    @GetMapping("/logout")
    public String indexAfterLogout(Model model){

        List<UrgentPost> urgentPosts = urgentPostService.getAllUrgentPost();

        Map<String, List<UrgentPost>> messages = new HashMap<>() {{
            put("urgent", urgentPosts);
        }};


        model.addAttribute("urgent", messages);

        return "index";
    }

    /**
     * Redirect register page string.
     *
     * @return the string
     */
    @GetMapping("/register")
    public String redirectRegisterPage(){
        return "register";
    }

    /**
     * Register string.
     *
     * @param email      the email
     * @param password   the password
     * @param rePassword the re password
     * @param model      the model
     * @return the string
     */
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


    /**
     * User principal.
     *
     * @param principal the principal
     * @return the principal
     */
    @RequestMapping(value = "/user")
    public Principal user(Principal principal) {
        return principal;
    }


}
