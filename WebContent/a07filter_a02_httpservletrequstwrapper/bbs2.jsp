<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Filiter的典型应用:为论坛过滤不雅文字和HTML特殊字符</title>
</head>
<body>
	
	content: ${param.content }
	
	<br><br>
	
	method: <%= request.getMethod() %>
	
	
	<br><br>
	<%= request %>
	
	
</body>
</html>