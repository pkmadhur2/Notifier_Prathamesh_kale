package com.java.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout_redirection")
public class logout_redirection extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public logout_redirection() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);	    
		if(session != null)
		{
    		request.getSession().invalidate();
    		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
        	dispatcher.forward(request, response);
    	}
		
	}
}
