package bank.management.system;

import java.sql.*;

public class Conn {
    
    //step 1 create connection.
    Connection c;
    
    //step 3 create statement.
    Statement s;
    
    public Conn() {
        try{
           //step 2 establishing connection.
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","Sumit@2211");
            s = c.createStatement(); 
            
            
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
