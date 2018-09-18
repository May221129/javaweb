<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>字符编码的过滤器</title>
</head>
<body>
	
	<!-- 设置请求的编码：在读取param.name属性时，用户输入的是中文，不会显示乱码 -->
	<!--真正开发时，可能会有上百个请求，所以直接通过下面这种方式来实现是不太可能的，所以需要用到Filter -->
	<%--
		request.setCharacterEncoding("UTF-8");
	--%>
	hello:${param.name}
	
</body>
</html>