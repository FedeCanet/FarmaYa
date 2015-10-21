package com.is3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FarmaciaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		String farmacia = request.getParameter("idFarmacia");
		
		String farmaciaPresentacion = Parameters.getParameter("farmaciaPresentacion");
		String farmaciaProductos = Parameters.getParameter("farmaciaProductos");
		String farmaciaCarrito = Parameters.getParameter("farmaciaCarritoVacio");
		request.setAttribute("farmaciaPresentacion", farmaciaPresentacion);
		request.setAttribute("farmaciaProductos", farmaciaProductos);
		request.setAttribute("farmaciaCarrito", farmaciaCarrito);
		
		RequestDispatcher rd = request.getRequestDispatcher("/farmacia.jsp");
        rd.forward(request, response);
	}	
}


