<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台登陆界面</title>
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
    <form action="login" method="post">
    	用户名<input type="text" name="username">
    	密码<input type="password" name="password">
    		<input type="submit" value="登录">
    </form>
    <br />
    <br />
    <br />
    <h2>注册</h2>
    <form action = "register" method = "post">
    	用户名<input type = "text" name = "username">
    	密码<input type = "password" name = "password">
    	昵称<input type = "text" name = "nikename">
    	手机号<input type = "text" name = "phoneNumber">
    	<input type = "submit" value = "注册">
    </form>
  </body>
</html>
