package controller;

/**
 * Controller of logging in window
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * This controller will get the Text registered username, and password into Text Fields,
 * Combo Box will provide the list of sections we have created before entering the record into LeafStudent Form
 * Two action buttons {Login, Cancel}
 * Submit: Action provide the user agreement on true information for the login already stored admin table in our sql database
 * Cancel button will omit the submission and go back to main admin view
 * All buttons are annotated by @FXML annotation and these are FX:IDs in FXML file
 **/
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.AdminDB;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class LoginCX {

    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    @FXML
    private Button loginButton;
    @FXML
    private Button cancelButton;

    @FXML
    public void login(ActionEvent e){
    if(e.getSource().equals(loginButton))
    {
        System.out.println("Check");
        boolean islogin=AdminDB.getOb(userName.getText(),password.getText());
        System.out.println(islogin);
        if(islogin)
        {
        System.out.println("Present System after login");
        try {
            FXMLLoader fxmlLoader3 = new FXMLLoader(getClass().getResource("/view/admin_view.fxml"));
            Parent root3 = fxmlLoader3.load();
            Stage stage3 = new Stage();
            stage3.setScene(new Scene(root3,800,600));
            stage3.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            Stage stage=(Stage) loginButton.getScene().getWindow();
            stage.close();
        }

    }
        else if(e.getSource().equals(cancelButton))
        {
            System.out.println("Move back to Main Window");
            Stage stage=(Stage) cancelButton.getScene().getWindow();
            stage.close();
        }
    }

}
