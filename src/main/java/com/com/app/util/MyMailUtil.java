package com.com.app.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MyMailUtil {

	@Autowired
	private JavaMailSender sender;

	public boolean send(
		    String to,
		    String cc[],
		    String bcc[],
		    String subject,
		    String text,
		    Resource files[]
		) {
		    if (to == null || to.isEmpty()) {
		        return false;
		    }
		    if (subject == null || subject.isEmpty() || text == null || text.isEmpty()) {
		        return false;
		    }
		    boolean sent = false;
		    try {
		        // 1 create empty message object
		        MimeMessage message = sender.createMimeMessage();

		        // 2 use helper class to set the details
		        MimeMessageHelper helper = new MimeMessageHelper(message, files != null && files.length > 0);

		        // 3 fill message details
		        helper.setTo(to);

		        if (cc != null && cc.length > 0)
		            helper.setCc(cc);

		        if (bcc != null && bcc.length > 0)
		            helper.setBcc(bcc);

		        helper.setSubject(subject);
		        helper.setText(text);

		        if (files != null && files.length > 0) {
		            for (Resource file : files) {
		                if (file != null) {
		                    helper.addAttachment(file.getFilename(), file);
		                }
		            }
		        }
		        // 4 send email
		        sender.send(message);
		        sent = true;

		    } catch (MessagingException e) {
		        e.printStackTrace();
		        sent = false;
		    } catch (MailException e) {
		        e.printStackTrace();
		        sent = false;
		    }
		    return sent;
		}

		/*
		 * overloaded method
		 */

		public boolean send(
		    String to,
		    String subject,
		    String text
		) {
		    return send(to, null, null, subject, text, null);
		}
}