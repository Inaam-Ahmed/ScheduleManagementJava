package model;
/**
 * Admin class
 * The private and public properties are implemented in this class
 * @author Inaam, Nixon
 * MUN_# 201692544
 * MUN_# 201472933
 * inaama@mun.ca, neo505@mun.ca
 * This file was prepared by Inaam Ahmed and Obi Nixon completed by me our both.
 * the constructor used to initialize the object of the class,getter methods used to access the private properties of the class
 **/
public class Admin{

    private String userName;
    private String password;
    private String depKey;

    public Admin(String userName,String password, String depKey){
        this.userName=userName;
        this.password=password;
        this.depKey=depKey;
        System.out.print("Admin Registered");
    }
    public boolean accessAdminScreen(String userName, String password) {
        try{
        if(this.userName.equals(userName)&& this.password.equals(password))
            return true;
        else
            return false;
    } catch (Exception e){System.out.println("Exception at Admin Access");return false;}
    }


    public boolean removeAdmin(String userName, String password) {
        this.userName=null;
        this.password=null;
        this.depKey=null;
        if((this.userName == null)&& (this.password==null) && (this.depKey==null)){return true;}
        else {return false;}
    }


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getDepKey() {
        return depKey;
    }
}

