package com.elec5619.bloodsystem.controller;

import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.Gender;
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
    public String editProfile(@RequestParam(value = "firstName", required = false) String firstName,
                              @RequestParam(value = "lastName", required = false) String lastName,
                              @RequestParam(value = "gender", required = false) String gender,
                              @RequestParam(value = "dateOfBirth", required = false) String dateOfBirth,
                              @RequestParam(value = "mobileNum", required = false) String mobileNum){

        Account account = accountService.getCurrentAccount();

        if (account.getProfile() == null){
            Profile profile = new Profile();
            if (firstName != null){
                profile.setFirstName(firstName);
            }
            if (lastName != null){
                profile.setLastName(lastName);
            }

            if (gender != null){
                if (gender.equals("male")){
                    profile.setGender(Gender.MALE);
                }else if (gender.equals("female")){
                    profile.setGender(Gender.FEMALE);
                }else{
                    profile.setGender(Gender.OTHER);
                }
            }

            if (dateOfBirth != null){
                profile.setDateOfBirth(dateOfBirth);
            }

            if (mobileNum != null){
                profile.setMobileNum(mobileNum);
            }

            profileService.saveProfile(profile);
            accountService.setProfile(profile, account.getId());

        }else{
            Profile profile = account.getProfile();
            Long profileId = profile.getProfileId();

            if (firstName != null){
                profileService.updateFirstNameById(profileId, firstName);
            }
            if (lastName != null){
                profileService.updateLastNameById(profileId, lastName);
            }

            if (gender != null){
                if (gender.equals("male")){
                    profileService.updateGenderById(profileId, Gender.MALE);
                }else if (gender.equals("female")){
                    profileService.updateGenderById(profileId, Gender.FEMALE);
                }else{
                    profileService.updateGenderById(profileId, Gender.OTHER);
                }
            }

            if (dateOfBirth != null){
                profileService.updateDateOfBirthById(profileId, dateOfBirth);
            }

            if (mobileNum != null){
                profileService.updateMobileNumById(profileId, mobileNum);
            }

            // edit profile
        }
        return "true";
    }


    @PostMapping("/profile/get-gender")
    @ResponseBody
    public String getGender(){
        Account account = accountService.getCurrentAccount();
        if (account.getProfile() == null){
            return "male";
        }else{
            Profile profile = account.getProfile();
            if (profile.getGender() == null){
                return "male";
            }else{
                return profile.getGender().toString();
            }
        }
    }
}
