package model;
/**
 * Course class
 * The private and public properties are implemented in this class
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the constructor used to initialize the object of the class,getter methods used to access the private properties of the class
 **/
import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String courseName;
    private int creditHours;
    private boolean isLabCourse;

    public Course(String courseCode, String courseName,int creditHours, boolean isLabCourse) {
        this.courseCode = courseCode.toLowerCase();
        this.courseName = courseName.toLowerCase();
        this.creditHours= creditHours;
        this.isLabCourse = isLabCourse;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public boolean isLabCourse() {
        return isLabCourse;
    }
}
