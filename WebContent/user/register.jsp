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
					<form>
						<div class="form-group">
							<label for="formGroupExampleInput">Full Name</label>
								<div class="row">
									<div class="col">
										<input type="text" class="form-control" placeholder="First Name" id="fName">
									</div>
									<div class="col">
										<input type="text" class="form-control" placeholder="Last name" id="lName">
									</div>
								</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col">
									<label for="mob_no">Mobile Number</label>
									<input type="text" class="form-control" placeholder="Mobile Number" id="mob_no">
								</div>
								<div class="col">
									<label for="email_id">Email Id</label>
									<input type="text" class="form-control" placeholder="Email Id" id="email_id">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col">
									<label for="mob_no">Pan Number</label>
									<input type="text" class="form-control" placeholder="PAN Number" id="pan_no">
								</div>
								<div class="col">
									<label for="email_id">Aadhar Number</label>
									<input type="text" class="form-control" placeholder="Aadhar Number" id="aadhar_no">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="">Date of Birth</label>
							<input type="date" class="form-control" id="dob">
						</div>
						<div class="form-group">
							<label for="address">Address</label>
							<input type="text" class="form-control" id="address" placeholder="Enter your Address">
						</div>
						<div class="form-group">
							<label for="address">Profile Photo</label>
							<input type="file" class="form-control-file" id="exampleFormControlFile1">
						</div>
						<div class="alert alert-success" id="success"></div>
						<div class="alert alert-danger" id="fail"></div>
					  
						<div class="col-xl-12 text-center"> 
							<button type="button" class="btn btn-primary" id="submitBtn">Register</button>
						</div>
					</form>
				</div>
			</div>
			
			<div class="footer">
				<div class="footer-copyright text-center py-3">&copy; 2018 Copyright
				</div>
			</div>
		</div>
	</body>
</html>