package com.llm.a01base.a03thirdwebapp;
//请求的转发：
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class B05ForwardServlet1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("B05ForwardServlet1's doGet");
		
		request.setAttribute("name", "abcde");
		System.out.println("B05ForwardServlet1's name: " + request.getAttribute("name"));
		
		//请求的转发.
		//1. 调用 HttpServletRequest 的 getRequestDispatcher() 方法获取  RequestDispatcher 对象
		//调用 getRequestDispatcher() 需要传入要转发的地址
		String path = "B05TestServlet1";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/" + path);
				
		//2. 调用 HttpServletRequest 的 forward(request, response) 进行请求的转发. 
		requestDispatcher.forward(request, response); 
	}
}
