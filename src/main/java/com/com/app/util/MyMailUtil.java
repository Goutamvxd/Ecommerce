package com.com.app.util;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.com.app.exception.MyMailException;

@Component
public class MyMailUtil {

    @Autowired
    private JavaMailSender sender;

    public boolean send(String to, String[] cc, String[] bcc, String subject, String text, Resource[] files) throws MyMailException {
        if (to == null || to.isEmpty()) {
            return false;
        }
        if (subject == null || subject.isEmpty() || text == null || text.isEmpty()) {
            return false;
        }
        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, files != null && files.length > 0);
            helper.setTo(to);
            if (cc != null && cc.length > 0) {
                helper.setCc(cc);
            }
            if (bcc != null && bcc.length > 0) {
                helper.setBcc(bcc);
            }
            helper.setSubject(subject);
            helper.setText(text);
            if (files != null && files.length > 0) {
                for (Resource file : files) {
                    if (file != null) {
                        helper.addAttachment(file.getFilename(), file);
                    }
                }
            }
            sender.send(message);
            return true;
        } catch (MessagingException | MailException e) {
            throw new MyMailException("Failed to send email.", e);
        }
    }

    public boolean send(String to, String subject, String text) throws MyMailException {
        return send(to, new String[0], new String[0], subject, text, new Resource[0]);
    }
}
