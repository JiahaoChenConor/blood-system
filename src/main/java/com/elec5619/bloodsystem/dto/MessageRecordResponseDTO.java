package com.elec5619.bloodsystem.dto;

import com.elec5619.bloodsystem.domain.Subject;

public class MessageRecordResponseDTO {

    private Subject subject;

    private String content;

    private String date;

    public MessageRecordResponseDTO(Subject subject, String content, String date) {
        this.subject = subject;
        this.content = content;
        this.date = date;
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
}
