package com.is3;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.is3.bo.Farmacia;
import com.is3.dto.Posicion;

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
				
		String direccion = null;
		String productoOFarmacia = "";
		boolean escribioProductoOFarmacia = false;
		
		if(request.getParameter("direccion") != null){
			direccion = String.valueOf(request.getParameter("direccion"));
		}
		
		if(request.getParameter("producto") != null){
			productoOFarmacia = String.valueOf(request.getParameter("producto"));
			if(productoOFarmacia.compareTo("") != 0 || productoOFarmacia.trim().compareTo("") != 0){
				escribioProductoOFarmacia = true;
			}
		}
		
		String str_selected_value = String.valueOf(request.getParameter("ciudad"));
		String ciudad = getCiudadFromIdSelected(str_selected_value);
		
		Posicion posicionUsuario = null;
		
		if(direccion != null){
			posicionUsuario = new Posicion();
			try {
				posicionUsuario.getLatLongByDirCiu(direccion, ciudad);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			//recuperar todas no se
			throw new NotImplementedException();
		}
		
		PersistenceHelper per = new PersistenceHelper();
		
		List <Farmacia> farmacias = per.obtenerFarmaciasCercanas(posicionUsuario);
		
		if(escribioProductoOFarmacia){
			List<Farmacia> farmaciasPorNombre = per.obtenerFarmaciasCercanasPorNombre(posicionUsuario, productoOFarmacia);
			if(farmaciasPorNombre.size() > 0){
				escribioProductoOFarmacia = false;
				farmacias = farmaciasPorNombre;
			}
		}
		
		String htmlBusqueda ="";
		
		if (farmacias.size()>0){
			for (Farmacia farm : farmacias){
				String nombre = farm.getNombre();
				String idFarmacia = String.valueOf(farm.getId());
				String horario = String.valueOf(farm.getHorarioDesde());
				String pedidoMin = String.valueOf(farm.getImporteMinimo());
				String puntaje = String.valueOf(farm.getPuntaje());
				String calle = farm.getDireccion().getCalle();
				
				String row = Parameters.getParameter("resultadodebusqueda");
				row = row.replace("#idFarmacia#", idFarmacia);
				row = row.replace("#nombreFarmacia#",nombre);
				row = row.replace("#puntaje#", puntaje);
				row = row.replace("#horario#",horario);
				row = row.replace("#direccion#",calle);
				row = row.replace("#importeMinimo#",pedidoMin);
				htmlBusqueda = htmlBusqueda + " " + row;
			}
		}else{
			System.out.println("sin registros");
		}
		
		String htmlBusquedaNoEncontradoPresentacion ="";
		if(escribioProductoOFarmacia){
			htmlBusquedaNoEncontradoPresentacion = Parameters.getParameter("resultadodebusquedaNoEncontradoPresentacion");
			htmlBusquedaNoEncontradoPresentacion = htmlBusquedaNoEncontradoPresentacion.replace("#busquedaProductoOFarmacia#", productoOFarmacia);	
		}
		request.setAttribute("resultadodebusquedaNoEncontradoPresentacion", htmlBusquedaNoEncontradoPresentacion);
		
		String htmlBusquedaPresentacion = Parameters.getParameter("resultadodebusquedapresentacion");
		request.setAttribute("resultadodebusqueda", htmlBusqueda);
		request.setAttribute("resultadodebusquedaPresentacion",htmlBusquedaPresentacion);
		RequestDispatcher rd = request.getRequestDispatcher("/resultadodebusqueda.jsp");
        rd.forward(request, response);
	}
	
	public String getCiudadFromIdSelected(String id){
		HashMap<String, String> mapCiudad = new HashMap<String, String>();
		mapCiudad.put("590", "Artigas");
		mapCiudad.put("665", "Bella Union");
		mapCiudad.put("610", "Canelones");
		mapCiudad.put("11", "Ciudad de la Costa");
		mapCiudad.put("592", "Colonia del Sacramento");
		mapCiudad.put("717", "Costa de Oro");
		mapCiudad.put("608", "Florida");
		mapCiudad.put("375", "Fray Bentos");
		mapCiudad.put("439", "Las Piedras");
		mapCiudad.put("43", "Maldonado");
		mapCiudad.put("632", "Melo");
		mapCiudad.put("666", "Mercedes");
		mapCiudad.put("1", "Montevideo");
		mapCiudad.put("654", "Pando");
		mapCiudad.put("718", "Parque del Plata");
		mapCiudad.put("64", "Paysandu");
		mapCiudad.put("129", "Piriapolis");
		mapCiudad.put("10", "Punta del Este");
		mapCiudad.put("425", "Rivera");
		mapCiudad.put("101", "Salto");
		mapCiudad.put("453", "San Carlos");
		mapCiudad.put("136", "San Jose");
		mapCiudad.put("594", "Tacuarembo");
		mapCiudad.put("664", "Treinta y Tres");
		return mapCiudad.get(id);
	}
}
