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
<h1>Student Update</h1>
	<form action="update" method="POST">
	<table>
		<tr>
			<td>Enter the User Name:</td>
			<td><input type="text" name="name" value="<%=s.getName()%>"></td>
		</tr>
		<tr>
			<td>Enter the Phone:</td>
			<td><input type="tel" name="phone" value="<%=s.getPhone()%>"></td>
		</tr>
		<tr>
			<td>Enter the Email:</td>
			<td><input type="email" name="email" value="<%=s.getEmail()%>"></td>
		</tr>
			
		<tr>
			<input type="hidden" name="id" value="<%=s.getId()%>">
			<td><button type="submit" class="bg-blue-900 hover:bg-blue-700 text-white font-bold py-1 px-3 rounded-full">
  Update Account
</button></td>
<td><a href="dashboard.jsp" class="bg-blue-900 hover:bg-blue-700 text-white font-bold py-1 px-3 rounded-full">
  Back
</a></td>
		</tr>
	</table>
	</form>
	<%}else{%>
		<%request.setAttribute("error-message", "Session expired!");%>
		<%request.getRequestDispatcher("login.jsp").forward(request, response);%>
	<%}%>
</body>
</html>