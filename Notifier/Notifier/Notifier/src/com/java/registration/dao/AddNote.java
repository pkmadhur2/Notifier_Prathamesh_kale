package com.java.registration.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.java.registration.model.Note;
public class AddNote 
{
	public int registerEmployee(Note note) throws ClassNotFoundException 
    {
        String INSERT_USERS_SQL = "INSERT INTO notes" +
            "  (note_name, start_date,end_date,reminder_date,status,tag,description,user_id) VALUES " +
            " (?, ?, ?, ?,?,?,?,?);";
        
        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/notifier?useSSL=false", "root", "dynamo@123");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) 
        {
            preparedStatement.setString(1, note.getNote_name());
            preparedStatement.setString(2,note.getStart_date());
            preparedStatement.setString(3,note.getEnd_date());
            preparedStatement.setString(4,note.getReminder_date());
            preparedStatement.setString(5, "Active");
            preparedStatement.setString(6, note.getTag());
            preparedStatement.setString(7, note.getDescription());
            preparedStatement.setInt(8, note.getId());
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            System.out.println(note.getId());
        } 
        catch (SQLException e) 
        {
            printSQLException(e);
        }
        return result;
    }
	
	public int UpdateNote(Note note) throws ClassNotFoundException 
    {
        String INSERT_USERS_SQL = "UPDATE notes SET note_name=?, start_date=?, end_date=?, reminder_date=?, status=?,tag=?, description=?, user_id=? where note_id=?" ;
        
        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/notifier?useSSL=false", "root", "dynamo@123");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) 
        {
            preparedStatement.setString(1, note.getNote_name());
            preparedStatement.setString(2,note.getStart_date());
            preparedStatement.setString(3,note.getEnd_date());
            preparedStatement.setString(4, note.getReminder_date());
            preparedStatement.setString(5, "Active");
            preparedStatement.setString(6, note.getTag());
            preparedStatement.setString(7, note.getDescription());
            preparedStatement.setInt(8, note.getId());
            preparedStatement.setInt(9, note.getNote_id());
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            System.out.println(note.getId());
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
