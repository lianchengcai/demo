<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function findDeptByDate(){
		//提交form
		document.itemsForm.action="${pageContext.request.contextPath }/findDeptByDate.action";
		document.itemsForm.submit();
	}
</script>

<script type="text/javascript">
	function findReceiverByDate(){
		//提交form
		document.itemsForm.action="${pageContext.request.contextPath }/findReceiverByDate.action";
		document.itemsForm.submit();
	}
</script>

<script type="text/javascript">
	function findOutstockByDate(){
		//提交form
		document.itemsForm.action="${pageContext.request.contextPath }/findOutstockByDate.action";
		document.itemsForm.submit();
	}
</script>

</head>
<body>
<form name="itemsForm" action="" target="right_down" method="post">
<center>
	开始时间:<input type="text" name="dateBefore" />
	结束时间:<input type="text" name="dateAfter" />
	<input type="button" value="领用部门" onclick="findDeptByDate()" />
	<input type="button" value="领用人" onclick="findReceiverByDate()" />		
	<input type="button" value="出库情况" onclick="findOutstockByDate()" /><br/><br/>		
	

	<a href="${pageContext.request.contextPath }/findOuttype.action" target="right_down">查看出库类型</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/addOuttype.action" target="right_down">添加出库类型</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/findOutstock.action" target="right_down">查看出库信息</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/addOutstock.action" target="right_down">添加出库信息</a>
</center>
</form>
</body>
</html>