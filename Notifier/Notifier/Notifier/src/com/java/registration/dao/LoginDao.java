package com.java.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.java.registration.model.Note;
import com.java.registration.model.User;

public class LoginDao 
{
	private int id;
    ArrayList<Note> notedata = new ArrayList<Note>();
    ArrayList<Note> notedatalist = new ArrayList<Note>();
    User user=new User();
    int count=0;
    public boolean getUser(User user) throws ClassNotFoundException 
    {
    	boolean status=false;
        String INSERT_USERS_SQL = "Select * from user where email=? and password=?";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/notifier?useSSL=false", "root", "dynamo@123");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) 
        {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            System.out.println(preparedStatement);
            ResultSet result = preparedStatement.executeQuery();
            status=result.next();
            System.out.println(status);
            id=result.getInt(1);
            if(status)
            {
                 user.setName(result.getString(2));
                 user.setId(result.getInt(1));
                 user.setMobile_no(result.getString(5));
            }
        } 
        catch (SQLException e) 
        {
            printSQLException(e);
        }
        return status;
    }
    
    public List<Note> getNoteData(User user) throws ClassNotFoundException 
    {
        String INSERT_USERS_SQL = "Select * from notes where user_id=?";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/notifier?useSSL=false", "root", "dynamo@123");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) 
        {
            preparedStatement.setInt(1,user.getId());
            System.out.println("ID:"+id);
            System.out.println(preparedStatement);
            ResultSet result = preparedStatement.executeQuery();
           while(result.next())
           {
        	   Note note=new Note();
        	   note.setId(result.getInt(1));
        	   note.setNote_name(result.getString(2));
        	   note.setStart_date(result.getString(3));
        	   note.setEnd_date(result.getString(4));
        	   note.setReminder_date(result.getString(5));
        	   note.setStatus(result.getString(6));
        	   note.setTag(result.getString(7));
        	   note.setDescription(result.getString(8));   
        	   notedata.add(note);
           }
        } 
        
        catch (SQLException e) 
        {
            printSQLException(e);
        }   
        for(int i = 0; i < notedata.size(); i++) {
            System.out.println("ABC:"+notedata.get(i).getId());
            System.out.println("ABC:"+notedata.get(i).getNote_name());
            System.out.println("ABC:"+notedata.get(i).getStart_date());
            System.out.println("ABC:"+notedata.get(i).getEnd_date());
            System.out.println("ABC:"+notedata.get(i).getReminder_date());
            System.out.println("ABC:"+notedata.get(i).getStatus());
            System.out.println("ABC:"+notedata.get(i).getTag());
            System.out.println("ABC:"+notedata.get(i).getDescription());
            System.out.println("**********************************************");
        }
		return notedata;
    }
    
    
    public int getdata(User user) throws ClassNotFoundException 
    {
        String INSERT_USERS_SQL = "Select * from notes where user_id=?";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/notifier?useSSL=false", "root", "dynamo@123");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) 
        {
        	preparedStatement.setInt(1,user.getId());
        	System.out.println(preparedStatement);
            ResultSet result = preparedStatement.executeQuery();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
      	  	Date date = new Date();  
            String todays_date=formatter.format(date);
            System.out.println("Today"+todays_date);
            user.setCount(count);
            count=0;
            while(result.next())
            {
            	String rem_date=result.getString(5);
            	System.out.println("rem: "+rem_date);
            	if(todays_date.equals(rem_date))
            	 {
            		 count++;
            	 }
            }
        } 
        catch (SQLException e) 
        {
            printSQLException(e);
        }
        user.setCount(count);
        return count;
    }
    
    public List<Note> NoteList(User user) throws ClassNotFoundException 
    {
        String INSERT_USERS_SQL = "Select * from notes where user_id=?";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/notifier?useSSL=false", "root", "dynamo@123");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) 
        {
        	preparedStatement.setInt(1,user.getId());
        	System.out.println(preparedStatement);
            ResultSet result = preparedStatement.executeQuery();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
      	  	Date date = new Date();  
            String todays_date=formatter.format(date);
            while(result.next())
            {
            	Note note1=new Note();
            	String rem_date=result.getString(5);
            	System.out.println("rem: "+rem_date);
            	if(todays_date.equals(rem_date))
            	 {
            		note1.setNote_name(result.getString(2));
            		note1.setReminder_date(result.getString(5));
            		notedatalist.add(note1);
            	 }
            }
        } 
        catch (SQLException e) 
        {
            printSQLException(e);
        }
        return notedatalist;
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