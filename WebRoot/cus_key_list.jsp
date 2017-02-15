<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basepath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
<title>客户型号报价表</title>
<link rel="stylesheet" type="text/css" href="${basepath}/css/bootstrap.min.css" />
<script type="text/javascript" src="${basepath}/js/jquery-3.1.1.js"></script>
</head>
<body>
	<jsp:include page="/head.jsp" />
		<div class="container">
			<div class="login-title text-center">
				<h1><small>客户型号报价表</small></h1>
			</div>
		<h3>客户名称:${customer_com} &nbsp; 业务员：${clerkname}</h3>	
			<div class="table-responsive">
				<table class="table">
					<tr>
						<th>编号</th>
						<th>品牌</th>
						<th>型号</th>
						<th>批次</th>
						<th>数量</th>
						<th>最高报价</th>
						<th>供应商数量</th>
						<th>最新报价时间</th>
					</tr>
					<c:forEach items="${excDetView}" var="edv" varStatus="status">
					<tr>
						<td>
							${status.index+1}</td>
						<td>
							${edv.factory}</td>
						<td>
							<a href="${basepath}/supplier/showModelQuote.do?factory=${edv.factory}&retrievalmodel=${edv.retrievalmodel}&batch=${edv.batch}&quantity=${edv.quantity}">
							${edv.retrievalmodel}</a></td>
						<td>
							${edv.batch}</td>
						<td>
							${edv.quantity}</td>
						<td>
							${edv.maxprice}</td>
						<td>
							${edv.sup_sum}</td>
						<td>
							${edv.quote_time}</td>
					</tr>
					</c:forEach>
				</table>
			</div>
	</div>
</body>
</html>