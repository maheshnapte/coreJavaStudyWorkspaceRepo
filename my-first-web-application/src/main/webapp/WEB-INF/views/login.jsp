<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Yahoo my first JSP ...</title>
</head>
<body>
	<%-- 	Bhai der hogi lekin andher nahi ... Welcome ${name} to JSP .:)...
 --%>

	<!-- 	<form action="/login.do">
		name: <input type="text" name="name" /><input type="submit"
			name="submit" value="submit">
	</form>
 -->
	<p><font color ="red"> ${errorMessage}</font></p>
	<form action="/login.do" method="post">
		name: <input type="text" name="name" /> password: <input
			type="password" name="password" /> <input type="submit"
			name="submit" value="submit" />
	</form>

	<%-- 	<%
	System.out.println("HA HA HA ..." + request.getParameter("name") + "");
	java.util.Date date = new java.util.Date();
%>
	<div>
		Current date is:<%=date%></div> --%>
</body>
</html>