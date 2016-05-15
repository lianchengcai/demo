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
<form action="${pageContext.request.contextPath }/updateSupplierSubmit.action" method="post">
	<input type="hidden" name="id" value="${supplier.id }"/>
	<table align="center" width="25%" border=1>
		<tr>
			<td>供应商编号</td>
			<td><input type="text" name="number" value="${supplier.number }"/></td>
		</tr>
		
		<tr>
			<td>供应商全称</td>
			<td><input type="text" name="fullName" value="${supplier.fullName }"/></td>
		</tr>
		
		<tr>
			<td>供应商简称</td>
			<td><input type="text" name="simName" value="${supplier.simName }"/></td>
		</tr>
		
		<tr>
			<td>供应商类型</td>
			<td><input type="text" name="type" value="${supplier.type }"/></td>
		</tr>
		
		<tr>
			<td>备注</td>
			<td><input type="text" name="note" value="${supplier.note }"/></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"><input type="submit" value="提交"/></td>
		</tr>
	</table>
</form>
</body>
</html>