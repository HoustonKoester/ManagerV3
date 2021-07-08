<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Approve or delete any pending Employees</h1>
<form action="Manager.jsp" method="post">
		<input type="submit" value="back" />
	</form>
<form action="servlet6" method="post">
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
				<th>Decision</th>
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
	}, 3000);
	
	
	const employeeBody = document.querySelector("#employee-table > tbody")
	fetch("pending.json").then(response => response.json()).then(data => {
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
				var va = document.createElement("input");
				va.setAttribute("type","hidden");
				va.setAttribute("name","id"+`${rownum}`+`${colnum}`);
				va.setAttribute("value",`${val}`)
				td.appendChild(va);
				colnum = colnum+1;
				tr.appendChild(td);
				
			});
			colnum = 0;
			const td = document.createElement("td");
			td.textContent = "blank";
			td.setAttribute("value","blank");
			td.setAttribute("name","decision"+`${rownum}`)
			tr.appendChild(td);
			var va = document.createElement("input");
			va.setAttribute("type","hidden");
			va.setAttribute("name","decision"+`${rownum}`);
			va.setAttribute("value","")
			td.appendChild(va);
			var accept = document.createElement("button");
			var Delete = document.createElement("button");
			accept.innerHTML = "Accept"
			Delete.innerHTML = "Delete"
			accept.setAttribute("name","Accept")
			Delete.setAttribute("name","Delete")
			accept.setAttribute("type","button")
			Delete.setAttribute("type","button")
			tr.appendChild(accept);
			tr.appendChild(Delete);
			
			tr.setAttribute("name","foo"+`${rownum}`);
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