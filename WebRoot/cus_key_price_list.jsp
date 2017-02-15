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
			
			<div class="login-title text-center">
				<h3>客户名称:${customer_com} &nbsp; 业务员：${clerkname}</h3>	
			</div>
			
				<div class="col-md-4 table-responsive ">
				<table class="table">
					<tr>
						<th>品牌</th>
						<th>型号</th>
						<th>批次</th>
						<th>数量</th>
					</tr>
					<tr>
						<td>
							${factory}</td>
						<td>
							${retrievalmodel}</td>
						<td>
							${batch}</td>
						<td>
							${quantity}</td>
					</tr>
				</table>
			</div>
			
			<div class="table-responsive col-md-12">
				<table class="table" >
					<tr>
						<th>序号</th>
						<th>报价</th>
						<th>报价时间</th>
						<th>供应商名称</th>
						<th>联系人</th>
						<th>手机</th>
						<th>QQ</th>
						<th>会员级别</th>
						<th>总报价次数</th>
					</tr>
					<c:forEach items="${supQuoteDet}" var="sqd" varStatus="status">
					<tr>
						<td>
							${status.index+1}</td>
						<td>
							${sqd.price}</td>
						<td>
							${sqd.quote_time}</td>
						<td>
							${sqd.new_name}</td>
						<td>
							${sqd.per_name}</td>
						<td>
							${sqd.sup_tel}</td>
						<td>
							${sqd.email}</td>
						<td>
							</td>
						<td>
							</td>
					</tr>
					</c:forEach>
				</table>
			</div>
	</div>
</body>
</html>