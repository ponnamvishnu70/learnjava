<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- we dont have /login with method type post. spring is going to take care of it -->
<form  action="/login" method="POST">
username: <input type="text" name="uname"/> 
Password: <input type="password"  name="password"/>
<!-- below line is must if you enable csrf in filter chain..i.e ...SecurityConfiguration.java -->
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /></strong>
<button type="submit">SUBMIT</button>
</form>

</body>
</html>