package com.is3;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.is3.dto.Posicion;

public class PositionServlet extends HttpServlet implements Servlet {
	
	@Override	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		String latitud = request.getParameter("latitud");
		String longitud = request.getParameter("longitud");
			
		try {
			Posicion p = new Posicion();
			p.getDirCiuByLatLong(new Float(latitud), new Float(longitud));
			request.setAttribute("direccion", "8 de octubre 1234");
			//request.setAttribute("ciudad", p.getCiudad());
	
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
				
		RequestDispatcher rd = request.getRequestDispatcher("/busqueda.jsp");
        rd.forward(request, response);
		
		//PrintWriter out= response.getWriter();
		//out.println("<font color=red>Either user name or password is wrong.</font>");
		//rd.include(request, response);

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}	

}