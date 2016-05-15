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
<form action="" method="post">
	<center>
	<!-- 显示错误信息 -->
	<c:if test="${allErrors!=null }">
		<c:forEach items="${allErrors }" var="error">
			<font color="red">${error.defaultMessage }</font>&nbsp;&nbsp;
		</c:forEach>
	</c:if>
	</center><br/>
	<table align="center" width="80%" border=1>
		<tr>
			<td>出库类型</td>
			<td>登记编号</td>
			<td>物品编号</td>
			<td>物品名称</td>
			<td>规格型号</td>
			<td>单位</td>
			<td>单价</td>
			<td>数量</td>
			<td>金额</td>
			<td>备注</td>
		</tr>
		<c:forEach items="${outstockList }" var="outstock">
			<tr>
				<td>${outstock.type }</td>
				<td>${outstock.number }</td>
				<td>${outstock.itemsCustom.number }</td>
				<td>${outstock.itemsCustom.name }</td>
				<td>${outstock.itemsCustom.model }</td>
				<td>${outstock.itemsCustom.piece }</td>
				<td>${outstock.itemsCustom.price }</td>
				<td>${outstock.sumNum }</td>
				<td>${outstock.sumMoney }</td>
				<td>${outstock.note }</td>
			</tr>
		</c:forEach>
	</table>
	<!-- 分页 -->
	<center>
		第${pageList.pageNo }/共${pageList.pages }页
		<a href="${pageContext.request.contextPath }/findOutstockByDate.action?dateBefore=${outstock.dateBefore }&dateAfter=${outstock.dateAfter }">首页</a>
		<c:if test="${pageList.pageNo>1 }">
			<a href="${pageContext.request.contextPath }/findOutstockByDate.action?dateBefore=${outstock.dateBefore }&dateAfter=${outstock.dateAfter }&pageNo=${pageList.pageNo-1 }">上一页</a>
		</c:if>
		<!-- 计算begin，end -->
		<c:choose>
			<c:when test="${pageList.pages<=10 }">
				<c:set var="begin" value="1"/>
				<c:set var="end" value="${pageList.pages }"/>
			</c:when>
			<c:otherwise>
				<!-- 当页面>10时，通过公式计算出begin和end -->
				<!-- <c:set var="begin" value="${pageList.pageNo-5 }"/>
				<c:set var="end" value="${pageList.pageNo+4 }"/>
				     头溢出
				<c:if test="${begin<1 } ">
					<c:set var="begin" value="1"/>
					<c:set var="end" value="10"/>
				</c:if> -->
				<c:if test="${pageList.pageNo<4 }">
					<c:set var="begin" value="${pageList.pageNo }"/>
					<c:set var="end" value="${pageList.pageNo+6 }"/>
				</c:if>
				
				<c:if test="${pageList.pageNo>=4 }">
					<c:set var="begin" value="${pageList.pageNo-3 }"/>
					<c:set var="end" value="${pageList.pageNo+3 }"/>
				</c:if>
				<!-- 尾溢出 -->
				<c:if test="${end>pageList.pages }">
					<c:set var="begin" value="${pageList.pages-6 }"/>
					<c:set var="end" value="${pageList.pages }"/>
				</c:if>
			</c:otherwise>
		</c:choose>

		<!-- 循环遍历页码表 -->
		<c:forEach var="i" begin="${begin }" end="${end }">
			<c:choose>
				<c:when test="${i eq pageList.pageNo }">
					[${i }]
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath }/findOutstockByDate.action?dateBefore=${outstock.dateBefore }&dateAfter=${outstock.dateAfter }&pageNo=${i }">[${i }]</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:if test="${pageList.pageNo<pageList.pages }">
			<a href="${pageContext.request.contextPath }/findOutstockByDate.action?dateBefore=${outstock.dateBefore }&dateAfter=${outstock.dateAfter }&pageNo=${pageList.pageNo+1 }">下一页</a>
		</c:if>
	
		<a href="${pageContext.request.contextPath }/findOutstockByDate.action?dateBefore=${outstock.dateBefore }&dateAfter=${outstock.dateAfter }&pageNo=${pageList.pages }">尾页</a>		
	</center> 
</form>
</body>
</html>