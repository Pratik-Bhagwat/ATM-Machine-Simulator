package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JButton b1,b2;
    JTextField t1;
    String pinNumber;
    
    Deposit(String pinNumber){
        this.pinNumber = pinNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("project_images/atm machine img.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);
       
       JLabel text = new JLabel("Enter the amount you want to deposit");
       text.setBackground(Color.black);
       text.setFont(new Font("System",Font.BOLD,16));
       text.setBounds(233,320,400,20);
       image.add(text);
       
       
       t1 = new JTextField();
       t1.setFont(new Font("Raleway",Font.BOLD,22));
       t1.setBounds(233,350,285,25);
       image.add(t1);
       
       
       b1 = new JButton("Deposit");
       b1.setBounds(385,455,150,30);
       b1.addActionListener(this);
       image.add(b1);
       
       b2 = new JButton("Back");
       b2.setBounds(385,488,150,30);
       b2.addActionListener(this);
       image.add(b2);
       
       setSize(900,900);
       setLocation(300,0);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pinNumber+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
    
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}
