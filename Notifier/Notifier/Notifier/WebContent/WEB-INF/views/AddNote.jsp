<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notifier | Notes</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
<style>
	<%@include file="/WEB-INF/assets/css_files/addnote.css"%>
</style>
<script>
<%@include file="/WEB-INF/assets/js/Test.js"%>
</script>
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
       <span id="notes" style="font-size:30px;margin-left:15px;">NOTES</span><button class="btn btn-danger" style="float:right;" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;Add Notes</button>
	  <div class="col-lg-8" id="main_content" style=" margin-top:50px;width:100%;">
	        <c:forEach items="${notesdetail}" var="item">
	        <form action="<%=request.getContextPath()%>/DeleteServlet" method="post">
		<p><b><u>${item.note_name}</u></b></p>
		<p>Start Date: ${item.start_date}</p>
		<p>End Date: ${item.end_date}</p>
		<p>Reminder Date: ${item.reminder_date}</p>
		<p>Status:<span style="color:green;"><b>${item.status}</b></span></p>
		<input type="hidden" name="idd" value="${item.id}">
		<button class="btn btn-warning" type="button" style="float:right;width:100px;margin-right:16px;" data-toggle="modal" data-target="#editmodal"><span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;Edit</button>
		<button class="btn btn-danger" type="submit" style="float:right;width:100px;margin-right: 16px"><span class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;Delete</button><br><br>
	<hr>
	<div class="modal fade" id="editmodal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add Note</h4>
        </div>
        <div class="modal-body">
          <form action="<%=request.getContextPath()%>/EditNote" method="post">
		  <input type="hidden" name="iddd" value="${item.id}">
			<div class="form-group" id="name_d">
			  <input type="text" class="form-control" id="name" placeholder="Enter Note Name" name="note_name" value="${item.note_name}">
			   <small id="error_msg_name">Error Message</small>
			</div>
			<div class="form-group" id="email_d">
			  <input type="date" class="form-control" id="email" placeholder="Start Date" name="start_date" value="${item.start_date}">
			   <small id="error_msg_email">Error Message</small>
			</div>
			<div class="form-group" id="pwd_d">
			  <input type="date" class="form-control" id="pwd" placeholder="End Date" name="end_date" value="${item.end_date}">
			   <small id="error_msg_pwd">Error Message</small>
			</div>
			<div class="form-group" id="c_pwd_d">
			  <input type="date" class="form-control" id="c_pwd" placeholder="Reminder Date" name="reminder_date" value="${item.reminder_date}">
			   <small id="error_msg_c_pwd">Error Message</small>
			</div>
			<div class="form-group" id="mob_no_d">
			  <input type="text" class="form-control" id="mob_no" placeholder="Tag" name="tag_tag" value="${item.tag}">
			   <small id="error_msg_mob_no">Error Message</small>
			</div>
			<div class="form-group" id="mob_no_d">
			  <textarea  class="form-control" rows="4"id="mob_no" placeholder="Description" name="description_description">${item.description}</textarea>
			   <small id="error_msg_mob_no">Error Message</small>
			</div>
			<button type="submit" class="btn btn-success" id="btn"  style="width:110px;">Submit</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal" style="width:110px;">Close</button>
		</form>

        </div>
      </div>
    </div>
</div>
		</form>
		</c:forEach>
		
		
	  </div>
    </div>
  </div>
</div>
<div class="footer">
  <p>Designed  By  Prathamesh Kale  [ Virtusa Full Stack React ]</p>
</div>

 <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit Note</h4>
        </div>
        <div class="modal-body">
          <form action="<%=request.getContextPath()%>/note" method="post">
		  
			<div class="form-group" id="name_d">
			  <input type="text" class="form-control" id="name" placeholder="Enter Note Name" name="note_name" >
			   <small id="error_msg_name">Error Message</small>
			</div>
			<div class="form-group" id="email_d">
			  <input type="date" class="form-control" id="email" placeholder="Start Date" name="start_date" >
			   <small id="error_msg_email">Error Message</small>
			</div>
			<div class="form-group" id="pwd_d">
			  <input type="date" class="form-control" id="pwd" placeholder="End Date" name="end_date" >
			   <small id="error_msg_pwd">Error Message</small>
			</div>
			<div class="form-group" id="c_pwd_d">
			  <input type="date" class="form-control" id="c_pwd" placeholder="Reminder Date" name="reminder_date" >
			   <small id="error_msg_c_pwd">Error Message</small>
			</div>
			<div class="form-group" id="mob_no_d">
			  <input type="text" class="form-control" id="mob_no" placeholder="Tag" name="tag_tag" >
			   <small id="error_msg_mob_no">Error Message</small>
			</div>
			<div class="form-group" id="mob_no_d">
			  <textarea type="text" class="form-control" rows="4"id="mob_no" placeholder="Description" name="description_description" ></textarea>
			   <small id="error_msg_mob_no">Error Message</small>
			</div>
			<button type="submit" class="btn btn-success" id="btn"  style="width:110px;">Submit</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal" style="width:110px;">Close</button>
		</form>
        </div>
      </div>
    </div>
