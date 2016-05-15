<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type="text/javascript"> 
	function exitSystem()
	{ 
		window.parent.location.href=$("#contextPath").val()+"/demo/logout.action"; } 
	</script>

</head>
<body>
<center>当前用户：${manager.id} <a target="_top" href="http://localhost:8080/demo/logout.action">退出</a></center><br>
<br>
<marquee>欢迎进入办公用品管理系统</marquee>
</body>
</html>