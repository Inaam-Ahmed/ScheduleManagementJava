package model;

import java.sql.*;
import java.util.ArrayList;

/**
 * Sections Database class
 * Store every new section information into 'section' table in SQL database upon submission of new section
 * The methods that initiate connection with the SQL database are defined and implemented in here
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the addOb creates a connection to the 'section' table in the database
 * the getOb get the whole table in the databse and returns a list of sections
 * the delOb truncate the table
 * Update queries are not implemented yet.
 * These queries can be implement with this skelton with little effort
 * As of now we have not made GUI previleges for updation of database
 **/
public class SectionDB {
    public static void addOb(Section obj){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");

            // the mysql insert statement
            String query = " INSERT INTO section (sectionName)"
                    + " VALUES (?)";

            //create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, obj.getSectionName());
            // execute the prepared statement
            preparedStmt.execute();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }
    public static ArrayList<Section> getOb(){
        ArrayList<Section> listOfSections=new ArrayList<>();
        Section theSection;
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");


            // the mysql get statement
            String query = "SELECT * FROM section";

            //Create Java Statement
            Statement st = conn.createStatement();

            // execute the query, and get a java result set
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                String getSectionName = rs.getString("sectionName");
                System.out.println(getSectionName);
                theSection=new Section(getSectionName);
                listOfSections.add(theSection);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());


        }
        return listOfSections;

    }
    public static void delOb(String sectionName){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM section WHERE sectionName='"+sectionName+"'");
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());


        }

    }






}
