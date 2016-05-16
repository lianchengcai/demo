<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@  taglib  uri="http://java.sun.com/jsp/jstl/functions"   prefix="fn"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

</head>

<body>
	<center>
	<h3>系统功能管理</h3><br/>
	
	<c:if test="${manager.permission.contains(\"1\")}">
		<a href="dept.action" target="right_top" >部门员工管理</a><br/><br/>
	</c:if>
	<c:if test="${manager.permission.contains(\"2\")}">
		<a href="itemsort.action" target="right_top">物品分类管理</a><br/><br/>
	</c:if>
	<c:if test="${manager.permission.contains(\"3\")}">
		<a href="intype.action" target="right_top">入库类型管理</a><br/><br/>
	</c:if>
	<c:if test="${manager.permission.contains(\"4\")}">
		<a href="outtype.action" target="right_top">出库类型管理</a><br/><br/>
	</c:if>
	<c:if test="${manager.permission.contains(\"5\")}">
		<a href="suptype.action" target="right_top">供应商管理</a><br/><br/>
	</c:if>
	<c:if test="${manager.permission.contains(\"6\")}">
		<a href="manager.action" target="right_top">后台管理人员管理</a>
	</c:if>
	</center>
</body>
</html>