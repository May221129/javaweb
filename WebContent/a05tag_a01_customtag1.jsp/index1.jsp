<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.llm.a03cookie.a03.javabean.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用传统的方式来完成request的属性的读取和遍历</title>
</head>
<body>

	<%
		//模拟Servlet中的操作：
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(1,"AA",11));
		customers.add(new Customer(2,"BB",12));
		customers.add(new Customer(3,"CC",13));
		customers.add(new Customer(4,"DD",14));
		customers.add(new Customer(5,"EE",15));
		
		request.setAttribute("customers", customers);
	%>
	
	<!-- 在页面上对request中的customers属性进行遍历，打印id，name，age -->
	<!-- 通过转发到test2.jsp和testtag.jsp页面来体现标签的优势： -->
	<jsp:forward page="testtag2.jsp"></jsp:forward>

</body>
</html>