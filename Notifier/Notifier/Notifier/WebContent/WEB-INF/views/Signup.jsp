<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notifier | Signup</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
<script>
	<%@include file="/WEB-INF/assets/js/signup.js"%>
</script>
<style>
	<%@include file="/WEB-INF/assets/css_files/signup.css"%>
</style>
</head>
<body>
<div class="row">
	<div class="col-lg-6" id="div1">
		<img class="img-responsive" src="/assets/images/l2.jpg">
	</div>
	<div class="col-lg-6" id="div2">
		<form action="<%=request.getContextPath()%>/register" method="post">
		  <div class="container text-center">
		  <h1>Notifier</h1>
			<h2>SignUp</h2>
			<div class="form-group" id="name_d">
			  <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name_r" >
			   <small id="error_msg_name">Error Message</small>
			</div>
			<div class="form-group" id="email_d">
			  <input type="email" class="form-control" id="email" placeholder="Enter Email" name="email_r" >
			   <small id="error_msg_email">Error Message</small>
			</div>
			<div class="form-group" id="pwd_d">
			  <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd_r" >
			   <small id="error_msg_pwd">Error Message</small>
			</div>
			<div class="form-group" id="c_pwd_d">
			  <input type="password" class="form-control" id="c_pwd" placeholder="Confirm Password" name="c_pwd_r" >
			   <small id="error_msg_c_pwd">Error Message</small>
			</div>
			<div class="form-group" id="mob_no_d">
			  <input type="text" class="form-control" id="mob_no" placeholder="Mobile Number" name="mob_no_r" >
			   <small id="error_msg_mob_no">Error Message</small>
			</div>
			<button type="submit" class="btn btn-success" id="btn" onclick="return validate_form()">Submit</button>
			<p style="margin-top:15px;">Already Member ? <a href="<%=request.getContextPath()%>/login_redirection">Login</a></p>
		  </div>
		</form>
	</div>
</div>
<div class="footer">
  <p>Designed  By  Prathamesh Kale  [ Virtusa Full Stack React ]</p>
</div>
</body>
</html>