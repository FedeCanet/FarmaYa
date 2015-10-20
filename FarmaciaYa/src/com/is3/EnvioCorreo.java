package com.is3;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.is3.bo.Orden;
import com.is3.bo.Producto;

public class EnvioCorreo {
 
	static Properties mailServerProperties;
	static Session getMailSession;
	
	public static void main(String args[])throws AddressException, MessagingException {
		try {
			Posicion p = new Posicion();
			p.getDirCiuByLatLong(new BigDecimal("-34.899124"), new BigDecimal("-56.1454787"));
			System.out.println(p.getDireccion());
			System.out.println(p.getCiudad());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String correo = "gdotta30@gmail.com";
		
		//EnvioCorreo.enviarCorreoConfirmarUsuario(correo);
	}
	
	public static void enviarCorreoPedidoRegistrado(Orden orden) throws AddressException, MessagingException {
				
		MimeMessage mailMessage = new MimeMessage(getMailSession);
		mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(orden.getUsuario().getCorreo()));
		
		mailMessage.setSubject(Parameters.getParameter("pedidoRegistradoSubject"));
		
		String emailBody = Parameters.getParameter("pedidoRegistradoBody").replace("#cliente#",orden.getUsuario().getNombreCompleto());
		
		emailBody = emailBody.replace("#farmacia#",orden.getFarmacia().getNombre());
		
		BigDecimal total = BigDecimal.ZERO;
		String listaPedido = "<table>";
		for (Producto p: orden.getProductos()){
			listaPedido += "<tr><td>"+p.getNombre()+"</td><td>"+p.getPrecioUnitario().toString()+"</td></tr>";
			total = total.add(p.getPrecioUnitario());
		}
		listaPedido += "<tr><td style=\"height: 20px;\"></td><td></td></tr>";
		listaPedido += "<tr><td>Total</td><td>"+total.toString()+"</td></tr></table>";
		
		emailBody = emailBody.replace("#detalleOrden#", listaPedido);
		
		mailMessage.setContent(emailBody, "text/html");
		EnvioCorreo.enviarCorreo(mailMessage);
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
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
	
	private static void enviarCorreo(MimeMessage mailMessage) throws AddressException, MessagingException {
		
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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query queryCinco = em.createQuery("SELECT u.correo " +
				"FROM Usuario u " +
				"where u.correo = :correo");

		queryCinco.setParameter("correo", correo);
		
		ArrayList usuarios = (ArrayList)queryCinco.getResultList();
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		if(usuarios.size() > 0){
			return true;
		}else{
			return false;
		}
	}
}