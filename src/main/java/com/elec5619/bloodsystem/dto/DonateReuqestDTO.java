package com.elec5619.bloodsystem.dto;

import com.elec5619.bloodsystem.domain.BloodType;

public class DonateReuqestDTO {
    private BloodType bloodType;
    private Double Cc;

    private String location;
    private String date;

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public Double getCc() {
        return Cc;
    }

    public void setCc(Double cc) {
        Cc = cc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
