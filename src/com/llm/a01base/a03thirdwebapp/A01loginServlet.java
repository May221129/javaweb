package com.llm.a01base.a03thirdwebapp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//不直接实现Servlet接口，而是继承已经实现了Servlet接口和ServletConfig接口的MyGenericServlet类
public class A01loginServlet extends GenericServlet{
	
	//对当前的Servlet进行初始化：需要覆盖init()方法
	//不建议直接覆盖 init(ServletConfig), 因为如果忘记编写 super.init(config); 而还是用了 SerlvetConfig 接口的方法,则会出现空指针异常. 
	@Override
	public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
	
	@Override
	public void service(ServletRequest request, ServletResponse reponse) throws ServletException, IOException {
		
		//获取请求方式是get还是post：
		HttpServletRequest httpSerbletRequest = (HttpServletRequest)request;
		String method = httpSerbletRequest.getMethod();
		System.out.println(method);
		
		//1、获取请求参数：username，password(看HTML文件中的命名）
		String username = request.getParameter("username");
		String password  = request.getParameter("password");
		
		//2、获取当前WEB应用的初始化参数：user，password
		//需要使用ServletContext对象
		
		String initUser = getServletContext().getInitParameter("user");
		String initPassword = getServletContext().getInitParameter("password");
		
		PrintWriter out = reponse.getWriter();
		
		//3、比对
		//4、打印响应字符串
		if(initUser.equals(username) && initPassword.equals(password)){
			out.println("Hello:" + username);
		}else{
			out.print("Sorry:" + username);
		}
	}
}
