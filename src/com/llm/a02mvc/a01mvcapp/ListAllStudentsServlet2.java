package com.llm.a02mvc.a01mvcapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//下面这行注释的作用：相当于在web.xml里面配置了<Servlet>和<Servlet-mapping>
@WebServlet("/listAllStudents")

public class ListAllStudentsServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
//	重写Servlet类中的doGet()方法（提问：怎么知道是重写doGet()方法还是doPost()方法？==>答案见：note/01Servlet.txt）
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StudentDao5 studentDao5 = new StudentDao5();
		List<Student4> students = studentDao5.getAll();
		request.setAttribute("students", students);
		request.getRequestDispatcher("/a01students3.jsp").forward(request, response);
	}
}