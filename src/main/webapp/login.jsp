<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
  <form action="login" method="post">
  <%String successMessage=(String)request.getAttribute("success-msg");%>
  <%if(successMessage!=null){%>
  <p style="color:green;"><%=successMessage%></p>
  <%}%>
  <%String errorMessage=(String)request.getAttribute("error-message");%>
  <%if(errorMessage!=null){%>
  <p style="color:red;"><%=errorMessage%></p>
  <%}%>
	<tr>
		<td>Enter the email ID:</td>
		<td><input type="email" name="email"></td>
	</tr>
	<tr>
		<td>Enter the Password:</td>
		<td><input type="password" name="password"></td>
	</tr>
	<tr>
		<td><button type="submit">Login</button></td>
		<td><a href="forgotPassword.jsp">forgot Password?</a></td>
	</tr>
	</form>
	
</table>
Don't have a account?<a href="register.jsp">Register</a>
</body>
</html>