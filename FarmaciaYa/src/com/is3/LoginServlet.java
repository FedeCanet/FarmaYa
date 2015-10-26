package com.is3;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.is3.bo.Orden;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// get request parameters for userID and password
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		PersistenceHelper persistHelper = new PersistenceHelper();
		
		if(persistHelper.existUsuario(user, pwd)){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("user", user);
			userName.setMaxAge(30*60);
			response.addCookie(userName);
			response.sendRedirect("busqueda.jsp");
			
			//Agregar una ORDEN VACIA
			if(session.getAttribute("orden") != null){
				//Ya tiene una orden
			}else{
				//creamos una nueva Orden
				Orden o = new Orden();
				o.setUsuario(persistHelper.getUsuario(user, pwd));
				o.setAclaracion("Esta es la ordeeen");
				session.setAttribute("elCarrito", o);
			}
		}else{
			request.setAttribute("errorMessage", "Usuario y/o Password incorrectos.");
			RequestDispatcher rd = request.getRequestDispatcher("/inicio.jsp");
            rd.forward(request, response);
		}
	}
}