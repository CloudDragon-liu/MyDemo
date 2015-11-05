<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中文乱码Demo</title>
</head>
<body>
	<a href="/ServletDemo/DisorderCodeServlet?username=大家好&username=liuyunlong2&password=123456789">点我</a>
	<form action="/ServletDemo/DisorderCodeServlet" method="post">
		用户名：<input type="text" name="username"/> <br/>
		<input type="submit" value="提交"/><br>
	</form>
</body>
</html>