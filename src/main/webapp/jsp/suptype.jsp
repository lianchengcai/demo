<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function findSupplyByDate(){
		//提交form
		document.itemsForm.action="${pageContext.request.contextPath }/findSupplyByDate.action";
		document.itemsForm.submit();
	}
</script>
</head>
<body>
<form name="itemsForm" action="" target="right_down" method="post">
<center>
	开始时间:<input type="text" name="dateBefore"/>
	结束时间:<input type="text" name="dateAfter"/>
	<input type="button" value="查询供货情况" onclick="findSupplyByDate()"/><br/><br/>
	
	<a href="${pageContext.request.contextPath }/findSuptype.action" target="right_down">查看供应商类型</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/addSuptype.action" target="right_down">添加供应商类型</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/findSupplier.action" target="right_down">查看供应商信息</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/addSupplier.action" target="right_down">添加供应商信息</a><br/><br/>
</center>
</form>
</body>
</html>