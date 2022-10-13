package com.elec5619.bloodsystem.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class UrgentPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long urgentId;

    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    private Boolean matched;

    private String location;

    private String content;

    private String date;


    private Double Measure;

    private Long correspondHistoryRecordId;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Get urgent id
     *
     * @return urgent id
     */
    public Long getUrgentId() {
        return urgentId;
    }

    /**
     *  Set urgent id
     * @param urgentId
     */
    public void setUrgentId(Long urgentId) {
        this.urgentId = urgentId;
    }

    /**
     * Get blood type
     * @return Blood type
     */
    public BloodType getBloodType() {
        return bloodType;
    }

    /**
     * Set blood type
     * @param bloodType
     */

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getMatched() {
        return matched;
    }

    public void setMatched(Boolean matched) {
        this.matched = matched;
    }

    public Double getMeasure() {
        return Measure;
    }

    public void setMeasure(Double measure) {
        Measure = measure;
    }

    public Long getCorrespondHistoryRecordId() {
        return correspondHistoryRecordId;
    }

    public void setCorrespondHistoryRecordId(Long correspondHistoryRecordId) {
        this.correspondHistoryRecordId = correspondHistoryRecordId;
    }

}
