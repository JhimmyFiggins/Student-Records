package Records;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author iya
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.io.*;
import java.util.HashMap;
import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ClassNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import static java.util.Map.entry;

import model.Student;
import static model.Checker.doesIDEx;

public class StudentRecords implements ActionListener{
    
    public static HashMap<String, Student> Cabinet = new HashMap<>();
    
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
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets (10, 10, 10, 10);
        
        JButton registerButton = new JButton("Register");
        gbc.gridx = 0;
        gbc.gridy = 0; 
        panel.add(registerButton, gbc);
        
        registerButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                registerStudent();
                
            }
        });
        
        JButton removeButton = new JButton("Remove");
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(removeButton, gbc); 
        
        removeButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                removeStudent();

            }
            
        });
        JButton listButton = new JButton("List");
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(listButton, gbc);
        listButton.setPreferredSize(new Dimension(75,25));
        listButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                listStudent();

            }
            
        });
        
        frame.setTitle("Student Records");
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
        panel.repaint();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        
     
        
        JLabel firstName = new JLabel("First Name: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(firstName, gbc);

        JTextField firstTF = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(firstTF, gbc);
        
        JLabel middleName = new JLabel("Middle Name: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(middleName, gbc);

        JTextField middleTF = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(middleTF, gbc);
        
        JLabel lastName = new JLabel("Last Name: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lastName, gbc);

        JTextField lastTF = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(lastTF, gbc);
        
        
        JLabel studentID = new JLabel("Student ID: ");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(studentID, gbc);
        
        JTextField idTF = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(idTF, gbc);
        
        JLabel studentYear = new JLabel("College Year: ");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(studentYear, gbc);
        
        JTextField yearTF = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(yearTF, gbc);
        
        JButton confirmButton = new JButton("Confirm");
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(confirmButton, gbc);
        
        confirmButton.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent e){
                String firstName = firstTF.getText();
                String middleName = middleTF.getText();
                String lastName = lastTF.getText();
                String id = idTF.getText();
                int year = Integer.valueOf(yearTF.getText());

                boolean decider = doesIDEx(id);
                
                if(!decider){
                    
                    Student addStudent = new Student(id, firstName, middleName, lastName, year);
                    Cabinet.put(id, addStudent);
                    JOptionPane.showMessageDialog(null, "Welcome");
                    mainMenu();
                    saveToFile(Cabinet,"Records/Students.txt");
                        
                    
                }else{
                    JOptionPane.showMessageDialog(null,"ID already existed. Please use different ID");
                    
                }
                
                
            }
        
        
        });
        
        
        JButton backButton = new JButton("Back");
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(backButton, gbc);
        
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainMenu();
                
            }
        
        
        });
    }
    
    
    
    public void removeStudent() {
        panel.removeAll();
        panel.repaint();
        panel.setBackground(Color.PINK);
        frame.setSize(500,500);
        frame.setTitle("Remove Student");
        JLabel idLabel = new JLabel("ID: ");
        
        JTextField searchTF = new JTextField(10);
        
        
        JButton scButton = new JButton("Remove");
        scButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                Student search = Cabinet.get(searchTF.getText());
                String ID = search.getStudentID();
                Cabinet.remove(ID);
                saveToFile(Cabinet,"Records/Students.txt");
            }
        
        });
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                mainMenu();
            }
        
        
        });
        
        panel.add(searchTF);
        panel.add(scButton);
        panel.add(backButton);
    }
    
    
    
    
    public void listStudent() {
        
        panel.removeAll();
        frame.setTitle("Student List");
        frame.setSize(500,500);
        panel.repaint();
        panel.setBackground(Color.PINK);
        
        
        
        JPanel listPanel = new JPanel();
        
        
        JTextField searchTF = new JTextField(10);
        
        
        JButton scButton = new JButton("Search");
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
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                mainMenu();
                
            }
        
        
        
        });
        panel.add(searchTF);
        panel.add(scButton);
        panel.add(backButton);
        
        
        JPanel tablePanel = new JPanel();
        JTable listTable = new JTable();
        String[] columnNames = {"ID", "Student Name", "Year Level"};
        Object[][] rowData = new Object[Cabinet.size()][3];
        
        ArrayList<String> IDCabinet = new ArrayList<String>();
        
        for (Map.Entry<String, Student> entry : Cabinet.entrySet()){
            String keyID = entry.getKey();         // Getting the key
            IDCabinet.add(keyID);
        }
        for (int i = 0; i<Cabinet.size(); i++){
            
            
        
        }
        
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
// Day 6 -- Add remove function and arrange the gbc. 0:40:00
// Day 7 -- Reviewed the code and made a list to study for later. 00:10:00
// Day 8 -- Added ID checker to the register student. I'm planning to do automatic id maker in the future. 0:16:00 -- 6/2
// Day 9 -- Fixed the static of the cabinet and the register student. Cram the goal of Day 9 and 10 tomorrow. 1:00:00 -- 6/3 - Finished on 6/4 2AM
// Day 10 -- Started of coding list of students using Map entry and getting their specific key -- 0:48:00
//           Continue this tomorrow