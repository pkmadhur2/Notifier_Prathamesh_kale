package com.java.registration.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.java.registration.model.Note;
import com.java.registration.dao.AddNote;

@WebServlet("/note")
public class NoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddNote note;
    public NoteServlet() 
    {
        super();
    }
    
    public void init() 
    {
    	note = new AddNote();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
    	RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/AddNote.jsp");
    	dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 	String note_name = request.getParameter("note_name");
		 	String start_date = request.getParameter("start_date");
		 	String end_date = request.getParameter("end_date");
		 	String  reminder_date = request.getParameter("reminder_date");
		    System.out.println("DATES BEFORE PARSING:" +request.getParameter("start_date")+"\n"+request.getParameter("end_date")+"\n"+request.getParameter("reminder_date"));
	        String tag = request.getParameter("tag_tag");
	        String description = request.getParameter("description_description");
	        HttpSession session = request.getSession(false);	
	        int id=(int)session.getAttribute("id");
	        Note note1 = new Note();
	        note1.setNote_name(note_name);
	        note1.setStart_date(start_date);
	        note1.setEnd_date(end_date);
	        note1.setReminder_date(reminder_date);
	        note1.setTag(tag);
	        note1.setDescription(description);
	        note1.setId(id);
	        System.out.println("ID:"+session.getAttribute("id"));
	        try 
	        {
	        	note.registerEmployee(note1);
	        	RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/AddNote.jsp");
	        	response.sendRedirect("list");
	   	    	response.setIntHeader("Refresh",5);
	   	        response.setHeader("Cache-Control", "no-cache");
	   	    	response.setHeader("Cache-Control", "no-store");
	   	    	dispatcher.forward(request, response);
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }

	     
	}

}
