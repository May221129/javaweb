package com.llm.a02mvc.a01mvcapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		���󴫹�����flowID�Ǹ��ַ���
		String flowId = request.getParameter("flowId");
		
		StudentDao5 studentDao5 = new StudentDao5();
		studentDao5.deleteByFlowId(Integer.parseInt(flowId));//���ַ���תΪInteger����
		
		request.getRequestDispatcher("/a01success7.jsp").forward(request, response);
	}
}
