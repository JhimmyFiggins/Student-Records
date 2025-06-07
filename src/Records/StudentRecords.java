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
import java.lang.NullPointerException;
import java.util.ArrayList;
import java.util.Map;
import static java.util.Map.entry;

import model.Student;
import static model.Checker.*;

public class StudentRecords{
    
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
        
        JComboBox yearCB = new JComboBox();
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(yearCB, gbc);
        yearCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"1st Year", "2nd Year", "3rd Year"
                        , "4th Year" }));
        
        
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
                String year = String.valueOf(yearCB.getSelectedItem());

                if(empty(firstName) || empty(middleName) || empty(lastName)){
                    JOptionPane.showMessageDialog(null, "Please fill any blanks");
                }else{
                    
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
        
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets (10,10,10,10);
        
        JLabel idLabel = new JLabel("ID: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(idLabel, gbc);
        
        JTextField searchTF = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(searchTF, gbc);
        
        JButton scButton = new JButton("Remove");
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(scButton, gbc);
        
        scButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                boolean  decider = doesIDEx(searchTF.getText());
                
                Student search = Cabinet.get(searchTF.getText());
                
                if(decider){
                
                }else{
                    
                }
                
                
                
                try{
                    String[] Options = {"Remove", "Back"};
                    String ID = search.getStudentID();
                    int removeDialog = JOptionPane.showOptionDialog(
                        null, 
                        "Would you like to remove this student:" +
                        search.getStudentFull() + " " + search.getStudentID(),
                        "Remove", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null,
                        Options, null);
                
                if(removeDialog == 0){
                    
                    JOptionPane.showMessageDialog(null, "Student is removed");
                    Cabinet.remove(ID);
                    saveToFile(Cabinet,"Records/Students.txt");
                    mainMenu();
                    
                }else if(removeDialog == 1){
                    
                }else{
                
                }
                    
                    
                }catch(NullPointerException a){
                    JOptionPane.showMessageDialog(null,"Please fill the search bar");
                }
                
            }
        
        });
        
        JButton backButton = new JButton("Back");
        gbc.gridx = 3;
        gbc.gridy = 0;
        panel.add(backButton, gbc);
        backButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                mainMenu();
            }
        
        
        });
        
        
    }
    
    
    
    
    public void listStudent() {
        
        panel.removeAll();
        frame.setTitle("Student List");
        frame.setSize(500,500);
        panel.repaint();
        panel.setBackground(Color.PINK);
        
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets (10,10,10,10);
        
        
        JPanel listPanel = new JPanel();
        
        
        JTextField searchTF = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(searchTF, gbc);
        
        JButton scButton = new JButton("Search");
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(scButton, gbc);
        
        scButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                Student search = Cabinet.get(searchTF.getText());
                try{
                String ID = search.getStudentID();
                String name = search.getStudentFull();
                String year = search.getYear();
                String StudentInfo = "ID: " + ID + "\nName: " + name + "\nCollege Year: " + year;
                JOptionPane.showMessageDialog(null, StudentInfo);
                
                }catch(NullPointerException a){
                
                    JOptionPane.showMessageDialog(null, "Please fill the ID");
                }
            }
        
        });
        
        JButton backButton = new JButton("Back");
        gbc.gridx = 3;
        gbc.gridy = 0;
        panel.add(backButton, gbc);
        backButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                mainMenu();
                
            }
        
        
        
        });

        JTable listTable = new JTable();
        String[] columnNames = {"Student ID", "Student Name", "Year Level"};
        Object[][] rowData = new Object[Cabinet.size()][3];
        
        ArrayList<String> IDCabinet = new ArrayList<String>();
        
        for (Map.Entry<String, Student> entry : Cabinet.entrySet()){
            String keyID = entry.getKey();         // Getting the key
            IDCabinet.add(keyID);
        }
        for (int i = 0; i<Cabinet.size(); i++){
            
            Student row = Cabinet.get(IDCabinet.get(i));
            rowData[i][0] = row.getStudentID();
            rowData[i][1] = row.getStudentFull();
            rowData[i][2] = row.getYear();
            
        }
        
        listTable = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(listTable);
        gbc.gridx = 0;
        gbc.gridy = 2;    
        panel.add(scrollPane, gbc);
        
        scrollPane.setPreferredSize(new Dimension (200,200));
        

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
//           Continue this tomorrow | Continuation -- 0:35:26.
// Day 11 -- Day 11 is a disaster 2 hours maybe.
// Day 12 -- blank textfield errors when  search, remove, and 
//           register(no nullpointerexception)are clicked were fixed 1:00:26.
