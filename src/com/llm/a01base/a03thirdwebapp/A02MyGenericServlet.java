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
 * ��ʲô���Զ����һ��Servlet�ӿڵ�ʵ����
 * Ŀ�ģ��ÿ������κ�Servlet���̳и��࣬�Լ򻯿�����
 */
public abstract class A02MyGenericServlet implements Servlet, ServletConfig {

	/**���·���ΪServlet�ӿڵķ��� **/
	
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
	
	//��servletConfig����Ϊ��Ա����
	private ServletConfig servletConfig;
	
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		//�Ѵ�������servletConfig������Ա����servletConfig��
		this.servletConfig = servletConfig;
		init();
	}
	
	public void init() throws ServletException {}

	@Override
	public abstract void service(ServletRequest request, ServletResponse response) throws ServletException, IOException;
	
	/**
	 * ���·���ΪServletConfig�ӿڵķ���
	 * �����еķ��ص�servletConfig��Ϊ����init()�����е�servletConfig
	 * �����޷��Լ�д������Щ������ʵ�֣���������servletConfig
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
