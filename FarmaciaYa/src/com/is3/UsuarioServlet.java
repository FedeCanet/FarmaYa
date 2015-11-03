package com.is3;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.is3.bo.Direccion;
import com.is3.bo.Orden;
import com.is3.bo.Usuario;
import com.is3.dto.Posicion;

public class UsuarioServlet extends HttpServlet implements Servlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
			session.setAttribute("user", correo);
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("user", correo);
			
			Usuario u = persistHelper.getUsuario(correo, password);
			Direccion dir = u.getDirecciones().get(0);
			int cantidad = 0;
			if(u.getOrdenes() != null){
				cantidad = u.getOrdenes().size();
			}
			session.setAttribute("puntuacionDireccion", dir.getCalle());
			session.setAttribute("nombreCompleto", u.getNombre() + " " + u.getApellido());
			session.setAttribute("cantPedidos", cantidad);
			
			userName.setMaxAge(30*60);
			response.addCookie(userName);
			response.sendRedirect("busqueda.jsp");
			
			//Agregar una ORDEN VACIA
			if(session.getAttribute("elCarrito") != null){
				//Ya tiene una orden
			}else{
				//creamos una nueva Orden
				Orden o = new Orden();
				o.setUsuario(persistHelper.getUsuario(correo, password));
				o.setFechaOrden(new Date(System.currentTimeMillis()));
				session.setAttribute("elCarrito", o);
			}
		}else{
			request.setAttribute("errorMessage", "Usuario y/o Password incorrectos.");
			RequestDispatcher rd = request.getRequestDispatcher("/inicio.jsp");
            rd.forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}	
}