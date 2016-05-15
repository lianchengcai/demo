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
<form action="${pageContext.request.contextPath }/updateSuptypeSubmit.action" method="post">
	<input type="hidden" name="id" value="${suptype.id }"/>
	<table align="center" width="22%" border=1>
		<tr>
			<td>类型编号</td>
			<td><input type="text" name="suptypeNumber" value="${suptype.suptypeNumber }"/></td>
		</tr>
		
		<tr>
			<td>类型名称</td>
			<td><input type="text" name="suptypeName" value="${suptype.suptypeName }"/></td>
		</tr>
		
		<tr>
			<td>备注</td>
			<td><input type="text" name="note" value="${suptype.note }"/></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"><input type="submit" value="提交"/></td>
		</tr>
	</table>
</form>
</body>
</html>