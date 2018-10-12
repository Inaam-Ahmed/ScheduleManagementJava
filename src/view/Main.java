package view;
/**
 * Main Entry point of application
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * This is mainJVM thread which will load the main_window of FXML file
 **/
import controller.MainWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main_window.fxml"));
        primaryStage.setTitle("Schedule Management System");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
        MainWindowController controllerTest = new MainWindowController();

    }
}


















































//        // Test Admin Class
//
//        controllerTest.createNewAdmin("Inaam", "123", "9876");
//        System.out.println("================== Admin Test ================");
//        boolean bool_Test = controllerTest.accessMyAdmin("Inaam", "123");
//        if (bool_Test == true) {
//            System.out.println("Admin with Got Access to Syetem Present System Screen to Admin");
//        } else {
//            System.out.println("Admin with Unable to Access the System:  Give Dialogue Message and Return back");
//        }
//
//
//        bool_Test = controllerTest.removeAdmin("inaam", "123");
//        if (bool_Test == true) {
//            System.out.println("Admin Removed");
//        } else {
//            System.out.println("Unable to Remove");
//        }
//
//
//        //Test Course Class
//        System.out.println("================== Course Test ================");
//        bool_Test = false;
//        bool_Test = controllerTest.createCourse("GS", "91001", false);
//        if (bool_Test == true) {
//            System.out.println("Course Created");
//        } else {
//            System.out.println("Unable to create");
//        }
//
//
//        //Test Instructor Class
//        System.out.println("================== Instructor Test ================");
//        bool_Test = false;
//        bool_Test = controllerTest.createInstructor("All", "91001", false);
//        if (bool_Test == true) {
//            System.out.println("Instrcutor Created");
//        } else {
//            System.out.println("Unable to create");
//        }
//
//
//        // Test Section Class
//        System.out.println("================== Section Test ================");
//        bool_Test = false;
//        bool_Test = controllerTest.createSection("1");
//        if (bool_Test == true) {
//            System.out.println("Section Created");
//        } else {
//            System.out.println("Unable to create");
//        }
//        bool_Test = false;
//        bool_Test = controllerTest.createSection("2");
//        if (bool_Test == true) {
//            System.out.println("Section Created");
//        } else {
//            System.out.println("Unable to create");
//        }
//
//
//        //Test LeafStudent Class
//        System.out.println("================== Leaf Student Test ================");
//        bool_Test = false;
//        bool_Test = controllerTest.createLeafStudent("Inaam", "201692544", "1");
//        if (bool_Test == true) {
//            System.out.println("Leaf Student Created and added to list");
//        } else {
//            System.out.println("Unable to create");
//        }
//
//
//        // Test Room Class
//        System.out.println("================== Room Test ================");
//        bool_Test = false;
//        bool_Test = controllerTest.createRoom("EN4000", 20);
//        if (bool_Test == true) {
//            System.out.println("Room Created");
//        } else {
//            System.out.println("Unable to create");
//        }
//
//
//        // Test Time Slot Class
//        System.out.println("================== Time Slot Test ================");
//        controllerTest.createTimeSlot(4.0f, 5.0f, "Monday");
//
//
//        // Resource Class Test
//        System.out.println("================== Resource Class Test ================");
//
//
//        // Do Instructor Assignment
//        System.out.println("================== Instructor Assignment Test ================");
//        // Do Room Assignment
//        System.out.println("================== Room Assignment Test ================");
//        // Do Slot Assignment
//        System.out.println("================== Slot Assignment Test ================");
//        // Build User Interface
//        System.out.println("================== User Interface Test ================");
//

//    }
//}
