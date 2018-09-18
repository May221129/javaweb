<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.llm.a02mvc.a01mvcapp.Student4"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%
		List<Student4> stus = (List<Student4>)request.getAttribute("students");
	%>
	
	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>FlowId</th>
			<th>Type</th>
			<th>IdCard</th>
			<th>ExamCard</th>
			<th>StudentName</th>
			<th>Location</th>
			<th>Grade</th>
			<th>Delete</th>
		</tr>
		
		<%
			for(Student4 student4 : stus){
		%>
			<tr>
				<td><%= student4.getFlowId() %></td>
				<td><%= student4.getType() %></td>
				<td><%= student4.getIdCard() %></td>
				<td><%= student4.getExamCard() %></td>
				<td><%= student4.getStudentName() %></td>
				<td><%= student4.getLocation() %></td>
				<td><%= student4.getGrade() %></td>
				<td><a href="deleteStudent?flowId=<%=student4.getFlowId() %>">Delete</a></td>
			</tr>
		<%		
			}
		%>
	</table>
	
</body>
</html>