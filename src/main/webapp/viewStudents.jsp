<%@page import="java.util.List"%>
<%@page import="com.dcl.dao.StudentDAOImpl"%>
<%@page import="com.dcl.dao.StudentDAO"%>
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
<%Student admin=(Student)session.getAttribute("student");%>
<%if(admin!=null&&admin.getId()==1){%>
	<h1>Students Info</h1>
	<a href="dashboard.jsp">Back</a>
	
	<table border="1">
		<thead>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Phone</td>
				<td>Email</td>
				<td>Delete</td>
			</tr>
		</thead>
		<tbody>
		<%StudentDAO sdao=new StudentDAOImpl();
		List<Student> studentsList=sdao.getAllStudent();%>
		<%for(Student s:studentsList){%>
		
		
			<tr>
				<td><%=s.getId()%></td>
				<td><%=s.getName()%></td>
				<td><%=s.getPhone()%></td>
				<td><%=s.getEmail()%></td>
				<td>
					<form action="delete" method="post">
						<input type="hidden" name="id" value="<%=s.getId()%>">
						<button type="submit">Delete</button>
					</form>
				</td>
			</tr>
			<%}%>
		</tbody>
	
	</table>
	<%}else{%>
		<%request.setAttribute("error-message", "Session expired!");%>
		<%request.getRequestDispatcher("login.jsp").forward(request, response);%>
	<%}%>
</body>
</html>