package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SignUp2 extends JFrame implements ActionListener {
   
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton yes,no;
    JComboBox relig,catego,incomeCato,qualificationCato,occup;
    String formNo;
    
    SignUp2(String formNo) {
        
        this.formNo = formNo;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
       
        
        
        // adding second title for additional details.
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        
        
        // setting religion text && and its JComboBox.
        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway",Font.BOLD,22));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        String[] valReligion = {"Hindu","Muslim","Sikh","Christian","Others"};
        relig = new JComboBox(valReligion);
        relig.setBackground(Color.white);
        relig.setBounds(300,140,400,30);
        add(relig);
        
        
        
        // setting category text && and its JComboBox.
        JLabel category= new JLabel("Category: ");
        category.setFont(new Font("Raleway",Font.BOLD,22));
        category.setBounds(100,190,200,30);
        add(category);
        
        
        String[] valCategory = {"OPEN","OBC","SBC","SC","NT","Other"};
        catego = new JComboBox(valCategory);
        catego.setBackground(Color.white);
        catego.setBounds(300,190,400,30);
        add(catego);
        
        
        
        // setting income text && and its JComboBox.
        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Raleway",Font.BOLD,22));
        income.setBounds(100,240,200,30);
        add(income);
        
        String[] incomeCategory = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,0000"};
        incomeCato = new JComboBox(incomeCategory);
        incomeCato.setBackground(Color.white);
        incomeCato.setBounds(300,240,400,30);
        add(incomeCato);
        

        
         // setting education text && and its JComboBox.
        JLabel education= new JLabel("Educational ");
        education.setFont(new Font("Raleway",Font.BOLD,22));
        education.setBounds(100,290,200,30);
        add(education);
        
        
        // setting qualification text && and its JComboBox.
        JLabel qualification= new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway",Font.BOLD,22));
        qualification.setBounds(100,315,200,30);
        add(qualification);
        
        
        String[] qualificationValues = {"Non-Graduation","Graduate","Post Graduate","Doctrate","Others"};
        qualificationCato = new JComboBox(qualificationValues);
        qualificationCato.setBackground(Color.white);
        qualificationCato.setBounds(300,315,400,30);
        add(qualificationCato);
                
        
        
        // setting occupation text && and its JComboBox.
        JLabel occupation= new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway",Font.BOLD,22));
        occupation.setBounds(100,390,200,30);
        add(occupation);
        
        String[] occupationValues = {"Salaried","Self-Employed","Business","Student","Retire","Others"};
        occup = new JComboBox(occupationValues);
        occup.setBackground(Color.white);
        occup.setBounds(300,390,400,30);
        add(occup);
        
        
        
        // setting panNo text && and its textField.
        JLabel panNo= new JLabel("PAN NO: ");
        panNo.setFont(new Font("Raleway",Font.BOLD,22));
        panNo.setBounds(100,440,200,30);
        add(panNo);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);
        
        
        
        // setting addharNo text && and its textField.
        JLabel addharNo= new JLabel("Addhar No: ");
        addharNo.setFont(new Font("Raleway",Font.BOLD,22));
        addharNo.setBounds(100,490,200,30);
        add(addharNo);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);
        
        
        
        // setting seniorCitizen text && and its textField.
        JLabel seniorCitizen= new JLabel("Senior Citizen: ");
        seniorCitizen.setFont(new Font("Raleway",Font.BOLD,22));
        seniorCitizen.setBounds(100,540,200,30);
        add(seniorCitizen);
        
        yes = new JRadioButton("Yes");
        yes.setBounds(300,540,100,30);
        yes.setBackground(Color.white);
        add(yes);
        
        no = new JRadioButton("No");
        no.setBounds(450,540,100,30);
        no.setBackground(Color.white);
        add(no);   
        
        ButtonGroup sGroup = new ButtonGroup(); 
        sGroup.add(yes);
        sGroup.add(no);
        
        
        // setting existingAcc text && and its textField.
        JLabel existingAcc= new JLabel("Existing Account: ");
        existingAcc.setFont(new Font("Raleway",Font.BOLD,22));
        existingAcc.setBounds(100,590,200,30);
        add(existingAcc);
        
        yes = new JRadioButton("Yes");
        yes.setBounds(300,590,100,30);
        yes.setBackground(Color.white);
        add(yes);
        
        no = new JRadioButton("No");
        no.setBounds(450,590,100,30);
        no.setBackground(Color.white);
        add(no);   
        
        ButtonGroup eGroup = new ButtonGroup(); 
        eGroup.add(yes);
        eGroup.add(no);
        
        
        
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
    
    
    // catego,incomeCato,qualificationCato,occup
    
    public void actionPerformed(ActionEvent btn) {
        
//       String formNo = random +""; // here converting random into a string.
       String religion = (String) relig.getSelectedItem(); // here we are getting the inputed name.
       String category = (String) catego.getSelectedItem();
       String income = (String) incomeCato.getSelectedItem();
       String education = (String) qualificationCato.getSelectedItem();
       String occupation = (String) occup.getSelectedItem();
       String seniorCitizen = null;
       if(yes.isSelected()) {
           seniorCitizen = "Yes";
       }
       else if(no.isSelected()) {
           seniorCitizen = "No";
       }
       
       String existinAccount = null;
       if(yes.isSelected()) {
           existinAccount = "Yes";
       }
       else if(no.isSelected()) {
           existinAccount = "No";
       }
       
       String panNo = panTextField.getText();
       String addharNo = aadharTextField.getText();
       
       // we are writing this because if name field is empty then show a message.
       try {
           if(religion.equals("")) {
               JOptionPane.showMessageDialog(null,"religion is Required");
           }
           if(category.equals("")) {
               JOptionPane.showMessageDialog(null,"category is Required");
           }
           if(income.equals("")) {
               JOptionPane.showMessageDialog(null,"income is Required");
           }
           if(education.equals("")) {
               JOptionPane.showMessageDialog(null,"Education is Required");
           }
           if(occupation.equals("")) {
               JOptionPane.showMessageDialog(null,"occupation is Required");
           }
           if(panNo.equals("")) {
               JOptionPane.showMessageDialog(null,"pan number is Required");
           }
           if(addharNo.equals("")) {
               JOptionPane.showMessageDialog(null,"addhar Number is Required");
           }
           
           // this is mysql query.
           else {
               Conn c = new Conn();
               String query = "insert into signuptwo values('"+formNo+"', '"+religion+"', '"+category+"','"+income+"','"+education+"','"+occupation+"','"+panNo+"','"+addharNo+"','"+seniorCitizen+"','"+existinAccount+"')";
               
               // and here final exceuting the query.
               c.s.executeUpdate(query);
               
               setVisible(false);
               new SignUp3(formNo).setVisible(true);
              
           }
       }
       catch (Exception e) {
           System.out.print(e);
       }
    }
    
    
    public static void main(String args[]) {
        new SignUp2("");
    }
}

