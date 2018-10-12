package controller;
/**
 * Controller of Main Window
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * This controller will get the Text registered username, and password into Text Fields,
 * Combo Box will provide the list of sections we have created before entering the record into LeafStudent Form
 * Four action buttons {Login,Register,exit}
 * Login: Used to login into the system for accessing schedule and entering resources
 * Register: Creating new Admin with the user name password and unique department key. {We have not implemented any table for the registration key authentication because it was not the primary work to do}
 * Exit: button will exit the complete application {Stops JVN Thread}
 * All buttons are annotated by @FXML annotation and these are FX:IDs in FXML file
 **/
import com.sun.org.apache.regexp.internal.RE;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import model.Admin;

import java.lang.Exception;

import sun.plugin.viewer.context.AxBridgeAppletContext;
import view.Main;


public class MainWindowController {

    @FXML
    private Button registerButton;
    @FXML
    private Button loginButton;
    @FXML
    private Button exitButton;

    // On action of buttons main_window method will be called to handle choice of user/admin
    @FXML
    public void main_window(ActionEvent e) {
        if (e.getSource().equals(registerButton)) {
            System.out.println("open window for registration form");
            try {
                FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/view/register_admin.fxml"));
                Parent root1 = fxmlLoader1.load();
                Stage stage1 = new Stage();
                stage1.setScene(new Scene(root1,800,600));
                stage1.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            Stage stage=(Stage) registerButton.getScene().getWindow();
            stage.close();

        } else if (e.getSource().equals(loginButton)) {
            System.out.println("Login Button");
            try {
                FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/view/login.fxml"));
                Parent root2 = fxmlLoader2.load();
                Stage stage2 = new Stage();
                stage2.setScene(new Scene(root2,800,600));
                stage2.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            Stage stage=(Stage) loginButton.getScene().getWindow();
            stage.close();
        } else if (e.getSource().equals(exitButton)) {
            System.out.println("Do Exit");
            System.exit(3);
        }

    }

}