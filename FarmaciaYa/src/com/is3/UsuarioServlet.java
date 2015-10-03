package com.is3;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioServlet extends HttpServlet implements Servlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		
		String nombre, apellido, correo, direccion, contraseña; 
		
		nombre = req.getParameter("nombre");
		apellido = req.getParameter("apellido");
		correo = req.getParameter("correo");
		direccion = req.getParameter("direccion");
		contraseña = req.getParameter("password");
		
		PersistenceHelper persistHelper = new PersistenceHelper();
		persistHelper.addUsuario(nombre,  apellido, correo, direccion, contraseña);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}	
}