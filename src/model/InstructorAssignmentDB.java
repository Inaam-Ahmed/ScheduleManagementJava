package model;

import java.sql.*;
import java.util.ArrayList;
/**
 * Instructor Assignment Database class
 * Store every new InstructorAssignment information into 'instructorassignment' table in SQL database during process of generating schedule
 * The methods that initiate connection with the SQL database are defined and implemented in here
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the addOb creates a connection to the 'instructorassignment' table in the database
 * the getOb get the whole table in the databse and returns a list of instructors assignmetns
 * the delOb truncate the table
 * Update queries are not implemented yet.
 * These queries can be implement with this skelton with little effort
 * As of now we have not made GUI previleges for updation of database
 **/

public class InstructorAssignmentDB {

    public static void addOb(InstructorAssignment obj){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");

            // the mysql insert statement
            String query = " INSERT INTO instructorassignment(courseCode,courseName,creditHours,isLabCourse,instructorID,instructorName)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";

            //create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, obj.getCourseCode());
            preparedStmt.setString(2, obj.getCourseName());
            preparedStmt.setInt(3,obj.getCreditHours());
            preparedStmt.setBoolean(4,obj.isLabCourse());
            preparedStmt.setString(5,obj.getInstructorID());
            preparedStmt.setString(6,obj.getInstructorName());

            // execute the prepared statement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());


        }
    }
    public static ArrayList<InstructorAssignment> getOb(){
        ArrayList<InstructorAssignment> listOfInstructorAssignment=new ArrayList<InstructorAssignment>();
        InstructorAssignment theInstructorAssignment;
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");


            // the mysql get statement
            String query = "SELECT * FROM instructorassignment";

            //Create Java Statement
            Statement st = conn.createStatement();

            // execute the query, and get a java result set
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                String getCourseCode = rs.getString("courseCode");
                String getCourseName = rs.getString("courseName");
                int getCreditHours = rs.getInt("creditHours");
                boolean getIsLabCourse = rs.getBoolean("isLabCourse");
                String getInstructorID = rs.getString("instructorID");
                String getInstructorName = rs.getString("instructorName");
                System.out.println("Seeeeeeee");
                System.out.println(getCourseCode + " " + getCourseName + " " +getCreditHours+ " " +getIsLabCourse+" "+getInstructorID + " "+ getInstructorName);
                theInstructorAssignment=new InstructorAssignment(getCourseCode,getCourseName,getCreditHours,getIsLabCourse,getInstructorID,getInstructorName);
                listOfInstructorAssignment.add(theInstructorAssignment);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }
        return listOfInstructorAssignment;

    }
    public static void delOb(){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");
            Statement st = conn.createStatement();
            st.executeUpdate("truncate instructorassignment");
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }



}
