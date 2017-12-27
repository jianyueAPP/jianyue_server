<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>反馈管理</title>
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
<div><h2 align="center">反馈管理</h2></div>
	<table align="center" border="1" width="1000">
	
	<tr>		
				<td>编  号&nbsp;&nbsp;</td>			
				<td>时  间&nbsp;&nbsp;</td>
				<td>反  馈&nbsp;&nbsp;</td>
				<td>状  态&nbsp;&nbsp;</td>		
	</tr>
    <c:forEach items="${advicelist}" var="advice" begin="${(pageNosAdvice-1)*onepagesizeAdvice }"
        end="${pageNosAdvice*onepagesizeAdvice-1}">
       <tr>
       		<td>
            	<div>${advice.id}</div>
            </td>
        <td>
            <div>${advice.time}</div>
        </td>
         <td>
            <div>${advice.content}</div>
        </td>
         <td>
        	<c:if test="${advice.status!=1}">
            <div>已删除</div>
            </c:if>
            <c:if test="${advice.status==1}">
            <div>
            <div style="float:left"> <form action="deleteAdvice.html"> 
            <input type="hidden" name="deleteid" value="${advice.id}"> 
            <input type="hidden" name="pageNos" value="${pageNosAdvice}">
            <input type="submit" value="删除" name="submit">  
        	</form> </div>
        	</div>
            </c:if>
        </td>
        </tr>
    </c:forEach>
    </table>
    <center>
    <c:if test="${pageNosAdvice>1 }">
<a href="advicelist.html?pageNosAdvice=1" >首页</a>
<a href="advicelist.html?pageNos=${pageNosAdvice-1 }">上一页</a>
</c:if>
<c:if test="${pageNosAdvice <countPageAdvice }">
<a href="advicelist.html?pageNosAdvice=${pageNosAdvice + 1 }">下一页</a>
<a href="advicelist.html?pageNosAdvice=${countPageAdvice }">末页</a>
</c:if>
</center>
<form action="advicelist.html">
<h4 align="center">共${countPageAdvice}页  
<input type="text" value="${pageNosAdvice}" name="pageNosAdvice" size="1">页
<input type="submit" value="go">
</h4>
</form>

</body>
</html>