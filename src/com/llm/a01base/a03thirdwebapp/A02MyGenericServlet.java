package com.llm.a01base.a03thirdwebapp;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 是什么：自定义的一个Servlet接口的实现类
 * 目的：让开发的任何Servlet都继承该类，以简化开发。
 */
public abstract class A02MyGenericServlet implements Servlet, ServletConfig {

	/**以下方法为Servlet接口的方法 **/
	
	@Override
	public void destroy() {}

	@Override
	public ServletConfig getServletConfig() {
		return servletConfig;
	}

	@Override
	public String getServletInfo() {
		return null;
	}
	
	//把servletConfig设置为成员变量
	private ServletConfig servletConfig;
	
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		//把传进来的servletConfig传给成员变量servletConfig：
		this.servletConfig = servletConfig;
		init();
	}
	
	public void init() throws ServletException {}

	@Override
	public abstract void service(ServletRequest request, ServletResponse response) throws ServletException, IOException;
	
	/**
	 * 以下方法为ServletConfig接口的方法
	 * 方法中的返回的servletConfig均为上面init()方法中的servletConfig
	 * 我们无法自己写下面这些方法的实现，均需依靠servletConfig
	 */
	@Override
	public String getInitParameter(String arg0) {	
		return servletConfig.getInitParameter(arg0);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		return servletConfig.getInitParameterNames();
	}

	@Override
	public ServletContext getServletContext() {
		return servletConfig.getServletContext();
	}

	@Override
	public String getServletName() {
		return servletConfig.getServletName();
	}
}
