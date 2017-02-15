<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basepath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
<title>供应商报价页</title>
<link rel="stylesheet" type="text/css" href="${basepath}/css/bootstrap.min.css" />
<script type="text/javascript" src="${basepath}/js/jquery-3.1.1.js"></script>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?0d9b0d128fbe69e7443021b8247b54c1";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>

<script type="text/javascript">
	$(function(){
		$("#submit").click(function(){
			var icname=$(".ic_name");
			var factory=$(".factory");
			var retrievalmodel=$(".retrievalmodel");
			var quantity=$(".quantity");
			var batch=$(".batch");
			var price=$(".price");
			var cus_excel_id=$(":input[name='cus_excel_id']").val();
			var new_name=$(":input[name='new_name']").val();
			var per_name=$(":input[name='per_name']").val();
			var sup_tel=$(":input[name='sup_tel']").val();
			var email=$(":input[name='email']").val();
			var json="[";
			for(var i=0;i<icname.length;i++){
				if(price.get(i).value==""){
					price.get(i).value=0;
				}
				if(quantity.get(i).value==""){
					quantity.get(i).value=0;
				}
				json+='{"ic_name":"'+icname.get(i).value+'","factory":"'+factory.get(i).value+'","retrievalmodel":"'+retrievalmodel.get(i).value+
					'","quantity":'+quantity.get(i).value+',"batch":"'+batch.get(i).value+'","price":'+price.get(i).value+'}';
				if(i<icname.length-1){
				json+=",";}
			}
			json+="]";
			/* if(new_name==""||per_name==""||sup_tel==""){
				alert("供应商信息不能为空！！！");
			}else  */if(!(/^[1][3578][0-9]{9}$/.test(sup_tel))){
				alert("不是完整的11位手机号或者正确的手机号前七位！！！");
			}else{
				$.ajax({
					type:"POST",
					url:"/pipe/supplier/quoteBom.do",//传入后台的地址/方法
					data:"json="+json+"&cus_excel_id="+cus_excel_id+"&new_name="+new_name+"&per_name="+per_name+"&sup_tel="+sup_tel+"&email="+email,//参数，这里是一个json语句
					success:function(data){
						window.location.href="/pipe/quote_success.jsp";
					}
				});
			}
		});
	});
</script>
</head>
<body>
		<div class="container">
			<div class="login-title text-center">
				<h2>呆料回收报价</h2>
				
			</div>
			<div class="table-responsive">
				<table class="table">
					<tr>
						<th>序号</th>
						<th>ic种类</th>
						<th>品牌</th>
						<th>型号</th>
						<th>数量</th>
						<th>批次</th>
						<th>单价</th>
					</tr>
					<input type="hidden" name="cus_excel_id" value="${param.excel_id}"/>
					<input type="hidden" name="email" value="${param.email}"/>
					<c:forEach items="${cusExcDetList}" var="list" varStatus="status">
					<tr><td>
							${status.index+1}</td>
						<td><input type="hidden" class="ic_name" value="${list.ic_name}"/>
							${list.ic_name}</td>
						<td><input type="hidden" class="factory" value="${list.factory}"/>
							${list.factory}</td>
						<td><input type="hidden" class="retrievalmodel" value="${list.retrievalmodel}"/>
							${list.retrievalmodel}</td>
						<td><input type="hidden" class="quantity" value="${list.quantity}"/>
							${list.quantity}</td>
						<td><input type="hidden" class="batch" value="${list.batch}"/>
							${list.batch}</td>
						<td>
							<input type="text" class="price"/></td>
					</tr>
					</c:forEach>
				</table>
			</div>
			<div class="form-group" style="width:500px">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class=""></span>供应商公司名称</span>
							<input type="text" id="indet" name="new_name" class="form-control" value="${param.oldname}" placeholder="公司全名"/>
						</div>
					</div>
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class=""></span>公司联系人</span>
							<input type="text" id="indet" name="per_name" class="form-control" placeholder="姓名"/>
						</div>
					</div>
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class=""></span>手机号</span>
							<input type="text" id="indet" name="sup_tel" class="form-control" placeholder="手机号"/>
						</div>
					</div>
			</div>
			<button id="submit" class="btn btn-info"><span class=""> 注册并提交</span></button>
	</div>
	<h4>联系人：田老师&nbsp;  电话:010-82755266&nbsp;  QQ:3330435367</h4>
</body>
</html>