<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>		UserServlet.html
  <form action="UserServlet.html?function=register" method="post">
    账&nbsp&nbsp号<input type="text" name="uname" value="长度为6-10的字母、数字组成"><br>
    密&nbsp&nbsp码<input type="password" name="pwd1" value=""><br>
   	确认密码 <input type="password" name="pwd2" value=""><br>
   	<input type="submit" value="注册">
   	</form>
  </body>
</html>
