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
import com.is3.PersistenceHelper;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// get request parameters for userID and password
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		PersistenceHelper persistHelper = new PersistenceHelper();
		
		//if(userID.equals(user) && password.equals(pwd)){
		if(persistHelper.existUsuario(user, pwd)){
			HttpSession session = request.getSession();
			//session.setAttribute("user", "Pankaj");
			session.setAttribute("user", user);
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("user", user);
			userName.setMaxAge(30*60);
			response.addCookie(userName);
			response.sendRedirect("busqueda.jsp");
			//response.sendRedirect("LoginSuccess.jsp");
		}else{
			//RequestDispatcher rd = getServletContext().getRequestDispatcher("/inicio.jsp");//("/login.html");
			request.setAttribute("errorMessage", "Usuario y/o Password incorrectos.");
			RequestDispatcher rd = request.getRequestDispatcher("/inicio.jsp");
            rd.forward(request, response);
			
			//PrintWriter out= response.getWriter();
			//out.println("<font color=red>Either user name or password is wrong.</font>");
			//rd.include(request, response);
		}
	}
}