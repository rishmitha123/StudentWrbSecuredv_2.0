<%@page import="com.codegnan.beans.Student"%>
<%@page import="com.codegnan.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    if(session.getAttribute("un")!=null && request.getParameter("id")!=null){
    	int id=Integer.parseInt(request.getParameter("id"));
    	StudentDao studentDao=new StudentDao();
    	Student student=studentDao.findById(id);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<h2>Edit Student</h2>
<form method="post" action="updateStudent">
	Id :<input type="text" name="id" value="<%= student.getId()%>" readonly><br><br>
	Name :<input type="text" name="name" value="<%= student.getName()%>"><br><br>
	Email :<input type="text" name="email" value="<%= student.getEmail()%>"><br><br>
	branch :<input type="text" name="branch" value="<%= student.getBranch()%>"><br><br>
	<input type="submit" value="Update">
	<input type="reset" value="Cancel">
</form>
</body>
</html>
<%
}
else{
response.sendRedirect("Login.jsp");
}
%>