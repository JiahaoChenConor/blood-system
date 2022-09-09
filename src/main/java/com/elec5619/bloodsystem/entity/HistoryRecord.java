package com.elec5619.bloodsystem.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class HistoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long historyId;


    @Enumerated(EnumType.STRING)
    private HistoryType historyType;

    private Double Measure;

    @Enumerated(EnumType.STRING)
    private BloodType bloodType;


    private String location;

    private String date;

    private Boolean matched;


    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    @OneToMany(mappedBy = "historyRecord")
    private List<MessageRecord> messagesInHistory;


    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<MessageRecord> getMessagesInHistory() {
        return messagesInHistory;
    }

    public void setMessagesInHistory(List<MessageRecord> messagesInHistory) {
        this.messagesInHistory = messagesInHistory;
    }


    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public Boolean getMatched() {
        return matched;
    }

    public void setMatched(Boolean matched) {
        this.matched = matched;
    }

}
