<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
   
   <h3>AAA PAGE</h3>
   
   <% 
   		String str = "abcde";
   		
   %>
   
   <!-- 在 a.jsp 中包含 b.jsp -->
   <%--  
   <%@ include file="b.jsp" %>
   --%>
   
   <jsp:include page="/a01base_a04_jsp_include01/b.jsp">
		<jsp:param value="abcd" name="username"/>
   </jsp:include>

	
	<%-- 
	<jsp:forward page="/include/b.jsp">
		<jsp:param value="abcd" name="username"/>
	</jsp:forward>	   
		request.getRequestDispatcher("/a01base_a04_jsp_include01/b.jsp").forward(request, response);
	--%>
   
</body>
</html>