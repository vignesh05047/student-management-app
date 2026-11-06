<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>Student Registration Page</h1>
	<form action="register" method="POST">
	<table>
		<tr>
			<td>Enter the User Name:</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>Enter the Phone:</td>
			<td><input type="tel" name="phone"></td>
		</tr>
		<tr>
			<td>Enter the Email:</td>
			<td><input type="email" name="email"></td>
		</tr>
		<tr>
			<td>Set a New Password:</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>Confirm the Password:</td>
			<td><input type="password" name="confirm"></td>
		</tr>
		<tr>
			<td><button type="submit" class="bg-blue-900 hover:bg-blue-700 text-white font-bold py-1 px-3 rounded-full">
  Register
</button></td>
		</tr>
	</table>
	</form>
</body>
</html>