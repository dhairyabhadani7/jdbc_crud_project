package com.dhairya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertExampleDynamic {
    public static void main(String[] args) {

        // String url = "jdbc:postgresql://localhost:5432/dhairyadb";
        // String user = "postgres";
        // String password = "Dhairya@1234";

        // String sql = "INSERT INTO students (name, course, email) VALUES ('Dhairya', 'Core Java', 'dhairya@example.com')";

        // try (Connection conn = DriverManager.getConnection(url, user, password);
        //      Statement stmt = conn.createStatement()) {

        //     int rows = stmt.executeUpdate(sql);
        //     if (rows > 0) {
        //         System.out.println("A new student was inserted successfully!");
        //     }

        // } catch (SQLException e) {
        //     System.out.println("Insertion failed!");
        //     e.printStackTrace();
        // }


    



        String url = "jdbc:postgresql://localhost:5432/dhairyadb";
        String user = "postgres";
        String password = "Dhairya@1234";

        String sql= "INSERT INTO students (name, course, email) VALUES (?, ?, ?)";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            Scanner scanner = new Scanner(System.in);
        ) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter course: ");
            String course = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            pstmt.setString(1,  name);
            pstmt.setString(2,  course);
            pstmt.setString(3,  email);

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
