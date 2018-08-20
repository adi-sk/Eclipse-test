
<%@page import="com.zycusBank.bank.Bank"%>
<%@page import="com.zycusBank.bank.BankDAO"%>
<%@page import="com.zycusBank.bank.Branch"%>
<%@page import="com.zycusBank.bank.BranchDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Add Bank</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style>
html {
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
}

body {
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
}

.container {
	min-height: 100%;
	box-sizing: border-box;
	border: 1px solid #CCCCCC;
	padding: 0 !important;
	position: relative;
	overflow-y: auto;
	overflow-x: hidden;
}

nav {
	width: 100%;
	background-color: #f2f2f2 !important;
}

img.img-fluid {
	height: 20px;
	margin-right: 20px;
}

div.footer {
	width: 100%;
	background-color: #f2f2f2;
	position: absolute;
	bottom: 0px;
	left: 0px;
	padding-top: 20px;
	padding-bottom: 20px;
}

div.form {
	width: 330px;
	height: 264px;
	box-sizing: border-box;
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -160px;
	margin-top: -220px;
}

h3 {
	text-align: center;
	margin-bottom: 50px;
}

.btn {
	width: 100%;
	font-size: 18px !important;
	padding-top: 8px;
	padding-bottom: 8px;
}

#user_id {
	border-bottom-left-radius: 0;
	border-bottom-right-radius: 0;
	border-bottom: 0px;
}

#password {
	border-top-left-radius: 0;
	border-top-right-radius: 0;
	margin-bottom: 30px;
}

p.new_user {
	font-size: 12px;
	text-align: center;
	margin-top: 15px;
}
</style>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<a class="navbar-left" href="#"><img src="../logo.png"
				class="img-fluid" alt="Responsive image"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="#"
						id="home">Home</a></li>

					<li class="nav-item active"><a class="nav-link"
						href="addBank.jsp" id="home">Banks</a></li>

					<li class="nav-item active"><a class="nav-link"
						href="addBranch.jsp" id="home">Branches</a></li>

					<li class="nav-item active"><a class="nav-link" href="#"
						id="home">Users</a></li>

					<li class="nav-item active"><a class="nav-link" href="#"
						id="home">Assign Users</a></li>
				</ul>

			</div>
		</nav>

		<div class="col-xl-12">

			<div class="form-group">

				<div class="row" style="padding: 12px;">

					<div class="col-sm">

						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle" type="button"
								id="dropDownBanks" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"
								style="padding-top: 5px; padding-bottom: 4px;">Bank
								Code</button>
							<div class="dropdown-menu" aria-labelledby="dropdownMenu1">
								<%
									BankDAO bankD = new BankDAO();
									for (Bank bank : bankD.findAll()) {
										if (bank != null) {
											out.println("<a class=\"dropdown-item\" id=\"" + bank.getBankCode() + "\" >" + bank.getBankName()
													+ "(" + bank.getBankCode() + ")</a>");
										}
									}
								%>
							</div>
						</div>

						<input type="text" class="form-control"
							placeholder="Branch Code (only 4 Chars)" id="inputBankCode"
							hidden>

					</div>

					<div class="col-sm">

						<input type="text" class="form-control"
							placeholder="Brach Code (only 3 numerics)" id="inputBranchCode">

					</div>

					<div class="col-sm">

						<input type="text" class="form-control" placeholder="Branch Name"
							id="inputBranchName">

					</div>

					<div class="col-2">

						<button type="button" class="btn btn-primary" id="addBranch"
							style="font-size: 14px !important;" data-container="body"
							data-toggle="popover" data-placement="bottom"
							data-content="Put 3 Characters in Branch Code">Add
							Branch</button>

					</div>
				</div>
			</div>
		</div>

		<div class="col-xl-12">
			<table class="table">
				<thead class="thead-light">
					<tr>
						<th>SR</th>
						<th>Bank Code</th>
						<th>Branch Code</th>
						<th>Branch Name</th>
					</tr>
				</thead>
				<tbody>
					<%
						int index = 1;
						BranchDAO branchD = new BranchDAO();

						for (Branch branch : branchD.findAll()) {

							out.println("<tr>");

							out.println("<th scope=\"row\">" + index + "</th>");

							out.println("<td>" + branch.getBankCode() + "</td>");

							out.println("<td>" + branch.getBranchCode() + "</td>");

							out.println("<td>" + branch.getBranchName() + "</td>");

							out.println("</tr>");

							index++;
						}
					%>
				</tbody>
			</table>
		</div>



		<div class="footer">
			<div class="footer-copyright text-center py-3">&copy; 2018
				Copyright</div>
		</div>
	</div>
	<script>
		$("#addBranch").click(function() {
			console.log("inside");
			console.log($("#inputBankCode").val());
			
			if ($("#inputBranchCode").val().length == 3) {
				var posting = $.post("../branch.do", {
					bankCode : $("#inputBankCode").val(),
					branchCode : $("#inputBranchCode").val(),
					branchName : $("#inputBranchName").val(),
					action : "addBranch"
				});

				posting.done(function(data) {
					location.reload();
				})

				posting.fail(function() {
					alert("something went wrong");
				})
			} else {
				$(this).popover();
			}

		})

		$(".dropdown-item").click(function() {
			$("#inputBankCode").val($(this).attr("id"))
			
			$("#dropDownBanks").html($(this).attr("id"))
			
			
		})
	</script>
</body>
</html>