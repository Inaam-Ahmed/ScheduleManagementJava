package model;
/**
 * Slot Assignment class
 * The private and public properties are implemented in this class
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This class contains Objects of InstructorAssignment class and RoomAssignment and do fix a random slot for them
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the constructor used to initialize the object of the class,getter methods used to access the private properties of the class
 **/


import java.util.ArrayList;
import java.util.Random;

public class SlotAssignment {

    private String courseCode;
    private String courseName;
    private int creditHours;
    private boolean isLabCourse;
    private String instructorID;
    private String instructorName;
    private String roomNum;
    private String Section;

    private int startTimeHr;
    private int startTimeMn;
    private int endTimeHr;
    private int endTimeMn;
    private int slotLength;
    private String dayOfSlot;
    private String roomNumber;
    private Random random;


    private ArrayList<InstructorAssignment> listOfInstructorAssignments;
    private ArrayList<TimeSlot> listOfTimeSlots;

    public ArrayList<SlotAssignment> listOfSlotAssignments;

    public SlotAssignment() {
        random = new Random();
    }


    public SlotAssignment(String courseCode, String instructorName, String roomNum, int startTimeHr, int startTimeMn, int endTimeHr, int endTimeMn, String dayOfSlot) {
        this.courseCode = courseCode;
        this.instructorName = instructorName;
        this.roomNum = roomNum;
        this.startTimeHr = startTimeHr;
        this.startTimeMn = startTimeMn;
        this.endTimeHr = endTimeHr;
        this.endTimeMn = endTimeMn;
        this.dayOfSlot = dayOfSlot;
    }

    public void doSlotAssignment() {

        listOfInstructorAssignments = InstructorAssignmentDB.getOb();
        listOfTimeSlots = TimeSlotDB.getOb();
        listOfSlotAssignments = new ArrayList<>();
        SlotAssignment theSlotAssignment = new SlotAssignment();
        for (int i = 0; i < listOfTimeSlots.size(); i++) {
            System.out.println(listOfTimeSlots.get(i).getDayOfSlot() + "  " + listOfTimeSlots.get(i).getRoomNumber() + "  " + listOfTimeSlots.get(i).getStartTimeHr() + " " + listOfTimeSlots.get(i).getStartTimeMn() + " " + listOfTimeSlots.get(i).getEndTimeHr() + " " + listOfTimeSlots.get(i).getEndTimeMn());
        }
        SlotAssignmentDB.delOb();

        for (int i = 0; i < listOfInstructorAssignments.size(); i++) {
            System.out.println(listOfInstructorAssignments.get(i).getCourseCode() + "  " + listOfInstructorAssignments.get(i).getCreditHours() + "  " + listOfInstructorAssignments.get(i).getInstructorName() + " " + listOfInstructorAssignments.get(i).getCourseName() + " " + listOfInstructorAssignments.get(i).getInstructorID());
            int n = 0;
            switch (listOfInstructorAssignments.get(i).getCreditHours()) {
                case 1:
                    n = random.nextInt(listOfTimeSlots.size());
                    courseCode = listOfInstructorAssignments.get(i).getCourseCode();
                    instructorName = listOfInstructorAssignments.get(i).getInstructorName();
                    startTimeHr = listOfTimeSlots.get(i).getStartTimeHr();
                    startTimeMn = listOfTimeSlots.get(i).getStartTimeMn();
                    endTimeHr = listOfTimeSlots.get(n).getEndTimeHr();
                    endTimeMn = listOfTimeSlots.get(n).getEndTimeMn();
                    dayOfSlot = listOfTimeSlots.get(n).getDayOfSlot();
                    roomNum = listOfTimeSlots.get(n).getRoomNumber();

                    theSlotAssignment = new SlotAssignment(courseCode, instructorName, roomNum, startTimeHr, startTimeMn, endTimeHr, endTimeMn, dayOfSlot);
                    listOfSlotAssignments.add(theSlotAssignment);

                    SlotAssignmentDB.addOb(theSlotAssignment);
                    listOfTimeSlots.remove(n);
                    break;
                case 2:
                    for (int assign = 0; assign < 2; assign++) {
                        n = random.nextInt(listOfTimeSlots.size());
                        courseCode = listOfInstructorAssignments.get(i).getCourseCode();
                        instructorName = listOfInstructorAssignments.get(i).getInstructorName();
                        startTimeHr = listOfTimeSlots.get(n).getStartTimeHr();
                        startTimeMn = listOfTimeSlots.get(n).getStartTimeMn();
                        endTimeHr = listOfTimeSlots.get(n).getEndTimeHr();
                        endTimeMn = listOfTimeSlots.get(n).getEndTimeMn();
                        dayOfSlot = listOfTimeSlots.get(n).getDayOfSlot();
                        roomNum = listOfTimeSlots.get(n).getRoomNumber();
                        theSlotAssignment = new SlotAssignment(courseCode, instructorName, roomNum, startTimeHr, startTimeMn, endTimeHr, endTimeMn, dayOfSlot);
                        listOfSlotAssignments.add(theSlotAssignment);
                        SlotAssignmentDB.addOb(theSlotAssignment);
                        listOfTimeSlots.remove(n);
                    }
                    break;
                case 3:
                    for (int assign = 0; assign < 3; assign++) {
                        n = random.nextInt(listOfTimeSlots.size());
                        courseCode = listOfInstructorAssignments.get(i).getCourseCode();
                        instructorName = listOfInstructorAssignments.get(i).getInstructorName();
                        startTimeHr = listOfTimeSlots.get(n).getStartTimeHr();
                        startTimeMn = listOfTimeSlots.get(n).getStartTimeMn();
                        endTimeHr = listOfTimeSlots.get(n).getEndTimeHr();
                        endTimeMn = listOfTimeSlots.get(n).getEndTimeMn();
                        dayOfSlot = listOfTimeSlots.get(n).getDayOfSlot();
                        roomNum = listOfTimeSlots.get(n).getRoomNumber();
                        theSlotAssignment = new SlotAssignment(courseCode, instructorName, roomNum, startTimeHr, startTimeMn, endTimeHr, endTimeMn, dayOfSlot);
                        listOfSlotAssignments.add(theSlotAssignment);
                        SlotAssignmentDB.addOb(theSlotAssignment);
                        listOfTimeSlots.remove(n);
                    }
                    break;
                default:
                    System.out.println("No Slot Assignment Done");
            }


        }

    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public boolean isLabCourse() {
        return isLabCourse;
    }

    public String getInstructorID() {
        return instructorID;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public String getSection() {
        return Section;
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

    public int getSlotLength() {
        return slotLength;
    }

    public String getDayOfSlot() {
        return dayOfSlot;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public Random getRandom() {
        return random;
    }

    public ArrayList<InstructorAssignment> getListOfInstructorAssignments() {
        return listOfInstructorAssignments;
    }

    public ArrayList<TimeSlot> getListOfTimeSlots() {
        return listOfTimeSlots;
    }

}
