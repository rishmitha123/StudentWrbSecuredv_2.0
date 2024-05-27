<%@page import="com.codegnan.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>Login</h2>
<form method="post">
Username :<input type="text" name="un"><br><br>
Password :<input type="password" name="pw"><br><br>
<input type="submit" value="login">
<input type="reset" value="Cancel">
</form>

</body>
</html>
<%
if(request.getMethod().equalsIgnoreCase("post")){
	String un=request.getParameter("un");
	String pw=request.getParameter("pw");
	if(UserDao.validate(un,pw)){
		session=request.getSession(true);
		session.setAttribute("un", un);
		//valid credentials
		//transfer to Student.jsp
		%>
		<jsp:forward page="Student.jsp"></jsp:forward>
		<%
		
	}
	else{
		//invalid credentials
		response.sendRedirect("Login.jsp");
	}
	
}
%>