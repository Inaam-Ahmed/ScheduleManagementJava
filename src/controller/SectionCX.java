package controller;
/**
 * Controller of Section Window
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * This controller is getting section name
 * Two action buttons {Submit,Cancel}
 * Submit: Creating section
 * Cancel: Exit the room form and go back to main window
 * All buttons are annotated by @FXML annotation and these are FX:IDs in FXML file
 **/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;

public class SectionCX {
    @FXML
    private TextField sectionName;
    @FXML
    private Button submitButton;
    @FXML
    private Button cancelButton;

    // theSection object is used to create new section and pass it to the SectionDB class for entering section into database
    Section theSection;
    @FXML
    public void enter_section(ActionEvent e){
        if(e.getSource().equals(submitButton)){
            theSection = new Section(sectionName.getText());
            System.out.println(theSection.getSectionName());

            try {
                SectionDB.addOb(theSection);
                // SectionDB.getOb();
                //SectionDB.delOb("masc");
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
