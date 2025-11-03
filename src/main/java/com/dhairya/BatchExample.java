package com.dhairya;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BatchExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dhairyadb";
        String user = "postgres";
        String pass = "Dhairya@1234";

        try (
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();

        ) {
            conn.setAutoCommit(false);

            stmt.addBatch("INSERT INTO students (name, course, email) VALUES ('Amit', 'Python', 'amit@example.com')");
            stmt.addBatch("INSERT INTO students (name, course, email) VALUES ('Neha', 'C++', 'neha@example.com')");
            stmt.addBatch("INSERT INTO students (name, course, email) VALUES ('Kiran', 'React', 'kiran@example.com')");

            int[] results = stmt.executeBatch();
            conn.commit();

            System.out.println("Batch executed: " + results.length + " rows inserted.");
            
        } catch (SQLException e) {
            System.out.println("Batch operation failed!");
            e.printStackTrace();
        }
    }
}
