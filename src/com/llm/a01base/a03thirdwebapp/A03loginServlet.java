package com.llm.a01base.a03thirdwebapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实际开发中, 直接继承 HttpServlet, 并根据请求方式复写 doXxx() 方法即可. 
 * 好处: 直接有针对性的覆盖 doXxx() 方法; 直接使用 HttpServletRequest 和  HttpServletResponse, 不再需要强转. 
 */
public class A03loginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		//获取请求方式是get还是post：
		String method = request.getMethod();
		System.out.println(method);
				
		//1、获取请求参数：username，password(看HTML文件中的命名）
		String username = request.getParameter("username");
		String password  = request.getParameter("password");
				
		//2、获取当前WEB应用的初始化参数：user，password
		//需要使用ServletContext对象
				
		String initUser = getServletContext().getInitParameter("user");
		String initPassword = getServletContext().getInitParameter("password");
				
		PrintWriter out = response.getWriter();
				
		//3、比对
		//4、打印响应字符串
		if(initUser.equals(username) && initPassword.equals(password)){
			out.println("Hello:" + username);
		}else{
			out.print("Sorry:" + username);
		}
	}
}