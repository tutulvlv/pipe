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
			<div align="center" style="margin-top: 100px">
				<h2>文件上传并群发邮件短信成功！！！！</h2>
				<a href="${basepath}/upload_bom.jsp">返回继续上传bom</a>
				<a href="${basepath}/customer/getAllCusExcel.do">查看供应商报价汇总表</a>
			</div>
		</div>
		
</body>
</html>