package model;
/**
 * Instructor Class
 * The private and public properties are implemented in this class
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the constructor used to initialize the object of the class,getter methods used to access the private properties of the class
 **/
import java.lang.String;
import java.util.ArrayList;

public class Instructor {
    private String instructorID;
    private String instructorName;
    private String prefCourse_1;
    private String prefCourse_2;


    public Instructor(String instructorName, String instructorID, String prefCourse_1,String prefCourse_2) {
        this.instructorID = instructorID.toLowerCase();
        this.instructorName = instructorName.toLowerCase();
        this.prefCourse_1=prefCourse_1.toLowerCase();
        this.prefCourse_2=prefCourse_2.toLowerCase();
    }

    public String getInstructorID() {
        return instructorID;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getPrefCourse_1() {
        return prefCourse_1;
    }

    public String getPrefCourse_2() {
        return prefCourse_2;
    }

}

