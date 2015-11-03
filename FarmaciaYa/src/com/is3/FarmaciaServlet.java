package com.is3;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.is3.bo.Direccion;
import com.is3.bo.Farmacia;
import com.is3.bo.Orden;
import com.is3.bo.Producto;

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
		
		PersistenceHelper per = new PersistenceHelper();
		Long farmaciaId = Long.parseLong(request.getParameter("idFarmacia"));
		Farmacia laFarmacia = per.obtenerFarmacia(farmaciaId);
		
		
		HttpSession session = request.getSession();
		if(session.getAttribute("elCarrito") != null){
			//Ya tiene una orden
			Orden o = (Orden)session.getAttribute("elCarrito");
			o.setFarmacia(laFarmacia);
			o.setFormaDePAgo(laFarmacia.getFormasDePago().get(0));
		}		
		
		String farmaciaPresentacion = Parameters.getParameter("farmaciaPresentacion");
		
		if(laFarmacia != null){
			farmaciaPresentacion = farmaciaPresentacion.replace("#NombreFarmacia#", laFarmacia.getNombre());
			String direccion = laFarmacia.getDireccion().getCalle();
			farmaciaPresentacion = farmaciaPresentacion.replace("#Direccion#", direccion);
			farmaciaPresentacion = farmaciaPresentacion.replace("#Puntaje#", String.valueOf(laFarmacia.getPuntaje()));
			farmaciaPresentacion = farmaciaPresentacion.replace("#ImporteMinimo#", String.valueOf(laFarmacia.getImporteMinimo()));
		}
		
		request.setAttribute("farmaciaPresentacion", farmaciaPresentacion);
		
		String productos = null;
		
		ArrayList<Producto> listaProductos = (ArrayList)per.obtenerProductos();
		for (int i = 0; i < 5; i++) {
			Producto p = listaProductos.get(i);
			String farmaciaProductos = Parameters.getParameter("farmaciaProductos");
			farmaciaProductos = farmaciaProductos.replace("#idFarmacia#", String.valueOf(farmaciaId));
			farmaciaProductos = farmaciaProductos.replace("#idProducto#", String.valueOf(p.getId()));
			farmaciaProductos = farmaciaProductos.replace("#Nombre#", p.getNombre());
			farmaciaProductos = farmaciaProductos.replace("#PrecioUnitario#", String.valueOf(p.getPrecioUnitario()));
			
			productos = productos + " " + farmaciaProductos;
		}
		
		//String farmaciaProductos = Parameters.getParameter("farmaciaProductos");
		request.setAttribute("farmaciaProductos", productos);
		
		String farmaciaCarrito = Parameters.getParameter("farmaciaCarritoVacio");
		request.setAttribute("farmaciaCarrito", farmaciaCarrito);
		
		RequestDispatcher rd = request.getRequestDispatcher("/farmacia.jsp");
        rd.forward(request, response);
	}	
}


