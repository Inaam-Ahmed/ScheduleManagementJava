package model;

import jdk.nashorn.internal.ir.Assignment;

import java.sql.*;
import java.util.ArrayList;

/**
 * Room Assignment Database class
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
public class RoomAssignmentDB {

        public static void addOb(RoomAssignment obj){
            try {
                // create a mysql database connection
                String myDriver = "com.mysql.jdbc.Driver";
                String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");

                // the mysql insert statement
                String query = " INSERT INTO roomassignment(sectionName,roomNum)"
                        + " VALUES (?, ?)";

                //create the mysql insert prepared statement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, obj.getSection());
                preparedStmt.setString(2, obj.getRoomNum());

                // execute the prepared statement
                preparedStmt.execute();

                conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());


            }
        }
        public static ArrayList<RoomAssignment> getOb(){
            ArrayList<RoomAssignment> listOfRoomAssignment=new ArrayList<RoomAssignment>();
            RoomAssignment theRoomAssignment;
            try {
                // create a mysql database connection
                String myDriver = "com.mysql.jdbc.Driver";
                String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");


                // the mysql get statement
                String query = "SELECT * FROM roomassignment";

                //Create Java Statement
                Statement st = conn.createStatement();

                // execute the query, and get a java result set
                ResultSet rs = st.executeQuery(query);

                while(rs.next()) {
                    String getSectionName = rs.getString("sectionName");
                    String getRoomNumber = rs.getString("roomNum");
                    System.out.println();
                    theRoomAssignment=new RoomAssignment(getSectionName,getRoomNumber);
                    listOfRoomAssignment.add(theRoomAssignment);
                }
                conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());

            }
            return listOfRoomAssignment;

        }
        public static void delOb(){
            try {
                // create a mysql database connection
                String myDriver = "com.mysql.jdbc.Driver";
                String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");
                Statement st = conn.createStatement();
                st.executeUpdate("truncate roomassignment");
                conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }

        }



}
