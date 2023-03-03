package bank.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class SignUp1 extends JFrame implements ActionListener {
    
    long random;
    JTextField nameTextField,fatherNameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinCodeTextField;
    JButton next;
    JRadioButton male,female,married,unMarried,other;
    JDateChooser dateChooser;
    
    
    SignUp1() {
        
        setLayout(null);
        
        // here we are getting a random 4 digit number as application no.
        Random ran = new Random();
        random = (Math.abs(ran.nextLong() % 9000L) + 1000L);
        
        // adding title with form number.
        JLabel formNo = new JLabel("APPLICATION FORM NO: " + random);
        formNo.setFont(new Font("Raleway",Font.BOLD,38));
        formNo.setBounds(140,20,600,40);
        add(formNo);
        
        // adding second title for personal details.
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        
        
        // setting name text && and its textField.
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        
        
        // setting fatherName text && and its textField.
        JLabel fatherName= new JLabel("Father's Name: ");
        fatherName.setFont(new Font("Raleway",Font.BOLD,22));
        fatherName.setBounds(100,190,200,30);
        add(fatherName);
        
        fatherNameTextField = new JTextField();
        fatherNameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fatherNameTextField.setBounds(300,190,400,30);
        add(fatherNameTextField);
        
        
        
        // setting dateOfBirth text && and its Calender with Jchooser.
        JLabel dateOfBirth= new JLabel("Date of Birth: ");
        dateOfBirth.setFont(new Font("Raleway",Font.BOLD,22));
        dateOfBirth.setBounds(100,240,200,30);
        add(dateOfBirth);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        
        
         // setting gender text && and its radioBtn using Jradiobtn.
        JLabel gender= new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.white);
        add(female);
        
        
        // we are doing so se we can choose either one of them only no multiple.
        ButtonGroup genderGroup = new ButtonGroup(); 
        genderGroup.add(male);
        genderGroup.add(female);
        
        
        
        // setting email text && and its textField.
        JLabel email= new JLabel("Email Address: ");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
        
        
        // setting materitalStat text && and its textField.
        JLabel materitalStat= new JLabel("Marital Status: ");
        materitalStat.setFont(new Font("Raleway",Font.BOLD,22));
        materitalStat.setBounds(100,390,200,30);
        add(materitalStat);
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.white);
        add(married);
        
        unMarried = new JRadioButton("Not Married");
        unMarried.setBounds(450,390,100,30);
        unMarried.setBackground(Color.white);
        add(unMarried);
        
        other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.white);
        add(other);
        
        // we are doing so se we can choose either one of them only no multiple.
        ButtonGroup maritalGroup = new ButtonGroup(); 
        maritalGroup.add(married);
        maritalGroup.add(unMarried);
        maritalGroup.add(other);
        
        
        
        // setting address text && and its textField.
        JLabel address= new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        
        
        // setting city text && and its textField.
        JLabel city= new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        
        
        // setting state text && and its textField.
        JLabel state= new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        
        
        // setting pinCode text && and its textField.
        JLabel pinCode= new JLabel("Pin Code: ");
        pinCode.setFont(new Font("Raleway",Font.BOLD,22));
        pinCode.setBounds(100,590,200,30);
        add(pinCode);
        
        pinCodeTextField = new JTextField();
        pinCodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinCodeTextField.setBounds(300,590,400,30);
        add(pinCodeTextField);
        
        
        
        //adding a next page btn.
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        
        //setting background color as white.
        getContentPane().setBackground(Color.WHITE);

        //setting frame size and frame.
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent btn) {
        
       String formNo = random +""; // here converting random into a string.
       String name = nameTextField.getText(); // here we are getting the inputed name.
       String fName = fatherNameTextField.getText();
       String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
       String gender = "";
       if(male.isSelected()) {
           gender = "Male";
       }
       else if(female.isSelected()) {
           gender = "Female";
       }
       
       String email = emailTextField.getText();
       String marital = "";
       if(married.isSelected()) {
           marital = "Married";
       }
       else if(unMarried.isSelected()) {
           marital = "Not Married";
       }
       else if(other.isSelected()) {
           marital = "Other";
       }
       
       String address = addressTextField.getText();
       String city = cityTextField.getText();
       String state = stateTextField.getText();
       String pinCode = pinCodeTextField.getText();
       
       // we are writing this because if name field is empty then show a message.
       try {
           if(name.equals("")) {
               JOptionPane.showMessageDialog(null,"Name is Required");
           }
           if(fName.equals("")) {
               JOptionPane.showMessageDialog(null,"Father Name is Required");
           }
           if(dob.equals("")) {
               JOptionPane.showMessageDialog(null,"Date of Birth is Required");
           }
           if(email.equals("")) {
               JOptionPane.showMessageDialog(null,"Email Address is Required");
           }
           if(address.equals("")) {
               JOptionPane.showMessageDialog(null,"Address is Required");
           }
           if(city.equals("")) {
               JOptionPane.showMessageDialog(null,"City is Required");
           }
           if(state.equals("")) {
               JOptionPane.showMessageDialog(null,"State is Required");
           }
           if(pinCode.equals("")) {
               JOptionPane.showMessageDialog(null,"Pin Code is Required");
           }
           
           // this is mysql query.
           else {
               Conn c = new Conn();
               String query = "insert into signup values('"+formNo+"', '"+name+"', '"+fName+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pinCode+"','"+state+"')";
               
               // and here final exceuting the query.
               c.s.executeUpdate(query);
               
               setVisible(false);
               new SignUp2(formNo).setVisible(true);
           }
       }
       catch (Exception e) {
           System.out.print(e);
       }
    }
    
    
    public static void main(String args[]) {
        new SignUp1();
    }
}
