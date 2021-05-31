package com.java.registration.controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.registration.dao.UserDao;
import com.java.registration.model.User;

/**
 * Servlet implementation class edituserdetails
 */
@WebServlet("/edituserdetails")
public class edituserdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userdao;
    public edituserdetails() 
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
    	RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
    	dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id=Integer.parseInt(request.getParameter("user_id"));
		String firstName = request.getParameter("user_name");
        String email = request.getParameter("user_email");
        String password = request.getParameter("user_pass");
        String encryp_pass= Base64.getEncoder().encodeToString(password.getBytes());
        String mob_no = request.getParameter("user_mobno");
        User user = new User();
        user.setId(id);
        user.setName(firstName);
        user.setEmail(email);
        user.setPassword(encryp_pass);
        user.setMobile_no(mob_no);
        try 
        {
        	userdao.updateuser(user);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/Signup.jsp");
    	dispatcher.forward(request, response);
	}

}
