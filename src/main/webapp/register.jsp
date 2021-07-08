<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Fill out the form below</h1>
<form action="servlet5" method="post">  
Name:<input type="text" name="userName" required/><br/>  
Email:<input type="email" name="Email"required/><br/>  
Password:<input type="password" name="userPass"required/><br/>  
Confirm Password:<input type="password" name="userPassConfirm"required/><br/>  
City:<input type="text" name="City"/><br/>  
State:<input type="text" name="State"/><br/>  
Position:<select id="position" name="position">
	<option value="employee">Employee</option>
	<option value="manager">Manager</option>
</select>
<br>
<input type="submit" value="Register"/>  
</form>  
</body>
</html>