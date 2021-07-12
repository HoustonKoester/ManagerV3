<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
<style type="text/css">
	.container{
	display: grid;
	grid-template-columns: 33.3% 33.3% 33.3%;
	justify-items: center;
	}
	form{
		
		border: 5px;
		margin: 5px;
	}
	html{
	background-image: repeating-radial-gradient(red,purple 10%, blue 15%);
	}
</style>
</head>
<header style="text-align:center;font-size:25px;font-weight:bold;"><a href="index.jsp" style="color:white;">Logout</a></header>
<body>
 <br>
<div class="container">
<form action="reimForm.jsp" method="post">
<input type="submit" value="Submit Reimbursement Form" style="width:300px; height:30px; font-size:17px;"/>
</form>
<form action="UpdateEmployee.jsp" method="post">
<input type="submit" value="Update Employee Information" style="width:300px; height:30px; font-size:17px;"/>
</form>
<form action="servlet10" method="post">
<input type="submit" value="Submitted Reimbursements" style="width:300px; height:30px; font-size:17px;"/>
</form>
</div>
<br>
<img alt="rand" src="https://content.timesjobs.com/img/62855069/Master.jpg" style="display: block; margin-left: auto; margin-right: auto; width: 50%;">
</body>
</html>