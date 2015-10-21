package com.is3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RecoverPasswordServlet extends HttpServlet implements Servlet {
	
	@Override	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// get request parameters for userID and password
		String correo = request.getParameter("correo");
		

		if (EnvioCorreo.verificarCorreo(correo)) {
			try {
				
				EnvioCorreo.enviarCorreoConfirmarUsuario(correo);
				String MsgExito = "Correo Enviado a " + correo + "!";
				request.setAttribute("title", MsgExito);
				request.setAttribute("text", "Te hemos enviado un correo electronico a tu casilla, en el hay instrucciones con los pasos a seguir.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("title", "Hubo un malentendido...");
				request.setAttribute("text", "No se pudo enviar el mail");
			}
		} else
		{
			request.setAttribute("title", "Hubo un malentendido...");
			request.setAttribute("text", "El correo no es valido");
		}
			
			
		
		

		
		//RequestDispatcher rd = getServletContext().getRequestDispatcher("/inicio.jsp");//("/login.html");
		//request.setAttribute("errorMessage", "Usuario y/o Password incorrectos.");
		RequestDispatcher rd = request.getRequestDispatcher("/recuperar.jsp");
        rd.forward(request, response);
		
		//PrintWriter out= response.getWriter();
		//out.println("<font color=red>Either user name or password is wrong.</font>");
		//rd.include(request, response);

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}	

}
