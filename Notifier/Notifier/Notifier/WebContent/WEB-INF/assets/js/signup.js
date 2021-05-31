var phoneno = /^\d{10}$/;
function validate_form()
{
	var name=document.getElementById("name").value;
	var email=document.getElementById("email").value;
	var password=document.getElementById("pwd").value;
	var confirm_password=document.getElementById("c_pwd").value;
	var mobile_no=document.getElementById("mob_no").value;
	if(name=="" && email=="" && password=="" && confirm_password=="" && mobile_no=="")
	{
		$("#name_d").addClass("error");
		$("#email_d").addClass("error");
		$("#pwd_d").addClass("error");
		$("#c_pwd_d").addClass("error");
		$("#mob_no_d").addClass("error");
		
		document.getElementById("error_msg_name").style.visibility = "visible";
		document.getElementById("error_msg_email").style.visibility = "visible";
		document.getElementById("error_msg_pwd").style.visibility = "visible";
		document.getElementById("error_msg_c_pwd").style.visibility = "visible";
		document.getElementById("error_msg_mob_no").style.visibility = "visible";
		
		document.getElementById("error_msg_name").innerHTML = "Name cannot be blank";
		document.getElementById("error_msg_email").innerHTML = "Eamil cannot be blank";
		document.getElementById("error_msg_pwd").innerHTML = "Password cannot be blank";
		document.getElementById("error_msg_c_pwd").innerHTML = "Confirm Password cannot be blank";
		document.getElementById("error_msg_mob_no").innerHTML = "Mobile Number cannot be blank";
		return false;
	}
	
	if(name=="")
	{
		$("#name_d").addClass("error");
		document.getElementById("error_msg_name").style.visibility = "visible";
		document.getElementById("error_msg_name").innerHTML = "Name cannot be blank";
		return false;
	}
	else
	{
		$("#name_d").addClass("success");
	}
	
	if(email=="")
	{
		
		$("#email_d").addClass("error");
		document.getElementById("error_msg_email").style.visibility = "visible";
		document.getElementById("error_msg_email").innerHTML = "Eamil cannot be blank";
		return false;
	}
	else
	{
		$("#email_d").addClass("success");
	}
	
	if(password=="")
	{
		$("#pwd_d").addClass("error");
		document.getElementById("error_msg_pwd").style.visibility = "visible";
		document.getElementById("error_msg_pwd").innerHTML = "Password cannot be blank";
		return false;
	}
	else
	{
		$("#pwd_d").addClass("success");
	}
	
	if(confirm_password=="")
	{
		
		$("#c_pwd_d").addClass("error");
		document.getElementById("error_msg_c_pwd").style.visibility = "visible";
		document.getElementById("error_msg_c_pwd").innerHTML = "Confirm Password cannot be blank";
		return false;
	}
	else
	{
		$("#c_pwd_d").addClass("success");
	}
	
	if(mobile_no=="")
	{
		$("#mob_no_d").addClass("error");
		document.getElementById("error_msg_mob_no").style.visibility = "visible";
		document.getElementById("error_msg_mob_no").innerHTML = "Mobile Number cannot be blank";
		return false;
	}
	else
	{
		$("#mob_no_d").addClass("success");
	}
	
	if(confirm_password!=password)
	{
		$("#c_pwd_d").addClass("error");
		document.getElementById("error_msg_c_pwd").style.visibility = "visible";
		document.getElementById("error_msg_c_pwd").innerHTML = "Confirm password should be same as actual Password";
		return false;
	}
	else
	{
		$("#c_pwd_d").addClass("success");
	}
	
	if(mobile_no.match(phoneno))
    {
		document.getElementById('mob_no').css('border-color', 'green');
        return true;
    }
    else
    {
        $("#mob_no").addClass("error");
		document.getElementById("error_msg_mob_no").innerHTML = "Mobile Number should be of 10 Digits.";
        return false;
    }
}
