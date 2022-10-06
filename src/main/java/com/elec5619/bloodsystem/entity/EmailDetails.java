package com.elec5619.bloodsystem.entity;


/**
 * The type Email details.
 */
// Class
public class EmailDetails {

    // Class data members
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;

    /**
     * Gets recipient.
     *
     * @return the recipient
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * Sets recipient.
     *
     * @param recipient the recipient
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * Gets msg body.
     *
     * @return the msg body
     */
    public String getMsgBody() {
        return msgBody;
    }

    /**
     * Sets msg body.
     *
     * @param msgBody the msg body
     */
    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    /**
     * Gets subject.
     *
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets subject.
     *
     * @param subject the subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Gets attachment.
     *
     * @return the attachment
     */
    public String getAttachment() {
        return attachment;
    }

    /**
     * Sets attachment.
     *
     * @param attachment the attachment
     */
    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
