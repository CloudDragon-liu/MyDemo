<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pageContext 访问其他域</title>
</head>
<body>
	<%
		// 		request.setAttribute("data", "aa"); // request 域对象
		// 		String string = (String) pageContext.getAttribute("data", pageContext.REQUEST_SCOPE);
		// 		out.write(string);
		// 		String data = (String) pageContext.findAttribute("data"); // page request session application
	%>

	<%
		// 		pageContext.forward("/jsp/case/out.jsp");
		// 		pageContext.include("/jsp/public/head.jsp");
	%>
	<jsp:forward page="/CacheServlet">
		<jsp:param value="liuyunlong9" name="username" />
	</jsp:forward>
</body>
</html>