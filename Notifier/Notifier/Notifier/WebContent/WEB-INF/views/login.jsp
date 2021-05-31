<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notifier | Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
<script>
	<%@include file="/WEB-INF/assets/js/login.js"%>
</script>
<style>
	<%@include file="/WEB-INF/assets/css_files/logincss.css"%>
</style>
</head>
<body>
	<div class="row">
	<div class="col-lg-12" id="div2">
		<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
		  <div class="container text-center">
		  <h1>Notifier</h1>
			<h2>Login</h2>
			<div class="form-group" id="user">
			  <input type="email" class="form-control success" id="email" placeholder="Enter email" name="email_r_r" >
			  <small id="error_msg_email">Error Message</small>
			</div>
			<div class="form-group" id="pass">
			  <input type="password" class="form-control error" id="pwd" placeholder="Enter password" name="pwd_r_r" >
			  <small id="error_msg_pass">Error Message</small>
			</div>
			<button type="submit" class="btn btn-success" id="btn" onclick="return checkInputs()">Submit</button>
			<p style="margin-top:15px;">New Member ? <a href="<%=request.getContextPath()%>/signup_redirection">Signup</a></p>
		  </div>
		</form>
	</div>
</div>
<div class="footer">
  <p>Designed  By  Prathamesh Kale  [ Virtusa Full Stack React ]</p>
</div>
</body>
</html>