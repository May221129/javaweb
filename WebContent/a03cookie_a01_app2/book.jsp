<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cookie_book</title>
</head>
<body>
	
	<h4>Book Detail Page</h4>
	
	<!-- request.getParameter(String name):返回name指定参数的参数值 -->
	Book: <%= request.getParameter("book") %>
	
	<br><br>
	
	<a href="books.jsp">Return</a>
	
	<% 
	//下面这段Java代码，是代表服务器端的servlet响应代码吗？
	
		String book = request.getParameter("book");
	
		//把书的信息以 Cookie 方式传回给浏览器，删除一个 Cookie
		//1. 确定要被删除的 Cookie：
		//前提: AT_ 开头的 Cookie 数量大于或等于 5，
		Cookie [] cookies = request.getCookies();
		
		//保存所有的 AT_ 开头的 Cookie
		List<Cookie> bookCookies = new ArrayList<Cookie>();
		
		//用来保存和 books.jsp 传入的 book 匹配的那个 Cookie
		Cookie tempCookie = null;
		
		if(cookies != null && cookies.length > 0){
			for(Cookie c: cookies){
				String cookieName = c.getName();
				if(cookieName.startsWith("AT_")){
					bookCookies.add(c);
					
					if(c.getValue().equals(book)){
						tempCookie = c;
					}
				}
			}
		}
		
		//①. 且若从 books.jsp 页面传入的 book 不在 AT_ 的 Cookie 中,则删除较早的那个 Cookie
		//（ AT_  数组的第一个 Cbookie），
		if(bookCookies.size() >= 5 && tempCookie == null){
			tempCookie = bookCookies.get(0);
		}
		
		//②. 若在其中，则删除该 Cookie
		//删除Cookie时，只需要将Cookie的最大时效设置为0
		if(tempCookie != null){
			tempCookie.setMaxAge(0);
			response.addCookie(tempCookie);
		}
	
		//2. 把从 books.jsp 传入的 book 作为一个 Cookie 返回
		
		Cookie cookie = new Cookie("AT_" + book, book);
		response.addCookie(cookie);
		
	%>
	
</body>
</html>