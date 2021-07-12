<html>
<head>
<style type="text/css">
body{
	background-image: linear-gradient(to bottom right, red, black);
}
h1{
	text-align: center;
}
div.form{
	font-size:25px;
	font-weight: bold;
	text-align: center;
	display: block;
}
form{
	display: inline-block;
	margin-left: auto;
	margin-right: auto;
	text-align: left;
}
footer{
	text-align: center;
}
</style>
</head>
<title>Login</title>
<body>
<header><h1>Login</h1></header>

<div class="form">
<form action="servlet1" method="post">  
Name:<input type="text" name="userName"/><br/>  
Password:<input type="password" name="userPass" style="width:125px"/><br/>  
<div class="form">
<input type="submit" value="Login"/>  
</div>
</form>  
</div>
<footer>
<form action="register.jsp" method="post">
<input type="submit" value="Register New User"/>
</form>

</footer>
</body>
</html>
