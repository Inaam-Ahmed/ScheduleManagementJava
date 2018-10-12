package model;
/**
 * TimeSlot class
 * The private and public properties are implemented in this class
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the constructor used to initialize the object of the class,getter methods used to access the private properties of the class
 **/
import java.util.ArrayList;

public class TimeSlot{

    private int startTimeHr;
    private int startTimeMn;
    private int endTimeHr;
    private int endTimeMn;
    private int slotLength;
    private String dayOfSlot;
    private String roomNumber;

    public TimeSlot() {
        //TimeSlot new Object without setting private fields
    }

    public TimeSlot(int startTimeHr, int startTimeMn, int endTimeHr, int endTimeMn, String dayOfSlot, String roomNumber) {
        this.startTimeHr = startTimeHr;
        this.startTimeMn = startTimeMn;
        this.endTimeHr = endTimeHr;
        this.endTimeMn = endTimeMn;
        this.dayOfSlot = dayOfSlot;
        this.roomNumber = roomNumber;
    }

    public TimeSlot(int startTimeHr, int startTimeMn, int endTimeHr, int endTimeMn,int slotLength ,String dayOfSlot,String roomNumber) {
        this.startTimeHr = startTimeHr;
        this.startTimeMn = startTimeMn;
        this.endTimeHr = endTimeHr;
        this.endTimeMn = endTimeMn;
        this.slotLength=slotLength;
        this.dayOfSlot = dayOfSlot;
        this.roomNumber=roomNumber;
    }

    public int getStartTimeHr() {
        return startTimeHr;
    }

    public int getStartTimeMn() {
        return startTimeMn;
    }

    public int getEndTimeHr() {
        return endTimeHr;
    }

    public int getEndTimeMn() {
        return endTimeMn;
    }

    public String getDayOfSlot() {
        return dayOfSlot;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}
