package com.llm.a01base.a03thirdwebapp;
//������ض���
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class B05RedirectServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("B05RedirectServlet2's doGet");
		
		request.setAttribute("name", "xyzmn");
		System.out.println("B05RedirectServlet2's name: " + request.getAttribute("name"));
		
		//ִ��������ض���, ֱ�ӵ��� response.sendRedirect(path) ����,
		//path ΪҪ�ض���ĵ�ַ
		String path = "B05TestServlet1";
		response.sendRedirect(path);
	}
}