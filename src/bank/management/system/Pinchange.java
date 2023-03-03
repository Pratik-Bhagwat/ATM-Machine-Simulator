
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pinchange extends JFrame implements ActionListener {
    
    JButton change,back;
    JPasswordField pin,repin;
    String pinNumber;
    
    Pinchange(String pinNumber) {
       
       this.pinNumber = pinNumber;
        
       setLayout(null); 
        
       ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("project_images/atm machine img.jpg"));
       Image img2 = img1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
       ImageIcon img3 = new ImageIcon(img2);
       
       JLabel image = new JLabel(img3);
       image.setBounds(0,0,900,900);
       add(image);
       
       JLabel text = new JLabel("Change your PIN");
       text.setBackground(Color.white);
       text.setFont(new Font("System",Font.BOLD,16));
       text.setBounds(310,320,400,20);
       image.add(text);
       
       JLabel pinText = new JLabel("New PIN: ");
       pinText.setBackground(Color.white);
       pinText.setFont(new Font("System",Font.BOLD,16));
       pinText.setBounds(220,350,180,20);
       image.add(pinText);
       
       JLabel repinText = new JLabel("Confirm PIN: ");
       repinText.setBackground(Color.white);
       repinText.setFont(new Font("System",Font.BOLD,16));
       repinText.setBounds(220,390,180,20);
       image.add(repinText);
       
       pin = new JPasswordField();
       pin.setFont(new Font("Raleway",Font.BOLD,22));
       pin.setBounds(330,350,180,25);
       image.add(pin);
       
       repin = new JPasswordField();
       repin.setFont(new Font("Raleway",Font.BOLD,22));
       repin.setBounds(330,390,180,25);
       image.add(repin);
       
       change = new JButton("Change");
       change.setBounds(385,455,150,30);
       change.addActionListener(this);
       image.add(change);
       
       back = new JButton("Back");
       back.setBounds(385,488,150,30);
       back.addActionListener(this);
       image.add(back);
       
       
       setSize(900,900);
       setLocation(300,0);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent btn) {
        
        if(btn.getSource() == change) {
            
            try {
                String newPin = pin.getText();
                String newRePin = repin.getText();
                
                if(!newPin.equals(newRePin)) {
                    JOptionPane.showMessageDialog(null, "Entered Pin doesnt match");
                }
                
                if(newPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter new PIN");
                }
                
                if(newRePin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+newRePin+"' where pin = '"+pinNumber+"'";
                String query2 = "update login set pinNumber = '"+newRePin+"' where pinNuber = '"+pinNumber+"'";
                String query3 = "update signupthree set pin = '"+newRePin+"' where pin = '"+pinNumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changes Successfully");
                setVisible(false);
                new Transactions(newRePin).setVisible(true);
                
            }
            catch (Exception e) {
            System.out.print(e);
        }
     }
        else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
  }
     
    
    public static void main(String args[]) {
        new Pinchange("").setVisible(true);
    }
}
