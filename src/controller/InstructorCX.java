package controller;
/**
 * Controller of entering Instructor window
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * This controller will get the Text value for the instructor name, instructor ID, and preffered Courses
 * {Preffered Courses} used to bind an instructor to a specific course
 * Two action buttons {Submit, Cancel}
 * Submit: Action provide the user agreement on true information for the instructor that will be stored into course table in our sql database
 * Cancel button will deny the submission and go back to main admin view
 * All buttons are annotated by @FXML annotation and these are FX:IDs in FXML file
 **/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Instructor;
import model.InstructorDB;


public class InstructorCX {
    @FXML
    private TextField instructorName;
    @FXML
    private TextField instructorID;
    @FXML
    private TextField prefCourse1;
    @FXML
    private TextField prefCourse2;
    @FXML
    private Button submitButton;
    @FXML
    private Button cancelButton;

    //Object of instructor class used to store new instructor and pass it to InstructorDB class for storing into instructor table in SQL database
    Instructor theInstructor;

    // On Button Actions this method will be called
    public void enter_instructor(ActionEvent e){
        if(e.getSource().equals(submitButton)){
            String insName=instructorName.getText();
            String insID=instructorID.getText();
            String pref1=prefCourse1.getText();
            String pref2=prefCourse2.getText();
            theInstructor = new Instructor(insName,insID,pref1,pref2);
            try {
                InstructorDB.addOb(theInstructor);
                Stage stage=(Stage) submitButton.getScene().getWindow();
                stage.close();
            }catch (Exception ex){
                return;
            }
            //InstructorDB.getOb();
            //InstructorDB.delOb();
        }
        else if (e.getSource().equals(cancelButton)){
            Stage stage=(Stage) cancelButton.getScene().getWindow();
            stage.close();

        }
        else{

        }

    }


}
