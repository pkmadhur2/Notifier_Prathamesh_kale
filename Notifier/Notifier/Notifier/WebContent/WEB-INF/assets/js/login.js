
function checkInputs()
{
	var email=document.getElementById("email").value.trim();
	var password=document.getElementById("pwd").value.trim();
	if(email=="" && password=="")
	{
		$("#user").addClass("error");
		document.getElementById("error_msg_email").style.visibility = "visible";
		document.getElementById("error_msg_email").innerHTML = "Username cannot be blank";
		$("#pass").addClass("error");
		document.getElementById("error_msg_pass").style.visibility = "visible";
		document.getElementById("error_msg_pass").innerHTML = "Password cannot be blank";
		return false;
	}
	if(email=="")
	{
		$("#user").addClass("error");
		document.getElementById("error_msg_email").style.visibility = "visible";
		document.getElementById("error_msg_email").innerHTML = "Username cannot be blank";
		return false;
	}
	else 
	{
		$("#user").addClass("success");
	}
	if(password=="")
	{
		$("#pass").addClass("error");
		document.getElementById("error_msg_pass").style.visibility = "visible";
		document.getElementById("error_msg_pass").innerHTML = "Password cannot be blank";
		return false;
	}
	else
	{
		$("#pass").addClass("success");
	}
	if(email!="" && password!="")
	{
		$("#user").addClass("success");
		$("#pass").addClass("success");
	}
}