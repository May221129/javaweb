package com.llm.a03cookie.a02.shoppingcart5;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/processStep2")
public class ProcessStep2Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		1、获取请求参数：name、address、cardType、card
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String cardType = request.getParameter("cardType");
		String card = request.getParameter("card");
		
//		用户信息封装成一个类：
		Customer customer = new Customer(name, address, cardType, card);
		
//		2、把请求信息放入到HttpSession中
		HttpSession session = request.getSession();
		
//		下面这种写法太麻烦，可以将用户的信息封装成一个类
		/*
		session.setAttribute("name", name);
		session.setAttribute("address", address);
		session.setAttribute("cardType", cardType);
		session.setAttribute("card", card);
		 */
		
//		用户信息封装成一个类后：
		session.setAttribute("customer", customer);
		
//		3、重定向页面到 a03cookie_a02_shoppingcart5/confirm.jsp
		response.sendRedirect(request.getContextPath() + "/a03cookie_a02_shoppingcart5/confirm.jsp");
	}
}
