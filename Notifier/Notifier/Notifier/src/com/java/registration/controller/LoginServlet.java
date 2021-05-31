package com.java.registration.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.registration.dao.LoginDao;
import com.java.registration.model.Note;
import com.java.registration.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao logindao;
	int count;
	List<Note> notedata1 = new ArrayList<Note>();
	List<Note> notedata2 = new ArrayList<Note>();
    public LoginServlet() 
    {
        super();
    }
    public void init() 
    {
    	logindao = new LoginDao();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
    	RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
    	response.setHeader("Cache-Control", "no-cache");
    	response.setHeader("Cache-Control", "no-store");
    	dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("email_r_r");
        String password = request.getParameter("pwd_r_r");
        String encryp_pass= Base64.getEncoder().encodeToString(password.getBytes());
        User user=new User();
        user.setEmail(email);
        user.setPassword(encryp_pass);
        try 
        {
        	if(logindao.getUser(user))
        	{
        		count=logindao.getdata(user);
        		notedata1.removeAll(notedata1);
        		notedata2.removeAll(notedata2);
        		notedata1=logindao.getNoteData(user);
        		notedata2=logindao.NoteList(user);
        		System.out.println("NOTEDATA 2:"+notedata1.size());
        		user.setCount(count);
        		System.out.println(user.getCount());
        		HttpSession session = request.getSession(false);	    
                session.setAttribute("currentSessionUser",user); 
                session.setAttribute("id", user.getId());
                session.setAttribute("notesdetail", notedata1);
                session.setAttribute("notedatalist", notedata2);
                session.setAttribute("totalcount", count);
        		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            	dispatcher.forward(request, response);
        	}
        	else
        	{
        		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
            	dispatcher.forward(request, response);
        	}
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}

}
