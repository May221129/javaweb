<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
</head>
<body>
	
	<!-- 文件都比较大，get的请求方式是将文件放在URL的？后面，文件大点就会放不下，需要用post -->
	<!-- 要写编码方式，否则你传过去的就可能是个字符,enctype -->
	<form action="../uploadServlet" method="post" enctype="multipart/form-data" >
		
		File:<input type="file" name="file">
		<br><br>
		Desc:<input type="text" name="desc">
		<br><br>
		<input type="submit" value="Submit">
		
	</form>
	
</body>
</html>