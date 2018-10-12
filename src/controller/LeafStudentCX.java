package controller;
/**
 * Controller of entering LeafStudent information window
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * This controller will get the Text value for the LeafStudent name, LeafStudent number,
 * Combo Box will provide the list of sections we have created before entering the record into LeafStudent Form
 * Two action buttons {Submit, Cancel}
 * Submit: Action provide the user agreement on true information for the instructor that will be stored into course table in our sql database
 * Cancel button will deny the submission and go back to main admin view
 * All buttons are annotated by @FXML annotation and these are FX:IDs in FXML file
 **/
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleAction;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import model.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;


public class LeafStudentCX implements Initializable {

    //Object of LeafStudent class used to store new LeafStudent and pass it to LeafStudentDB class for storing into instructor table in SQL database
    LeafStudent theLeafStudent;
    @FXML
    private TextField studentName;
    @FXML
    private TextField studentNumber;
    @FXML
    public ComboBox studentSection;
    @FXML
    private Button submitButton;
    @FXML
    private Button cancelButton;

    //Method used to populate the sections list into the Combo Box of this form
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Section> listOfSections;
        listOfSections=SectionDB.getOb();
        List<String> list = new ArrayList<String>();
        for(int i=0;i<listOfSections.size();i++){
            list.add(listOfSections.get(i).getSectionName());
        }
        ObservableList obList = FXCollections.observableList(list);
        studentSection.getItems().clear();
        studentSection.setItems(obList);
    }

    // On Action of Submit of Cancel method below is called
    public void enter_leafstudent(ActionEvent e)
    {
        if(e.getSource().equals(submitButton)){
            theLeafStudent=new LeafStudent(studentName.getText(),studentNumber.getText(),studentSection.getValue().toString());

            try {
                LeafStudentDB.addOb(theLeafStudent);
                Stage stage=(Stage) submitButton.getScene().getWindow();
                stage.close();
            }catch (Exception ex){
                return;
            }

//                InstructorDB.getOb();
//                InstructorDB.delOb("obi");

        }
        else if (e.getSource().equals(cancelButton)){
            Stage stage=(Stage) cancelButton.getScene().getWindow();
            stage.close();
        }
        else{

        }
    }

}
