
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author iya
 */

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.io.*;
import java.util.HashMap;
import javax.swing.*;
import student.model.Student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ClassNotFoundException;


public class StudentRecords implements ActionListener{
    
    private HashMap<String, Student> Cabinet = new HashMap<>();
    
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Student Records");
   
    
    
    
    public StudentRecords(){
        
        Cabinet = loadFromFile("Records/Students.txt");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        panel.setSize(400,400);
        mainMenu();
    
    }
    
    public void mainMenu(){
        
        panel.removeAll();
        panel.setBackground(Color.PINK);
        frame.setSize(400,400);
        
        JButton registerButton = new JButton("register");
        registerButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                registerStudent();
                
            }
        });
        
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                removeStudent();

            }
            
        });
        JButton listButton = new JButton("List");
        listButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                listStudent();

            }
            
        });
        
        panel.add(listButton);
        panel.add(registerButton);
        panel.add(removeButton);
        
        frame.add(panel);
        frame.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("registerButton")) {
            System.out.println("meowth");
        }
    }
    
    public void registerStudent() {
        
        frame.setSize(700,500);
        panel.removeAll();
        frame.setTitle("Register Student");
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.PINK);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        
     
        
        JLabel studentName = new JLabel("Student Name: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(studentName, gbc);
        
        JTextField nameTF = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nameTF, gbc);
        
        JLabel studentID = new JLabel("Student ID: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(studentID, gbc);
        
        JTextField idTF = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(idTF, gbc);
        
        JLabel studentYear = new JLabel("College Year: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(studentYear, gbc);
        
        JTextField yearTF = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(yearTF, gbc);
        
        JButton confirmButton = new JButton("Confirm");
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(confirmButton, gbc);
        confirmButton.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent e){
                String name = nameTF.getText();
                String id = idTF.getText();
                int year = Integer.valueOf(yearTF.getText());
                
                Student addStudent = new Student(id, name, year);
                Cabinet.put(id, addStudent);
                JOptionPane.showMessageDialog(null, "Welcome");
                mainMenu();
                saveToFile(Cabinet,"Records/Students.txt");
            }
        
        
        });
        
        
        JButton backButton = new JButton("Back");
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(backButton, gbc);
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainMenu();
            }
        
        
        });
    }
    
    
    
    public void removeStudent() {
        
        
    }
    
    
    
    
    public void listStudent() {
        
        panel.removeAll();
        frame.setTitle("Student List");
        frame.setSize(400,400);
        panel.repaint();
        panel.setBackground(Color.PINK);
        
        
        
        JPanel listPanel = new JPanel();
        
        
        JTextField searchTF = new JTextField(10);
        
        
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
    
    public void saveToFile(HashMap<String, Student> cabinet, String filename){
        
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
            out.writeObject(cabinet);
        
        }catch (IOException e){
            e.printStackTrace();
        
        }
    
    }
    
    public HashMap<String, Student> loadFromFile(String filename){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
            
            return (HashMap<String, Student>) in.readObject();
            
        }catch(IOException | ClassNotFoundException e){
            
            e.printStackTrace();
            return new HashMap<>();
        }
        
    }
    

    
    
}

// Day 1 -- Defined the Student class and made some StudentRecords(not functional) 00:54:30
// Day 2 -- Added function to ADD and DELETE(simple). 1:20:00 
// Day 3 -- Added function to list and search id. 00:54:00 -- I also created a repository for this project.
// Day 4 -- Reviewed and made another project with the same function, but it supposed to be IO. 
//          Added function to OG prjt. in register & remove method. 1:02:00
// Day 5 -- Added save and load function, as well as the function of register. 1:12:45
