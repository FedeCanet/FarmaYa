package com.is3;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class envioCorreo {
 
	static Properties mailServerProperties;
	static Session getMailSession;
	
	public static void main(String args[]) throws AddressException, MessagingException {
		MimeMessage mailMessage = new MimeMessage(getMailSession);
		mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("gdotta@simplificasoftware.com"));
	//	mailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("fedeea@gmail.com"));
	//	mailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("nicojfernandez@gmail.com"));
	//	mailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("marrerog.joseluis@gmail.com"));
		mailMessage.setSubject("IMPORTANTE2222, LEER URGENTE.");
		String emailBody = "Puto el que lee" + "<br><br> Regards, <br>Colo Colo.";
		mailMessage.setContent(emailBody, "text/html");
		generateAndSendEmail(mailMessage);
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}
 
	public static void generateAndSendEmail(MimeMessage mailMessage, String userGmail, String password) throws AddressException, MessagingException {
 
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		transport.connect("smtp.gmail.com", "yomevoyalafarmacia@gmail.com", "farmaciaya2015");
		transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
		transport.close();
	}
}