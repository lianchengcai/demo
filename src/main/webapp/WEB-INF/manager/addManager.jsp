<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/addManagerSubmit.action" method="post">
	<table align="center" width="23%" border=1>
		<tr>
			<td>工号</td>
			<td><input type="text" name="id" "/></td>
		</tr>
		
		<tr>
			<td>姓名</td>
			<td><input type="text" name="name" "/></td>
		</tr>
		
		<tr>
			<td>权限</td>
			<td><input type="text" name="permission" "/></td>
		</tr>
		
		<tr>
			<td>角色</td>
			<td><input type="text" name="role" "/></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"><input type="submit" value="添加"/></td>
		</tr>
	</table>
</form>
</body>
</html>