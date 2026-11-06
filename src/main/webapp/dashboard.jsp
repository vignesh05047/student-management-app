<%@page import="com.dcl.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%Student s=(Student)session.getAttribute("student");%>
<%if(s!=null){%>
<%=request.getRequestedSessionId()%>
<header>
<h1>Welcome <%=s.getName()%>,</h1>
<nav>
	<ul>
		<%if(s.getId()==1){%>
		<li><a href="viewStudents.jsp">View Students</a></li>
		<%}%>
		<li><a href="updateAccount.jsp">Update Account</a></li>
		<li><a href="vieStudents.jsp">Reset Password</a></li>
		<li><button><a href="logout">Logout</a></button></li>
	</ul>
</nav>

<%String successMessage=(String)request.getAttribute("success-message");%>
<%if(successMessage!=null){%>
	<p style="color:green;"><%=successMessage%></p>
<%}%>

<table border="1">
	<thead>
		<tr>
		<td>ID</td>
		<td>Name</td>
		<td>Phone</td>
		<td>Email</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getName()%></td>
			<td><%=s.getPhone()%></td>
			<td><%=s.getEmail()%></td>
		</tr>
	</tbody>
</table>
</header>
<%}%>
                                                                                 
</body>
</html>