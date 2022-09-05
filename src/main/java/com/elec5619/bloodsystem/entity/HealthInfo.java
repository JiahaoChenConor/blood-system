package com.elec5619.bloodsystem.entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HealthInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long healthInfoId;

    private BloodType bloodType;

    private int age;


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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
