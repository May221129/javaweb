<%@page import="com.llm.a05tag.a01.customtag.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 导入标签库(描述文件)： -->
<%@taglib uri="http://www.atllm.com/a05tag_a01_mytag/core" prefix="atllm" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用标签和EL的方式来完成requestScope的属性的读取和遍历</title>
</head>
<body>
	
	<!-- 使用EL自定义函数： -->
	${fn:length(param.name) }
	
	<br><br>
	
	<!-- 测试自定义的EL自定义函数：两个字符串的拼接 -->
	${atllm:concat(param.name1,param.name2)}
	
	<br><br>
	
	<!-- 测试带父标签的自定义标签 -->
	<atllm:chooseParentTag>
		<atllm:whenSonTag test="${param.age > 24 }">--大学毕业</atllm:whenSonTag>
		<atllm:whenSonTag test="${param.age > 20 }">--高中毕业</atllm:whenSonTag>
		<atllm:otherwise>--高中以下学历...</atllm:otherwise>
	</atllm:chooseParentTag>
	
	<br><br>
	
	<c:choose>
		 <c:when test="${param.age > 24 }">大学毕业</c:when>
		 <c:when test="${param.age > 20 }">高中毕业</c:when>
		 <c:otherwise>高中以下学历...</c:otherwise>
	</c:choose>
	
	<br><br>
	
	<!-- 体验父标签 -->
	<!-- 父标签：打印name到控制台 -->
	<atllm:parentTag>
		<!-- 子标签以父标签的标签体存在；子标签把父标签的name属性打印到JSP页面上 -->
		<atllm:sonTag/>
	</atllm:parentTag>
	
	<br><br>
	
	<!-- 体验c:forEach标签:遍历集合： -->
	<%
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(1,"AA"));
		customers.add(new Customer(2,"BB"));
		customers.add(new Customer(3,"CC"));
		customers.add(new Customer(4,"DD"));
		request.setAttribute("customers", customers);
	%>
	<c:forEach items="${requestScope.customers }" var="cust">
		${cust.id }--${cust.name } <br>
	</c:forEach>
	
	<br><br>
	
	<!-- 体验自定义标签:forEach标签:遍历集合： -->
	<atllm:forEach items="${requestScope.customers }" var="cust">
		--${cust.id }--${cust.name } <br>
	</atllm:forEach>
	
	<br><br>
	
	<!-- 测试com.llm.a05tag.a01.customtag.PrintUppercaseNTime5：把标签体内容转换为大写, 并输出 time 次到浏览器上 -->
	<atllm:testUppercaseNTime time="10">I Love You</atllm:testUppercaseNTime>
	
	<br><br>
	
	<!-- 测试com.llm.a05tag.a01.customtag.HelloSimpleTag1：自定义标签入门 -->
	<!-- 需求：把value值在jsp页面上打印10遍。
		  提问：下面写的value="atllm" count="10"属性，怎么传给标签处理器类呢？
		  答：需要通过标签的属性，即在标签的实现类中设置setValue()和setCount()方法 -->
	<atllm:hello count="5" value="${param.name }"/><!-- 这里的param.name需要从RUL后加上？name=XXX -->
	
	<br><br>
	
	<!-- 测试com.llm.a05tag.a01.customtag.TestJspFragment4：带标签体的标签 -->
	<atllm:testJspFragment>hello:${param.name }</atllm:testJspFragment>
	
	<br><br>
	
	<!-- 测试com.llm.a05tag.a01.customtag.MaxTag2：带属性的自定义标签 -->
	<atllm:max number2="${param.a }" number1="${param.b }"/><!-- 这里的param.a/b需要从RUL后加上？a=X&b=Y -->
		
	<br><br>
	
	<!-- 测试com.llm.a05tag.a01.customtag.ReadFileTag3 -->
	<!-- 用于输出指定文件的内容：如果文件的内容有标签，则需要转换一下，
		否则HTML读取到这个标签时，会当做一般的标签处理，而不会在页面上打印出来 -->
	<atllm:readFile src="/WEB-INF/a05tag_a01_testprintfile.txt"/>
		
</body>
</html>