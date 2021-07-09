<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employees</title>
</head>
<body>

<h1>All active employees are listed below</h1>
	<table id="employee-table" class="table" onclick="handleClick(event);">
		<thead>
			<tr>
				<th>EmployeeId</th>
				<th>UserName</th>
				<th>Password</th>
				<th>EmployeeName</th>
				<th>City</th>
				<th>State</th>
				<th>Email</th>
				<th>Position</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	</table>
	<form action="Manager.jsp" method="post">
		<input type="submit" value="back" />
	</form>
	<script type="text/javascript">
	setTimeout(function(){
		if(window.location.hash != '#r'){
			window.location.hash = 'r';
		window.location.reload(1);
		}
	}, 3500);
	
	
	const employeeBody = document.querySelector("#employee-table > tbody")
	fetch("all.json").then(response => response.json()).then(data => {
		while(employeeBody.firstChild){
			employeeBody.removeChild(employeeBody.firstChild);
		}
		var value = 0;
		var rownum = 0;
		var colnum = 0;
		data.forEach((row) => {
			const tr = document.createElement("tr");
			var input = document.createElement("input");
			input.setAttribute("type","hidden");
			input.setAttribute("name","id");
			input.setAttribute("value",`${rownum}`)
			tr.appendChild(input);
			
			row.forEach((val) => {
				if(colnum == 2){
					const td = document.createElement("td");
					td.textContent = "hidden";
					td.setAttribute("value","hidden");
					td.setAttribute("name","col"+`${rownum}`+`${colnum}`)
					colnum = colnum+1;
					tr.appendChild(td);
				}else{
					const td = document.createElement("td");
					td.textContent = val;
					td.setAttribute("value",val);
					td.setAttribute("name","col"+`${rownum}`+`${colnum}`)
					colnum = colnum+1;
					tr.appendChild(td);
				}
				
			
				
			});
			colnum = 0;
			
			rownum=rownum+1;

			employeeBody.appendChild(tr);
		});
	})
	

</script>
</body>
</html>