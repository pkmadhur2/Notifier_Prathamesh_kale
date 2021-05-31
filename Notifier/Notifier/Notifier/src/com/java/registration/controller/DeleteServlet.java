package com.java.registration.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.registration.dao.DeleteNote;
import com.java.registration.model.Note;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeleteNote delnote;
    public DeleteServlet() 
    {
        super();
    }
    public void init() 
    {
    	delnote = new DeleteNote();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
    	RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/AddNote.jsp");
    	dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int n_id = Integer.parseInt(request.getParameter("idd"));
		System.out.println("RECEIVED ID :" + n_id);
		Note note1 = new Note();
	    note1.setId(n_id);
	    try 
        {
	    	delnote.del_note(note1);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	    
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/AddNote.jsp");
        response.setIntHeader("Refresh", 2);
    	dispatcher.forward(request, response);
	}

}
