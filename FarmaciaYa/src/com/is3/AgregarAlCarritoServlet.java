package com.is3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgregarAlCarritoServlet extends HttpServlet {
	
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
				
		//Presentacion
		String farmaciaPresentacion = Parameters.getParameter("farmaciaPresentacion");
		
		//Productos de la Farmacia
		String farmaciaProductos = Parameters.getParameter("farmaciaProductos");
		
		//Productos A agregar
		String producto = request.getParameter("idProducto");
		String farmaciaCarritoStructura = Parameters.getParameter("farmaciaCarritoStructura");
	
		if(producto.equals("1")){
			//Aspirina
			String farmaciaCarritoProducto =  Parameters.getParameter("farmaciaCarritoProducto");
			
			farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#NombreProducto#","Aspirina");
			farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#PrecioProducto#","200");
			
			farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#productosEnElCarrito#", farmaciaCarritoProducto);
			farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#subtotal#", "200");
			farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#total#", "200");
			
			request.setAttribute("farmaciaCarrito", farmaciaCarritoStructura);
			
		}else{
			//Zolven
			String farmaciaCarritoProducto =  Parameters.getParameter("farmaciaCarritoProducto");
			
			farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#NombreProducto#","Zolven");
			farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#PrecioProducto#","150");
			
			farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#productosEnElCarrito#", farmaciaCarritoProducto);
			farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#subtotal#", "150");
			farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#total#", "150");
			
			request.setAttribute("farmaciaCarrito", farmaciaCarritoStructura);
		}
		
		request.setAttribute("farmaciaPresentacion", farmaciaPresentacion);
		request.setAttribute("farmaciaProductos", farmaciaProductos);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/farmacia.jsp");
        rd.forward(request, response);
	}	

}
