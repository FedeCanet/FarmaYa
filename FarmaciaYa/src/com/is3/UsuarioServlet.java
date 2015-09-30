package com.is3;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioServlet extends HttpServlet implements Servlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		
		String title = req.getParameter("nombre");
		
		//req.getSession().setAttribute("schoolschedule", schedule);
		//getServletContext().getRequestDispatcher("/Schedule.jsp").forward(request, response);
	}

}
