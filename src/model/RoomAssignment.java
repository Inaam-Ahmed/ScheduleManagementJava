package model;
/**
 * Room Assignment class
 * The private and public properties are implemented in this class
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * Objects of InsttructorAssignment class contains binding of rooms to sections depending upon strength of section and capacity of room
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the constructor used to initialize the object of the class,getter methods used to access the private properties of the class
 **/


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class RoomAssignment {

    private ArrayList<Section> listOfSections=new ArrayList<>();
    private ArrayList<Room> listOfRooms=new ArrayList<>();
    private ArrayList<LeafStudent> listOfLeafStudents=new ArrayList<>();

    private String roomNum;
    private String Section;
    private RoomAssignment theRoomAssignment;
    public RoomAssignment() {
        theRoomAssignment=null;
    }
    public RoomAssignment(String roomNum,String Section){
        this.roomNum=roomNum;
        this.Section=Section;
    }
    public void doRoomAssignment(){
        listOfSections=SectionDB.getOb();
        listOfRooms=RoomDB.getOb();
        listOfLeafStudents=LeafStudentDB.getOb();
        RoomAssignmentDB.delOb();
        SectionStrength theSectionStrength;
        ArrayList<SectionStrength> listOfStudentsInSection=new ArrayList<SectionStrength>();
        int sectionStrength=0;
        SectionStrengthDB.delOb();
        for (int i=0;i<listOfSections.size();i++){
            for(int j=0;j<listOfLeafStudents.size();j++) {
                if ((listOfSections.get(i).getSectionName()).equals(listOfLeafStudents.get(j).getStudentSection())) {
                    sectionStrength++;
                }
            }
            theSectionStrength=new SectionStrength(listOfSections.get(i).getSectionName(),sectionStrength);
            SectionStrengthDB.addOb(theSectionStrength);
            sectionStrength=0;
        }

       listOfStudentsInSection=SectionStrengthDB.getOb();


        for(int i=0;i<listOfStudentsInSection.size();i++){

            for (int j=0;j<listOfRooms.size();j++){

                if(listOfStudentsInSection.get(i).getSectionStrength()<=listOfRooms.get(j).getRoomCapacity()){

                    theRoomAssignment= new RoomAssignment(listOfStudentsInSection.get(i).getSectionName(),listOfRooms.get(i).getRoomNum());

                    System.out.println(theRoomAssignment.getRoomNum()+" "+theRoomAssignment.getSection());

                    RoomAssignmentDB.addOb(theRoomAssignment);

                    listOfStudentsInSection.remove(i); listOfRooms.remove(j);
                }

            }


        }

    }

    public String getRoomNum() {
        return roomNum;
    }

    public String getSection() {
        return Section;
    }
}
