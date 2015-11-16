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
				
		PersistenceHelper per = new PersistenceHelper();
		HttpSession session = request.getSession();
		String selectedItemRow = "selected='selected'";
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
		
		
		
		//Presentacion
		Long farmaciaId = Long.parseLong(request.getParameter("idFarmacia"));
		Farmacia laFarmacia = per.obtenerFarmacia(farmaciaId);
		orden.setFarmacia(laFarmacia);
		
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
		
		
		//Productos A agregar
		long idProducto = Long.parseLong(request.getParameter("idProducto"));
		Producto producto = per.obtenerProducto(idProducto);
		String farmaciaCarritoStructura = Parameters.getParameter("farmaciaCarritoStructura");
	
		if(orden.getProductoOrden() != null && orden.getProductoOrden().size() > 0){
			
			
			for (ProductoOrden productoOrden : orden.getProductoOrden()) {
				System.out.println(productoOrden.getProducto().getNombre());
			}
			
			String productosEnElCarrito = "";
			double total = 0.0;
			
			
			
			for (ProductoOrden productoOrden : orden.getProductoOrden()) {
				Producto producto2 = productoOrden.getProducto();			
				String farmaciaCarritoProducto =  Parameters.getParameter("farmaciaCarritoProducto");
				
								
				
				farmaciaCarritoProducto = setSelectedProduct(farmaciaCarritoProducto, producto2.getCantidad());
				
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#NombreProducto#",producto2.getNombre());
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#PrecioProducto#",String.valueOf(producto2.getPrecioUnitario()));
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#idFarmacia#", String.valueOf(farmaciaId));
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#idProducto#", String.valueOf(producto2.getId()));
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#idProductoCantidad#", String.valueOf(producto2.getId()));
				total += Double.parseDouble(String.valueOf(producto2.getPrecioUnitario().doubleValue() * producto2.getCantidad()));
				productosEnElCarrito = productosEnElCarrito + " " + farmaciaCarritoProducto;
			}
			
			if(producto != null){
				producto.setCantidad(1);
				ProductoOrden prodOrden = new ProductoOrden();
				if(orden.getProductoOrden() == null){
					orden.setProductoOrden(new ArrayList<ProductoOrden>());
				}
				
				prodOrden.setOrden(orden);
				prodOrden.setProducto(producto);
				orden.getProductoOrden().add(prodOrden);
				
				//Aspirina
				String farmaciaCarritoProducto =  Parameters.getParameter("farmaciaCarritoProducto");
				farmaciaCarritoProducto = setDefaultUno(farmaciaCarritoProducto);
				
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#NombreProducto#",producto.getNombre());
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#PrecioProducto#",String.valueOf(producto.getPrecioUnitario()));
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#idFarmacia#", String.valueOf(farmaciaId));
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#idProducto#", String.valueOf(producto.getId()));
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#idProductoCantidad#", String.valueOf(producto.getId()));
				
				String totalDeProductos = productosEnElCarrito + " " + farmaciaCarritoProducto;
				total += Double.parseDouble(String.valueOf(producto.getPrecioUnitario().doubleValue() * producto.getCantidad()));
				
				farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#direccionAEntregar#", direccionAEntregar);
				farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#productosEnElCarrito#", totalDeProductos);
				farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#subtotal#", String.valueOf(total));
				farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#total#", String.valueOf(total));
				
				request.setAttribute("farmaciaCarrito", farmaciaCarritoStructura);		
			}else{
				farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#direccionAEntregar#", direccionAEntregar);
				farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#productosEnElCarrito#", productosEnElCarrito);
				farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#subtotal#", String.valueOf(total));
				farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#total#", String.valueOf(total));
				
				request.setAttribute("farmaciaCarrito", farmaciaCarritoStructura);	
			}
			
			orden.setTotal(new BigDecimal(total));
			
		}else{
			if(producto != null){
				
				producto.setCantidad(1);
				ProductoOrden prodOrden = new ProductoOrden();
				if(orden.getProductoOrden() == null){
					orden.setProductoOrden(new ArrayList<ProductoOrden>());
				}
				
				prodOrden.setOrden(orden);
				prodOrden.setProducto(producto);
				orden.getProductoOrden().add(prodOrden);
				
				String farmaciaCarritoProducto =  Parameters.getParameter("farmaciaCarritoProducto");
				farmaciaCarritoProducto = setDefaultUno(farmaciaCarritoProducto);
				
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#NombreProducto#",producto.getNombre());
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#PrecioProducto#",String.valueOf(producto.getPrecioUnitario()));
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#idFarmacia#", String.valueOf(farmaciaId));
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#idProducto#", String.valueOf(producto.getId()));
				farmaciaCarritoProducto = farmaciaCarritoProducto.replace("#idProductoCantidad#", String.valueOf(producto.getId()));
				
				farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#direccionAEntregar#", direccionAEntregar);
				farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#productosEnElCarrito#", farmaciaCarritoProducto);
				farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#subtotal#", String.valueOf(producto.getPrecioUnitario()));
				farmaciaCarritoStructura = farmaciaCarritoStructura.replace("#total#", String.valueOf(producto.getPrecioUnitario()));
				
				request.setAttribute("farmaciaCarrito", farmaciaCarritoStructura);	
				
				orden.setTotal(new BigDecimal(String.valueOf(producto.getPrecioUnitario())));
			}		
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/farmacia.jsp");
        rd.forward(request, response);
        
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

}