package com.elec5619.bloodsystem.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class HistoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long historyId;

    private HistoryType historyType;

    private Double Measure;

    private String location;

    private String date;

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
}
