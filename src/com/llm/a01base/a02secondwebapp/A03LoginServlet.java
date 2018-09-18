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
	//service()��������Ӧ��������Ϊÿ�����󶼻����service()������
		//����д�Ĵ��룬����service()�����У�
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("��������...");
		System.out.println(request); 
		
		//��ȡ���������4����Ҫ������
		
		//1��getParametere():����������������֣������������ֵ
		//����������ж�����÷���ֻ�ܻ�ȡ����һ���ύ��ֵ
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		System.out.println(user + ", " + password); 
		
		String interesting = request.getParameter("interesting");
		System.out.println(interesting); 
				
		//2��getParameterValues():����������������֣��������������Ӧ���ַ�������
			String [] interestings = request.getParameterValues("interesting");
			for(String interest: interestings){
				System.out.println("-->" + interest);
			}
			
		//3��Enumeration getParameterNames(): ���ز�������Ӧ�� Enumeration ����, 
		//������ ServletConfig(�� ServletContext) �� getInitParameterNames() ����.
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String val = request.getParameter(name);
			
			System.out.println("^^" + name + ": " + val);
		}
		
		//4��Map getParameterMap(): ������������ļ�ֵ��: key: ������,  value: ����ֵ, String ��������. 
		Map<String, String[]> map = request.getParameterMap();
		for(Map.Entry<String, String[]> entry: map.entrySet()){
			System.out.println("**" + entry.getKey() + ":" + Arrays.asList(entry.getValue()));  
		}
		
		//Ҫ��ǿת��
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		//��ȡURI(URI:��Ŀ¼֮���·������
		String requestURI = httpServletRequest.getRequestURI();
		System.out.println(requestURI);
		
		//��ȡ����ʽ��post��get������
		String method = httpServletRequest.getMethod();
		System.out.println(method); 
		
		//��ȡ����������ַ���
		//ע�⣺post����ʱ�������ӡ������null��get����ʱ�����д�ӡֵ��������Ϊget���������������URL�ĺ��棬�ã������ӣ���һ��һ���ļ�ֵ�ԡ�
		String queryString = httpServletRequest.getQueryString();
		System.out.println("^-^" + queryString); 

		String servletPath = httpServletRequest.getServletPath();
		System.out.println("^-^2" + servletPath); 
		
		//������Ӧ���������ͣ�
		//���û���������д��룬helloworld�ͻ�ֱ�Ӵ�ӡ���������
		response.setContentType("application/msword");

		PrintWriter out = response.getWriter();
		out.println("helloworld...");
	}
}
