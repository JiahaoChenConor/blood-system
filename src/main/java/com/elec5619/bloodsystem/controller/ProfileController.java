package com.elec5619.bloodsystem.controller;

import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.Profile;
import com.elec5619.bloodsystem.service.AccountService;
import com.elec5619.bloodsystem.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProfileController {
    @Autowired
    AccountService accountService;

    @Autowired
    ProfileService profileService;

    @GetMapping("/profile")
    public String profilePage(Model model){
        accountService.addCurrentUser(model);
        Account account = accountService.getCurrentAccount();

        if (account.getProfile() == null){
            model.addAttribute("firstName", "N/A");
            model.addAttribute("lastName", "N/A");
            model.addAttribute("dob", "00/00/0000");
            model.addAttribute("gender", "other");
            model.addAttribute("mobileNum", "0421000000");
        }else{
            Profile profile = account.getProfile();
            if (profile.getFirstName() == null){
                model.addAttribute("firstName", "N/A");
            }else{
                model.addAttribute("firstName", profile.getFirstName());
            }

            if (profile.getLastName() == null){
                model.addAttribute("lastName", "N/A");
            }else{
                model.addAttribute("lastName", profile.getLastName());
            }

            if (profile.getDateOfBirth() == null){
                model.addAttribute("dob", "00/00/0000");
            }else{
                model.addAttribute("dob", profile.getDateOfBirth());
            }

            if (profile.getGender() == null){
                model.addAttribute("gender", "other");
            }else{
                model.addAttribute("gender", profile.getGender());
            }


            if (profile.getMobileNum() == null){
                model.addAttribute("mobileNum", "0421000000");
            }else{
                model.addAttribute("mobileNum", profile.getMobileNum());
            }

        }


        model.addAttribute("email", accountService.getCurrentUserEmail());
        return "profile";
    }

    @PostMapping("/profile")
    @ResponseBody
    public String editProfile(@RequestParam("firstName") String firstName){
        Account account = accountService.getCurrentAccount();
        System.out.println(firstName + "XXXXXXX");

        if (account.getProfile() == null){
            Profile profile = new Profile();
            profile.setFirstName(firstName);
            profileService.saveProfile(profile);
            accountService.setProfile(profile, account.getId());
        }else{
            Profile profile = account.getProfile();
            Long profileId = profile.getProfileId();
            profileService.updateFirstNameById(profileId, firstName);
            // edit profile
        }
        return "true";
    }


}
