<%@page import="org.dbms.ks.util.SecurityUtil"%>
<%
	if (SecurityUtil.isAuthenticated(request)) {
		// already logged in redirecting to home page
		response.sendRedirect("index.jsp");
		return;
	}
%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<style>
	body {
		background-color: #76ff03;
	}
	
	h1 {
		color: white;
	}
</style>
<body>
<h1> KickStarter Analysis</h1>
<form method="POST" action="api/login" style="margin: 50px">
<table align="center">
	<tr>
		<td colspan="2" align="center"><em>Login to KickStarter</em></td>
	</tr>
	<tr>
		<td>Name:</td>
		<td><input type="text" name="username"></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input type="password" name="password"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit"></td>
	</tr>
</table>
</form>
</body>
</html>
