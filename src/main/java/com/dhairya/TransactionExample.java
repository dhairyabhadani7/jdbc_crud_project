package com.dhairya;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dhairyadb";
        String user="postgres";
        String pass="Dhairya@1234";

        try (
            Connection conn = DriverManager.getConnection(url, user, pass);
        ) {
            conn.setAutoCommit(false);

           try (Statement stmt = conn.createStatement()) {
            
                stmt.executeUpdate("INSERT INTO students (name, course, email) VALUES ('Riya', 'SQL', 'riya@example.com')");
                stmt.executeUpdate("UPDATE students SET course='Advanced SQL' WHERE name='Riya'");
                
                conn.commit(); // commit both

                System.out.println("Transaction committed successfully!");

            } catch (SQLException ex) {
                conn.rollback(); // undo everything if one fails
                System.out.println("Transaction rolled back due to error.");
                ex.printStackTrace();
            }
            
        } catch (SQLException e) {
           
        }
    }
}
