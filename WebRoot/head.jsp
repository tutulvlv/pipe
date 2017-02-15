<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
 <div class="navbar navbar-inverse" role="navigation">
      <div class="container">
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<%=path%>/upload_bom.jsp">上传客户BOM表</a></li>
          	<li class="active"><a href="<%=path%>/customer/getAllCusExcel.do">查看BOM报价列表</a></li>
          	<li class="active"><a href="<%=path%>/customer/getViewHistory.do">查看报价访问记录</a></li>
          	<li class="active"><a href="<%=path%>/customer/getSendHistory.do">查看推送记录</a></li>
          </ul>
         </div>
    </div>
 </div>
