package com.llm.a01base.a03thirdwebapp;
//请求的重定向：
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class B05RedirectServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("B05RedirectServlet2's doGet");
		
		request.setAttribute("name", "xyzmn");
		System.out.println("B05RedirectServlet2's name: " + request.getAttribute("name"));
		
		//执行请求的重定向, 直接调用 response.sendRedirect(path) 方法,
		//path 为要重定向的地址
		String path = "B05TestServlet1";
		response.sendRedirect(path);
	}
}