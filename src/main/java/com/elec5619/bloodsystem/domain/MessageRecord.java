package com.elec5619.bloodsystem.domain;

import javax.persistence.*;

/**
 * The type Message record.
 */
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

    /**
     * Instantiates a new Message record.
     *
     * @param sender        the sender
     * @param receiver      the receiver
     * @param subject       the subject
     * @param content       the content
     * @param date          the date
     * @param account       the account
     * @param historyRecord the history record
     * @param haveRead      the have read
     */
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

    /**
     * Instantiates a new Message record.
     */
    public MessageRecord() {
    }

    @ManyToOne
    @JoinColumn(name = "historyRecordId")
    private HistoryRecord historyRecord;


    /**
     * Gets message id.
     *
     * @return the message id
     */
    public Long getMessageId() {
        return messageId;
    }

    /**
     * Sets message id.
     *
     * @param messageId the message id
     */
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    /**
     * Gets sender.
     *
     * @return the sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * Sets sender.
     *
     * @param sender the sender
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * Gets receiver.
     *
     * @return the receiver
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * Sets receiver.
     *
     * @param receiver the receiver
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * Gets subject.
     *
     * @return the subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Sets subject.
     *
     * @param subject the subject
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
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
     * Gets history record.
     *
     * @return the history record
     */
    public HistoryRecord getHistoryRecord() {
        return historyRecord;
    }

    /**
     * Sets history record.
     *
     * @param historyRecord the history record
     */
    public void setHistoryRecord(HistoryRecord historyRecord) {
        this.historyRecord = historyRecord;
    }

    /**
     * Gets have read.
     *
     * @return the have read
     */
    public Boolean getHaveRead() {
        return haveRead;
    }

    /**
     * Sets have read.
     *
     * @param haveRead the have read
     */
    public void setHaveRead(Boolean haveRead) {
        this.haveRead = haveRead;
    }

}
