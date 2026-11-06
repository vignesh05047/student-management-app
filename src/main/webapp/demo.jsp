<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
	<%@include file="header.jsp"%>
	<%Date d=new Date();%>
	<h3><%=d%></h3>
	<%Random rd=new Random();%>
	<h5><%=rd.nextLong()%></h5>
	<%@include file="footer.jsp" %>
</body>
</html>