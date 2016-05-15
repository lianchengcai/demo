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
<form action="${pageContext.request.contextPath }/updateItemsSubmit.action" method="post">
	<input type="hidden" name="id" value="${items.id }"/>
	<table align="center" width="22%" border=1>
		<tr>
			<td>物品编号</td>
			<td><input type="text" name="number" value="${items.number }"/></td>
		</tr>
		
		<tr>
			<td>物品名称</td>
			<td><input type="text" name="name" value="${items.name }"/></td>
		</tr>
		
		<tr>
			<td>物品分类</td>
			<td><input type="text" name="sort" value="${items.sort }"/></td>
		</tr>
		
		<tr>
			<td>规格型号</td>
			<td><input type="text" name="model" value="${items.model }"/></td>
		</tr>
		
		<tr>
			<td>单位</td>
			<td><input type="text" name="piece" value="${items.piece }"/></td>
		</tr>
		
		<tr>
			<td>单价</td>
			<td><input type="text" name="price" value="${items.price }"/></td>
		</tr>
		
		<tr>
			<td>库存数量</td>
			<td><input type="text" name="totalNum" value="${items.totalNum }"/></td>
		</tr>
		
		<tr>
			<td>库存金额</td>
			<td><input type="text" name="totalMoney" value="${items.totalMoney }"/></td>
		</tr>
		
		<tr>
			<td>备注</td>
			<td><input type="text" name="note" value="${items.note }"/></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"><input type="submit" value="提交"/></td>
		</tr>
	</table>
</form>
</body>
</html>