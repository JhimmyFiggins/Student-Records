package model;

import Records.StudentRecords;
import java.io.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author iya
 */

public class Student implements Serializable{

    private String ID;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullName;
    private String yearLevel;
        
    
    public Student(String id, String firstName, String middleName, String lastName, String year) {
        
        this.ID = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.yearLevel = year;

    }
    
    
    public String getStudentID(){
        return ID;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getMiddleName(){
        return middleName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getStudentName(){
        
        return fullName = getFirstName() + " " + getMiddleName() + " " + getLastName();
    }
    
    public String getYear(){
        return yearLevel;
    }
    
    public void setStudentID(String id){
        this.ID = id;
    }
    
    public void setFirstName(String name){
        this.firstName = name;
    }
    
    public void setMiddleName(String name){
        this.middleName = name;
    }
    
    public void setLastName(String name){
        this.lastName = name;
    }
    
    
    public void setYear(String year){
        this.yearLevel = year;
    }
    
    @Override
    public String toString() {
        return "ID: " + ID + ", Name: " +fullName + ", Grade: " + yearLevel;
    }
    
    
    
}

