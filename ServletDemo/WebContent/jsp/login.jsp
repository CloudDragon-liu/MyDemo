<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
姓名：<input type="text"><br />
密码：<input type="password"><br />
验证码：<input type="text"> &nbsp;<img style="cursor: pointer;" alt="输入验证码" src="/ServletDemo/ValidateCodeServlet" onclick="changeImage(this)"><br />
<input type="button" value="登录">
<script type="text/javascript">
	function changeImage(img){
		img.src = img.src + "?" + new Date().getTime();
	}
	
</script>
</body>
</html>