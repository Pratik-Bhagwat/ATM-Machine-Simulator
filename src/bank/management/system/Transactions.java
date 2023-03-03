package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
   
    JButton exit,deposit,withdrawl,fastCash,miniStatement,pinChange,balanceEnquiry;
    String pinNumber;
    
   Transactions(String pinNumber) {
       this.pinNumber = pinNumber;
       
       setLayout(null);
       
       ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("project_images/atm machine img.jpg"));
       Image img2 = img1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
       ImageIcon img3 = new ImageIcon(img2);
       
       JLabel image = new JLabel(img3);
       image.setBounds(0,0,900,900);
       add(image);

       
       JLabel transcation = new JLabel("Please select your Transaction");
       transcation.setBounds(260,315,700,35);
       transcation.setFont(new Font("System",Font.BOLD,16));
       transcation.setBackground(Color.white);
       image.add(transcation);
       
       
       deposit = new JButton("Deposit");
       deposit.setBounds(220,390,150,30);
       deposit.addActionListener(this);
       image.add(deposit);
       
       withdrawl = new JButton("Cash Withdrawl");
       withdrawl.setBounds(390,390,150,30);
       withdrawl.addActionListener(this);
       image.add(withdrawl);
       
       fastCash = new JButton("Fast Cash");
       fastCash.setBounds(220,423,150,30);
       fastCash.addActionListener(this);
       image.add(fastCash);
       
       miniStatement = new JButton("Mini Statement");
       miniStatement.setBounds(390,423,150,30);
       miniStatement.addActionListener(this);
       image.add(miniStatement);
       
       pinChange = new JButton("Pin Change");
       pinChange.setBounds(220,456,150,30);
       pinChange.addActionListener(this);
       image.add(pinChange);
       
       balanceEnquiry = new JButton("Balance Enquiry");
       balanceEnquiry.setBounds(390,456,150,30);
       balanceEnquiry.addActionListener(this);
       image.add(balanceEnquiry);
       
       exit = new JButton("Exit");
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
           System.exit(0);
       }
       else if(btn.getSource() == deposit) {
           setVisible(false);
           new Deposit(pinNumber).setVisible(true);
       }
       else if(btn.getSource() == withdrawl) {
           setVisible(false);
           new Withdrawal(pinNumber).setVisible(true);
       }
       else if(btn.getSource() == fastCash) {
           setVisible(false);
           new Fastcash(pinNumber).setVisible(true);
       }
       else if(btn.getSource() == pinChange) {
           setVisible(false);
           new Pinchange(pinNumber).setVisible(true);
       }
       else if(btn.getSource() == balanceEnquiry) {
           setVisible(false);
           new Balance(pinNumber).setVisible(true);
       }
       else if(btn.getSource() == miniStatement) {
           setVisible(false);
           new Ministatement(pinNumber).setVisible(true);
       }
   }
   
   
    public static void main(String args[]) {
       new Transactions("");
    }
}
