


<!DOCTYPE HTML>
<html>

<head>
	<title>Groovy Login Form a Responsive Widget Template :: w3layouts</title>
</head>
<body>
<b>Welcome to DemoAPI</b>
<h1>Groovy Login Form</h1>
	<!-- Main-Content -->
	<div class="main-w3layouts-form">
		<h2>Login to your account</h2>
		<!-- main-w3layouts-form -->
		<form action="http://localhost:8081/DemoAPI/rest/loginUser" method="post">
			<div class="fields-w3-agileits">
				<span class="fa fa-user" aria-hidden="true"></span>
				<input type="text" name="emailId" required="" placeholder="Username" />
			</div>
			<div class="fields-w3-agileits">
				<span class="fa fa-key" aria-hidden="true"></span>
				<input type="password" name="pwd" required="" placeholder="Password" />
			</div>
			<div class="remember-section-wthree">
				<ul>
					<li>
						<label class="anim">
							<input type="checkbox" class="checkbox">
							<span> Remember me ?</span> 
						</label>
					</li>
					<li> <a href="#">Forgot password?</a> </li>
				</ul>
				<div class="clear"> </div>
			</div>
			<input type="submit" value="Login" />
		</form>
	</div>
</body>
</html>