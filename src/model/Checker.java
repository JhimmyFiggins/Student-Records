/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author iya
 */
import Records.StudentRecords;

public class Checker {
    
    public static boolean doesIDEx(String ID){
        
        boolean decider = true;
        
        try{
          
          Student checker = StudentRecords.Cabinet.get(ID);
          String year = checker.getYear();//for nullpointexception
          
        }catch(NullPointerException e){
            decider = false;
        }
        
        return decider;
    }

    public static String fullname(String ID){//currently not using
        
        StudentRecords records = new StudentRecords();
        Student name = records.Cabinet.get(ID);
        String fullname = name.getStudentFull();
        
        return fullname;
    }

    public static boolean empty (String check){
        
        int length = check.length();
        if(length == 0){
            return true;
        }else{
            return false;
        }
    }
}
