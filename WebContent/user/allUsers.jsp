<%@page import="com.zycusBank.user.UserDAO"%>
<%@page import="com.zycusBank.user.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Zycus Bank</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
		<style>
			html{
				width: 100%;
				height: 100%;
				margin: 0;
				padding: 0;
			}
			body{
				width: 100%;
				height: 100%;
				margin: 0;
				padding: 0;
			}
			.container{
				min-height: 100%;
				box-sizing: border-box;
				border: 1px solid #CCCCCC;
				padding: 0 !important;
				position: relative;
				overflow-y: auto;
				overflow-x: hidden;
			}
			nav{
				width: 100%;
				background-color: #f2f2f2 !important;
			}
			img.img-fluid{
				height: 20px;
				margin-right: 20px;
			}
			div.footer{
				width: 100%;
				background-color: #f2f2f2;
				position: absolute;
				bottom: 0px;
				left: 0px;
				padding-top: 20px;
				padding-bottom: 20px;
			}
			li.nav-item{
				padding-left: 10px;
				padding-right: 10px;
			}
			#profile{
				color: rgba(0, 0, 0, 0.5);
			}
			#transfer, #new_acc{
				color: rgba(0, 0, 0, 0.5);
			}
			div.row{
				padding: 30px;
			}
			.card{
				padding: 10px;
				text-align: center;
			}
			span.username{
				font-weight: bold;
			}
			img#placeholder{
				width: 100px;
				height: 100px;
				margin: 0 auto;
				margin-bottom: 20px;
			}
			div#accounts_card{
				width: 100%;
				height: 100%;
				border: 0;
				padding: 0;
			}
			div#balance_card{
				padding: 0;
				text-align: left;
			}
			div.card-header{
				font-weight: bold;
			}
			#icon{
				margin-right: 10px;
			}
			#savings{
				margin-right: 10px;
			}
			div#all_accounts_card{
				text-align: left;
				padding: 0;
				margin-top: 50px;
				border: 0;
			}
			div#all_accounts_card .card-header{
				border-top: 1px solid rgba(0, 0, 0, 0.125);
				border-left: 1px solid rgba(0, 0, 0, 0.125);
				border-right: 1px solid rgba(0, 0, 0, 0.125);
				border-bottom: 0;
			}
			div#all_accounts_card .card-body{
				padding: 0;
			}
		</style>
		<script src="../js/jquery-3.3.1.min.js"></script>
		<script src="../js/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light">
				<a class="navbar-left" href="#"><img src="../logo.png" class="img-fluid" alt="Responsive image"></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active">
							<a class="nav-link" href="#" id="home">Home</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="profile.html" id="profile">My Profile</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="#" id="new_acc">New Account</a>
						</li>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown" id="payment">
								Payment & Transfer
							</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#">Fund Transfer</a>
								<a class="dropdown-item" href="#">Pay Bills</a>
								<a class="dropdown-item" href="#">Recharge</a>
							</div>
						</li>
					</ul>
				</div>
			</nav>
				<div class="col col-xl-12">
					<div class="card" id="accounts_card">
						<div class="card" id="balance_card">
							<div class="card-header">
								Total Balance
							</div>
							<div class="card-body">
								<i class="fas fa-user" id="icon"></i>
								<span id="savings">Savings</span>
								<span>&#8377 0.0</span>
							</div>
						</div>
						<div class="card" id="all_accounts_card">
							<div class="card-header">
								All Users
							</div>
							<div class="card-body">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>id</th>
											<th>Name</th>
											<th>title</th>
											<th>mobile</th>
											<th>DOB</th>
											<th>Aadhaar No</th>
											<th>Role</th>
										</tr>
									</thead>
									<tbody>
<%	
UserDAO userD = new UserDAO();

for(User user : userD.findAll() ){
	
	if(user != null){
		out.println("<tr>");
		out.println("<td>"+user.getId()+"</td>");
		out.println("<td>"+user.getFirstName()+" "+user.getLastName()+"</td>");
		out.println("<td>"+user.getTitle()+"</td>");
		out.println("<td>"+user.getMobile()+"</td>");
		out.println("<td>"+user.getDob().toString()+"</td>");
		out.println("<td>"+user.getAadhaarNo()+"</td>");
		out.println("<td>"+user.getRole().name()+"</td>");
		out.println("</tr>");
	
	}
	
} 									
									
										
										
										
%>										
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="footer">
				<div class="footer-copyright text-center py-3">&copy; 2018 Copyright
					
				</div>
			</div>
		</div>
	</body>
</html>