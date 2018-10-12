package model;

import java.sql.*;
import java.util.ArrayList;
/**
 * Room Database class
 * Store every new room information into 'room' table in SQL database upon submission of new course
 * The methods that initiate connection with the SQL database are defined and implemented in here
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the addOb creates a connection to the 'room' table in the database
 * the getOb get the whole table in the databse and returns a list of rooms
 * the delOb truncate the table
 * Update queries are not implemented yet.
 * These queries can be implement with this skelton with little effort
 * As of now we have not made GUI previleges for updation of database
 **/
public class RoomDB {

    public static void addOb(Room obj){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");
            // the mysql insert statement
            String query = " INSERT INTO room (roomNumber, capacity)"
                    + " VALUES (? , ?)";
            //create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, obj.getRoomNum());
            preparedStmt.setInt(2, obj.getRoomCapacity());
            System.out.println(obj.getRoomNum() +""+ obj.getRoomCapacity());
            // execute the prepared statement
            preparedStmt.execute();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }

    }
    public static ArrayList<Room> getOb(){
        Room theRoom;
        ArrayList<Room> listOfRooms=new ArrayList<>();
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");


            // the mysql get statement
            String query = "SELECT * FROM room";

            //Create Java Statement
            Statement st = conn.createStatement();

            // execute the query, and get a java result set
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                String roomNumber = rs.getString("roomNumber");
                String capacity = rs.getString("capacity");
                theRoom=new Room(roomNumber,Integer.parseInt(capacity));
                listOfRooms.add(theRoom);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return listOfRooms;
    }
    public static void delOb(String roomNumber){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM room WHERE roomNumber='"+roomNumber+"'");

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
