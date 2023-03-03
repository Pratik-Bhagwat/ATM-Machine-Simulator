package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawal extends JFrame implements ActionListener{
    
    JButton Withdrawal,back;
    JTextField t1;
    String pinNumber;
    
    Withdrawal(String pinNumber){
        
        
        this.pinNumber = pinNumber;
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("project_images/atm machine img.jpg"));
       Image img2 = img1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
       ImageIcon img3 = new ImageIcon(img2);
       
       JLabel image = new JLabel(img3);
       image.setBounds(0,0,900,900);
       add(image);
       
       JLabel text = new JLabel("Enter the amount you want to Withdraw");
       text.setBackground(Color.black);
       text.setFont(new Font("System",Font.BOLD,16));
       text.setBounds(233,320,400,20);
       image.add(text);
       
       
       t1 = new JTextField();
       t1.setFont(new Font("Raleway",Font.BOLD,22));
       t1.setBounds(233,350,285,25);
       image.add(t1);
       
       
       Withdrawal = new JButton("Withdraw");
       Withdrawal.setBounds(385,455,150,30);
       Withdrawal.addActionListener(this);
       image.add(Withdrawal);
       
       back = new JButton("Back");
       back.setBounds(385,488,150,30);
       back.addActionListener(this);
       image.add(back);
       
       setLayout(null);
       setSize(900,900);
       setLocation(300,0);
       setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==Withdrawal){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c1.s.executeUpdate("insert into bank values('"+pinNumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }

    
    
    public static void main(String[] args){
        new Withdrawal("").setVisible(true);
    }
}
