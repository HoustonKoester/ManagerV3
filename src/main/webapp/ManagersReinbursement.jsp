<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" http-equiv="refresh" content="20">
<title>Reimbursements</title>
<style type="text/css">
tr{cursor: pointer; transition: all .25s ease-in-out}
tr:hover{
	background-color: #ffff99;
}
       .selected{background-color: red; font-weight: bold; color: #fff;}
</style>
</head>
<body>
	<h1>Active reimbursement requests</h1>
	<form action="Manager.jsp" method="post">
		<input type="submit" value="back" />
	</form>
<form action="servlet2" method="post">
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
		<input type="submit" value="Submit" />
	</form>
	
	<script type="text/javascript">
	setTimeout(function(){
		if(window.location.hash != '#r'){
			window.location.hash = 'r';
		window.location.reload(1);
		}
	}, 3500);
	
	
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
				var accept = document.createElement("button");
				var deny = document.createElement("button");
				accept.innerHTML = "Accept"
				deny.innerHTML = "Deny"
				accept.setAttribute("name","Accept")
				deny.setAttribute("name","Deny")
				accept.setAttribute("type","button")
				deny.setAttribute("type","button")
				tr.appendChild(accept);
				tr.appendChild(deny);
			}else if(value == 1){
				tr.bgColor = "green"
				
			}else if(value == 2){
				tr.bgColor = "red"
			}
			reinburseBody.appendChild(tr);
		});
	})
	
	function handleClick(evt){
		var node = evt.target || evt.srcElement;
		if (node.name == 'Accept'){
			console.log("accepted")
			var tr = node.closest("tr")
			var td = tr.getElementsByTagName("td")[3]
			td.children[0].setAttribute("value","Accepted")
			td.setAttribute("value","Accepted")
			
			var col=0
			let name = "name"
			fetch("active.json").then(response => response.json()).then(data => {
				data.forEach((row) => {	
					row.forEach((val) => {
						if(col == 1){
							name = val
							var td = tr.getElementsByTagName("td")[4]
							td.children[0].setAttribute("value",`${name}`)
							td.setAttribute("value",`${name}`)
						}
						col = col + 1;
					});
				});
			})
			node.closest("tr").bgColor = "Green"
		}else if(node.name == 'Deny'){
			console.log("Denied")
			var tr = node.closest("tr")
			var td = tr.getElementsByTagName("td")[3]
			td.children[0].setAttribute("value","Denied")
			td.setAttribute("value","Denied")
			var col=0
			let name = "name"
			fetch("active.json").then(response => response.json()).then(data => {
				data.forEach((row) => {	
					row.forEach((val) => {
						if(col == 1){
							name = val
							var td = tr.getElementsByTagName("td")[4]
							td.children[0].setAttribute("value",`${name}`)
							td.setAttribute("value",`${name}`)
						}
						col = col + 1;
					});
				});
			})
			//td.textContent = "Denied"
			node.closest("tr").bgColor = "Red"
	}
	}

</script>
</body>
</html>