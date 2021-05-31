<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notifier | Notebook</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
<style>
	<%@include file="/WEB-INF/assets/css_files/notebook.css"%>
</style>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <p id="logo" class="navbar-brand">Notifier</p>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
         <li ><a href="<%=request.getContextPath()%>/HomeRedirection"style="color:white;">Home</a></li>
        <li><a href="<%=request.getContextPath()%>/NotebookRedirection"style="color:white;">Notebooks</a></li>
        <li><a href="<%=request.getContextPath()%>/NotesRedirection"style="color:white;">Notes</a></li>
        <li><a href="#edituser" data-toggle="modal" data-target="#edituser"style="color:white;">Edit User</a></li>
      </ul>
        <ul class="nav navbar-nav navbar-right">
	  <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-bell white"><span class="badge badge-light"><c:out value= "${ currentSessionUser.count }" /></span></span></a>
        <ul class="dropdown-menu">
          <p style="font-size:20px;margin-top:10px;color:#004347;"><strong><i class="far fa-bell-on"></i> Notification</strong></p><br>
          <c:forEach items="${notedatalist}" var="item">
			  <li><b>${item.note_name}</b><br>Reminder Date: ${item.reminder_date}</li><br>
		</c:forEach>
        </ul>
      </li>
      <li><a href="<%=request.getContextPath()%>/logout_redirection"><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;&nbsp;Logout</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container-fluid text-center" id="main_cont">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <p><span class="glyphicon glyphicon-tasks"></span>&nbsp;&nbsp;<u>Your Daily Tasks</u></p><br>
      <c:forEach items="${notesdetail}" var="item">
	  <p><b><u>${item.note_name}</u></b></p>
		<p>Start Date: ${item.start_date}</p>
		<p>End Date: ${item.end_date}</p>
	</c:forEach>
    </div>
    <div class="col-lg-10 text-left" id="main_frame"> 
        <span id="notes" style="font-size:30px;margin-left:15px;">NOTEBOOK</span><button class="btn btn-danger" style="float:right;" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;Add Notebook</button>
	 <div class="col-lg-8" id="main_content" style=" margin-top:50px;width:100%;">
	      <%--    <c:forEach items="${notesdetail}" var="item"> --%>
	        <form action="<%=request.getContextPath()%>/DeleteServlet" method="post" id="main_content1">
		<p><b><u>Virtusa</u></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5 Notes</p>
		<button class="btn btn-default" type="button" style="float:right;width:120px;margin-right:16px;" data-toggle="modal" data-target="#editmodal"><span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;Add Note&nbsp;&nbsp;</button>
                <button class="btn btn-warning" type="button" style="float:right;width:120px;margin-right:16px;" data-toggle="modal" data-target="#editmodal"><span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;Edit&nbsp;&nbsp;</button>
		<button class="btn btn-danger" type="submit" style="float:right;width:120px;margin-right: 16px"><span class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;Delete&nbsp;&nbsp;</button><br><br>
		</form><br><br>
		<form action="<%=request.getContextPath()%>/DeleteServlet" method="post" id="main_content1">
		<p><b><u>Virtusa Polaris</u></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5 Notes</p>
		<button class="btn btn-default" type="button" style="float:right;width:120px;margin-right:16px;" data-toggle="modal" data-target="#editmodal"><span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;Add Note&nbsp;&nbsp;</button>
                <button class="btn btn-warning" type="button" style="float:right;width:120px;margin-right:16px;" data-toggle="modal" data-target="#editmodal"><span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;Edit&nbsp;&nbsp;</button>
		<button class="btn btn-danger" type="submit" style="float:right;width:120px;margin-right: 16px"><span class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;Delete&nbsp;&nbsp;</button><br><br>
		</form>
		<%-- </c:forEach> --%>
	</div>
    </div>
  </div>
</div>

<div class="footer">
  <p>Designed  By  Prathamesh Kale  [ Virtusa Full Stack React ]</p>
</div>
</body>
</html>