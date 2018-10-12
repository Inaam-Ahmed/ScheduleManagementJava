package model;

import jdk.nashorn.internal.ir.Assignment;

import java.sql.*;
import java.util.ArrayList;

/**
 * Time Slot Database class
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

public class SlotAssignmentDB {

    public static void addOb(SlotAssignment obj){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");

            // the mysql insert statement
            String query = " INSERT INTO slotassignment(courseCode,instructorName,roomNum,startTimeHr,startTimeMn,endTimeHr,endTimeMn,dayOfSlot)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            //create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, obj.getCourseCode());
            preparedStmt.setString(2, obj.getInstructorName());
            preparedStmt.setString(3,obj.getRoomNum());
            preparedStmt.setInt(4,obj.getStartTimeHr());
            preparedStmt.setInt(5,obj.getStartTimeMn());
            preparedStmt.setInt(6,obj.getEndTimeHr());
            preparedStmt.setInt(7,obj.getStartTimeMn());
            preparedStmt.setString(8,obj.getDayOfSlot());

            // execute the prepared statement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());


        }
    }
    public static ArrayList<SlotAssignment> getOb(){
        ArrayList<SlotAssignment> listOfSlotAssignments=new ArrayList<SlotAssignment>();
        SlotAssignment theSlotAssignment;
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");


            // the mysql get statement
            String query = "SELECT * FROM slotassignment";

            //Create Java Statement
            Statement st = conn.createStatement();

            // execute the query, and get a java result set
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                String getCourseCode = rs.getString("courseCode");
                String getInstructorName = rs.getString("instructorName");
                String getRoomNum = rs.getString("roomNum");
                int getStartTimeHr = rs.getInt("startTimeHr");
                int getStartTimeMn = rs.getInt("startTimeMn");
                int getEndTimeHr = rs.getInt("endTimeHr");
                int getEndTimeMn = rs.getInt("endTimeMn");
                String getDayOfSlot = rs.getString("dayOfSlot");
                System.out.println();

                theSlotAssignment=new SlotAssignment(getCourseCode,getInstructorName,getRoomNum,getStartTimeHr,getStartTimeMn,getEndTimeHr,getEndTimeMn,getDayOfSlot);
                System.out.println("Slot Assignment");
                System.out.println(theSlotAssignment.getCourseCode() + " " + theSlotAssignment.getInstructorName()+ " " + theSlotAssignment.getRoomNum() + " " + theSlotAssignment.getStartTimeHr() + " " + theSlotAssignment.getStartTimeMn() + " " + theSlotAssignment.getEndTimeHr() + " " + theSlotAssignment.getEndTimeMn() + " " + theSlotAssignment.getDayOfSlot());
                listOfSlotAssignments.add(theSlotAssignment);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }
        return listOfSlotAssignments;

    }
    public static void delOb(){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");
            Statement st = conn.createStatement();
            st.executeUpdate("truncate slotassignment");
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }



}
