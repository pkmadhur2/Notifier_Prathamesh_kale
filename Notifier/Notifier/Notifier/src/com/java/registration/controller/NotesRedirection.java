package com.java.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NotesRedirection")
public class NotesRedirection extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public NotesRedirection() 
    {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/AddNote.jsp");
		  response.setHeader("Cache-Control", "no-cache");
	    	response.setHeader("Cache-Control", "no-store");
    	dispatcher.forward(request, response);
	}
}
