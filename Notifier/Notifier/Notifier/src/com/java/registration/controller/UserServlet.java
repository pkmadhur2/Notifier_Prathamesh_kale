package com.java.registration.controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.registration.dao.UserDao;
import com.java.registration.model.User;

@WebServlet("/register")
public class UserServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private UserDao userdao;
    public UserServlet() 
    {
        super();
    }
    public void init() 
    {
    	userdao = new UserDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	response.getWriter().append("Served at: ").append(request.getContextPath());
    	RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/Signup.jsp");
    	dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        String firstName = request.getParameter("name_r");
        String email = request.getParameter("email_r");
        String password = request.getParameter("pwd_r");
        String encryp_pass= Base64.getEncoder().encodeToString(password.getBytes());
        String mob_no = request.getParameter("mob_no_r");
        User user = new User();
        user.setName(firstName);
        user.setEmail(email);
        user.setPassword(encryp_pass);
        user.setMobile_no(mob_no);
        try 
        {
        	userdao.registerEmployee(user);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/Signup.jsp");
    	dispatcher.forward(request, response);
    }
}

