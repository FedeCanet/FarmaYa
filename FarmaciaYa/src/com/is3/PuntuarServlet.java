package com.is3;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.is3.bo.Orden;
import com.is3.bo.ProductoOrden;
import com.is3.bo.Usuario;

public class PuntuarServlet extends HttpServlet {

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
		
		String puntaje = request.getParameter("Radios");
		Long idOrdenAPuntuar = Long.parseLong(request.getParameter("idOrdenAPuntuar"));
				
		float elPuntaje = new Float(puntaje);

		per.puntuarOrden(idOrdenAPuntuar, elPuntaje);	
		
		per.puntuarFarmacia(idOrdenAPuntuar, elPuntaje);
				
		HttpSession session = request.getSession();		
		if(session.getAttribute("elCarrito") != null){
			Orden orden = (Orden)session.getAttribute("elCarrito");
			if(orden.getUsuario() != null){
				Usuario usuario = per.getUsuarioById(new Long(orden.getUsuario().getId()));
				List<Orden> ordenes = usuario.getOrdenes();		
				
				String resultadoOrdenesAMostrar = "";
				
				for (Orden laOrden : ordenes) {
					
					String nombreFarmacia = laOrden.getFarmacia().getNombre();
					String fechaOrden = String.valueOf(laOrden.getFechaOrden());
					String pedido = "";
					
					List<ProductoOrden> po = laOrden.getProductoOrden();
					for (ProductoOrden productoOrden : po) {
						String pedidoIter = productoOrden.getProducto().getNombre() + " $ " + productoOrden.getProducto().getPrecioUnitario();
						if(pedido == ""){
							//Es el primer pedido
							pedido = pedidoIter;
						}else{
							//No es el primer pedido
							pedido = pedido + " + " + pedidoIter;
						}						
					}
					
					if(laOrden.getPuntaje() > 0.0){
						//Ya fue puntuada, recuperamos HTML puntuado.
						String ordenPuntuada = Parameters.getParameter("ordenPuntuada");
						ordenPuntuada = ordenPuntuada.replace("#nombreFarmacia#", nombreFarmacia);
						ordenPuntuada = ordenPuntuada.replace("#elPedido#", pedido);
						ordenPuntuada = ordenPuntuada.replace("#fechaPedido#", fechaOrden);
						
						String checkedAndDisable = "checked disabled";
						String disable = "disabled";
						
						String point = String.valueOf(laOrden.getPuntaje());
						
						switch (point) {
						case "1.0":
							ordenPuntuada = ordenPuntuada.replace("#statusMMala#", checkedAndDisable);
							ordenPuntuada = ordenPuntuada.replace("#statusMala#", disable);
							ordenPuntuada = ordenPuntuada.replace("#statusBuena#", disable);
							ordenPuntuada = ordenPuntuada.replace("#statusMBuena#", disable);
							ordenPuntuada = ordenPuntuada.replace("#statusExcelente#", disable);
							break;
						case "2.0":
							ordenPuntuada = ordenPuntuada.replace("#statusMMala#", disable);
							ordenPuntuada = ordenPuntuada.replace("#statusMala#", checkedAndDisable);
							ordenPuntuada = ordenPuntuada.replace("#statusBuena#", disable);
							ordenPuntuada = ordenPuntuada.replace("#statusMBuena#", disable);
							ordenPuntuada = ordenPuntuada.replace("#statusExcelente#", disable);
							break;
						case "3.0":
							ordenPuntuada = ordenPuntuada.replace("#statusMMala#", disable);
							ordenPuntuada = ordenPuntuada.replace("#statusMala#", disable);
							ordenPuntuada = ordenPuntuada.replace("#statusBuena#", checkedAndDisable);
							ordenPuntuada = ordenPuntuada.replace("#statusMBuena#", disable);
							ordenPuntuada = ordenPuntuada.replace("#statusExcelente#", disable);
							break;
						case "4.0":
							ordenPuntuada = ordenPuntuada.replace("#statusMMala#", disable);
							ordenPuntuada = ordenPuntuada.replace("#statusMala#", disable);
							ordenPuntuada = ordenPuntuada.replace("#statusBuena#", disable);
							ordenPuntuada = ordenPuntuada.replace("#statusMBuena#", checkedAndDisable);
							ordenPuntuada = ordenPuntuada.replace("#statusExcelente#", disable);
							break;
						case "5.0":
							ordenPuntuada = ordenPuntuada.replace("#statusMMala#", disable);
							ordenPuntuada = ordenPuntuada.replace("#statusMala#", disable);
							ordenPuntuada = ordenPuntuada.replace("#statusBuena#", disable);
							ordenPuntuada = ordenPuntuada.replace("#statusMBuena#", disable);
							ordenPuntuada = ordenPuntuada.replace("#statusExcelente#", checkedAndDisable);
							break;
						default:
							break;
						}
						
						resultadoOrdenesAMostrar = resultadoOrdenesAMostrar + "" + ordenPuntuada;

					}else{
						//Aun no ha sido puntuada, recuperamos el HTML sin puntuar.
						String ordenParaPuntuar = Parameters.getParameter("ordenParaPuntuar");
						ordenParaPuntuar = ordenParaPuntuar.replace("#nombreFarmacia#", nombreFarmacia);
						ordenParaPuntuar = ordenParaPuntuar.replace("#elPedido#", pedido);
						ordenParaPuntuar = ordenParaPuntuar.replace("#fechaPedido#", fechaOrden);
						ordenParaPuntuar = ordenParaPuntuar.replace("#idOrdenAPuntuar#", String.valueOf(laOrden.getId()));
												
						resultadoOrdenesAMostrar = resultadoOrdenesAMostrar + " " + ordenParaPuntuar;
					}
				}
				request.setAttribute("resultadoPuntuacion", resultadoOrdenesAMostrar);
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/puntuacion.jsp");
        rd.forward(request, response);
	}
}
