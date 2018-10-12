package model;
/**
 * Schedule
 * The private and public properties are implemented in this class
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the constructor used to initialize the object of the class,getter methods used to access the private properties of the class
 **/
import jdk.nashorn.internal.ir.Assignment;
import model.InstructorAssignment;
import model.RoomAssignment;

import java.util.ArrayList;

public class Schedule {
    private ArrayList<SlotAssignment> listOfSlotAssignments;
    private ArrayList<RoomAssignment> listOfRoomAssignment;
    private ArrayList<InstructorAssignment> listOfInstructorAssignments;

    public Schedule(){
        listOfSlotAssignments=SlotAssignmentDB.getOb();
        listOfRoomAssignment=RoomAssignmentDB.getOb();
        listOfInstructorAssignments=InstructorAssignmentDB.getOb();
    }

    public ArrayList<SlotAssignment> getListOfSlotAssignments() {
        return listOfSlotAssignments;
    }


    public ArrayList<RoomAssignment> getListOfRoomAssignment() {
        return listOfRoomAssignment;
    }



    public ArrayList<InstructorAssignment> getListOfInstructorAssignments() {
        return listOfInstructorAssignments;
    }

    public void setListOfSlotAssignments(ArrayList<SlotAssignment> listOfSlotAssignments) {
        this.listOfSlotAssignments = listOfSlotAssignments;
    }

    public void setListOfRoomAssignment(ArrayList<RoomAssignment> listOfRoomAssignment) {
        this.listOfRoomAssignment = listOfRoomAssignment;
    }

    public void setListOfInstructorAssignments(ArrayList<InstructorAssignment> listOfInstructorAssignments) {
        this.listOfInstructorAssignments = listOfInstructorAssignments;
    }
}
