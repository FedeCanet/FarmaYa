package com.is3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscarServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/**
		 * RECUPERAR LAS FARMACIAS MAS CERCANAS 
		 * La eleccion del departamento no importa para este 1er caso.
		 * 
		 * 1) Recuperar la direccion ingresada que viene en el request.
		 * 2) Recuperar el producto que esta buscando que viene en el request.
		 * 3) Llamar al metodo de Fede Cannet que a partir de la direccion devuelve un objeto direccion con latitud y longitud
		 * 4) Llamar al metodo de Fede cannet que a partir de una latitud, longitud y producto (producto es opcional), devuelva 
		 * 		una lista de farmacias mas cercanas que tengan ese producto, en caso de no venir el prducto por parametro buscar 
		 * 		las farmacias mas cercanas a la longitud y latitud.
		 * 
		 * 5) mostrar esos resultados armando dinamicamente el html 
		 */
		
		
		
		String htmlBusqueda = Parameters.getParameter("resultadodebusqueda");
		request.setAttribute("resultadodebusqueda", htmlBusqueda);
		RequestDispatcher rd = request.getRequestDispatcher("/resultadodebusqueda.jsp");
        rd.forward(request, response);
	}
	
	

}
