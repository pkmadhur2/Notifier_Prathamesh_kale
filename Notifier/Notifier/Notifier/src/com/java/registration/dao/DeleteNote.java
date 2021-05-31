package com.java.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java.registration.model.Note;

public class DeleteNote  
{
	int result;
	public int del_note(Note note1) throws ClassNotFoundException 
	{
        String INSERT_USERS_SQL = "Delete from notes where note_id=?"; 
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/notifier?useSSL=false", "root", "dynamo@123");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) 
        {
            preparedStatement.setInt(1, note1.getId());
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            if(result>0)
            {
            	System.out.println(note1.getId()+" : Deleted Successfully");
            }
        } 
        catch (SQLException e) 
        {
            printSQLException(e);
        }
        return result;
	}
	  private void printSQLException(SQLException ex) 
	    {
	        for (Throwable e: ex) 
	        {
	            if (e instanceof SQLException) 
	            {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) 
	                {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }

}
