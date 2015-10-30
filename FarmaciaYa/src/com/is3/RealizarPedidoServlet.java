package com.is3;

import java.io.IOException;
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
		
		EnvioCorreo env = new EnvioCorreo();
		try {
			env.enviarCorreoPedidoRegistrado(orden);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//reiniciamos la orden
//		orden.setProductos(null);
		
		RequestDispatcher rd = request.getRequestDispatcher("/inicio.jsp");
        rd.forward(request, resp);
	}
}
