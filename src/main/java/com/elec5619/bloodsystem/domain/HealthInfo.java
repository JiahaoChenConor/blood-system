package com.elec5619.bloodsystem.domain;

import javax.persistence.*;

/**
 * The type Health info.
 */
@Entity
public class HealthInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long healthInfoId;

    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    private Integer age;


    /**
     * Gets health info id.
     *
     * @return the health info id
     */
    public Long getHealthInfoId() {
        return healthInfoId;
    }

    /**
     * Sets health info id.
     *
     * @param healthInfoId the health info id
     */
    public void setHealthInfoId(Long healthInfoId) {
        this.healthInfoId = healthInfoId;
    }

    /**
     * Gets blood type.
     *
     * @return the blood type
     */
    public BloodType getBloodType() {
        return bloodType;
    }

    /**
     * Sets blood type.
     *
     * @param bloodType the blood type
     */
    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}
