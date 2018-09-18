<%@page import="com.llm.a03cookie.a03.javabean.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用传统的方式来完成request的属性的读取和遍历</title>
</head>
<body>
	
	<!-- 在页面上对request中的customers属性进行遍历，打印id，name，age -->
	<%
		//先从request中获取customers属性：
		List<Customer> customers = (List<Customer>)request.getAttribute("customers");
		//再对读取到的customers进行遍历：
		if(customers != null){
			for(Customer customer : customers){
	%>
			<%= customer.getId() %>,<%= customer.getName() %>,<%= customer.getAge() %>
			<br>
	<% 
			}
		}
	%>
	
</body>
</html>