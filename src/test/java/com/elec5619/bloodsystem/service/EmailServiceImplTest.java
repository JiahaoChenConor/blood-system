package com.elec5619.bloodsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.elec5619.bloodsystem.entity.EmailDetails;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.ConfigurableMimeFileTypeMap;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmailServiceImpl.class})
@ExtendWith(SpringExtension.class)
class EmailServiceImplTest {
    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @MockBean
    private JavaMailSender javaMailSender;

    /**
     * Method under test: {@link EmailServiceImpl#sendSimpleMail(EmailDetails)}
     */
    @Test
    void testSendSimpleMail() throws MailException {
        doNothing().when(javaMailSender).send((SimpleMailMessage) any());

        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setAttachment("Attachment");
        emailDetails.setMsgBody("Not all who wander are lost");
        emailDetails.setRecipient("Recipient");
        emailDetails.setSubject("Hello from the Dreaming Spires");
        assertEquals("Mail Sent Successfully...", emailServiceImpl.sendSimpleMail(emailDetails));
        verify(javaMailSender).send((SimpleMailMessage) any());
    }

    /**
     * Method under test: {@link EmailServiceImpl#sendMailWithAttachment(EmailDetails)}
     */
    @Test
    void testSendMailWithAttachment() throws MailException {
        doNothing().when(javaMailSender).send((MimeMessage) any());
        when(javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));

        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setAttachment("Attachment");
        emailDetails.setMsgBody("Not all who wander are lost");
        emailDetails.setRecipient("Recipient");
        emailDetails.setSubject("Hello from the Dreaming Spires");
        assertEquals("Mail sent Successfully", emailServiceImpl.sendMailWithAttachment(emailDetails));
        verify(javaMailSender).createMimeMessage();
        verify(javaMailSender).send((MimeMessage) any());
    }



    /**
     * Method under test: {@link EmailServiceImpl#sendMailWithAttachment(EmailDetails)}
     */
    @Test
    void testSendMailWithAttachment3() throws MailException {
        doNothing().when(javaMailSender).send((MimeMessage) any());
        when(javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        EmailDetails emailDetails = mock(EmailDetails.class);
        when(emailDetails.getAttachment()).thenReturn("Attachment");
        when(emailDetails.getSubject()).thenReturn("Hello from the Dreaming Spires");
        when(emailDetails.getMsgBody()).thenReturn("Not all who wander are lost");
        when(emailDetails.getRecipient()).thenReturn("");
        doNothing().when(emailDetails).setAttachment((String) any());
        doNothing().when(emailDetails).setMsgBody((String) any());
        doNothing().when(emailDetails).setRecipient((String) any());
        doNothing().when(emailDetails).setSubject((String) any());
        emailDetails.setAttachment("Attachment");
        emailDetails.setMsgBody("Not all who wander are lost");
        emailDetails.setRecipient("Recipient");
        emailDetails.setSubject("Hello from the Dreaming Spires");
        assertEquals("Error while sending mail!!!", emailServiceImpl.sendMailWithAttachment(emailDetails));
        verify(javaMailSender).createMimeMessage();
        verify(emailDetails).getRecipient();
        verify(emailDetails).setAttachment((String) any());
        verify(emailDetails).setMsgBody((String) any());
        verify(emailDetails).setRecipient((String) any());
        verify(emailDetails).setSubject((String) any());
    }

    /**
     * Method under test: {@link EmailServiceImpl#getJavaMailSender()}
     */
    @Test
    void testGetJavaMailSender() {
        assertEquals("conorfortesting@gmail.com",
                ((JavaMailSenderImpl) emailServiceImpl.getJavaMailSender()).getUsername());
        assertTrue(((JavaMailSenderImpl) emailServiceImpl.getJavaMailSender())
                .getDefaultFileTypeMap() instanceof ConfigurableMimeFileTypeMap);
        assertEquals(4, ((JavaMailSenderImpl) emailServiceImpl.getJavaMailSender()).getJavaMailProperties().size());
        assertEquals("lyhhbzmqtqwulygp", ((JavaMailSenderImpl) emailServiceImpl.getJavaMailSender()).getPassword());
        assertEquals("smtp.gmail.com", ((JavaMailSenderImpl) emailServiceImpl.getJavaMailSender()).getHost());
        assertEquals(587, ((JavaMailSenderImpl) emailServiceImpl.getJavaMailSender()).getPort());
    }
}