</div>


<div class="modal fade" id="editmodal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit Note</h4>
        </div>
        <div class="modal-body">
          <form action="<%=request.getContextPath()%>/note" method="post">
		  
			<div class="form-group" id="name_d">
			  <input type="text" class="form-control" id="name" placeholder="Enter Note Name" name="note_name" value="${item.note_name}">
			   <small id="error_msg_name">Error Message</small>
			</div>
			<div class="form-group" id="email_d">
			  <input type="date" class="form-control" id="email" placeholder="Start Date" name="start_date" value="${item.start_date}">
			   <small id="error_msg_email">Error Message</small>
			</div>
			<div class="form-group" id="pwd_d">
			  <input type="date" class="form-control" id="pwd" placeholder="End Date" name="end_date" value="${item.end_date}">
			   <small id="error_msg_pwd">Error Message</small>
			</div>
			<div class="form-group" id="c_pwd_d">
			  <input type="date" class="form-control" id="c_pwd" placeholder="Reminder Date" name="reminder_date" value=" ${item.reminder_date}">
			   <small id="error_msg_c_pwd">Error Message</small>
			</div>
			<div class="form-group" id="mob_no_d">
			  <input type="text" class="form-control" id="mob_no" placeholder="Tag" name="tag_tag" >
			   <small id="error_msg_mob_no">Error Message</small>
			</div>
			<div class="form-group" id="mob_no_d">
			  <textarea type="text" class="form-control" rows="4"id="mob_no" placeholder="Description" name="description_description" ></textarea>
			   <small id="error_msg_mob_no">Error Message</small>
			</div>
			<button type="submit" class="btn btn-success" id="btn"  style="width:110px;">Submit</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal" style="width:110px;">Close</button>
		</form>
        </div>
      </div>
    </div>
</div>

<div class="modal fade" id="edituser" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit User</h4>
        </div>
        <div class="modal-body">
          <form action="<%=request.getContextPath()%>/edituserdetails" method="post">
		  <input type="hidden" name="user_id" value="${ currentSessionUser.id }">
			<div class="form-group" id="name_d">
			  <input type="text" class="form-control" id="name_edit" placeholder="Enter Name" name="user_name" value="${ currentSessionUser.name }">
			   <small id="error_msg_name">Error Message</small>
			</div>
			<div class="form-group" id="email_d">
			  <input type="text" class="form-control" id="email_edit" placeholder="Enter User Email" name="user_email" value="${ currentSessionUser.email }">
			   <small id="error_msg_email">Error Message</small>
			</div>
			<div class="form-group" id="pwd_d">
			  <input type="password" class="form-control" id="pwd_edit" placeholder="Enter Password" name="user_pass">
			   <small id="error_msg_pwd">Error Message</small>
			</div>
			<div class="form-group" id="c_pwd_d">
			  <input type="text" class="form-control" id="mobno_edit" placeholder="Enter Mobile No" name="user_mobno" value="${ currentSessionUser.mobile_no}">
			   <small id="error_msg_c_pwd">Error Message</small>
			</div>
			<button type="submit" class="btn btn-success" id="btn"  style="width:110px;">Update</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal" style="width:110px;">Close</button>
		</form>
        </div>
      </div>
    </div>
</div>



<div class="modal fade" id="pop_delete" role="dialog">
    <div class="modal-dialog" style="width:500px;margin-top:250px;">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Warning !</h4>
        </div>
        <div class="modal-body text-center">
          <h5><b>Do you really want to delete this note ?</b></h5>
        </div>
        <div class="modal-footer text-center">
        <form method="get" action="<%=request.getContextPath()%>/logout_redirection">
				<button type="submit" class="btn btn-success" id="btn"  style="width:110px;" onclick="getdata()">Yes</button>
          		<button type="button" class="btn btn-danger" data-dismiss="modal" style="width:110px;">No</button>
          </form>
        </div>
      </div>
    </div>
</div>
</body>
</html>