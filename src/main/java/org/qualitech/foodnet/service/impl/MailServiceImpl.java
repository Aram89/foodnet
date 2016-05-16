package org.qualitech.foodnet.service.impl;

import org.qualitech.foodnet.domain.Message;
import org.qualitech.foodnet.service.MailService;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Service
public class MailServiceImpl implements MailService {

    private static final String host = "mail.narinj.am";
    private static final String user = "support@narinj.am";
    private static final String password = "Zugamet2";


    @Override
    public void send(Message message) {
        // Get system properties
        Properties props = System.getProperties();
        Authenticator auth = new SMTPAuthenticator();
        // Get the default Session object.
        Session session = Session.getDefaultInstance(props, auth);
        // Setup mail server
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");

        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(new InternetAddress(message.getSender()));
            InternetAddress[] address = {new InternetAddress(user)};
            mimeMessage.setRecipients(MimeMessage.RecipientType.TO, address);
            mimeMessage.setSubject(message.getSubject());
            mimeMessage.setSentDate(new Date());
            mimeMessage.setText(message.getBody());
            Transport.send(mimeMessage);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

    private class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, password);
        }
    }
}
