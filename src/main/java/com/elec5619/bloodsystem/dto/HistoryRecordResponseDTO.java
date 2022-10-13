package com.elec5619.bloodsystem.dto;

import com.elec5619.bloodsystem.domain.BloodType;
import com.elec5619.bloodsystem.domain.HistoryType;


public class HistoryRecordResponseDTO {

    private HistoryType historyType;

    private Double Measure;

    private BloodType bloodType;

    private String location;

    private String date;

    public HistoryRecordResponseDTO(HistoryType historyType, Double measure, BloodType bloodType, String location, String date) {
        this.historyType = historyType;
        Measure = measure;
        this.bloodType = bloodType;
        this.location = location;
        this.date = date;
    }

    public HistoryType getHistoryType() {
        return historyType;
    }

    public void setHistoryType(HistoryType historyType) {
        this.historyType = historyType;
    }

    public Double getMeasure() {
        return Measure;
    }

    public void setMeasure(Double measure) {
        Measure = measure;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
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
