package com.is3;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

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

public class EliminarDelCarritoServlet extends HttpServlet {

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
		HttpSession session = request.getSession();
		
		Orden orden = null;
		
		if(session.getAttribute("elCarrito") != null){
			orden = (Orden)session.getAttribute("elCarrito");
		}else{
			orden = new Orden();
			session.setAttribute("elCarrito", orden);
		}
		
		Long farmaciaId = Long.parseLong(request.getParameter("idFarmacia"));
		Farmacia laFarmacia = null;
		
		if(orden.getFarmacia() != null){
			laFarmacia = orden.getFarmacia();
		}else{
			laFarmacia = per.obtenerFarmacia(farmaciaId);
			orden.setFarmacia(laFarmacia);
		}
		
		//Presentacion
		Long productoIdAEliminar = Long.parseLong(request.getParameter("idProducto"));

		
		for (ProductoOrden prodOrden : orden.getProductoOrden()) {
			if(prodOrden.getProducto().getId() == productoIdAEliminar){
				orden.getProductoOrden().remove(prodOrden);
				break;
			}			
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
		
		//Productos de la Farmacia
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
		
		
		//Agregamos los productos que estan en la orden, si está vacia entonces agregamos el carrito vacio.
		String farmaciaCarritoStructura = Parameters.getParameter("farmaciaCarritoStructura");
	
		if(orden.getProductoOrden() != null && orden.getProductoOrden().size() > 0){
						
			String productosEnElCarrito = "";
			double total = 0.0;
			
			for (ProductoOrden prodOrden : orden.getProductoOrden()) {
				Producto producto2 = prodOrden.getProducto();
				String farmaciaCarritoProducto =  Parameters.getParameter("farmaciaCarritoProducto");
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#NombreProducto#",producto2.getNombre());
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#PrecioProducto#",String.valueOf(producto2.getPrecioUnitario()));
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#idFarmacia#", String.valueOf(farmaciaId));
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#idProducto#", String.valueOf(producto2.getId()));
				total += Double.parseDouble(String.valueOf(producto2.getPrecioUnitario()));
				productosEnElCarrito = productosEnElCarrito + " " + farmaciaCarritoProducto;
			}
			
			farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#productosEnElCarrito#", productosEnElCarrito);
			farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#subtotal#", String.valueOf(total));
			farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#total#", String.valueOf(total));
			
			request.setAttribute("farmaciaCarrito", farmaciaCarritoStructura);	
			
			orden.setTotal(new BigDecimal(total));
		}else{
			
			String farmaciaCarrito = Parameters.getParameter("farmaciaCarritoVacio");
			request.setAttribute("farmaciaCarrito", farmaciaCarrito);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/farmacia.jsp");
        rd.forward(request, response);
	}
}
