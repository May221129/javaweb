package com.llm.a08listener;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setAttribute("requestKey", "requestValue2");
		
//		request.getRequestDispatcher("/a08listener_a01.listener/test.jsp").forward(request, response);
		response.sendRedirect("/a08listener_a01.listener/test2.jsp");
		
		System.out.println("Œ“ «Servlet∞°∞°∞°");
	}
}
