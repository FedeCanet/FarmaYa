package com.is3;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.is3.bo.Farmacia;
import com.is3.bo.Orden;
import com.is3.bo.Producto;
import com.is3.bo.ProductoOrden;
import com.is3.bo.Usuario;

public class RealizarPedidoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		
		Orden orden = null;
		
		if(session.getAttribute("elCarrito") != null){
			orden = (Orden)session.getAttribute("elCarrito");
		}else{
			
		}
		
		PersistenceHelper perHelper = new PersistenceHelper();
		
		try {
			perHelper.confirmarOrden(orden);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
				
		EnvioCorreo env = new EnvioCorreo();
		try {
			env.enviarCorreoPedidoRegistrado(orden);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		long idFarmacia = orden.getFarmacia().getId();
		
		Farmacia laFarmacia = perHelper.obtenerFarmacia(idFarmacia);
		
		if(session.getAttribute("elCarrito") != null){
			//Ya tiene una orden
			Orden o = (Orden)session.getAttribute("elCarrito");
			o.setFarmacia(laFarmacia);
			o.setFormaDePAgo(laFarmacia.getFormasDePago().get(0));
			//reiniciamos la orden
			o.setProductoOrden(null);
			ArrayList<ProductoOrden> pordenVacio = new ArrayList<ProductoOrden>(); 
			o.setProductoOrden(pordenVacio);
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
		
		String productos = "";
		
		ArrayList<Producto> listaProductos = (ArrayList)perHelper.obtenerProductos();
		for (int i = 0; i < 5; i++) {
			Producto p = listaProductos.get(i);
			String farmaciaProductos = Parameters.getParameter("farmaciaProductos");
			farmaciaProductos = farmaciaProductos.replace("#idFarmacia#", String.valueOf(idFarmacia));
			farmaciaProductos = farmaciaProductos.replace("#idProducto#", String.valueOf(p.getId()));
			farmaciaProductos = farmaciaProductos.replace("#Nombre#", p.getNombre());
			farmaciaProductos = farmaciaProductos.replace("#PrecioUnitario#", String.valueOf(p.getPrecioUnitario()));
			
			productos = productos + " " + farmaciaProductos;
		}
		
		request.setAttribute("farmaciaProductos", productos);
		
		String farmaciaCarrito = Parameters.getParameter("farmaciaCarritoVacio");
		request.setAttribute("farmaciaCarrito", farmaciaCarrito);
		
		request.setAttribute("comproProperty", "compro");
		//RequestDispatcher rd = request.getRequestDispatcher("/inicio.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/farmacia.jsp");
        rd.forward(request, resp);
	}
}
