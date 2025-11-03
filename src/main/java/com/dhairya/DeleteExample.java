package com.dhairya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dhairyadb";
        String user = "postgres";
        String pass = "Dhairya@1234";

        String sql= "DELETE FROM students WHERE id = ?";

        try ( Connection conn= DriverManager.getConnection(url, user, pass);
              PreparedStatement pstmt = conn.prepareStatement(sql);
              Scanner scanner = new Scanner(System.in);

        ) {

            System.out.print("Enter the student ID to delete: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("No student found with the given ID.");
            }
            
        } catch (SQLException e) {
            System.out.println("Delete failed!");
            e.printStackTrace();
        }
    }
}
