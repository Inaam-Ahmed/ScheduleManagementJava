package controller;
/**
 * Controller of Register Window
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * This controller will get the Text registered username, and password into Text Fields,
 * Text fields and password field are getting username, password and dept key
 * Two action buttons {Register,Cancel}
 * Register: Creating new Admin with the user name password and unique department key. Storing that infomation into admin table ins sql Database {We have not implemented any table for the registration key authentication because it was not the primary work to do}
 * Cancel: Exit the registration scene and go back to main window
 * All buttons are annotated by @FXML annotation and these are FX:IDs in FXML file
 **/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;

public class RegisterCX {


    Admin theAdmin;
    @FXML
    private Button submitRegisterButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private TextField deptKey;

    // On action of buttons register_admin method is called AdminDB is class connecting to admin table in database
    @FXML
    public void register_admin(ActionEvent e) {
        System.out.println("Reached to Register Class");
        if(e.getSource().equals(submitRegisterButton)){
            theAdmin=new Admin(userName.getText(),password.getText(),deptKey.getText());
            try {
                AdminDB.addOb(theAdmin);
                Stage stage=(Stage) submitRegisterButton.getScene().getWindow();
                stage.close();
            }catch (Exception ex){
                return;
            }
            try {
                FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/view/login.fxml"));
                Parent root2 = fxmlLoader2.load();
                Stage stage2 = new Stage();
                stage2.setScene(new Scene(root2,800,600));
                stage2.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        else if (e.getSource().equals(cancelButton)){
            Stage stage=(Stage) cancelButton.getScene().getWindow();
            stage.close();
        }
    }

}
