/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author iya
 */
public class Subject implements Serializable{
    
    private String subject;
    private double grade;
    
    public Subject(String Subject, double Grade){
    
        this.subject = Subject;
        this.grade = Grade;
        
    }
    
    public void setGrade(double Grade){
        
        this.grade = Grade;
        
    }
    public void setSubject(String Subject){
        
        this.subject = Subject;
    }
    
    public String getSubject(){
        return subject;
    }
    
    public double getGrade(){
        return grade;
    }
}
