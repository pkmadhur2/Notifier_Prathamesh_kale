package com.java.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java.registration.model.User;

public class UserDao 
{

    public int registerEmployee(User user) throws ClassNotFoundException 
    {
        String INSERT_USERS_SQL = "INSERT INTO user" +
            "  (name, email, password, mobile_no) VALUES " +
            " (?, ?, ?, ?);";

        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/notifier?useSSL=false", "root", "dynamo@123");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) 
        {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getMobile_no());
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

        } 
        catch (SQLException e) 
        {
            printSQLException(e);
        }
        return result;
    }
    
    public int updateuser(User user) throws ClassNotFoundException 
    {
        String INSERT_USERS_SQL = "UPDATE user SET name=?,email=?,password=?,mobile_no=? where user_id=?";

        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/notifier?useSSL=false", "root", "dynamo@123");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) 
        {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getMobile_no());
            preparedStatement.setInt(5, user.getId());
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

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