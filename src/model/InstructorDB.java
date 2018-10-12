package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;

/**
 * Instructor Database class
 * Store every new Instructor information into 'instructor' table in SQL database upon submission of new instructor
 * The methods that initiate connection with the SQL database are defined and implemented in here
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the addOb creates a connection to the 'instructor' table in the database
 * the getOb get the whole table in the databse and returns a list of instructors
 * the delOb truncate the table
 * Update queries are not implemented yet.
 * These queries can be implement with this skelton with little effort
 * As of now we have not made GUI previleges for updation of database
 **/
public class InstructorDB {
    public static void addOb(Instructor obj){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");

            // the mysql insert statement
            String query = " INSERT INTO Instructor (instructorName, instructorID, prefCourse1, prefCourse2)"
                    + " VALUES (?, ?, ?, ?)";

             //create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, obj.getInstructorName());
            preparedStmt.setString(2, obj.getInstructorID());
            preparedStmt.setString(3,obj.getPrefCourse_1());
            preparedStmt.setString(4,obj.getPrefCourse_2());

            // execute the prepared statement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());


        }
    }
    public static ArrayList<Instructor> getOb(){
        ArrayList<Instructor> listOfInstructors=new ArrayList<Instructor>();
        Instructor theInstructor;
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");


            // the mysql get statement
            String query = "SELECT * FROM instructor";

            //Create Java Statement
            Statement st = conn.createStatement();

            // execute the query, and get a java result set
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                String getInstructorName = rs.getString("instructorName");
                String getInstructorID = rs.getString("instructorID");
                String getPrefCourse_1 = rs.getString("prefCourse1");
                String getPrefCourse_2 = rs.getString("prefCourse2");
                System.out.println(getInstructorID +" "+ getInstructorName +" "+ getPrefCourse_1 +" "+ getPrefCourse_2);
                theInstructor=new Instructor(getInstructorName,getInstructorID,getPrefCourse_1,getPrefCourse_2);
                listOfInstructors.add(theInstructor);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }
        return listOfInstructors;

    }
    public static void delOb(){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");
            Statement st = conn.createStatement();
            st.executeUpdate("truncate instructor");
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }







}
