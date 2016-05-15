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
<form action="${pageContext.request.contextPath }/updateEmployeeSubmit.action" method="post">
	<input type="hidden" name="id" value="${employee.id }"/>
	<table align="center" width="22%" border=1>
		<tr>
			<td>员工编号</td>
			<td><input type="text" name="number" value="${employee.number }"/></td>
		</tr>
		
		<tr>
			<td>员工名称</td>
			<td><input type="text" name="name" value="${employee.name }"/></td>
		</tr>
		
		<tr>
			<td>员工部门</td>
			<td><input type="text" name="dept" value="${employee.dept }"/></td>
		</tr>
		
		<tr>
			<td>手机号码</td>
			<td><input type="text" name="telephone" value="${employee.telephone }"/></td>
		</tr>
		
		<tr>
			<td>性别</td>
			<td><input type="text" name="sex" value="${employee.sex }"/></td>
		</tr>
		
		<tr>
			<td>工作</td>
			<td><input type="text" name="job" value="${employee.job }"/></td>
		</tr>
		
		<tr>
			<td>备注</td>
			<td><input type="text" name="note" value="${employee.note }"/></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"><input type="submit" value="提交"/></td>
		</tr>
	</table>
</form>
</body>
</html>