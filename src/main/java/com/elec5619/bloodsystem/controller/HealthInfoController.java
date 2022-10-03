package com.elec5619.bloodsystem.controller;

import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.BloodType;
import com.elec5619.bloodsystem.entity.HealthInfo;
import com.elec5619.bloodsystem.entity.Profile;
import com.elec5619.bloodsystem.service.AccountService;
import com.elec5619.bloodsystem.service.HealthInfoService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
public class HealthInfoController {

    @Autowired
    AccountService accountService;

    @Autowired
    HealthInfoService healthInfoService;

    @GetMapping("/health-info")
    public String healthInfoPage(Model model){
        accountService.addCurrentUser(model);
        return "health-info";
    }



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

    @RequestMapping("/health-info/upload")
    public String fileUpLoad(HttpServletRequest request, MultipartFile upload) throws Exception {
        // TODO: deal with uploaded file
//        System.out.println("Uploading file...");
//        String path = request.getSession().getServletContext().getRealPath("/uploads/");
//        File file = new File(path);
//        if(!file.exists()){
//            file.mkdirs();
//        }
//
//        String filename = upload.getOriginalFilename();
//        // make file name unique
//        String uuid = UUID.randomUUID().toString().replace("-", "");
//        filename = uuid+"_"+filename;
//        upload.transferTo(new File(path,filename));
//        Path source = Paths.get("src", "main", "webapp", "uploads", filename);
//        Path dest = Paths.get("data.csv");
//        Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
        return "upload-success";
    }

}
