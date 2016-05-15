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
<form action="${pageContext.request.contextPath }/updateDeptSubmit.action" method="post">
	<input type="hidden" name="id" value="${dept.id }"/>
	<table align="center" width="22%" border=1>
		<tr>
			<td>部门编号</td>
			<td><input type="text" name="deptNumber" value="${dept.deptNumber }"/></td>
		</tr>
		
		<tr>
			<td>部门名称</td>
			<td><input type="text" name="deptName" value="${dept.deptName }"/></td>
		</tr>
		
		<tr>
			<td>备注</td>
			<td><input type="text" name="note" value="${dept.note }"/></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"><input type="submit" value="提交"/></td>
		</tr>
	</table>
</form>
</body>
</html>