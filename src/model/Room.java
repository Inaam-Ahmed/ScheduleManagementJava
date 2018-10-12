package model;
/**
 * Room Class
 * The private and public properties are implemented in this class
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the constructor used to initialize the object of the class,getter methods used to access the private properties of the class
 **/
import java.util.ArrayList;

public class Room {
    private String roomNum;
    private int roomCapacity;


    public Room(String roomNum, int roomCapacity){
        this.roomNum=roomNum;
        this.roomCapacity=roomCapacity;

    }

    public String getRoomNum() {
        return roomNum;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }
}
