<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function findInquiryByDate(){
		//提交form
		document.itemsForm.action="${pageContext.request.contextPath }/findInquiryByDate.action";
		document.itemsForm.submit();
	}
</script>
</head>
<body>

<form name="itemsForm" action="" target="right_down" method="post">
<center>
	开始时间:<input type="text" name="dateBefore" />
	结束时间:<input type="text" name="dateAfter" />
	<input type="button" value="入库情况" onclick="findInquiryByDate()" /><br/><br/>	
	
	<a href="${pageContext.request.contextPath }/findIntype.action" target="right_down">查看入库类型</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/addIntype.action" target="right_down">添加入库类型</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/findInquiry.action" target="right_down">查看入库信息</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/addInquiry.action" target="right_down">添加入库信息</a><br/><br/>
</center>
</form>
</body>
</html>