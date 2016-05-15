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
<form action="${pageContext.request.contextPath }/addOutstockSubmit.action" method="post">
	<center>
	<!-- 显示错误信息 -->
	<c:if test="${allErrors!=null }">
		<c:forEach items="${allErrors }" var="error">
			<font color="red">${error.defaultMessage }</font><br/>
		</c:forEach>
	</c:if>
	</center><br/>
	<table align="center" width="22%" border=1>
		<tr>
			<td>登记编号</td>
			<td><input type="text" name="number"/></td>
		</tr>
		
		<tr>
			<td>出库日期</td>
			<td><input type="text" name="date"/></td>
		</tr>
		
		<tr>
			<td>出库类型</td>
			<td><input type="text" name="type"/></td>
		</tr>
		
		<tr>
			<td>领用部门</td>
			<td><input type="text" name="dept"/></td>
		</tr>
		
		<tr>
			<td>领用人</td>
			<td><input type="text" name="receiver"/></td>
		</tr>
		
		<tr>
			<td>制单人</td>
			<td><input type="text" name="operator"/></td>
		</tr>
		
		<tr>
			<td>物品</td>
			<td><input type="text" name="items"/></td>
		</tr>
		
		<tr>
			<td>备注</td>
			<td><input type="text" name="note"/></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"><input type="submit" value="添加"/></td>
		</tr>
	</table>
</form>
</body>
</html>