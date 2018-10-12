package controller;
/**
 * Controller of Section Window
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * This controller is getting Time Slot information
 * {Interger: start time hour, start time minute, end time hour, end time minute, day of slot and room number}
 * FXIDs are self explanatory
 * Two action buttons {Submit,Cancel}
 * Submit: Creating section
 * Cancel: Exit the time slot form and go back to main window
 * All buttons are annotated by @FXML annotation and these are FX:IDs in FXML file
 **/

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
/**
 * Controller of Time Slot Information
 * This controller is responsible for input of variable lenght time slots information
 * @author Inaam, Nixon
 * MUN_# 201692544
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 *
 **/

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import model.*;
import sun.security.provider.ConfigFile;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TimeSlotCX implements Initializable {
    TimeSlot theTimeSlot;
    @FXML
    private Spinner startTimeHr;
    @FXML
    private Spinner startTimeMn;
    @FXML
    private Spinner endTimeHr;
    @FXML
    private Spinner endTimeMn;
    @FXML
    private ChoiceBox dayOfSlot;
    @FXML
    private ComboBox roomNumber;
    @FXML
    private Button submitButton;
    @FXML
    private Button cancelButton;

    //Method is used to populate list of room we have created before entering this time slot
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Room> listOfRooms;
        listOfRooms= RoomDB.getOb();
        List<String> list = new ArrayList<String>();
        for(int i=0;i<listOfRooms.size();i++){
            list.add(listOfRooms.get(i).getRoomNum());
        }
        ObservableList obList = FXCollections.observableList(list);
        roomNumber.getItems().clear();
        roomNumber.setItems(obList);
    }

    // On Action of button this  enter_time_slot method is called
    @FXML
    public void enter_time_slot(ActionEvent e){
        if(e.getSource().equals(submitButton)){
            int sth= (int) startTimeHr.getValue();
            int stm= (int) startTimeMn.getValue();
            int eth= (int) endTimeHr.getValue();
            int etm= (int) endTimeMn.getValue();
            String day=(String)dayOfSlot.getSelectionModel().getSelectedItem();
            theTimeSlot= new TimeSlot(sth,stm,eth,etm,day,roomNumber.getValue().toString());
            System.out.println(sth +" "+stm+" "+eth+" "+etm+" "+day+" "+" "+roomNumber.getValue().toString());
            try {
                TimeSlotDB.addOb(theTimeSlot);
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
