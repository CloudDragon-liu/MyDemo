<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/errors/error_page.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>case1</title>
</head>
<body>
	<%
		Date date = new Date();
		out.write(date.toLocaleString());
		int x = 1 / 0;
	%>
	<!-- <p>哈哈</p> -->
	<%
		out.print(x);
	%>
</body>
</html>