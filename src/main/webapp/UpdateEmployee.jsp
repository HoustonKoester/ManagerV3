<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<h1>Update information below</h1>
<h3>Any form left blank will not be updated.</h3>
<body>
<form action="Employee.jsp" method="post">
		<input type="submit" value="back" />
	</form>
<form action="servlet8" method="post">
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
		<input type="submit" value="Submit" />
	</form>
		<script type="text/javascript">
	setTimeout(function(){
		if(window.location.hash != '#r'){
			window.location.hash = 'r';
		window.location.reload(1);
		}
	}, 3500);
	
	
	const employeeBody = document.querySelector("#employee-table > tbody")
	fetch("active.json").then(response => response.json()).then(data => {
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
				
				const td = document.createElement("td");
				td.textContent = val;
				td.setAttribute("value",val);
				td.setAttribute("name","col"+`${rownum}`+`${colnum}`)
				if(colnum == 0){
					var va = document.createElement("input");
					va.setAttribute("type","hidden");
					va.setAttribute("name","id"+`${rownum}`+`${colnum}`);
					va.setAttribute("value",`${val}`)
					td.appendChild(va);
				}
				if(colnum != 7){
					if(colnum != 0){
				var va = document.createElement("input");
				va.setAttribute("type","text");
				va.setAttribute("name","id"+`${rownum}`+`${colnum}`);
				va.setAttribute("value",`${val}`)
				td.appendChild(va);
				
				}}
				colnum = colnum+1;
				tr.appendChild(td);
				
			});
			colnum = 0;
			
			rownum=rownum+1;

			employeeBody.appendChild(tr);
		});
	})
	
	function handleClick(evt){
		var node = evt.target || evt.srcElement;
		if (node.name == 'Accept'){
			console.log("accepted")
			var tr = node.closest("tr")
			var td = tr.getElementsByTagName("td")[8]
			td.children[0].setAttribute("value","Accepted")
			td.setAttribute("value","Accepted")
			//td.textContent = "Accepted"
			node.closest("tr").bgColor = "Green"
		}else if(node.name == 'Delete'){
			console.log("Delete")
			var tr = node.closest("tr")
			var td = tr.getElementsByTagName("td")[8]
			td.children[0].setAttribute("value","Delete")
			td.setAttribute("value","Delete")
			//td.textContent = "Denied"
			node.closest("tr").bgColor = "Red"
	}
	}

</script>
	
</body>
</html>