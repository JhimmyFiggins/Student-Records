/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.model;

/**
 *
 * @author iya
 */
import src.StudentRecords;

public class vCheck {

    public boolean doesIDEx(String ID){
        
        boolean decider = false;
        
        try{
          Student checker = Cabinet.get(ID);
        }catch(Exception e){
            decider = true;
        }
        
        return decider;
    }
}
