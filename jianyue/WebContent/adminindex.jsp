<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章管理</title>
</head>
<body>
<div style="text-align:right;border-bottom:1px solid #000;">
	欢迎使用！&nbsp;&nbsp;
	<a href="<%=request.getContextPath()%>/articlelist.html">文章列表</a>
	&nbsp;<a href="<%=request.getContextPath()%>/addArticleInput.jsp">添加文章</a>
	&nbsp;<a href="<%=request.getContextPath()%>/updateSelfInput.jsp"> 修改个人信息</a>
	&nbsp;<a href="<%=request.getContextPath() %>/logout.jsp">退出系统</a>
</div>
<div><h2 align="center">文章管理</h2></div>
	<table align="center" border="1" width="1000">
	<tr>
		<td colspan="7">
			<form action="articlelist.html">
				<label>标  题:&nbsp;&nbsp;</label>
				<input type="text"  name="titlecon" value = "${titlecon}"/>
				<label>作  者:&nbsp;&nbsp;</label>
				<input type="text"  name="authorcon" value =  "${authorcon}" />
				<label>链  接:&nbsp;&nbsp;</label>
				<input type="text"  name="linkcon" value =  "${linkcon}" />
				<label>标  签:&nbsp;&nbsp;</label>
				<input type="text"  name="tagcon" value =  "${tagcon}" />
				<input type="submit" value="查询"/>
			</form>
		</td>
	</tr>
	<tr>		
				<td>编  号&nbsp;&nbsp;</td>
				<td>标  题&nbsp;&nbsp;</td>
				<td>作  者&nbsp;&nbsp;</td>				
				<td>链  接&nbsp;&nbsp;</td>			
				<td>标  签&nbsp;&nbsp;</td>
				<td>状  态&nbsp;&nbsp;</td>		
	</tr>
    <c:forEach items="${articlelist}" var="article" begin="${(pageNos-1)*onepagesize }"
        end="${pageNos*onepagesize-1}">
       <tr>
       		<td>
            	<div>${article.id}</div>
            </td>
        <td>
            <div>${article.title}</div>
        </td>
         <td>
            <div>${article.author}</div>
        </td>
         <td>
            <div>${article.link}</div>
        </td>
        <td>
            <div>${article.tags}</div>
        </td>
        <td>
        	<c:if test="${article.status!=1}">
            <div>已删除</div>
            </c:if>
            <c:if test="${article.status==1}">
            <div>
            <div style="float:left"> <form action="deleteArticle.html"> 
            <input type="hidden" name="deleteid" value="${article.id}"> 
            <input type="hidden" name="pageNos" value="${pageNos}">
            <input type="submit" value="删除" name="submit">  
        	</form> </div>
        	<div style="float:center"> <form action="updateArticleInput.jsp"> 
            <input type="hidden" name="id" value="${article.id}"> 
            <input type="hidden" name="title" value="${article.title}"> 
            <input type="hidden" name="author" value="${article.author}"> 
            <input type="hidden" name="link" value="${article.link}"> 
            <input type="hidden" name="tag" value="${article.tags}"> 
            <input type="hidden" name="pageNos" value="${pageNos}">
            <input type="submit" value="修改" name="submit">  
        	</form> </div>
        	</div>
            </c:if>
        </td>
        </tr>
    </c:forEach>
    </table>
    <center>
    <c:if test="${pageNos>1 }">
<a href="articlelist.html?pageNos=1" >首页</a>
<a href="articlelist.html?pageNos=${pageNos-1 }">上一页</a>
</c:if>
<c:if test="${pageNos <countPage }">
<a href="articlelist.html?pageNos=${pageNos+1 }">下一页</a>
<a href="articlelist.html?pageNos=${countPage }">末页</a>
</c:if>
</center>
<form action="articlelist.html">
<h4 align="center">共${countPage}页  
<input type="text" value="${pageNos}" name="pageNos" size="1">页
<input type="submit" value="go">
</h4>
</form>

</body>
</html>