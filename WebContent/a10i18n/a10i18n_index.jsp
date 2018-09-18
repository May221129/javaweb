<%@page import="java.util.Locale"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>利用标签实现JavaWeb的国际化</title>
</head>
<body>
	 
	<%
		Date date = new Date();
		request.setAttribute("date", date);
		request.setAttribute("salary", 12345.67);
	%>
	
	<%--
	<fmt:bundle basename="i18n">
		<fmt:message key="date"></fmt:message>:
		<fmt:formatDate value="${date }"/>,
		<fmt:message key="salary"></fmt:message>:
		<fmt:formatNumber value="${salary }"></fmt:formatNumber>.
	</fmt:bundle>
	<br><br>
	 --%>
	 
	 <%
	 	String code = request.getParameter("code");
	 	if(code != null){
	 		if("zh".equals(code)){
	 			session.setAttribute("locale",Locale.CHINA );
	 		}else if("en".equals(code)){
	 			session.setAttribute("locale", Locale.US);
	 		}
	 	}
	 %>
	
	<c:if test="${sessionScope.locale != null }">
		<fmt:setLocale value="${sessionScope.locale }"/>
	</c:if>
	
	<fmt:setBundle basename="/com.llm.a10.i18n/i18n"/>
	
	<fmt:message key="date"></fmt:message>:
	<fmt:formatDate value="${date }" dateStyle="FULL"/>,
	<fmt:message key="salary"></fmt:message>:
	<fmt:formatNumber value="${salary }" type="currency"></fmt:formatNumber>.
	<br><br>
	
	<a href="a10i18n_index.jsp?code=zh">中文</a>\
	<a href="a10i18n_index.jsp?code=en">English</a>
	
</body>
</html>