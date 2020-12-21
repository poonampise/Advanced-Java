package com.cdac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cdac.model.Register;



public class RegisterDao {

    public int registerRegister(Register register) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO login" +
            "  ( first_name, last_name, username, password, address, contact) VALUES " +
            " ( ?, ?, ?, ?,?,?);";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "12345");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
          
            preparedStatement.setString(1, register.getFirstName());
            preparedStatement.setString(2, register.getLastName());
            preparedStatement.setString(3, register.getUsername());
            preparedStatement.setString(4, register.getPassword());
            preparedStatement.setString(5, register.getAddress());
            preparedStatement.setString(6, register.getContact());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}