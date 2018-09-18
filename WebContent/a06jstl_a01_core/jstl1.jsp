<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.llm.a05tag.a01.customtag.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL核心标签</title>
</head>
<body>
	
	<h4>
		c:url 产生一个URL地址，可以根据cookie是否可用来智能进行URL重写、还可以对get请求的参数进行编码
		可以把产生的URL存储在域对象的属性中；
		还可以使用c:param为URL添加参数； c:url会对参数进行自动转码
		value中的 / 代表的是当前web应用的根目录
	</h4>
	<c:url value="/a06jstl_a01_core_test.jsp" var="testurl">
		<c:param name="name" value="赖丽梅"></c:param>
	</c:url>
	<h5>打印URL</h5>
	url:${testurl }
	
	<br><br>
	
	<h4>c:redirect 使当前JSP页面重定向到指定的页面；使当前jsp转发到指定的页面forward</h4>
	<%--<jsp:forward page="test2.jsp"></jsp:forward>-->
	<!-- 如果这里的URL是“/test2.jsp”，因为这是放在一个标签里，所以是给JSP来解析的，所以/代表的是Web引用的根目录 -->
	<c:redirect url="http://www.baidu.com"></c:redirect>
	--%>
	
	<br><br>
	
	<h4>c:import 可以包含任何页面到当前页面</h4>
	<c:import url="http://www.baidu.com"></c:import>
	
	<br><br>
	
	<h4>c:forTokens :处理字符串的，类似于String的split()方法</h4>
	<c:set value="a,b,c.d,e,f;g;h;j" var="test" scope="request"></c:set>
	<c:forTokens items="${requestScope.test }" delims="," var="s">
		${s }<br>
	</c:forTokens>
	
	<br><br>
	
	<h4>c:forEach 可以对数组、collection、map进行遍历</h4>
	<h5>began(对于集合是从0开始算)；end：结束于X； step：每隔X个数</h5>
	<!-- 下面是没有items的情况下:1~10,每隔3 -->
	<c:forEach begin="1" end="10" step="3" var="i">
		${i }
	</c:forEach>
	<br>
	<h5>c：forEach 遍历一个Collection(遍历数组也是一样的)</h5>
	<%
		List<Customer> custs = new ArrayList<Customer>();
		custs.add(new Customer(1,"AA"));
		custs.add(new Customer(2,"BB"));
		custs.add(new Customer(3,"CC"));
		custs.add(new Customer(4,"DD"));
		custs.add(new Customer(5,"EE"));
		custs.add(new Customer(6,"FF"));
		request.setAttribute("custs", custs);
	%>
	<h5>c:forEach的通常用法一：</h5>
	<c:forEach items="${requestScope.custs}" var="cust">
		${cust.id }--${cust.name }<br>
	</c:forEach>
	<br>
	<h5>c:forEach的通常用法二：</h5>
	<!-- c:forEach的varStatus属性可以获取到当前成员的索引，是第几个，是否是第一个，是否是最后一个 -->
	<c:forEach items="${requestScope.custs }" var="customer" begin="1" end="5" step="2" varStatus="status">
		--${status.index},${status.count},${status.first},${status.last}:${customer.id }: ${customer.name }<br>
	</c:forEach>
	<br>
	<h5>c:forEach 遍历Map</h5>
	<%
		Map<String, Customer> custMap = new HashMap<String, Customer>();
		custMap.put("a", new Customer(1,"AA"));
		custMap.put("b", new Customer(2,"BB"));
		custMap.put("c", new Customer(3,"CC"));
		custMap.put("d", new Customer(4,"DD"));
		custMap.put("e", new Customer(5,"EE"));
		request.setAttribute("custMap", custMap);
	%>
	<c:forEach items="${requestScope.custMap }" var="cust2">
		<!-- 下面输出的是当前成员的引用： -->
		${cust2.key },${cust2.value }<br>
	</c:forEach>
	<br>
	<c:forEach items="${requestScope.custMap }" var="cust2">
		<!-- 下面输出的是当前成员的引用： -->
		${cust2.key }--${cust2.value.id }--${cust2.value.name }<br>
	</c:forEach>
	<br>
	<h5>c：forEach 遍历一个数组)</h5>
	<%
		String [] names = new String[]{"A","B","C"};
		request.setAttribute("names", names);
	%>
	<c:forEach items="${names }" var="name">
		${name }->
	</c:forEach>
	<br>
	<!-- 提问：为什么我要写了下面这行代码（还在URL后面加了?subject=...），后面那个forEach才能在页面打印出东西呢？ -->
	<c:set var="subject222" value="${param.subject }" scope="session"></c:set>	
	<h5>在学习“表达式操作 c:set”时，我为session设置了一个自定义变量var为subject，这里利用c:forEach进行获取 </h5>
	<c:forEach items="${pageContext.session.attributeNames }" var="attrName" begin="0">
		${attrName }^_^
	</c:forEach>
	
	<br><br>
	
	<h4>c:choose, c:when, c:otherwise: 可以实现if...else if...else if...else的效果，但较为麻烦</h4>
	<h5>其中，c:choose 是以 c:when、 c:otherwise 的父标签出现，且不能脱离 c:choose 而单独使用；c:otherwise 必须在c:when之后使用</h5>
	<c:choose>
		<c:when test="${param.age > 60 }">老年</c:when>
		<c:when test="${param.age > 40 }">中年</c:when>
		<c:when test="${param.age > 18 }">青年</c:when>
		<c:otherwise>未成年</c:otherwise>
	</c:choose>
	
	<br><br>
	
	<h4>流程控制 c:if </h4>
	<h5>(缺点：只能有一个判断，不能有else...；优点：可把判断的结果储存起来，以备之后使用。)</h5>
	<c:set value="20" var="age" scope="request"></c:set>
	<c:if test="${requestScope.age > 18 }">成年了...</c:if>
	<br>
	<c:if test="${param.age > 18 }" var="isAdult" scope="request"></c:if>
	isAdult:${requestScope.isAdult }
	
	<br><br>
	
	<h4>表达式操作 c:remove 移除指定域对象的指定属性</h4>
	<c:set value="2017-10-18" var="date" scope="session"></c:set>
	date:${sessionScope.date }
	<br>
	<c:remove var="date" scope="session"/>
	--date:${sessionScope.date }
	
	<br><br>
	
	<h4>表达式操作 c:set</h4>
	<!-- c:set的作用：可以为域赋属性值，其中value属性值也可以是EL表达式；
		还可以为域对象中的JavaBean的属性赋值，target、value都支持EL表达式。 -->
	<c:set var="name" value="ATLLM" scope="page"></c:set>
	<!-- 上面这行代码，相当于： -->
	<%--
		pageContext.setAttribute("name", "ATLLM");
	--%>
	name:${pageScope.name }
	<br>
	<c:set var="subject" value="${param.subject }" scope="session"></c:set>	
	^_^subject:${sessionScope.subject }
	<br>
	<%
		Customer  cust = new Customer();
		cust.setId(1001);
		request.setAttribute("cust", cust);
	%>
	ID:${requestScope.cust.id }
	<br>
	<!-- c:set为JavaBean的属性赋值： -->
	<c:set target="${requestScope.cust }" property="id" value="${param.id }"></c:set>
	--ID:${requestScope.cust.id }
		
	<br><br>
	
	<h4>表达式操作 c:out</h4>
	<!-- c:out 可以对特殊字符进行转换，不影响输出 -->
	<%
		request.setAttribute("book", "<<Java>>");
	%>
	<!-- 要实现的功能：在页面上显示上面的内容：里面有<>,EL无法 进行解析，页面上显示不了 -->
	<!-- 1. 用EL来实现： -->
	book:${requestScope.book}
	<br><br>
	<!-- 2. 用JSTL的c:out来实现：遇到<>敏感字符会自动进行转译：&lt;&lt;Java&gt;&gt; 、
		default="booktitle"：默认值为booktitle，如果找不到requestScope.book，就会在页面展示默认值-->
	<c:out value="${requestScope.book }" default="booktitle"></c:out>
	
</body>
</html>