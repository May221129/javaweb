package com.llm.a01base.a02secondwebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

public class A03LoginServlet implements Servlet{

	@Override
	public void destroy() {

	}

	@Override
	public ServletConfig getServletConfig() {

		return null;
	}

	@Override
	public String getServletInfo() {

		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {

		
	}
	
	
	@Override
	//service()方法用于应答请求，因为每次请求都会调用service()方法。
		//真正写的代码，放在service()方法中：
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("请求来了...");
		System.out.println(request); 
		
		//获取请求参数的4个重要方法：
		
		//1、getParametere():根据请求参数的名字，返回请求参数值
		//若请求参数有多个，该方法只能获取到第一个提交的值
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		System.out.println(user + ", " + password); 
		
		String interesting = request.getParameter("interesting");
		System.out.println(interesting); 
				
		//2、getParameterValues():根据请求参数的名字，返回请求参数对应的字符串数组
			String [] interestings = request.getParameterValues("interesting");
			for(String interest: interestings){
				System.out.println("-->" + interest);
			}
			
		//3、Enumeration getParameterNames(): 返回参数名对应的 Enumeration 对象, 
		//类似于 ServletConfig(或 ServletContext) 的 getInitParameterNames() 方法.
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String val = request.getParameter(name);
			
			System.out.println("^^" + name + ": " + val);
		}
		
		//4、Map getParameterMap(): 返回请求参数的键值对: key: 参数名,  value: 参数值, String 数组类型. 
		Map<String, String[]> map = request.getParameterMap();
		for(Map.Entry<String, String[]> entry: map.entrySet()){
			System.out.println("**" + entry.getKey() + ":" + Arrays.asList(entry.getValue()));  
		}
		
		//要先强转：
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		//获取URI(URI:根目录之后的路径）：
		String requestURI = httpServletRequest.getRequestURI();
		System.out.println(requestURI);
		
		//获取请求方式（post？get？）：
		String method = httpServletRequest.getMethod();
		System.out.println(method); 
		
		//获取请求参数的字符串
		//注意：post请求时，这里打印出来是null。get请求时，才有打印值出来，因为get把请求参数附着在URL的后面，用？来连接，是一个一个的键值对。
		String queryString = httpServletRequest.getQueryString();
		System.out.println("^-^" + queryString); 

		String servletPath = httpServletRequest.getServletPath();
		System.out.println("^-^2" + servletPath); 
		
		//设置响应的内容类型：
		//如果没有下面这行代码，helloworld就会直接打印在浏览器上
		response.setContentType("application/msword");

		PrintWriter out = response.getWriter();
		out.println("helloworld...");
	}
}
