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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		Orden orden = new Orden();
		String correo = "";
		String nombre = "";
		String nombreFarmacia= "";
				
		HttpSession session = req.getSession();
		correo = String.valueOf(session.getAttribute("user"));
		
		Usuario u = new Usuario();
		u.setCorreo(correo);
		u.setNombre(nombre);
		u.setApellido(nombre);
		
		Farmacia f = new Farmacia();
		f.setNombre(nombreFarmacia);
		
		List<Producto> lista = new ArrayList<Producto>();
		
		orden.setUsuario(u);
		orden.setFarmacia(f);
		orden.setProductos(lista);
		
		EnvioCorreo env = new EnvioCorreo();
		try {
			//env.enviarCorreoConfirmarUsuario("nicojfernandez@gmail.com");
			env.enviarCorreoPedidoRegistrado(orden);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/inicio.jsp");
        rd.forward(req, resp);
	}
}
