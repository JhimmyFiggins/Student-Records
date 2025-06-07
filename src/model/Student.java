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
    private String StudentFirst;
    private String StudentMiddle;
    private String StudentLast;
    private String StudentFull;
    private String CollegeYear;
        
    
    public Student(String id, String firstName, String middleName, String lastName, String year) {
        
        this.ID = id;
        this.StudentFirst = firstName;
        this.StudentMiddle = middleName;
        this.StudentLast = lastName;
        this.CollegeYear = year;

    }
    
    
    public String getStudentID(){
        return ID;
    }
    
    public String getStudentFirst(){
        return StudentFirst;
    }
    
    public String getStudentMiddle(){
        return StudentMiddle;
    }
    
    public String getStudentLast(){
        return StudentLast;
    }
    
    public String getStudentFull(){
        
        return StudentFull = getStudentFirst() + " " + getStudentMiddle() + " " + getStudentLast();
    }
    
    public String getYear(){
        return CollegeYear;
    }
    
    public void setStudentID(String id){
        this.ID = id;
    }
    
    public void setStudentFirst(String name){
        this.StudentFirst = name;
    }
    
    public void setStudentMiddle(String name){
        this.StudentFirst = name;
    }
    
    
    
    public void setYear(String year){
        this.CollegeYear = year;
    }
    
    @Override
    public String toString() {
        return "ID: " + ID + ", Name: " +StudentFull + ", Grade: " + CollegeYear;
    }
    
    
    
}

