<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align: center; top: 50%;">
		<form id="newUser" action="../add-user.do" method="post">

			First Name: <input type="text" name="firstName" onblur="validateFN()">
			<h6 id="warningFN"></h6>

			Last Name : <input type="text" name="lastName" onblur="validateLN()">
			<h6 id="warningLN"></h6>

			Title : <input id="title" type="text" name="title"
				onblur="validateTitle()">
			<h6 id="warningTitle"></h6>
			
			
			Role : 
			<select name="userRole" id="userRole">
				<option value="BANK_ADMIN">Bank_admin</option>
				<option value="BRANCH_ADMIN">Branch_admin</option>
				<option value="CUSTOMER">Customer</option>
			</select>

			age : <input type="number" name="age"><br />
			<br /> DOB: <input type="date" name="dob"><br />
			<br /> Set Password : <input type="password" name="password">
			
			

			<input id="addUser" type="submit" value="Add User" disabled>

		</form>
		
		
		
	</div>
	<script>
		var element = document.getElementById("addUser");
		var form = document.getElementById("newUser");
		function validateFN() {
			var fnameL = form.elements[0].value.length;
			if (fnameL < 2) {
				document.getElementById("warningFN").innerHTML = "Needs atleast 2 characters";

			} else {
				document.getElementById("warningFN").innerHTML = "";

			}

		}

		function validateLN() {
			var lnameL = form.elements[1].value.length;
			if (lnameL < 2) {
				document.getElementById("warningLN").innerHTML = "Needs atleast 2 characters";
			} else {
				document.getElementById("warningLN").innerHTML = "";
			}
		}

		function validateTitle() {
			var titleArray = [ "mr", "ms", "mrs", "dr" ];
			if (titleArray.indexOf(document.getElementById("title").value
					.toLowerCase()) == -1) {
				document.getElementById("warningTitle").innerHTML = "Title must be "
						+ titleArray[0]
						+ "/"
						+ titleArray[1]
						+ "/"
						+ titleArray[2] + "/" + titleArray[3]
			} else {
				document.getElementById("warningTitle").innerHTML = "";
				document.getElementById("addUser").disabled = false;
			}

		}
	</script>

</body>
</html>