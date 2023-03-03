
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Balance extends JFrame implements ActionListener {
    
    JButton back;
    String pinNumber;
    
    Balance(String pinNumber) {
       this.pinNumber = pinNumber;
        
       setLayout(null); 
        
       ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("project_images/atm machine img.jpg"));
       Image img2 = img1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
       ImageIcon img3 = new ImageIcon(img2);
       
       JLabel image = new JLabel(img3);
       image.setBounds(0,0,900,900);
       add(image);
       
       back = new JButton("Back");
       back.setBounds(385,488,150,30);
       back.addActionListener(this);
       image.add(back);
       
       Conn conn = new Conn();
       int balance = 0;  
          try {
              ResultSet rs = conn.s.executeQuery("select * from bank where pin ='"+pinNumber+"'");
        
              while(rs.next()) {
                  if(rs.getString("type").equals("Deposit")) {
                      balance += Integer.parseInt(rs.getString("amount"));
                  }
                  else {
                      balance -= Integer.parseInt(rs.getString("amount"));
                  }
              }
          }
            catch (Exception e) {
                    System.out.print(e);
      }
          
       JLabel text = new JLabel("Your current Account balance is: " + balance);
       text.setForeground(Color.black);
       text.setBounds(280,350,400,30);
       image.add(text);
       
       
       setSize(900,900);
       setLocation(300,0);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent btn) {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
    
    public static void main(String args[]) {
        new Balance("");
        
    }
    
}
