package controller;
/**
 * Controller implementing push methods course information form
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * This controller will get the Text value for the Course Code and Course Name into the Text fields annotated by @FXML annotation
 * Get a spinner value (Integer) for the credit hour value of course
 * Getting the boolean value for the course type {Lab Course/ Not a Lab Course}
 * Two action buttons {Submit, Cancel}
 * Submit: Action provide the user agreement on true information for the course that will be stored into course table in our sql database
 * Cancel button will deny the submission and go back to main admin view
 * All buttons are annotated by @FXML annotation and these are FX:IDs in FXML file
 **/
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Course;
import model.CourseDB;

public class CourseCX {


    Course theCourse;

    @FXML
    private TextField courseCode;
    @FXML
    private TextField courseName;
    @FXML
    private Spinner  creditHours;
    @FXML
    private ToggleButton isLabCourse;
    @FXML
    private Button submitButton;
    @FXML
    private Button cancelButton;

    // On Button Actions this method will be called
    @FXML
    public void enter_course(ActionEvent e){
        if(e.getSource().equals(submitButton)){
            int spinner=(Integer)(creditHours.getValue());
            theCourse=new Course(courseCode.getText(),courseName.getText(),spinner, isLabCourse.isSelected());
            System.out.println(theCourse.getCourseCode()+theCourse.getCourseName()+theCourse.getCreditHours()+theCourse.isLabCourse());
            try {
                CourseDB.addOb(theCourse);

                Stage stage=(Stage) submitButton.getScene().getWindow();
                stage.close();
            }catch (Exception ex){
                return;
            }
        }
        else if (e.getSource().equals(cancelButton)){
            Stage stage=(Stage) cancelButton.getScene().getWindow();
            stage.close();
        }
        else{

        }

    }

}
