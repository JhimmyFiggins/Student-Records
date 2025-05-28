
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author iya
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;
import javax.swing.*;
import student.model.Student;

public class StudentRecords implements ActionListener{
    
    private HashMap<String, Student> Cabinet = new HashMap<>();
    JPanel panel = new JPanel();
    JFrame frame = new JFrame("Student Records");
    public StudentRecords(){
        
        registerStudent();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        panel.setSize(400,400);
        
        
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                Student user1 = Cabinet.get("R012");
                String ID012 = user1.getStudentID();
                JOptionPane.showMessageDialog(null,ID012);
                
                System.out.println(Cabinet.get("C02"));
                System.out.println(Cabinet.get("F03"));
                System.out.println(Cabinet.get("M04"));
            }
        });
        
        JButton delButton = new JButton("Delete");
        delButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                Cabinet.remove("M04");

            }
            
        });
        JButton listButton = new JButton("List");
        listButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                listStudent();

            }
            
        });
        
        
        
        panel.add(listButton);
        panel.add(addButton);
        panel.add(delButton);
        
        frame.add(panel);
        frame.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("addButton")) {
            System.out.println("meowth");
        }
    }
    
    public void registerStudent() {
        
        Student User1 = new Student("R01", "Reuel", 2);
        Cabinet.put("R012", User1);
        Student User2 = new Student("C02", "Crull", 3);
        Cabinet.put("C02", User2);
        Student User3 = new Student("F03", "Ferry", 3);
        Cabinet.put("F03", User3);
        Student User4 = new Student("M04", "Manuel", 2);
        Cabinet.put("M04", User4);
        
        
        
    }
    
    public void removeStudent() {
        
        
    }
    
    public void listStudent() {
        
        panel.removeAll();
        panel.setBackground(Color.PINK);
        frame.setTitle("Student List");
        
        JPanel listPanel = new JPanel();
        listPanel.setSize(400,400);
        
        JTextField searchTF = new JTextField(10);
        searchTF.setSize(50,100);
        
        JButton scButton = new JButton();
        scButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                Student search = Cabinet.get(searchTF.getText());
                String ID = search.getStudentID();
                String name = search.getStudentName();
                int year = search.getYear();
                String StudentInfo = "ID: " + ID + "\nName: " + name + "\nCollege Year: " + year;
                JOptionPane.showMessageDialog(null, StudentInfo);
            
            }
        
        });
        panel.add(searchTF);
        panel.add(scButton);
        frame.add(panel);
        frame.setVisible(true);
        
        
        
    }
    
    

    
    
}

// Day 1 -- Defined the Student class and made some StudentRecords(not functional) 00:54:30
// Day 2 -- Added function to ADD and DELETE(simple). 1:20:00 
// Day 3 -- Added function to list and search id. 00:54:00 -- I also created a repository for this project.