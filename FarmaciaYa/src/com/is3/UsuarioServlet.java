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

import com.is3.dto.Posicion;

public class UsuarioServlet extends HttpServlet implements Servlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(request, response);
		
		String nombre, apellido, correo, direccion, password; 
		
		nombre = request.getParameter("nombre");
		apellido = request.getParameter("apellido");
		correo = request.getParameter("correo");
		direccion = request.getParameter("direccion");
		password = request.getParameter("password");
		
		PersistenceHelper persistHelper = new PersistenceHelper();
		persistHelper.addUsuario(nombre,  apellido, correo, direccion, password);
		
		if(persistHelper.existUsuario(correo, password)){
			HttpSession session = request.getSession();
			//session.setAttribute("user", "Pankaj");
			session.setAttribute("user", correo);
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("user", correo);
			userName.setMaxAge(30*60);
			response.addCookie(userName);
			response.sendRedirect("busqueda.jsp");
			
			//RequestDispatcher rd = request.getRequestDispatcher("/LoginServlet");
            //rd.forward(request, response);
			//response.sendRedirect("busqueda.jsp");
		}else{
			//RequestDispatcher rd = getServletContext().getRequestDispatcher("/inicio.jsp");//("/login.html");
			request.setAttribute("errorMessage", "Usuario y/o Password incorrectos.");
			RequestDispatcher rd = request.getRequestDispatcher("/inicio.jsp");
            rd.forward(request, response);
			
			//PrintWriter out= response.getWriter();
			//out.println("<font color=red>Either user name or password is wrong.</font>");
			//rd.include(request, response);
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}	
}