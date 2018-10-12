package model;

import java.sql.*;
import java.util.ArrayList;/**
 * Section Strength Database class
 * Store every new section strength information into sectionstrength table in SQL database during process of generating schedule
 * The methods that initiate connection with the SQL database are defined and implemented in here
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the addOb creates a connection to the 'sectionstrength' table in the database
 * the getOb get the whole table in the databse and returns a list of instructors assignmetns
 * the delOb truncate the table
 * Update queries need not implemented yet.
 * These queries can be implement with this skelton with little effort
 * As of now we have not made GUI previleges for updation of database
 *Rooms are assigned to sections based on their capacity and section's strength
 **/
public class SectionStrengthDB {

    public static void addOb(SectionStrength obj){
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");

            // the mysql insert statement
            String query = " INSERT INTO sectionstrength (sectionName,sectionStrength)"
                    + " VALUES (?, ?)";

            //create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, obj.getSectionName());
            preparedStmt.setInt(2, obj.getSectionStrength());
            // execute the prepared statement
            preparedStmt.execute();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }
    public static ArrayList<SectionStrength> getOb() {
        ArrayList<SectionStrength> listOfSectionStrength = new ArrayList<>();
        SectionStrength theSectionStrength;
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");


            // the mysql get statement
            String query = "SELECT * FROM sectionstrength " + "ORDER BY sectionStrength ASC";

            //Create Java Statement
            Statement st = conn.createStatement();

            // execute the query, and get a java result set
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String getSectionName = rs.getString("sectionName");
                String getSectionStrength = rs.getString("sectionStrength");
                System.out.println(getSectionName);
                theSectionStrength = new SectionStrength(getSectionName, Integer.parseInt(getSectionStrength));
                listOfSectionStrength.add(theSectionStrength);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());


        }
        return listOfSectionStrength;
    }
//Delete Objects
        public static void delOb()
        {
            try {
                // create a mysql database connection
                String myDriver = "com.mysql.jdbc.Driver";
                String myUrl = "jdbc:mysql://localhost:3306/schedule_pr";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "adminadmin");
                Statement st = conn.createStatement();
                st.executeUpdate("truncate sectionstrength");

                conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
        }

    }


