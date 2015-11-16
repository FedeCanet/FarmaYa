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

import com.is3.bo.Direccion;
import com.is3.bo.Farmacia;
import com.is3.bo.Orden;
import com.is3.bo.Producto;
import com.is3.bo.ProductoOrden;
import com.is3.bo.Usuario;

public class ActualizarCantidadItemCarrito extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {

		PersistenceHelper per = new PersistenceHelper();
		HttpSession session = request.getSession();
		
		long str_selected_value = Long.valueOf(request.getParameter("qty_1610399"));
		long idProductoCantidad = Long.valueOf(request.getParameter("idProductoCantidad"));
		
		Orden orden = null;
		String direccionAEntregar = "8 de Octubre 2487 Apto 203";
		
		if(session.getAttribute("elCarrito") != null){
			orden = (Orden)session.getAttribute("elCarrito");
			if(orden.getUsuario() != null){
				Usuario usu = orden.getUsuario();
				if(usu != null){
					List<Direccion> direcciones = usu.getDirecciones();
					for (Direccion direccion : direcciones) {
						direccionAEntregar = direccion.getCalle();
					}
				}
			}	
		}else{
			orden = new Orden();
			session.setAttribute("elCarrito", orden);
		}
		
		Long farmaciaId = orden.getFarmacia().getId();
		Farmacia laFarmacia = null;
		
		if(orden.getFarmacia() != null){
			laFarmacia = orden.getFarmacia();
		}else{
			laFarmacia = per.obtenerFarmacia(farmaciaId);
			orden.setFarmacia(laFarmacia);
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
		String productos = "";
		
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
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#idProductoCantidad#", String.valueOf(producto2.getId()));
				
				if(producto2.getId() == idProductoCantidad){
					producto2.setCantidad(new Integer(str_selected_value + ""));
					total += Double.parseDouble(String.valueOf(producto2.getPrecioUnitario().doubleValue() * producto2.getCantidad()));
				}else{
					total += Double.parseDouble(String.valueOf(producto2.getPrecioUnitario().doubleValue() * producto2.getCantidad()));
				}
				
				farmaciaCarritoProducto = setSelectedProduct(farmaciaCarritoProducto, producto2.getCantidad());
				
				productosEnElCarrito = productosEnElCarrito + " " + farmaciaCarritoProducto;
			}
			
			farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#direccionAEntregar#", direccionAEntregar);
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
        rd.forward(request, resp);
				
	}
	
	public String setSelectedProduct(String str_row, int cant){
		if(cant > 10 || cant <1){
			return setDefaultUno(str_row);
		}else{
			for (int i = 0; i < 10; i++) {
				int iter = i + 1;
				if(iter == cant){
					str_row = str_row.replace("#selectedItemRow" + iter + "#", "selected='selected'");
				}else{
					String buscarToReplace = "#selectedItemRow" + iter + "#";
					str_row = str_row.replace(buscarToReplace, "");
				}
			}
			return str_row;
		}
	}
	
	public String setDefaultUno(String str_row){
		
		str_row = str_row.replace("#selectedItemRow1#", "selected='selected'");
		
		for (int i = 1; i < 10; i++) {
			int iter = i + 1;
			String buscarToReplace = "#selectedItemRow" + iter + "#";
			str_row = str_row.replace(buscarToReplace, "");
		}
		
		return str_row;
	}

}
