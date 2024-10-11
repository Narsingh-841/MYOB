package com.asis;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import com.asis.util.BaseClass;

public class Main extends BaseClass{

	public void emailToUser(){
		String from = "topgst@theoutsourcepro.com.au";
		// Sender's password
		String password = "Guf87765" ;
		// Receiver's email address
		String senderMail = SENDER_TO;
		String firstPath = "C:/Users/";
		String user_name = USERNAME;
		String secondPath = "/.jenkins/workspace/GST_Reconciliation_Parameters";
		String finalPath = firstPath+user_name+secondPath;
		String emailBody="Hello User,\nThank you for using our service and looking forward for more such opportunities/nYour GST file would be in the following folder"  +finalPath;

		// Outlook SMTP server configuration
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		// Creating a session object
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			// Creating a default MimeMessage object
			Message message = new MimeMessage(session);
			// Set From: header field of the header
			message.setFrom(new InternetAddress(from));
			// Set To: header field of the header
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(senderMail));
			// Set Subject: header field
			message.setSubject("Testing Email from Java");
			// Now set the actual message
			message.setText(emailBody);

			// Send message
			Transport.send(message);
			System.out.println("Email sent successfully.");
			System.out.println(firstPath+user_name+secondPath);
			System.out.println(finalPath);
		} catch (AuthenticationFailedException e) {
			System.out.println("Authentication failed. Please check your credentials and try again.");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}