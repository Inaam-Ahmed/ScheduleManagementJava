package model;
/**
 * Instructor Assignment class
 * The private and public properties are implemented in this class
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * Objects of InsttructorAssignment class contains binding of instructors to their preffered courses
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the constructor used to initialize the object of the class,getter methods used to access the private properties of the class
 **/

import java.util.ArrayList;

public class InstructorAssignment {


    private ArrayList<Course> listOfCourses;
    private ArrayList<Instructor> listOfInstructor;

    private String courseCode;
    private String courseName;
    private int creditHours;
    private boolean isLabCourse;
    private String instructorID;
    private String instructorName;

    public static ArrayList<InstructorAssignment> listOfInstructorAssignment;

    public InstructorAssignment(){
        // Creating InstructorAssignment object with empty fields
    }

    public InstructorAssignment(String courseCode,String courseName,int creditHours, boolean isLabCourse,String instructorID,String instructorName) {
        this.courseCode=courseCode;
        this.courseName=courseName;
        this.creditHours=creditHours;
        this.isLabCourse=isLabCourse;
        this.instructorID=instructorID;
        this.instructorName=instructorName;
    }


    public void doInstructorAssignment(){
        listOfCourses = CourseDB.getOb();
        listOfInstructor = InstructorDB.getOb();
        InstructorAssignmentDB.delOb();
        for (int i = 0; i < listOfInstructor.size(); i++) {
            System.out.println(listOfCourses.get(i).getCourseCode() + " " + listOfCourses.get(i).getCourseName() + " " + listOfCourses.get(i).getCreditHours() + " " + listOfCourses.get(i).isLabCourse());
        }
        for (int i = 0; i < listOfInstructor.size(); i++) {
            System.out.println(listOfInstructor.get(i).getInstructorID() + " " + listOfInstructor.get(i).getInstructorName() + " " + listOfInstructor.get(i).getPrefCourse_1() + " " + listOfInstructor.get(i).getPrefCourse_2());
        }


        for(int i=0;i<listOfCourses.size();i++){
            for (int j=0;j<listOfInstructor.size();j++){
                if(listOfCourses.get(i).getCourseCode().equals(listOfInstructor.get(j).getPrefCourse_1())){
                     courseCode=listOfCourses.get(i).getCourseCode();
                     courseName=listOfCourses.get(i).getCourseName();
                     creditHours=listOfCourses.get(i).getCreditHours();
                     isLabCourse=listOfCourses.get(i).isLabCourse();
                     instructorID=listOfInstructor.get(j).getInstructorID();
                     instructorName=listOfInstructor.get(j).getInstructorName();
                     InstructorAssignmentDB.addOb( new InstructorAssignment(courseCode,courseName,creditHours,isLabCourse,instructorID,instructorName));
                     break;
                }
            }
        }



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

    public String getInstructorID() {
        return instructorID;
    }

    public String getInstructorName() {
        return instructorName;
    }

}