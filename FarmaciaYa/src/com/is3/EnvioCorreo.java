package com.is3;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnvioCorreo {
 
	static Properties mailServerProperties;
	static Session getMailSession;
	
	public static void main(String args[])throws AddressException, MessagingException {
		String correo = "gdotta30@gmail.com";
		
		EnvioCorreo.enviarCorreoConfirmarUsuario(correo);
	}
	
	public static void enviarCorreoRecuperarPassword(String correo) throws AddressException, MessagingException {
		
		MimeMessage mailMessage = new MimeMessage(getMailSession);
		mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
	
		mailMessage.setSubject(Parameters.getParameter("recuperarPasswordSubject"));
		
		String urlLink = Parameters.getParameter("urlRecoverPassword")+"?userid="+correo;
		
		String emailBody = Parameters.getParameter("recuperarPasswordBody").replace("#link#","<a href='"+urlLink+"'>aqui</a>");
		mailMessage.setContent(emailBody, "text/html");
		EnvioCorreo.enviarCorreo(mailMessage);
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}
	
	public static void enviarCorreoConfirmarUsuario(String correo) throws AddressException, MessagingException {
		
		MimeMessage mailMessage = new MimeMessage(getMailSession);
		mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
	
		mailMessage.setSubject(Parameters.getParameter("confirmarUsuarioSubject"));
		
		String urlLink = Parameters.getParameter("urlConfirmarUsuario")+"?userid="+correo;
		
		String emailBody = Parameters.getParameter("confirmarUsuarioBody").replace("#link#","<a href='"+urlLink+"'>aqui</a>");
		mailMessage.setContent(emailBody, "text/html");
		EnvioCorreo.enviarCorreo(mailMessage);
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}
	
	public static void enviarCorreo(MimeMessage mailMessage) throws AddressException, MessagingException {
		
		String userGmail = Parameters.getParameter("correo");
		String password = Parameters.getParameter("password");
		
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
 
		transport.connect("smtp.gmail.com", userGmail, password);
		transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
		transport.close();
	}
	
	public static boolean verificarCorreo(String correo)
	{
		return true;
	}
}