<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>dispatcher</title>
</head>
<body>
	
	<h5>体会通过web.xml文件中的设置dispatcher控制过滤器工作的时机</h5>
	
	<%--
	<!--请求的转发触发Filter工作：-->
	<jsp:forward page="/a07filter_a01_filter1/test2.jsp"></jsp:forward>
	
	<!--包含页面触发Filter工作：-->
	 <jsp:include page="/a07filter_a01_filter1/test2.jsp"></jsp:include>
	 --%>
	 
	 <!-- 页面有异常 触发Filter工作： -->
	 <%-- 页面有声明时异常的两种指定错误页面处理方式：其中第一种方式不能触发，第二种才能
	 	1. <%@ page errorPage="...";
	 	2. 在web.xml配置文件中，指定一个 error-page --%> 
	 <%
	 	int i = 10 / 0;
	 %>
	 
</body>
</html>