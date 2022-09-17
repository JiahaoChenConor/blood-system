package com.elec5619.bloodsystem.entity;

import javax.persistence.*;

@Entity
public class MessageRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messageId;

    private String sender;

    private String receiver;

    @Enumerated(EnumType.STRING)
    private Subject subject;

    private String content;

    private String date;

    private Boolean haveRead;



    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    public MessageRecord(String sender, String receiver, Subject subject, String content, String date, Account account, HistoryRecord historyRecord, Boolean haveRead) {
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.content = content;
        this.date = date;
        this.account = account;
        this.historyRecord = historyRecord;
        this.haveRead = haveRead;
    }

    public MessageRecord() {
    }

    @ManyToOne
    @JoinColumn(name = "historyRecordId")
    private HistoryRecord historyRecord;


    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public HistoryRecord getHistoryRecord() {
        return historyRecord;
    }

    public void setHistoryRecord(HistoryRecord historyRecord) {
        this.historyRecord = historyRecord;
    }

    public Boolean getHaveRead() {
        return haveRead;
    }

    public void setHaveRead(Boolean haveRead) {
        this.haveRead = haveRead;
    }

}
