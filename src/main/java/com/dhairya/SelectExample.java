package com.dhairya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dhairyadb";
        String user = "postgres";
        String pass = "Dhairya@1234";

        String sql = "SELECT id, name, course, email FROM students";

        try (
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            
            System.out.println("Connected to PostgreSQL successfully!\n");
            System.out.println("ID | NAME | COURSE | EMAIL");
            System.out.println("-------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name= rs.getString("name");
                String course = rs.getString("course");
                String email = rs.getString("email");

                System.out.println(id + " | " + name + " | " + course + " | " + email);
            }
            

        } catch (SQLException e) {
            System.out.println("Query failed!");
            e.printStackTrace();
        }

    }
}
