<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h4>Index Page</h4>
	
	<a href="test2.jsp">To test page</a>
	
	<!-- request: 是一个请求, 当一个响应返回时, 即被销毁. 当发送一个请求时被创建. 注意, 请求转发的过程是一个 request 对象. -->
	<%--
		request.setAttribute("requestKey","requestValue");
		<jsp:forward page="test2.jsp"></jsp:forward>
	--%>
	
	<br><br>
	
	<a href="TestServlet">TestServlet</a>
	
</body>
</html>