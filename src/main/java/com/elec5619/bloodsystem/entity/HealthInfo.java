package com.elec5619.bloodsystem.entity;

import io.swagger.models.auth.In;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
public class HealthInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long healthInfoId;

    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    private Integer age;


    public Long getHealthInfoId() {
        return healthInfoId;
    }

    public void setHealthInfoId(Long healthInfoId) {
        this.healthInfoId = healthInfoId;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
