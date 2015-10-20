package com.is3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RealizarPedidoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		EnvioCorreo env = new EnvioCorreo();
		try {
			env.enviarCorreoConfirmarUsuario("nicojfernandez@gmail.com");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/inicio.jsp");
        rd.forward(req, resp);
	}
}
