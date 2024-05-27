<%@page import="com.codegnan.beans.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.codegnan.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    if(session.getAttribute("un")!=null){
    	String un=(String)session.getAttribute("un");
    	StudentDao studentDao=new StudentDao();
    	ArrayList<Student> students=studentDao.findAll();
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students Details</title>
</head>
<body>
<h3>Welcome to </h3><%=un %><br><br>
<h2>Students details</h2>
<br><br>
	<h3>New Student</h3>
	<form method="post" action="newStudent">
		ID : <input type="text" name="id"> <br><br>
		Name : <input type="text" name="name"> <br><br>
		Email : <input type="text" name="email"> <br><br>
		Branch : <input type="text" name="branch"> <br><br>
		<input type="submit" value="Save">
		<input type="reset" value="Cancel">
	</form>
	<br><br>
<table border="1" cellspacing="0" cellpadding="0">
<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Branch</th>
<th>Edit |delete</th>

<%
for(Student student:students){
	%>
	<tr>
	<td><%=student.getId() %></td>
	<td><%=student.getName() %></td>
	<td><%=student.getEmail() %></td>
	<td><%=student.getBranch()%></td>
	<td><a href="EditStudent.jsp?id=<%= student.getId()%>">Edit</a> |<a href="deleteStudent?<%=student.getId()%>">Delete</a>
	</tr>
	<%
	}%>
	
	

</table>

</body>
</html>
<%
}
    else{
    	response.sendRedirect("Login.jsp");
    }
%>
