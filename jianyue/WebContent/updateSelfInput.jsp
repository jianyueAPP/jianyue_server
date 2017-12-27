<%@ page import="model.Admin"  %>
<%@ page import="util.ValidateUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户更新</title>

</head>
<body>
<div style="text-align:right;border-bottom:1px solid #000;">
	欢迎使用！&nbsp;&nbsp;
	<a href="<%=request.getContextPath()%>/articlelist.html">文章列表</a>
	&nbsp;<a href="<%=request.getContextPath()%>/advicelist.html">反馈列表</a>
	&nbsp;<a href="<%=request.getContextPath()%>/addArticleInput.jsp">添加文章</a>
	&nbsp;<a href="<%=request.getContextPath()%>/updateSelfInput.jsp"> 修改个人信息</a>
	&nbsp;<a href="<%=request.getContextPath() %>/logout.jsp">退出系统</a>
</div>
<div><h2 align="center">个人信息修改</h2></div>
<form action="updateself.html" method="post">
<table align="center" width="500" border="1">
	<tr>
		<td>用户：</td>
		<td>
			${loginUser.adminname}
		</td>
	</tr>
	<tr>
		<td>密码：</td><td><input type="password" name="password" value="${loginUser.password }"/>
			<%=ValidateUtil.showError(request,"password")%>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<input type="submit" value="更新用户"/><input type="reset" value="重置信息"/><a href="articlelist.html"><input type="button" value="返回"></input></a>
		</td>
	</tr>
	
</table>
</form>
</body>
</html>