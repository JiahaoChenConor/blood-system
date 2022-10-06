package com.elec5619.bloodsystem.controller;

import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.BloodType;
import com.elec5619.bloodsystem.entity.HealthInfo;
import com.elec5619.bloodsystem.service.AccountService;
import com.elec5619.bloodsystem.service.HealthInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Health info controller.
 */
@Controller
public class HealthInfoController {

    /**
     * The Account service.
     */
    @Autowired
    AccountService accountService;

    /**
     * The Health info service.
     */
    @Autowired
    HealthInfoService healthInfoService;

    /**
     * Health info page string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/health-info")
    public String healthInfoPage(Model model){
        accountService.addCurrentUser(model);
        return "health-info";
    }


    /**
     * Edit health info string.
     *
     * @param bloodType the blood type
     * @param age       the age
     * @return the string
     */
    @PostMapping("/health-info")
    @ResponseBody
    public String editHealthInfo(@RequestParam(value = "bloodType", required = false) String bloodType,
                                 @RequestParam(value = "age", required = false) String age){

        System.out.println(age + "XXXXx");
        Account account = accountService.getCurrentAccount();

        if (account.getHealthInfo() == null){
            HealthInfo healthInfo = new HealthInfo();

            if (bloodType != null){
                switch (bloodType) {
                    case "A" -> healthInfo.setBloodType(BloodType.A);
                    case "B" -> healthInfo.setBloodType(BloodType.B);
                    case "AB" -> healthInfo.setBloodType(BloodType.AB);
                    case "O" -> healthInfo.setBloodType(BloodType.O);
                }
            }

            if (age != null){
                try{
                    healthInfo.setAge(Integer.parseInt(age));
                }catch (Exception e){
                    throw new IllegalArgumentException("age Must be integer");
                }

            }

            healthInfoService.saveHealthInfo(healthInfo);
            accountService.setHealthInfo(healthInfo, account.getId());
        }else {
            HealthInfo healthInfo = account.getHealthInfo();

            Long healthInfoId = healthInfo.getHealthInfoId();

            if (bloodType != null){
                switch (bloodType) {
                    case "A" -> healthInfoService.updateBloodTypeById(healthInfoId, BloodType.A);
                    case "B" -> healthInfoService.updateBloodTypeById(healthInfoId, BloodType.B);
                    case "AB" -> healthInfoService.updateBloodTypeById(healthInfoId, BloodType.AB);
                    case "O" -> healthInfoService.updateBloodTypeById(healthInfoId, BloodType.O);
                }
            }

            if (age != null){
                try{
                    healthInfoService.updateAgeById(healthInfoId, Integer.parseInt(age));
                }catch (Exception e){
                    throw new IllegalArgumentException("age Must be integer");
                }

            }
        }

        return  "true";

    }


    /**
     * Get age string.
     *
     * @return the string
     */
    @PostMapping("/health-info/age")
    @ResponseBody
    public String getAge(){
        Account account = accountService.getCurrentAccount();
        if (account.getHealthInfo() == null){
            return "18";
        }else{
            HealthInfo healthInfo = account.getHealthInfo();
            if (healthInfo.getAge() == null){
                return "18";
            }else{
                return healthInfo.getAge().toString();
            }
        }
    }

    /**
     * Get blood type string.
     *
     * @return the string
     */
    @PostMapping("/health-info/blood-type")
    @ResponseBody
    public String getBloodType(){
        Account account = accountService.getCurrentAccount();
        if (account.getHealthInfo() == null){
            return "A";
        }else{
            HealthInfo healthInfo = account.getHealthInfo();
            if (healthInfo.getBloodType() == null){
                return "A";
            }else{
                return healthInfo.getBloodType().toString();
            }
        }
    }

    /**
     * File up load string.
     *
     * @param request the request
     * @param upload  the upload
     * @return the string
     * @throws Exception the exception
     */
    @RequestMapping("/health-info/upload")
    public String fileUpLoad(HttpServletRequest request, MultipartFile upload) throws Exception {
        // TODO: deal with uploaded file
        return "upload-success";
    }

}
