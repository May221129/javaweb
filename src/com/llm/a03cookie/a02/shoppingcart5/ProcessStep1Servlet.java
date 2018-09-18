package com.llm.a03cookie.a02.shoppingcart5;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/processStep1")
public class ProcessStep1Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1、获取选中的图书的信息
		String [] books = request.getParameterValues("book");
		
//		2、把图书信息放入到HttpSession中
		request.getSession().setAttribute("books", books);
		
//		问题：这里为什么是用重定向，而不是用转发？？？
//		3、重定向页面到 a03cookie_a02_shoppingcart5/step2.jsp
//		sendRedirect(要重定向到哪个页面，可以写绝对路径，也可以写相对路径)，下面这行代码是为了测试看绝对路径是否正确的：
		System.out.println(request.getContextPath() + "/a03cookie_a02_shoppingcart5/step2.jsp");
		response.sendRedirect(request.getContextPath() + "/a03cookie_a02_shoppingcart5/step2.jsp");
//		java文件编译后的.class文件是在根路径下的
	}
}
