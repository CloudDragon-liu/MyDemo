<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户端带数据Demo</title>
</head>
<body>
	<a href="/ServletDemo/NormalRequestMethodsServlet?username=liuyunlong&username=liuyunlong2&password=123456789">点我</a>
	<form action="/ServletDemo/NormalRequestMethodsServlet" method="post">
		用户名：<input type="text" name="username"/> <br/>
		密码：<input type="text" name="password"/><br/>
		性别：<input type="radio" name="gender" value="男"/>男<input type="radio" name="gender" value="女"/>女<br/>
		所在地：<select name="city">
					<option value="beijin">北京</option>
					<option value="shanghai">上海</option>
					<option value="nanjing">南京</option>
				</select><br/>
		爱好：
		<input type="checkbox" name="hobby" value="sing"/>唱歌
		<input type="checkbox" name="hobby" value="basketball"/>篮球
		<input type="checkbox" name="hobby" value="football"/>足球<br/>
		简介：<textarea rows="2" cols="2" name="brief"></textarea><br/>
		头像：<input type="file" name="icon"/><br/>
		<input type="hidden" name="id" value="10"/>
		<input type="submit" value="提交"/><br>
	</form>
</body>
</html>