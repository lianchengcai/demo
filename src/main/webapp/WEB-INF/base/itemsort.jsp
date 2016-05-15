<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<a href="${pageContext.request.contextPath }/findItemsort.action" target="right_down">查看物品类型</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/addItemsort.action" target="right_down">添加物品类型</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/findItems.action" target="right_down">查看物品信息</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/addItems.action" target="right_down">添加物品信息</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/findItemsByLimit.action" target="right_down">查询超限情况</a>
</center>
</body>
</html>