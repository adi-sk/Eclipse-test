<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Zycus Bank Register</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
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
			h2{
				margin-top: 10px;
				text-align: center;
				margin-bottom: 30px;
			}
			p{
				box-sizing: border-box;
				padding: 20px;
				text-align: center;
			}
			.col-xl-12{
				box-sizing: border-box;
				width: 100%;
				padding: 50px;
			}
			div.alert{
				display: none;
			}
		</style>
		<script src="../js/jquery-3.3.1.min.js"></script>
		<script src="../js/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
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
							<a class="nav-link" href="index.html" id="home">Home</a>
						</li>
					</ul>
				</div>
			</nav>
			
			<div class="row">
				<div class="col-xl-12">
					<h2>Register User</h2>
					<form action="../add-user.do" method="post">
						<div class="form-group">
							<label for="formGroupExampleInput">Full Name</label>
								<div class="row">
									<button class="btn btn-primary dropdown-toggle" id="ddBtnTitle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Title</button>
									<div class="dropdown-menu" id="title_dd">
										<a class="dropdown-item" href="#" id="MR">MR</a>
										<a class="dropdown-item" href="#" id="MS">MS</a>
										<a class="dropdown-item" href="#" id="MRS">MRS</a>
										<a class="dropdown-item" href="#" id="DR">DR</a>
									</div>
									<input type="text"  id="title" name="title" hidden>
									
									<div class="col">
										<input type="text" class="form-control" placeholder="First Name" id="firstName" name="firstName">
									</div>
									<div class="col">
										<input type="text" class="form-control" placeholder="Last name" id="lastName" name="lastName">
									</div>
								</div>
						</div>
				
						<div class="form-group">
							<label for="formGroupExampleInput">Role</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<button class="btn btn-primary dropdown-toggle" id="ddBtnRole" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</button>
									<div class="dropdown-menu" id="title_dd">
										<a class="dropdown-item" href="#" id="BANK_ADMIN">Bank Admin</a>
										<a class="dropdown-item" href="#" id="BRANCH_ADMIN">Branch Admin</a>
										<a class="dropdown-item" href="#" id="CUSTOMER">Customer</a>
									</div>
								</div>
								<input type="text" class="form-control" aria-label="Text input with dropdown button" placeholder="Select Role" id="userRole" name="userRole">
							</div>
						</div>
						
						<div class="form-group">
							<div class="row">
								<div class="col">
									<label for="mob_no">Mobile Number</label>
									<input type="text" class="form-control" placeholder="Mobile Number" id="mobile" name="mobile">
									<div class="alert alert-danger" id="failMobile">Please enter valid contact</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col">
									<label for="email_id">Aadhaar Number</label>
									<input type="text" class="form-control" placeholder="Aadhar Number" id="aadhaarNo" name="aadhaarNo">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="dob">Date of Birth</label>
							<input type="date" class="form-control" id="dob" name="dob">
						</div>
						<div class="form-group">
							<label for="address">Profile Photo</label>
							<input type="file" class="form-control-file" id="profilePic" name = "profilePic">
						</div>
						
						<div class="form-group">
							<label for="password">Set Password</label>
							<input type="password" class="form-control" id="pass" name="password">
						</div>
						<div class="form-group">
							<div class="alert alert-success" id="success">SUCCESS</div>
							<div class="alert alert-danger" id="fail"></div>
					  	</div>
						<div class="col-xl-12 text-center"> 
							<button type="submit" class="btn btn-primary" id="submitBtn">Register</button>
						</div>
					</form>
				</div>
			</div>
			
			<div class="footer">
				<div class="footer-copyright text-center py-3">&copy; 2018 Copyright
				</div>
			</div>
		</div>
		<script>
		
		$("#mobile").blur(function() {
			if($(this).val().length != 10){
				$("#failMobile").show()
				$("#submitBtn").attr("disabled","disabled")
				
			}
			else{
				$("#failMobile").hide()
				$("#submitBtn").removeAttr("disabled")
			}
		})
		
		$("#BANK_ADMIN").click(function(){
			$("#userRole").val($("#BANK_ADMIN").attr("id"))
		})
		
		$("#BRANCH_ADMIN").click(function(){
			$("#userRole").val($("#BRANCH_ADMIN").attr("id"))
		})
		
		$("#CUSTOMER").click(function(){
			$("#userRole").val($("#CUSTOMER").attr("id"))
		})
		
		$("#MR").click(function(){
			$("#ddBtnTitle").html($("#MR").attr("id"))
			$("#title").val($("#MR").attr("id"))
		})
		
		$("#MS").click(function(){
			$("#ddBtnTitle").html($("#MS").attr("id"))
			$("#title").val($("#MS").attr("id"))
		})
		
		$("#MRS").click(function(){
			$("#ddBtnTitle").html($("#MRS").attr("id"))
			$("#title").val($("#MRS").attr("id"))
		})
		
		$("#DR").click(function(){
			$("#ddBtnTitle").html($("#DR").attr("id"))
			$("#title").val($("#DR").attr("id"))
		})
		
		
		</script>
		
	</body>
</html>