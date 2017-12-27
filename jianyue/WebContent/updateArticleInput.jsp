<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<div><h2 align="center">修改文章</h2></div>
<div align="center">

   <form action = "updateArticle.html">
   <div>
    <input type="hidden" name="id" value="<%=request.getParameter("id")  %>"> 
    <input type="hidden" name="pageNos" value="<%=request.getParameter("pageNos")  %>"> 
    </div>
   	<div>
	<label>标  题:&nbsp;&nbsp;</label>
	<input type="text"  name="title" value="<%=request.getParameter("title") %>"/>
	</div>
	<div >
	<label>作  者:&nbsp;&nbsp;</label>
	<input type="text"  name="author" value="<%=request.getParameter("author") %>"/>
	</div>
	<div >
	<label>链  接:&nbsp;&nbsp;</label>
	<input type="text"  name="link" value="<%=request.getParameter("link")  %>"/>
	</div>
	<div >
	<label>标  签:&nbsp;&nbsp;</label>
	<input type="text"  name="tag" value="<%=request.getParameter("tag") %>"/>
	</div>
	<div class="loginform_row">
	<span class = "returnInfo"></span>
	<input type="submit" class="loginform_submit" value="提交" />
	<a href="articlelist.html"><input type="hidden" name="pageNos" value="${pageNos}"><input type="button" value="返回"></input></a>
	</div>
	
    </form>
	</div>
</body>
</html>