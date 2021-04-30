<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Login</title>
		<link href="vendor/fontawesome-free/css/login.css" rel="stylesheet" type="text/css">
	</head>

	<body class="login-body">
		<div class="wrapper fadeInDown">
			<div id="formContent">
				<h2 class="active">Sign In</h2>
				<h2 class="inactive underlineHover" data-toggle="modal" data-target="#SignUpModal" >Sign Up</h2>
				
				<div class="modal fade" id="SignUpModal" tabindex="-1" role="dialog"
						aria-labelledby="SignUpModalTitle" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="SignUpModalitle">Choose user type</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<div class="flex justify-content-around">
										<a href="/signup-individual">Individual</a>
										<a href="/signup-business">Business</a>
										
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
	
				<form:form action="userCredentials" modelAttribute="userCredentials"
					method="POST" enctype="multipart/form-data">
	
					<form:errors path="email" id="error" />  
					<form:input type="text" id="email" class="fadeIn second" path="email" placeholder="email"/>
					<form:input type="password" id="password" class="fadeIn third" path="password" placeholder="password"/>
					<input type="submit" class="fadeIn fourth form-group" value="Log In"/>
					
				</form:form>
				
				<a href="http://localhost:8082/oauth2/authorization/google" class="btn btn-google btn-user"style="margin-bottom: 10px">
					<i class="fab fa-google fa-fw"></i> Login with Google
				</a>
	
				<div id="formFooter">
					<a class="underlineHover" href="#">Forgot Password?</a>
				</div>
	
			</div>
		</div>
	
	
	</body>

</html>
