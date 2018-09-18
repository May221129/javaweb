package com.llm.a01base.a03thirdwebapp;
//请求的转发：
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class B05TestServlet1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("B05TestServlet1's doGet 方法. ");
		
		System.out.println("B05TestServlet1's name: " + request.getAttribute("name"));	
	}
}
