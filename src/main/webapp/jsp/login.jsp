<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function changeImg(){
	    document.getElementById("randomcode_img").src="http://localhost:8080/demo/validatecode.jsp?t="+Math.random();

	}
	

</SCRIPT>

</head>
<body>

<form action="${pageContext.request.contextPath }/SecurityVerification/login.action" method="post">
	<table align="center" border=1>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="username"/></td>
		</tr>
		<tr>
			<td>密码：<td>
			<input type="password" name="password"/></td>
		</tr>
		
		<tr>
			<td>验证码：<td>
			<input id="randomcode" name="randomcode" size="8" />
			<img id="randomcode_img" alt="absMiddle" src="http://localhost:8080/demo/validatecode.jsp" onclick="changeImg()">
			</td>
		</tr>

		<tr>
			<td colspan="2" align="center"><input type="submit" value="登录"/></td>
		</tr>
	</table>
</form>
</body>
</html>