package model;
/**
 * Section class
 * The private and public properties are implemented in this class
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the constructor used to initialize the object of the class,getter methods used to access the private properties of the class
 **/
import java.util.ArrayList;

public class Section {
    private String sectionName;
    private static int sectionCount=0;
    private ArrayList<LeafStudent> listOfStudents;


    public Section(String sectionName) {
        this.sectionName= sectionName;
        sectionCount++;

    }
    public boolean addToSection(LeafStudent LS){
        if(this.sectionName.equals(LS.getStudentSection()))
        {
            listOfStudents.add(LS);
            System.out.println("Student Added to section");
            return true;
        }

        return false;
    }

    public int getSectionStrength(){
        return this.listOfStudents.size();
    }
    public ArrayList<LeafStudent> getAllStudents() {
        return this.listOfStudents;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
