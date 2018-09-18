<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% 
		
		HttpSession session = request.getSession(true);
		out.println(session.getId());
		out.print("<br>");
		
		//使当前的Session对象立即时效：
		//session.invalidate();
		
		//获取 Session 的最大时效, 以秒为单位，默认为 30 分钟. 
		session.setMaxInactiveInterval(60);
		out.print(session.getMaxInactiveInterval());
		//session.invalidate();
	%>
	
</body>
</html>