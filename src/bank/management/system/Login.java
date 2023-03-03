package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton loginBtn,clearBtn,signUpBtn;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    
    Login() {
        
        setLayout(null);
        
        setTitle("ATM" + "(" + "AUTOMATED TELLER MACHINE" + ")");
        
        //here we are loading or importing our logo from its specific folder.
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("project_images/logo.jpg"));
       
        
        Image img2 = img1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel img = new JLabel(img3);
        
        //now here we are deciding the logo image length on the frame.
        img.setBounds(70, 10, 100, 100);
        add(img);
        
        //here we are setting a title and adjusting its size.
        JLabel text = new JLabel("Welcome to the ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        
        
        // seting cardNumber text && its text field.
        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway",Font.BOLD,28));
        cardNo.setBounds(120,150,150,30);
        add(cardNo);
        
        cardTextField = new JTextField();
        cardTextField.setFont(new Font("Ariel",Font.BOLD,14));
        cardTextField.setBounds(300, 150, 230, 30);
        add(cardTextField);
        
        
        
        //setting pin text && its text field.
        JLabel pinNo = new JLabel("PIN:");
        pinNo.setFont(new Font("Raleway",Font.BOLD,28));
        pinNo.setBounds(120,220,150,30);
        add(pinNo);
        
        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,28));
        pinTextField.setFont(new Font("Ariel",Font.BOLD,14));
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);
        
        
        
        //adding buttons into the frame && adding addActionListener method.
        loginBtn = new JButton("SIGN IN");
        loginBtn.setBounds(300,300,100,30);
        loginBtn.setBackground(Color.BLACK);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.addActionListener(this);
        add(loginBtn);
        
        clearBtn = new JButton("CLEAR");
        clearBtn.setBounds(430,300,100,30);
        clearBtn.setBackground(Color.BLACK);
        clearBtn.setForeground(Color.WHITE);
        clearBtn.addActionListener(this);
        add(clearBtn);
        
        signUpBtn = new JButton("SIGN UP");
        signUpBtn.setBounds(300,350,230,30);
        signUpBtn.setBackground(Color.black);
        signUpBtn.setForeground(Color.white);
        signUpBtn.addActionListener(this);
        add(signUpBtn);
        
        
        
        // changing background color.
        getContentPane().setBackground(Color.WHITE);
        
        // here we are setting the frame size.
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    
    // here we are setting what the btns should do when its clicked.
    public void actionPerformed(ActionEvent btn){
        if(btn.getSource() == clearBtn) {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(btn.getSource() == loginBtn) {
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where cardNumber = '"+cardNumber+"' and pinNumber = '"+pinNumber+"'";
            
            try{
               ResultSet rs = conn.s.executeQuery(query);
               if(rs.next()) {
                   setVisible(false);
                   new Transactions(pinNumber).setVisible(true);
               }
               else {
                   JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
               }
            }
            catch (Exception e) {
                System.out.print(e);
            }
        }
        else if(btn.getSource() == signUpBtn) {
            // because when we click on signup btn it shuld close the current page and open the signup page.
            setVisible(false);
            
            // here we are calling the signup constructor and seting visible as true so the signup page would be visible.
            new SignUp1().setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Login();
    }
}
