package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;



public class SignUp3 extends JFrame implements ActionListener{
     
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formNo;
    
    SignUp3(String formNo) {
        
        this.formNo = formNo;
        
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        JLabel label = new JLabel("Page 3: Account Details");
        label.setFont(new Font("Raleway",Font.BOLD,22));
        label.setBounds(280,40,400,40);
        add(label);
        
        JLabel accountType = new JLabel("Account Type");
        accountType.setFont(new Font("Raleway",Font.BOLD,22));
        accountType.setBounds(100,140,200,30);
        add(accountType);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(100,180,150,20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(350,180,250,20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(100,220,250,20);
        add(r3);
        
        r4 = new JRadioButton("Recuring Deposit");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(350,220,250,20);
        add(r4);
        
        
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(r1);
        radioGroup.add(r2);
        radioGroup.add(r3);
        radioGroup.add(r4);
        
        JLabel cardType = new JLabel("Card Number: ");
        cardType.setFont(new Font("Raleway",Font.BOLD,22));
        cardType.setBounds(100,300,200,30);
        add(cardType);
        
        JLabel cardNumber = new JLabel("XXXX-XXXX-XXXX-4104");
        cardNumber.setFont(new Font("Raleway",Font.BOLD,22));
        cardNumber.setBounds(330,300,300,30);
        add(cardNumber);
        
        JLabel cardPin = new JLabel("PIN: ");
        cardPin.setFont(new Font("Raleway",Font.BOLD,22));
        cardPin.setBounds(100,370,200,30);
        add(cardPin);
        
        JLabel cardDetails = new JLabel("Your 16 Digit Card Number");
        cardDetails.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetails.setBounds(100,330,200,15);
        add(cardDetails);
        
        JLabel cardPinNum = new JLabel("XXXX");
        cardPinNum.setFont(new Font("Raleway",Font.BOLD,22));
        cardPinNum.setBounds(330,370,200,30);
        add(cardPinNum);
        
        JLabel pinDetails = new JLabel("Your 4 Digit Password");
        pinDetails.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetails.setBounds(100,400,200,15);
        add(pinDetails);
        
        JLabel servicesRequired = new JLabel("Services Required: ");
        servicesRequired.setFont(new Font("Raleway",Font.BOLD,22));
        servicesRequired.setBounds(100,450,300,30);
        add(servicesRequired);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,230,30);
        add(c3);
        
        c4 = new JCheckBox("SMS && Email Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(100,550,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statemnet");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
        
        c7 = new JCheckBox("I Hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,680,600,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent btn) {
        if(btn.getSource() == submit) {
            String accountType = null;
            if(r1.isSelected()) {
                accountType = "Saving Account";
            }
            else if(r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            }
            else if(r3.isSelected()) {
                accountType = "Current Account";
            }
            else if(r4.isSelected()) {
                accountType = "Recuring Deposit";
            }
            
            Random random = new Random();
            String cardNumber = Math.abs((random.nextLong() % 9000000L)+ 5040936000000000L) +"";
            String pinNumber =  "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            
            String facility = "";
            if(c1.isSelected()) {
                facility = facility + "ATM CARD";
            }
            else if(c2.isSelected()) {
                facility = facility + "Internet Banking";
            }
            else if(c3.isSelected()) {
                facility = facility + "Mobile Banking";
            }
            else if(c4.isSelected()) {
                facility = facility + "SMS && Email Alerts";
            }
            else if(c5.isSelected()) {
                facility = facility + "Cheque Book";
            }
            else if(c6.isSelected()) {
                facility = facility + "E-Statemnet";
            }
            
            try {
                
                if(accountType.equals("")) {
                    JOptionPane.showMessageDialog(null,"Account Type is Required");   
                }
                else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values ('"+formNo+"', '"+accountType+"', '"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    JOptionPane.showMessageDialog(null,"Card Number: " + cardNumber + "\n Pin: " + pinNumber);
                    String query2 = "insert into login values ('"+formNo+"', '"+cardNumber+"','"+pinNumber+"')";
                    
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                }
                
                setVisible(false);
                new Deposit(pinNumber).setVisible(false);
                
            } catch (Exception e) {
                System.out.print(e);
            }
        }
        else if(btn.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new SignUp3("");
        
    }
}
