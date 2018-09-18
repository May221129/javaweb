package com.llm.a03cookie.a02.shoppingcart5;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/processStep1")
public class ProcessStep1Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1����ȡѡ�е�ͼ�����Ϣ
		String [] books = request.getParameterValues("book");
		
//		2����ͼ����Ϣ���뵽HttpSession��
		request.getSession().setAttribute("books", books);
		
//		���⣺����Ϊʲô�����ض��򣬶�������ת��������
//		3���ض���ҳ�浽 a03cookie_a02_shoppingcart5/step2.jsp
//		sendRedirect(Ҫ�ض����ĸ�ҳ�棬����д����·����Ҳ����д���·��)���������д�����Ϊ�˲��Կ�����·���Ƿ���ȷ�ģ�
		System.out.println(request.getContextPath() + "/a03cookie_a02_shoppingcart5/step2.jsp");
		response.sendRedirect(request.getContextPath() + "/a03cookie_a02_shoppingcart5/step2.jsp");
//		java�ļ�������.class�ļ����ڸ�·���µ�
	}
}
