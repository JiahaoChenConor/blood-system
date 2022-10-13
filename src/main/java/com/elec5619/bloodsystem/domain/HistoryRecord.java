package com.elec5619.bloodsystem.domain;


import javax.persistence.*;
import java.util.List;

/**
 * The type History record.
 */
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

    private String content;

    private Boolean hasMatchers;

    /**
     * Gets has matchers.
     *
     * @return the has matchers
     */
    public Boolean getHasMatchers() {
        return hasMatchers;
    }

    /**
     * Sets has matchers.
     *
     * @param hasMatchers the has matchers
     */
    public void setHasMatchers(Boolean hasMatchers) {
        this.hasMatchers = hasMatchers;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    @OneToMany(mappedBy = "historyRecord")
    private List<MessageRecord> messagesInHistory;


    /**
     * Gets history id.
     *
     * @return the history id
     */
    public Long getHistoryId() {
        return historyId;
    }

    /**
     * Sets history id.
     *
     * @param historyId the history id
     */
    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    /**
     * Gets history type.
     *
     * @return the history type
     */
    public HistoryType getHistoryType() {
        return historyType;
    }

    /**
     * Sets history type.
     *
     * @param historyType the history type
     */
    public void setHistoryType(HistoryType historyType) {
        this.historyType = historyType;
    }

    /**
     * Gets measure.
     *
     * @return the measure
     */
    public Double getMeasure() {
        return Measure;
    }

    /**
     * Sets measure.
     *
     * @param measure the measure
     */
    public void setMeasure(Double measure) {
        Measure = measure;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets account.
     *
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Sets account.
     *
     * @param account the account
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Gets messages in history.
     *
     * @return the messages in history
     */
    public List<MessageRecord> getMessagesInHistory() {
        return messagesInHistory;
    }

    /**
     * Sets messages in history.
     *
     * @param messagesInHistory the messages in history
     */
    public void setMessagesInHistory(List<MessageRecord> messagesInHistory) {
        this.messagesInHistory = messagesInHistory;
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
     * Gets matched.
     *
     * @return the matched
     */
    public Boolean getMatched() {
        return matched;
    }

    /**
     * Sets matched.
     *
     * @param matched the matched
     */
    public void setMatched(Boolean matched) {
        this.matched = matched;
    }

}
