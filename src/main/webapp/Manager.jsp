<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Managers</title>
<style type="text/css">
	.container{
	display: grid;
	grid-template-columns: 50% 50%;
	grid-template-rows: 50% 50%;
	justify-items: center;
	}
	form{
		margin: 5px;
	}
</style>
</head>
<header style="text-align:center;font-size:25px;color:black;"><a href="index.jsp">Logout</a></header>
<body>
 <br>
 <div class="container">
<form action="servlet3" method="post">
<input type="submit" value="Active Reimbursements" style="width:300px; height:30px; font-size:17px;"/>
</form>

<form action="servlet7" method="post">
<input type="submit" value="Pending Employees" style="width:300px; height:30px; font-size:17px;"/>
</form>
<form action="servlet11" method="post">  
Employee ID to check:<input type="text" name="userid"/><br/>  
<input type="submit" value="Check Employee Reimbursements" style="width:300px; height:30px; font-size:17px;"/>  
</form>  
<form action="servlet9" method="post">
<input type="submit" value="View All Employees" style="width:300px; height:30px; font-size:17px;"/>
</form>
</div>
<br>
<img alt="rand" src="https://ak1.picdn.net/shutterstock/videos/2343311/thumb/1.jpg"  style="display: block; margin-left: auto; margin-right: auto; width: 50%;">
</body>
</html>