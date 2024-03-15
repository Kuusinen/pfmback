package com.rogue.pfm.service;

import java.util.Date;
import java.util.Properties;

import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message.RecipientType;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailServiceImpl implements EmailService {

	@Override
	public void sendEmail(final String adresses, final String message, final String productInvolve) {

		final Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		final Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
                        	return new PasswordAuthentication("petitfilmodele@gmail.com", "tocu gylt qfnv pjtg ");
			}
		});

		final MimeMessage msg = new MimeMessage(session);

		try {
			msg.setRecipients(RecipientType.TO, InternetAddress.parse("petitfilmodele@gmail.com"));
			msg.setSubject("Pfm message de contact");
			msg.setContent("Pfm message de contact", "text/html");
			msg.setSentDate(new Date());

			final MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(message, "text/html");

			final Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			msg.setContent(multipart);
			Transport.send(msg);

		} catch (final MessagingException e) {
			e.printStackTrace();
		}
	}
}
