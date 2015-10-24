package com.is3;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import com.is3.bo.Farmacia;
import com.is3.bo.Orden;
import com.is3.bo.Producto;
import com.is3.dto.Posicion;

public class EnvioCorreo {
 
	static Properties mailServerProperties;
	static Session getMailSession;
	
	public static void main(String args[])throws AddressException, MessagingException {

		try {
			Posicion p = new Posicion();
			p.setLatitud(new Float("-34.755950"));
			p.setLongitud(new Float("-55.726902"));
			
			Posicion p2 = new Posicion();
			p2.setLatitud(new Float("-34.766620"));
			p2.setLongitud(new Float("-55.764409"));
			 
			Posicion p3 = new Posicion();
			p3.setLatitud(new Float("-34.765573"));
			p3.setLongitud(new Float("-55.755245"));
			
			if (p.estaCerca(p2, 1000)){
				System.out.println("si esta al toque");

			}else{
				System.out.println("ni a palo");

			}
			
			PersistenceHelper per = new PersistenceHelper();
			System.out.println("tiro select");
			List <Farmacia> farmacias = per.obtenerFarmaciasCercanas(p);
			if (farmacias.size()>0){
				for (Farmacia farm : farmacias){
					System.out.println(farm.getNombre());
				}
			}else{
				System.out.println("sin registros");
			}

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
		
		String emailBody = Parameters.getParameter("pedidoRegistradoBody").replace("#clienteNombre#",orden.getUsuario().getNombreCompleto());
		
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
		
		/*
		String prueba = "<form method='post' name='contact_form' " + 
							" action='http://localhost:8080/FarmaciaYa/ConfirmarMail'>" + 
							" <input type='submit' class='submitLink' value='Submit'>Click Aqui</form>";	
		
		String emailBody = Parameters.getParameter("confirmarUsuarioBody").replace("#link#",prueba);
		*/
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