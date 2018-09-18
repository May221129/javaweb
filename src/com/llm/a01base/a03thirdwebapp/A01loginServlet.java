package com.llm.a01base.a03thirdwebapp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//��ֱ��ʵ��Servlet�ӿڣ����Ǽ̳��Ѿ�ʵ����Servlet�ӿں�ServletConfig�ӿڵ�MyGenericServlet��
public class A01loginServlet extends GenericServlet{
	
	//�Ե�ǰ��Servlet���г�ʼ������Ҫ����init()����
	//������ֱ�Ӹ��� init(ServletConfig), ��Ϊ������Ǳ�д super.init(config); ���������� SerlvetConfig �ӿڵķ���,�����ֿ�ָ���쳣. 
	@Override
	public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
	
	@Override
	public void service(ServletRequest request, ServletResponse reponse) throws ServletException, IOException {
		
		//��ȡ����ʽ��get����post��
		HttpServletRequest httpSerbletRequest = (HttpServletRequest)request;
		String method = httpSerbletRequest.getMethod();
		System.out.println(method);
		
		//1����ȡ���������username��password(��HTML�ļ��е�������
		String username = request.getParameter("username");
		String password  = request.getParameter("password");
		
		//2����ȡ��ǰWEBӦ�õĳ�ʼ��������user��password
		//��Ҫʹ��ServletContext����
		
		String initUser = getServletContext().getInitParameter("user");
		String initPassword = getServletContext().getInitParameter("password");
		
		PrintWriter out = reponse.getWriter();
		
		//3���ȶ�
		//4����ӡ��Ӧ�ַ���
		if(initUser.equals(username) && initPassword.equals(password)){
			out.println("Hello:" + username);
		}else{
			out.print("Sorry:" + username);
		}
	}
}
