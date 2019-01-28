<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>webmvc</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    <c:set var="name" value="<script>alert(123);</script>"></c:set>
    <c:out value="${name }" escapeXml="true"></c:out>
    <%
    	Date date = new Date();
    	request.setAttribute("date", date);
    %>>
    <fmt:formatDate value="${date }" pattern="yyyy-MM-dd HH:mm:ss" />
    <%
	String[] str = {"123","456","789"};
	request.setAttribute("str", str);
	%>
	<c:forEach items="${str }" var="s" varStatus="ss">
		${ss.index }----- ${ss.count}---${ss.current}<br>
	</c:forEach>
	<a href="UserServlet.html">查询用户列表</a>
  </body>
</html>
