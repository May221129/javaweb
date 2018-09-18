package com.llm.a01base.a03thirdwebapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ʵ�ʿ�����, ֱ�Ӽ̳� HttpServlet, ����������ʽ��д doXxx() ��������. 
 * �ô�: ֱ��������Եĸ��� doXxx() ����; ֱ��ʹ�� HttpServletRequest ��  HttpServletResponse, ������Ҫǿת. 
 */
public class A03loginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		//��ȡ����ʽ��get����post��
		String method = request.getMethod();
		System.out.println(method);
				
		//1����ȡ���������username��password(��HTML�ļ��е�������
		String username = request.getParameter("username");
		String password  = request.getParameter("password");
				
		//2����ȡ��ǰWEBӦ�õĳ�ʼ��������user��password
		//��Ҫʹ��ServletContext����
				
		String initUser = getServletContext().getInitParameter("user");
		String initPassword = getServletContext().getInitParameter("password");
				
		PrintWriter out = response.getWriter();
				
		//3���ȶ�
		//4����ӡ��Ӧ�ַ���
		if(initUser.equals(username) && initPassword.equals(password)){
			out.println("Hello:" + username);
		}else{
			out.print("Sorry:" + username);
		}
	}
}