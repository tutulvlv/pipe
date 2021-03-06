<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basepath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
<title>客户报价BOM表</title>
<link rel="stylesheet" type="text/css" href="${basepath}/css/bootstrap.min.css" />
<script type="text/javascript" src="${basepath}/js/jquery-3.1.1.js"></script>
</head>
<body>
	<jsp:include page="/head.jsp" />
		<div class="container">
			<div class="login-title text-center">
				<h1><small>客户报价BOM表</small></h1>
			</div>
			<div class="table-responsive">
				<table class="table">
					<tr>
						<th>编号</th>
						<th>bom名称</th>
						<th>客户公司名</th>
						<th>上传时间</th>
						<th>业务员</th>
					</tr>
					<c:forEach items="${cusExcList}" var="cel" varStatus="status">
					<tr><td>
							${cel.cus_excel_id}</td>
						<td>
							<a href="${basepath}/supplier/showQuote.do?cus_excel_id=${cel.cus_excel_id}&customer_com=${cel.customer_com}&clerkname=${cel.clerkname}">
							${cel.excel_name}</a></td>
						<td>
							${cel.customer_com}</td>
						<td>
							${cel.upload_time}</td>
						<td>
							${cel.clerkname}</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		<div style="float:left;width:100%;text-align:center">
				<ul class="pagination">
					<c:if test="${requestScope.pager.hasFirst==true}">
						<li><a href="getAllCusExcel.do?currentPage=1">首页</a></li>
					</c:if>
					<c:if test="${requestScope.pager.hasFirst==false}">
						<li class="disabled"><a href="javascript:void(0)">首页</a>
						</li>
					</c:if>
					<c:if test="${requestScope.pager.hasPrevious==true}">
						<li><a
							href="getAllCusExcel.do?currentPage=${requestScope.pager.currentPage-1}">
								上一页 </a></li>
					</c:if>
					<c:if test="${requestScope.pager.hasPrevious==false}">
						<li class="disabled"><a
							href="javascript:void(0)">
								上一页 </a></li>
					</c:if>
					<c:if test="${requestScope.pager.hasNext==true}">
						<li><a
							href="getAllCusExcel.do?currentPage=${requestScope.pager.currentPage+1}">
								下一页 </a></li>
					</c:if>
					<c:if test="${requestScope.pager.hasNext==false}">
						<li class="disabled"><a
							href="javascript:void(0)">
								下一页 </a></li>
					</c:if>
					<c:if test="${requestScope.pager.hasLast==true}">
						<li><a
							href="getAllCusExcel.do?currentPage=${requestScope.pager.totalPage}">
								尾页 </a></li>
					</c:if>
					<c:if test="${requestScope.pager.hasNext==false}">
						<li class="disabled"><a
							href="javascript:void(0)">
								尾页 </a></li>
					</c:if>
				</ul>
				<br> 当前第
				${requestScope.pager.currentPage}
				页，总共
				${requestScope.pager.totalPage}
				页
			</div>
	</div>
</body>
</html>