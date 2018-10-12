package controller;
/**
 * Controller of Room Window
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * This controller is getting room number and capacity of the room
 * Text fields are getting Room Number and Capacity of the room
 * Two action buttons {Submit,Cancel}
 * Submit: Creating certain room with finite capacity (Capacity is used to decide which section will be assigned to this room :  we are getiing our section strength from a separate class names SectionStrength)
 * Cancel: Exit the room form and go back to main window
 * All buttons are annotated by @FXML annotation and these are FX:IDs in FXML file
 **/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.AdminDB;
import model.Room;
import model.RoomDB;

public class RoomCX {

    Room theRoom;
    @FXML
    private TextField roomNum;
    @FXML
    private TextField roomCapacity;
    @FXML
    private Button submitButton;
    @FXML
    private Button cancelButton;

    // On action of every button this enter_room method will be called
    @FXML
    public void enter_room(ActionEvent e)
    {
        String  cap=null;
        if(e.getSource().equals(submitButton)){
            cap= roomCapacity.getText();
         System.out.println(cap);
            theRoom= new Room(roomNum.getText(), Integer.parseInt(cap));
            try {
                RoomDB.addOb(theRoom);
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
    }

}
