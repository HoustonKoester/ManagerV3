<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Completed Reimbursements</title>
</head>
<body>
	<h1>Submitted reimbursement requests</h1>
	<form action="Employee.jsp" method="post">
		<input type="submit" value="back" />
	</form>

	<table id="reinburse-table" class="table" onclick="handleClick(event);">
		<thead>
			<tr>
				<th>EmployeeId</th>
				<th>EmployeeName</th>
				<th>Amount</th>
				<th>Status</th>
				<th>Accepted By</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	</table>


	
	<script type="text/javascript">
	setTimeout(function(){
		if(window.location.hash != '#r'){
			window.location.hash = 'r';
		window.location.reload(1);
		}
	}, 3000);
	
	
	const reinburseBody = document.querySelector("#reinburse-table > tbody")
	fetch("reinburse.json").then(response => response.json()).then(data => {
		while(reinburseBody.firstChild){
			reinburseBody.removeChild(reinburseBody.firstChild);
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
				if(colnum == 3){
				if(val == "Pending"){
					value = 0
				}else if(val == "Accepted"){
					value=1
				}else if(val == "Denied"){
					value=2
				}
				}
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
			
			
			tr.setAttribute("name","foo"+`${rownum}`);
			rownum=rownum+1;
			if(value == 0){
				tr.bgColor = "blue"
			}else if(value == 1){
				tr.bgColor = "green"
			}else if(value == 2){
				tr.bgColor = "red"
			}
			reinburseBody.appendChild(tr);
		});
	})
	

</script>

</body>
</html>