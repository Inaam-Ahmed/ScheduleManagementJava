package controller;
/**
 * Controller of Schedule Window
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * This controller has Text Area IDs to set specific text on text area we have in our schedule view
 * Text fields and password field are getting username, password dept key
 * Four action buttons {Show,Cancel}
 * Show: Button used to start the random schedule generation and show it on the grid view of schedule
 * Cancel: Exit the scene and go back to main window
 * All buttons are annotated by @FXML annotation and these are FX:IDs in FXML file
 **/



import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.*;
import javafx.scene.control.*;
import java.util.ArrayList;


public class ScheduleCX {


    @FXML
    private Button Show;
    @FXML
    private Button Cancel;

    @FXML
    private TextArea Mon_09_10;
    @FXML
    private TextArea Mon_10_11;
    @FXML
    private TextArea Mon_11_12;
    @FXML
    private TextArea Mon_12_13;
    @FXML
    private TextArea Mon_13_14;
    @FXML
    private TextArea Mon_14_15;
    @FXML
    private TextArea Mon_15_16;
    @FXML
    private TextArea Mon_16_17;

    @FXML
    private TextArea Tue_09_10;
    @FXML
    private TextArea Tue_10_11;
    @FXML
    private TextArea Tue_11_12;
    @FXML
    private TextArea Tue_12_13;
    @FXML
    private TextArea Tue_13_14;
    @FXML
    private TextArea Tue_14_15;
    @FXML
    private TextArea Tue_15_16;
    @FXML
    private TextArea Tue_16_17;


    @FXML
    private TextArea Wed_09_10;
    @FXML
    private TextArea Wed_10_11;
    @FXML
    private TextArea Wed_11_12;
    @FXML
    private TextArea Wed_12_13;
    @FXML
    private TextArea Wed_13_14;
    @FXML
    private TextArea Wed_14_15;
    @FXML
    private TextArea Wed_15_16;
    @FXML
    private TextArea Wed_16_17;


    @FXML
    private TextArea Thu_09_10;
    @FXML
    private TextArea Thu_10_11;
    @FXML
    private TextArea Thu_11_12;
    @FXML
    private TextArea Thu_12_13;
    @FXML
    private TextArea Thu_13_14;
    @FXML
    private TextArea Thu_14_15;
    @FXML
    private TextArea Thu_15_16;
    @FXML
    private TextArea Thu_16_17;


    @FXML
    private TextArea Fri_09_10;
    @FXML
    private TextArea Fri_10_11;
    @FXML
    private TextArea Fri_11_12;
    @FXML
    private TextArea Fri_12_13;
    @FXML
    private TextArea Fri_13_14;
    @FXML
    private TextArea Fri_14_15;
    @FXML
    private TextArea Fri_15_16;
    @FXML
    private TextArea Fri_16_17;



    @FXML
    public void showSchedule(javafx.event.ActionEvent e){

        InstructorAssignment theInstructorAssignment = new InstructorAssignment();
        theInstructorAssignment.doInstructorAssignment();

        RoomAssignment theRoomAssignment = new RoomAssignment();
        theRoomAssignment.doRoomAssignment();

        SlotAssignment theSlotAssignment = new SlotAssignment();
        theSlotAssignment.doSlotAssignment();

        Schedule theSchedule = new Schedule();

        ArrayList<SlotAssignment> listOfSlotAssignments = new ArrayList<>();
        ArrayList<RoomAssignment> listOfRoomAssignment = new ArrayList<>();

        listOfRoomAssignment = RoomAssignmentDB.getOb();
        listOfSlotAssignments = SlotAssignmentDB.getOb();

        String textArea;

        if(e.getSource().equals(Show)) {
            for (int i = 0; i < listOfSlotAssignments.size(); i++) {
                System.out.println(listOfSlotAssignments.get(i).getCourseCode() + "  " + listOfSlotAssignments.get(i).getCreditHours() + "  " + listOfSlotAssignments.get(i).getInstructorName() + " " + listOfSlotAssignments.get(i).getCourseName() + " " + listOfSlotAssignments.get(i).getInstructorID());

                if (listOfSlotAssignments.get(i).getDayOfSlot().equals("Monday")) {
                    if (listOfSlotAssignments.get(i).getStartTimeHr() == 9) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Mon_09_10.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 10) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Mon_10_11.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 11) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Mon_11_12.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 12) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Mon_12_13.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 13) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Mon_13_14.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 14) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Mon_14_15.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 15) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Mon_15_16.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 16) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Mon_16_17.setText(textArea);
                        System.out.println(textArea);
                    }


                } else if (listOfSlotAssignments.get(i).getDayOfSlot().equals("Tuesday")) {
                    if (listOfSlotAssignments.get(i).getStartTimeHr() == 9) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Tue_09_10.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 10) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Tue_10_11.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 11) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Tue_11_12.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 12) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Tue_12_13.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 13) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Tue_13_14.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 14) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Tue_14_15.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 15) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Tue_15_16.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 16) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Tue_16_17.setText(textArea);
                        System.out.println(textArea);
                    }

                } else if (listOfSlotAssignments.get(i).getDayOfSlot().equals("Wednesday")) {
                    if (listOfSlotAssignments.get(i).getStartTimeHr() == 9) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Wed_09_10.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 10) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Wed_10_11.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 11) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Wed_11_12.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 12) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Wed_12_13.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 13) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Wed_13_14.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 14) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Wed_14_15.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 15) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Wed_15_16.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 16) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Wed_16_17.setText(textArea);
                        System.out.println(textArea);
                    }

                } else if (listOfSlotAssignments.get(i).getDayOfSlot().equals("Thursday")) {
                    if (listOfSlotAssignments.get(i).getStartTimeHr() == 9) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Thu_09_10.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 10) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Thu_10_11.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 11) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Thu_11_12.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 12) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Thu_12_13.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 13) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Thu_13_14.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 14) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Thu_14_15.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 15) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Thu_15_16.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 16) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Thu_16_17.setText(textArea);
                        System.out.println(textArea);
                    }

                } else if (listOfSlotAssignments.get(i).getDayOfSlot().equals("Friday")) {
                    if (listOfSlotAssignments.get(i).getStartTimeHr() == 9) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Fri_09_10.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 10) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Fri_10_11.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 11) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Fri_11_12.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 12) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Fri_12_13.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 13) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Fri_13_14.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 14) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Fri_14_15.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 15) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Fri_15_16.setText(textArea);
                        System.out.println(textArea);
                    } else if (listOfSlotAssignments.get(i).getStartTimeHr() == 16) {
                        textArea = listOfSlotAssignments.get(i).getCourseCode() + "\n" + listOfSlotAssignments.get(i).getInstructorName() + "\n" + listOfSlotAssignments.get(i).getRoomNum();
                        Fri_16_17.setText(textArea);
                        System.out.println(textArea);
                    }
                }


            }

            for (int i = 0; i < listOfRoomAssignment.size(); i++) {
                System.out.println(listOfRoomAssignment.get(i).getRoomNum() + "  " + listOfRoomAssignment.get(i).getSection());
            }
        }
        if(e.getSource().equals(Cancel)){
            try {
                Stage stage=(Stage) Cancel.getScene().getWindow();
                stage.close();
            }catch (Exception ex){
                return;
            }
        }

    }

}
