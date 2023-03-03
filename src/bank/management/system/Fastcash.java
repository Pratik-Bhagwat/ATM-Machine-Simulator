package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
public class Fastcash extends JFrame implements ActionListener {
   
    JButton exit,hundred,fiveHundred,thousand,twoThousand,fiveThousand,tenThousand;
    String pinNumber;
    
   Fastcash(String pinNumber) {
       this.pinNumber = pinNumber;
       
       setLayout(null);
       
       ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("project_images/atm machine img.jpg"));
       Image img2 = img1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
       ImageIcon img3 = new ImageIcon(img2);
       
       JLabel image = new JLabel(img3);
       image.setBounds(0,0,900,900);
       add(image);

       
       JLabel transcation = new JLabel("Please select your Withdrawl Amount");
       transcation.setBounds(260,315,700,35);
       transcation.setFont(new Font("System",Font.BOLD,16));
       transcation.setBackground(Color.white);
       image.add(transcation);
       
       
       hundred = new JButton("Rs 100");
       hundred.setBounds(220,390,150,30);
       hundred.addActionListener(this);
       image.add(hundred);
       
       fiveHundred = new JButton("Rs 500");
       fiveHundred.setBounds(390,390,150,30);
       fiveHundred.addActionListener(this);
       image.add(fiveHundred);
       
       thousand = new JButton("Rs 1000");
       thousand.setBounds(220,423,150,30);
       thousand.addActionListener(this);
       image.add(thousand);
       
       twoThousand = new JButton("Rs 2000");
       twoThousand.setBounds(390,423,150,30);
       twoThousand.addActionListener(this);
       image.add(twoThousand);
       
       fiveThousand = new JButton("Rs 5000");
       fiveThousand.setBounds(220,456,150,30);
       fiveThousand.addActionListener(this);
       image.add(fiveThousand);
       
       tenThousand = new JButton("Rs 10000");
       tenThousand.setBounds(390,456,150,30);
       tenThousand.addActionListener(this);
       image.add(tenThousand);
       
       exit = new JButton("Back");
       exit.setBounds(390,488,150,30);
       exit.addActionListener(this);
       image.add(exit);
       
       setSize(900,900);
       setLocation(300,0);
//     setUndecorated(true);
       setVisible(true);
       
   } 
    
   public void actionPerformed(ActionEvent btn) {
       if(btn.getSource() == exit){
           setVisible(false);
           new Transactions(pinNumber).setVisible(true);
       }
       else {
          String amount = ((JButton) btn.getSource()).getText().substring(3);
          Conn conn = new Conn();
          
          try {
              ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
              int balance = 0;
              
              while(rs.next()) {
                  if(rs.getString("type").equals("Deposit")) {
                      balance += Integer.parseInt(rs.getString("amount"));
                  }
                  else {
                      balance -= Integer.parseInt(rs.getString("amount"));
                  }
              }
              
              if(btn.getSource() != exit && balance < Integer.parseInt(amount)) {
                  JOptionPane.showMessageDialog(null,"Insufficient Balance");
                  return;
              }
              
              Date date = new Date();
              String query = "insert into bank values ('"+pinNumber+"','"+date+"', 'Withdrawl','"+amount+"')";
              conn.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Rs" + amount + "Debited Successfully");
              
              setVisible(false);
              new Transactions(pinNumber).setVisible(true);
          }
          catch (Exception e) {
              System.out.print(e);
          }
       }
   }
   
   
    public static void main(String args[]) {
       new Fastcash("");
    }
}
