package com.dhairya;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateExample {
    public static void main(String[] args) {
        
    
    String url = "jdbc:postgresql://localhost:5432/dhairyadb";
    String user = "postgres";
    String pass = "Dhairya@1234";

    String sql="UPDATE students SET course = ? WHERE id = ?";

    try(
        Connection conn = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = conn.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        
    ){
        System.out.print("Enter the student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the new course: ");
        String course = sc.nextLine();
       
        pstmt.setString(1, course);
        pstmt.setInt(2, id);
       

        int rowsUpdated = pstmt.executeUpdate();
        if (rowsUpdated>0) {
            System.out.println("Student course updated successfully!");
        }
            else {
                System.out.println("No student found with the given ID.");
            }
        
    }
    catch(SQLException e){
        System.out.println("Update failed!");
        e.printStackTrace();
    }   
}
}

