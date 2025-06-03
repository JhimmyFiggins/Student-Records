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
    private String StudentFull = StudentFirst+ " " + StudentMiddle + " " + StudentLast;
    private int CollegeYear;
        
    
    public Student(String id, String firstName, String middleName, String lastName, int year) {
        
        this.ID = id;
        this.StudentFirst = firstName;
        this.StudentMiddle = middleName;
        this.StudentLast = lastName;
        this.CollegeYear = year;

    }
    
    
    public String getStudentID(){
        return ID;
    }
    
    public String getStudentName(){
        
        return StudentFull;
    }
    
    public int getYear(){
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
    
    public void setStudentLast(String name){
        this.StudentFirst = name;
    }
    
    public void setYear(int year){
        this.CollegeYear = year;
    }
    
    @Override
    public String toString() {
        return "ID: " + ID + ", Name: " +StudentFull + ", Grade: " + CollegeYear;
    }
    
    
    public static boolean doesIDEx(String ID){
        StudentRecords records = new StudentRecords();
        boolean decider = false;
        
        try{
          
          Student checker = records.Cabinet.get(ID);
          
        }catch(Exception e){
            decider = true;
        }
        
        return decider;
    }
}

