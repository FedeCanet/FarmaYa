package com.is3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ActualizarContrasena extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PersistenceHelper per = new PersistenceHelper();
		
		if(request.getParameter("userId") != null){
			String UserID = String.valueOf(request.getParameter("userId"));
			String nuevaPass = request.getParameter("contrasena");
			String nuevaPassRepetida = request.getParameter("contrasenaRepetida");
			
			if(nuevaPass.compareTo(nuevaPassRepetida) == 0){
				per.actualizarContrasena(UserID, nuevaPass);
			}
		}
		
		response.sendRedirect("inicio.jsp");
	}

	
}
