package model;

import java.sql.*;
import java.util.ArrayList;
/**
 * Course Database class
 * Store every new TimeSlot information into 'timeslot' table in SQL database upon submission of new timeslot
 * The methods that initiate connection with the SQL database are defined and implemented in here
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the addOb creates a connection to the timeslot table in the database
 * the getOb get the whole table in the databse and returns a list of timeslots
 * the delOb truncate the table
 * Update queries are not implemented yet.
 * These queries can be implement with this skelton with little effort
 * As of now we have not made GUI previleges for updation of database
 **/
public class TimeSlotDB {

    public static void addOb(TimeSlot obj){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");
            // the mysql insert statement
            String query = " INSERT INTO timeslot(starttimeHr, starttimeMn, endtimeHr, endtimeMn, dayofslot, roomnumber)"
                    + " VALUES (? , ? , ? , ? , ? , ?)";
            //create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, obj.getStartTimeHr());
            preparedStmt.setInt(2, obj.getStartTimeMn());
            preparedStmt.setInt(3, obj.getEndTimeHr());
            preparedStmt.setInt(4, obj.getEndTimeMn());
            preparedStmt.setString(5, obj.getDayOfSlot());
            preparedStmt.setString(6, obj.getRoomNumber());
            // execute the prepared statement
            preparedStmt.execute();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }

    }
    public static ArrayList<TimeSlot> getOb(){
        ArrayList<TimeSlot> listOfTimeSlots=new ArrayList<TimeSlot>();
        TimeSlot theTimeSlot=new TimeSlot();
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");


            // the mysql get statement
            String query = "SELECT * FROM timeslot";

            //Create Java Statement
            Statement st = conn.createStatement();

            // execute the query, and get a java result set
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                int getStartTimeHr = rs.getInt("starttimeHr");
                int getStartTimeMn = rs.getInt("starttimeMn");
                int getEndTimeHr = rs.getInt("endtimeHr");
                int getEndTimeMn = rs.getInt("endtimeMn");
                String getDayOfSlot = rs.getString("dayofslot");
                String getRoomNumber = rs.getString("roomnumber");

                theTimeSlot=new TimeSlot(getStartTimeHr,getStartTimeMn,getEndTimeHr,getEndTimeMn,getDayOfSlot,getRoomNumber);

                listOfTimeSlots.add(theTimeSlot);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return listOfTimeSlots;

    }
    public static void delOb(float starttime,String day){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM room WHERE roomNumber='"+starttime+"' WHERE dayofslot ='"+day+"'");

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }



}
