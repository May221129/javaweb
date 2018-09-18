package com.llm.a02mvc.a01mvcapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��������ע�͵����ã��൱����web.xml����������<Servlet>��<Servlet-mapping>
@WebServlet("/listAllStudents")

public class ListAllStudentsServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
//	��дServlet���е�doGet()���������ʣ���ô֪������дdoGet()��������doPost()������==>�𰸼���note/01Servlet.txt��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StudentDao5 studentDao5 = new StudentDao5();
		List<Student4> students = studentDao5.getAll();
		request.setAttribute("students", students);
		request.getRequestDispatcher("/a01students3.jsp").forward(request, response);
	}
}