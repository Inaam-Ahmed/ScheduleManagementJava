package model;
/**
 * Section Strength Class
 * The private and public properties are implemented in this class
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the constructor used to initialize the object of the class,getter methods used to access the private properties of the class
 * This class only keeps track of registering students to count how many students are registered for a certain section
 **/
public class SectionStrength {
    private String sectionName;
    private int sectionStrength;

    public SectionStrength(String sectionName, int sectionStrength) {
        this.sectionName = sectionName;
        this.sectionStrength = sectionStrength;
    }

    public String getSectionName() {
        return sectionName;
    }

    public int getSectionStrength() {
        return sectionStrength;
    }
}