<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/updateOutstockSubmit.action" method="post">
	<input type="hidden" name="id" value="${outstock.id }"/>
	<table align="center" width="22%" border=1>
		<tr>
			<td>登记编号</td>
			<td><input type="text" name="number" value="${outstock.number }"/></td>
		</tr>
		
		<tr>
			<td>出库日期</td>
			<td><input type="text" name="date" value='<fmt:formatDate value="${outstock.date }" pattern="yyyy-MM-dd HH:mm:ss"/>' /></td>
		</tr>
		
		<tr>
			<td>出库类型</td>
			<td><input type="text" name="type" value="${outstock.type }"/></td>
		</tr>
		
		
		<tr>
			<td>领用部门</td>
			<td><input type="text" name="dept" value="${outstock.dept }"/></td>
		</tr>
		
		<tr>
			<td>领用人</td>
			<td><input type="text" name="receiver" value="${outstock.receiver }"/></td>
		</tr>
		
		<tr>
			<td>制单人</td>
			<td><input type="text" name="operator" value="${outstock.operator }"/></td>
		</tr>
		
		<tr>
			<td>物品</td>
			<td><input type="text" name="items" value="${outstock.items }"/></td>
		</tr>
		
		<tr>
			<td>备注</td>
			<td><input type="text" name="note" value="${outstock.note }"/></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"><input type="submit" value="提交"/></td>
		</tr>
	</table>
</form>
</body>
</html>