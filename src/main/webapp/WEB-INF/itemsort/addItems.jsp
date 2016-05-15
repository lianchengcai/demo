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
<form action="${pageContext.request.contextPath }/addItemsSubmit.action" method="post">
	<table align="center" width="23%" border=1>
		<tr>
			<td>物品编号</td>
			<td><input type="text" name="number"/></td>
		</tr>
		
		<tr>
			<td>物品名称</td>
			<td><input type="text" name="name"/></td>
		</tr>
		
		<tr>
			<td>物品分类</td>
			<td><input type="text" name="sort"/></td>
		</tr>
		
		<tr>
			<td>规格型号</td>
			<td><input type="text" name="model"/></td>
		</tr>
		
		<tr>
			<td>单位</td>
			<td><input type="text" name="piece"/></td>
		</tr>
		
		<tr>
			<td>单价</td>
			<td><input type="text" name="price"/></td>
		</tr>
		
		<tr>
			<td>库存数量</td>
			<td><input type="text" name="totalNum"/></td>
		</tr>
		
		<tr>
			<td>库存金额</td>
			<td><input type="text" name="totalMoney"/></td>
		</tr>
		
		<tr>
			<td>库存上限</td>
			<td><input type="text" name="higher"></td>
		</tr>
		
		<tr>
			<td>库存下限</td>
			<td><input type="text" name="lower"></td>
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