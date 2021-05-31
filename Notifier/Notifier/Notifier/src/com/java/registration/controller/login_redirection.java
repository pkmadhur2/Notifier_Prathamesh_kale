package com.java.registration.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.registration.model.User;

@WebServlet("/login_redirection")
public class login_redirection extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public login_redirection() 
    {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 User user=new User();
		HttpSession session = request.getSession(false);	    
        session.setAttribute("currentSessionUser",user); 
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
    	dispatcher.forward(request, response);
    	
	}
}
