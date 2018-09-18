<%@page import="com.llm.a08listener.Customer03"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h4>HttpSessionBindingListener</h4>
	
	<!-- 测试感知Session绑定的事件监听器：HttpSessionBindingListener -->
	<%--
		Customer03 customer = new Customer03();
		session.setAttribute("customer", customer);
		System.out.println("---------------");
		
		session.removeAttribute("customer");
	--%>
	
	<!-- 感知session被活化或钝化的监听器：HttpSessionActivationListener -->
	<%
		Object customer = session.getAttribute("customer");
		if(customer == null){
			customer = new Customer03();
			session.setAttribute("customer", customer);
			System.out.println("创建一个新的Customer03对象:" + customer + "并放入到session中。");
		}else{
			System.out.println("从session中读取到Customer03对象：" + customer);
		}
	
	%>
	
</body>
</html>