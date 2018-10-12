package model;

import java.sql.*;
import java.util.ArrayList;
/**
 * LeafStudent Database class
 * Store every new LeafStudent information into 'LeafStudent' table in SQL database upon submission of new course
 * The methods that initiate connection with the SQL database are defined and implemented in here
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both
 * the addOb creates a connection to the 'LeafStudent' table in the database
 * the getOb get the whole table in the databse and returns a list of leaf students
 * the delOb truncate the table
 * Update queries are not implemented yet
 * These queries can be implement with this skelton with little effort
 * As of now we have not made GUI previleges for updation of database
 **/
public class LeafStudentDB {

    public static void addOb(LeafStudent obj){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");
            // the mysql insert statement
            String query = " INSERT INTO leafstudent (studentName, studentNumber, studentSection)"
                    + " VALUES (? , ? , ?)";
            //create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, obj.getStudentName());
            preparedStmt.setString(2, obj.getStudentNumber());
            preparedStmt.setString(3, obj.getStudentSection());
            // execute the prepared statement
            preparedStmt.execute();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }

    }
    public static ArrayList<LeafStudent> getOb(){
        ArrayList<LeafStudent> listOfLeafStudents=new ArrayList<>();
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");


            // the mysql get statement
            String query = "SELECT * FROM leafstudent";

            //Create Java Statement
            Statement st = conn.createStatement();

            // execute the query, and get a java result set
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                String getStudentName = rs.getString("studentName");
                String getStudentNumber = rs.getString("studentNumber");
                String getStudentSection = rs.getString("studentSection");
                listOfLeafStudents.add(new LeafStudent(getStudentName,getStudentNumber,getStudentSection));
            }

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return listOfLeafStudents;

    }
    public static void delOb(String studentNumber){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM Instructor WHERE courseCode='"+studentNumber+"'");

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());


        }

    }


}
