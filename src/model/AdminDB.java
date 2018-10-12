package model;

import java.sql.*;

/**
 * Admin Database class
 * Store Admin information into admin table in SQL database upon registration of new admin
 * The methods that initiate connection with the SQL database are defined and implemented in here
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the addOb creates a connection to the admin table in the database
 * the getOb get the whole table in the databse and returns a list of admins
 * the delOb truncate the table
 * Update queries are not implemented yet.
 * These queries can be implement with this skelton with little effort
 * As of now we have not made GUI previleges for updation of database
 **/

public class AdminDB {

    public static void addOb(Admin obj){
    try {
        // create a mysql database connection
        String myDriver = "com.mysql.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");
        // the mysql insert statement
        String query = " INSERT INTO admin (userName, thispassword, depKey)"
                + " VALUES (?, ?, ?)";
        //create the mysql insert prepared statement
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, obj.getUserName());
        preparedStmt.setString(2, obj.getPassword());
        preparedStmt.setString(3, obj.getDepKey());
        // execute the prepared statement
        preparedStmt.execute();
        conn.close();
    } catch (Exception e) {
        System.err.println("Got an exception!");
        System.err.println(e.getMessage());

    }

}
    public static boolean getOb(String GuserName, String Gpassword){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");


            // the mysql get statement
            String query = "SELECT * FROM admin";

            //Create Java Statement
            Statement st = conn.createStatement();

            // execute the query, and get a java result set
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                String userName = rs.getString("userName");
                String password = rs.getString("thispassword");
                String depKey = rs.getString("depKey");
                if(GuserName.equals(userName) && Gpassword.equals(password))
                {
                    return true;
                }
            }

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());


        }
        return false;
    }
    public static void delOb(String userName){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM Instructor WHERE userName='"+userName+"'");

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());


        }

    }



}
