<%@page import="com.zycusBank.bank.Bank"%>
<%@page import="com.zycusBank.bank.BankDAO"%>
<%@page import="com.zycusBank.enums.Role"%>
<%@page import="com.zycusBank.user.User"%>
<%@page import="com.zycusBank.user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Assign Users</title>
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
					<li class="nav-item active"><a class="nav-link"
						href="../logs.jsp" id="home">Home</a></li>

					<li class="nav-item active"><a class="nav-link"
						href="addBank.jsp" id="home">Banks</a></li>

					<li class="nav-item active"><a class="nav-link"
						href="addBranch.jsp" id="home">Branches</a></li>

					<li class="nav-item active"><a class="nav-link"
						href="../user/allUsers.jsp" id="home">Users</a></li>

					<li class="nav-item active"><a class="nav-link"
						href="../user/assignUser.jsp" id="home">Assign Users</a></li>
				</ul>
			</div>
		</nav>

		<div class="card">
			<div class="card-header">
				<p class="font-weight-bold">Users</p>
			</div>
			<div class="card-body">
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Role</th>
							<th>Bank Code</th>
							<th>Branch Code</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<%
							UserDAO userD = new UserDAO();
							BankDAO bankD = new BankDAO();
							for (User user : userD.findAll()) {
								out.println("<tr>");
								out.println("<td>" + user.getId() + "</td>");
								out.println("<td>" + user.getFirstName() + " " + user.getLastName() + "</td>");
								out.println("<td>" + user.getRole().name() + "</td>");
								out.println("<td>");
								out.println(
										
										"<div class=\"dropdown\">"+
										"<button class=\"btn btn-secondary dropdown-toggle dropdownBankCode\" type=\"button\""+
											"id=\""+user.getId()+"\" data-toggle=\"dropdown\" aria-haspopup=\"true\""+
											"aria-expanded=\"false\">Bank Code</button>"+
										"<div class=\"dropdown-menu\" aria-labelledby=\"dropdownBank\">");
								
										for(Bank bank : bankD.findAll())
											out.println("<a class=\"dropdown-item bankCodeDrop\" id=\""+bank.getBankCode()+"_"+user.getId()+"\">"+bank.getBankName()+"</a>");
	
										out.println("</div>"+
									"</div>");
									
									

								
								
								out.println("<input type=\"text\" id=\""+user.getId()+"_banKCode\" hidden/>");
								
								

								out.println("</td>");
								
								out.println("<td>");
								
								if((user.getRole().equals(Role.BRANCH_ADMIN)) || user.getRole().equals(Role.CUSTOMER)){
									out.println(
											
											"<div class=\"dropdown\">"+
											"<button class=\"btn btn-secondary dropdown-toggle\" type=\"button\""+
												"id=\""+user.getId()+"_branchCode\" data-toggle=\"dropdown\" aria-haspopup=\"true\""+
												"aria-expanded=\"false\">Branch Code</button>"+
											"<div class=\"dropdown-menu dropDownBranch_"+user.getId()+"\" aria-labelledby=\"dropDownBranch\">"+
												"<a class=\"dropdown-item branchCodeDrop \">Action</a>"+
											
											"</div>"+
										"</div>"
	
									);
								}
								else{
									out.println(" ");
								}
								
								out.println("<input type=\"text\" id=\""+user.getId()+"_branchCode\" hidden/>");
								out.println("</td>");
								
								
								
							if(user.getRole().equals(Role.CUSTOMER)){
								out.println(
										"<td><button type=\"button\" class=\"btn btn-success\" id=\"addAccount\">Add Account</button></td>");
							}else{
								out.println(
										"<td><button type=\"button\" class=\"btn btn-success\" id=\"assignUser\">Assign</button></td>");
							}
								out.println("</tr>");
							}
						%>
						
						
					</tbody>

				</table>
			</div>

		</div>



		<div class="footer">
			<div class="footer-copyright text-center py-3">&copy; 2018
				Copyright</div>
		</div>
	</div>
	
	<script>
		$(".bankCodeDrop").click(function() {
			
			var id = $(this).attr("id");
			var str = id.split("_");
			
			var userId = str[1];
			
			$("#"+userId).html(str[0]);
			
			var posting = $.post("../bank.do", {
				bankCode : str[0],
				action : "getBranches"
			});
			
			posting.done(function(data) {
				var branches = data.data;
				$(".dropDownBranch_"+userId).html("");
				
				for(var i in branches){
					$(".dropDownBranch_"+userId).append("<a class=\"dropdown-item branchCodeDrop id=\""+branches[i].branchCode+"_"+userId+\" \">"+branches[i].branchName+"</a>")
				}
			});
			
			posting.fail(function() {
					alert("something went wrong");
				});
			
		})
	</script>
	
	
	
</body>
</html>