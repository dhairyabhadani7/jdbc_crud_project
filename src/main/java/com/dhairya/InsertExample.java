package com.dhairya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dhairyadb";
        String user = "postgres";
        String password = "Dhairya@1234";
        String sql = "INSERT INTO students (name, course, email) VALUES (?, ?, ?)";

        try(Connection conn = DriverManager.getConnection(url, user, password)) {
          PreparedStatement pstmt = conn.prepareStatement(sql);
          pstmt.setString(1, "Dhairya");
          pstmt.setString(2, "Core Java");
          pstmt.setString(3, "dhairya@example.com");   
          int rows = pstmt.executeUpdate();
          if(rows > 0) {
            System.out.println("A new student was inserted successfully using PreparedStatement!");
          }  
        } catch (SQLException e) {
             System.out.println("Insertion failed!");
            e.printStackTrace();
        }
    }
}
