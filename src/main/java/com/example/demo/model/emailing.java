package com.example.demo.model;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class emailing {
	public void send_email(ContactUs contact) {
		// Sender's email address
        String senderEmail = "ayanokoji01052000@gmail.com";
        // Sender's email password
        String senderPassword = "qouw hpuq zwgp bljk";

        // Recipient's email address
        String recipientEmail = "angelosieon01@gmail.com";

        // Set the host and properties for the SMTP server (e.g., Gmail)
        String host = "smtp.gmail.com";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        // Get the Session object and create a MimeMessage object
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set From: header field of the header
            message.setFrom(new InternetAddress(senderEmail));

            // Set To: header field of the header
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

            // Set Subject: header field
            message.setSubject("Quotation from :"+contact.getU_email());

            // Now set the actual message
            String msg="Name:"+contact.getUser_firstname()+" "+contact.getUser_lastname()+"\n MESSAGE:"+contact.getU_message()+"\n Phone number:"+contact.getUser_phonenumber()+"\nProduct:"+contact.getU_products();
            message.setText(msg);

            session.setDebug(true);
            // Send the message
            Transport.send(message);
            
         
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
