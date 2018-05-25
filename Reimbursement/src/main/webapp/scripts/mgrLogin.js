function sendAjaxGet(url, func) {

	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");

	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};

	xhr.open("GET", url, true);
	xhr.send();
}

function populateEmployees(xhr) {
	if (xhr.responseText) {
		console.log(xhr.responseText);
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		var table = document.getElementById("allEmp");
		for (var x in res) {
			var row = table.insertRow(0);
			var id = res[x].employeeID;
			var firstName = res[x].firstName;
			var lastName = res[x].lastName;
			var email = res[x].email;
			for (var i in x) {
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				var cell4 = row.insertCell(3);
				cell1.innerHTML = id;
				cell2.innerHTML = firstName;
				cell3.innerHTML = lastName;
				cell4.innerHTML = email;	
			}
		}
	} else {
		window.location = "http://localhost:8080/Reimbursement/homepage";
	}
}

function populateMgrInfo(xhr) {
	if (xhr.responseText) {
		console.log(xhr.responseText);
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		var header = document.createElement("H6");
		var text1 = document.createTextNode("Manager ID: " + res.managerID);
		var text2 = document.createTextNode("Name: " + res.firstName + " " + res.lastName);
		header.appendChild(text1);
		header.appendChild(document.createElement("br"));
		header.appendChild(text2);
		header.appendChild(document.createElement("br"));
		console.log(header);
		document.getElementById("mgrInfo").appendChild(header);
	} else {
		window.location = "http://localhost:8080/Reimbursement/homepage";
	}
}

function populatePendingRequests(xhr) {
	if (xhr.responseText) {
		console.log(xhr.responseText);
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		var table = document.getElementById("pendingReqs");
		for (var x in res) {
			var row = table.insertRow(0);
			var reqId = res[x].requestID;
			var empId = res[x].employeeID;
			var comment = res[x].comment;
			var amount = res[x].amount;
			var dateCreated = res[x].dateCreated;

			for (var i in x) {
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				var cell4 = row.insertCell(3);
				var cell5 = row.insertCell(4);
				var cell6 = row.insertCell(5);
				cell1.innerHTML = reqId;
				cell2.innerHTML = empId;
				cell3.innerHTML = comment;
				cell4.innerHTML = amount;
				cell5.innerHTML = dateCreated;
				var approveButton = document.createElement("BUTTON");
				approveButton.setAttribute("type","button");
				approveButton.setAttribute("id","approveButton");
				approveButton.addEventListener("click", ()=> {
					var xhr = new XMLHttpRequest()
					|| new ActiveXObject("Microsoft.HTTPRequest");
					console.log('sdfsdf');
					xhr.onreadystatechange = function() {
						if (this.readyState == 4 && this.status == 200) {
							func(this);
						}
					};
					xhr.open("POST", "approveReq/?id=" + reqId, true);
					xhr.send();
				});
				var aButtonText = document.createTextNode("Approve");
				approveButton.appendChild(aButtonText);
				cell6.appendChild(approveButton);
				
				var denyButton = document.createElement("BUTTON");
				denyButton.setAttribute("type","button");
				denyButton.setAttribute("id","denyButton");
				denyButton.addEventListener("onclick", ()=> {
					var xhr = new XMLHttpRequest()
					|| new ActiveXObject("Microsoft.HTTPRequest");

					xhr.onreadystatechange = function(){
						if (this.readyState == 4 && this.status == 200) {
							window.location.href = "manager";
						}
					};
					xhr.open("POST", "http://localhost:8080/Reimbursement/denyReq/?id=" + reqId, true);
					xhr.send();
				});
				var dButtonText = document.createTextNode("Deny");
				denyButton.appendChild(dButtonText);
				cell6.appendChild(denyButton);
			}
		}
	} else {
		window.location = "http://localhost:8080/Reimbursement/homepage";
	}
}

function populateResolvedRequests(xhr) {
	if (xhr.responseText) {
		console.log(xhr.responseText);
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		var table = document.getElementById("resolvedReqs");
		for (var x in res) {
			var row = table.insertRow(0);
			var reqId = res[x].requestID;
			var empId = res[x].employeeID;
			var comment = res[x].comment;
			var amount = res[x].amount;
			var dateCreated = res[x].dateCreated;
			var mgrId = res[x].managerID;
			var status = res[x].status;
			var dateResolved = res[x].dateResolved;
			for (var i in x) {
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				var cell4 = row.insertCell(3);
				var cell5 = row.insertCell(4);
				var cell6 = row.insertCell(5);
				var cell7 = row.insertCell(6);
				var cell8 = row.insertCell(7);
				cell1.innerHTML = reqId;
				cell2.innerHTML = empId;
				cell3.innerHTML = comment;
				cell4.innerHTML = amount;
				cell5.innerHTML = dateCreated;
				cell6.innerHTML = mgrId;
				cell7.innerHTML = status;
				cell8.innerHTML = dateResolved;
			}
		}
	} else {
		window.location = "http://localhost:8080/Reimbursement/homepage";
	}
}

window.onload = function() {
	console.log("executed window.onload");
	sendAjaxGet("http://localhost:8080/Reimbursement/mgrInfo", populateMgrInfo);
	sendAjaxGet("http://localhost:8080/Reimbursement/allEmp", populateEmployees);
	sendAjaxGet("http://localhost:8080/Reimbursement/pendingReq", populatePendingRequests);
	sendAjaxGet("http://localhost:8080/Reimbursement/resolvedReq", populateResolvedRequests);
}
