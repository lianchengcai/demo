<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="" method="post">

	<table align="center" width="80%" border=1>
		<tr>
			<td>登记编号</td>
			<td>入库日期</td>
			<td>入库类型</td>
			<td>供应商</td>
			<td>经办人</td>
			<td>制单人</td>
			<td>物品</td>
			<td>备注</td>
			<td colspan="2" align="center">操作</td>
		</tr>
		<c:forEach items="${inquiryList }" var="inquiry">
			<tr>
				<td>${inquiry.number }</td>
				<td><fmt:formatDate value="${inquiry.date }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${inquiry.type }</td>
				<td>${inquiry.sup }</td>
				<td>${inquiry.trustee }</td>
				<td>${inquiry.operator }</td>
				<td>${inquiry.items }</td>
				<td>${inquiry.note }</td>
				<td align="center"><a href="${pageContext.request.contextPath }/updateInquiry.action?id=${inquiry.id }">修改</a></td>
				<td align="center"><a href="${pageContext.request.contextPath }/deleteInquiry.action?id=${inquiry.id }">删除</a></td>
				
			</tr>
		</c:forEach>
	</table>
	<!-- 分页 -->
	<center>
		第${pageList.pageNo }/共${pageList.pages }页
		<a href="${pageContext.request.contextPath }/findInquiry.action?pageNo=1">首页</a>
		<c:if test="${pageList.pageNo>1 }">
			<a href="${pageContext.request.contextPath }/findInquiry.action?pageNo=${pageList.pageNo-1 }">上一页</a>
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
					<a href="${pageContext.request.contextPath }/findInquiry.action?pageNo=${i }">[${i }]</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:if test="${pageList.pageNo<pageList.pages }">
			<a href="${pageContext.request.contextPath }/findInquiry.action?pageNo=${pageList.pageNo+1 }">下一页</a>
		</c:if>
	
		<a href="${pageContext.request.contextPath }/findInquiry.action?pageNo=${pageList.pages }">尾页</a>		
	</center> 
</form>
</body>
</html>