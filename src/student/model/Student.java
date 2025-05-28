package student.model;

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
    private String StudentN;
    private int CollegeYear;
    
    
    public Student(String id, String name, int year) {
        
        this.ID = id;
        this.StudentN = name;
        this.CollegeYear = year;

    }
    
    
    public String getStudentID(){
        return ID;
    }
    
    public String getStudentName(){
        return StudentN;
    }
    
    public int getYear(){
        return CollegeYear;
    }
    
    public void setStudentID(String id){
        this.ID = id;
    }
    
    public void setStudentName(String name){
        this.StudentN = name;
    }
    public void setYear(int year){
        this.CollegeYear = year;
    }
    
    @Override
    public String toString() {
        return "ID: " + ID + ", Name: " + StudentN + ", Grade: " + CollegeYear;
    }
}
