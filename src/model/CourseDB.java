package model;

import java.sql.*;
import java.util.ArrayList;

/**
 * Course Database class
 * Store every new course information into 'course' table in SQL database upon submission of new course
 * The methods that initiate connection with the SQL database are defined and implemented in here
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the addOb creates a connection to the course table in the database
 * the getOb get the whole table in the databse and returns a list of courses
 * the delOb truncate the table
 * Update queries are not implemented yet.
 * These queries can be implement with this skelton with little effort
 * As of now we have not made GUI previleges for updation of database
 **/

public class CourseDB {

    public static void addOb(Course obj){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");
            // the mysql insert statement
            String query = " INSERT INTO course (courseCode, courseName, creditHours, isLabCourse)"
                    + " VALUES (? , ? , ? , ?)";
            //create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, obj.getCourseCode());
            preparedStmt.setString(2, obj.getCourseName());
            preparedStmt.setInt(3, obj.getCreditHours());
            preparedStmt.setBoolean(4, obj.isLabCourse());
            // execute the prepared statement
            preparedStmt.execute();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }

    }
    public static ArrayList<Course> getOb(){
        ArrayList<Course> listOfCourses= new ArrayList<>();
        Course theCourse;
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");


            // the mysql get statement
            String query = "SELECT * FROM course";

            //Create Java Statement
            Statement st = conn.createStatement();

            // execute the query, and get a java result set
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                String courseCode = rs.getString("courseCode");
                String courseName = rs.getString("courseName");
                String creditHours = rs.getString("creditHours");
                Boolean isLabCourse = rs.getBoolean("isLabCourse");
                theCourse=new Course(courseCode,courseName,Integer.parseInt(creditHours),isLabCourse);
                listOfCourses.add(theCourse);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());


        }
        return listOfCourses;

    }
    public static void delOb(String courseCode){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM Instructor WHERE courseCode='"+courseCode+"'");

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());


        }

    }


}
