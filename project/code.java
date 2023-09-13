package guifinal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class BankLoginPage extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel usernameLabel, passwordLabel, newAccountLabel;
    private JTextField usernameField, newAccountField;
    private JPasswordField passwordField;
    private JButton loginButton, newAccountButton;

    public BankLoginPage() {
        setTitle("Bank Login Page");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        newAccountButton = new JButton("Create New Account");
        newAccountButton.addActionListener(this);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel(" "));
        panel.add(new JLabel(" "));
        panel.add(newAccountButton);
        panel.add(loginButton);
        add(panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
    	 if (e.getSource() == loginButton) {
             String name=usernameField.getText();
             @SuppressWarnings("deprecation")
 			String pass=passwordField.getText();
             int flag=0;
             if(name=="" || pass=="") {
             	flag=1;
             	JOptionPane.showMessageDialog(this,"INCORRECT CREDENTIALS",pass, JOptionPane.ERROR_MESSAGE);
             }
         	else {
 	            for(int i=0;i<name.length();i++) {
 	            	if(!((name.charAt(i)>='A' && name.charAt(i)<='Z') || (name.charAt(i)>='a' && name.charAt(i)<='z'))) {
 	            		flag=1;
 	            		break;
 	            	}
 	            		
 	            }
             }
             if(flag==0) {
             	name=name+"@123";
             	if(name.compareTo(pass)==0) {
             		dispose();
             		Radio r=new Radio();
             		r.setVisible(true);
             	}
             	else {
                 	JOptionPane.showMessageDialog(this,"INCORRECT CREDENTIALS",pass, JOptionPane.ERROR_MESSAGE);	
             	}
             }
             else {
             	JOptionPane.showMessageDialog(this,"INCORRECT CREDENTIALS",pass, JOptionPane.ERROR_MESSAGE);
             }
             // Validate the username and password here
             // ...

             // If the username and password are valid, show the main bank page
  
         } else if (e.getSource() == newAccountButton) {
             // Show the new account creation window
         	dispose();
             NewAccountWindow newAccountWindow = new NewAccountWindow();
             newAccountWindow.setVisible(true);
         }
     }
    public static void main(String[] args) {
        BankLoginPage bn=new BankLoginPage();
    	bn.setVisible(true);
	}
 }

    class NewAccountWindow extends JFrame implements ActionListener {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JLabel usernameLabel, passwordLabel, confirmPasswordLabel, mobileLabel, aadharLabel, captchaLabel;
        private JTextField usernameField, mobileField, aadharField, captchaField;
        private JPasswordField passwordField, confirmPasswordField;
        private JButton createButton, cancelButton;

        public NewAccountWindow() {
            setTitle("Create New Account");
            setSize(400, 300);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            usernameLabel = new JLabel("Username: ");
            passwordLabel = new JLabel("Password: ");
            confirmPasswordLabel = new JLabel("Confirm Password: ");
            mobileLabel = new JLabel("Mobile Number: ");
            aadharLabel = new JLabel("Aadhar Number: ");
            captchaLabel = new JLabel("Captcha: ");
            usernameField = new JTextField(15);
            passwordField = new JPasswordField(15);
            confirmPasswordField = new JPasswordField(15);
            mobileField = new JTextField(15);
            aadharField = new JTextField(15);
            captchaField = new JTextField(15);
            createButton = new JButton("Create Account");
            createButton.addActionListener(this);
            cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(this);

            JPanel panel1 = new JPanel(new GridLayout(6, 2));
            panel1.add(usernameLabel);
            panel1.add(usernameField);
            panel1.add(passwordLabel);
            panel1.add(passwordField);
            panel1.add(confirmPasswordLabel);
            panel1.add(confirmPasswordField);
            panel1.add(mobileLabel);
            panel1.add(mobileField);
            panel1.add(aadharLabel);
            panel1.add(aadharField);
            panel1.add(createButton);
            panel1.add(cancelButton);
            add(panel1, BorderLayout.CENTER);
        }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==createButton) {
				dispose();
				BankLoginPageSuccess bs=new BankLoginPageSuccess();
				bs.setVisible(true);
			}
			else if(e.getSource()==cancelButton) {
				dispose();
				BankLoginPage bn=new BankLoginPage();
		    	bn.setVisible(true);
			}
		}
    }
     class BankLoginPageSuccess extends JFrame implements ActionListener {
        /**
    	 * 
    	 */
        private JButton HomeButton, newAccountButton;
        JLabel textLabel;
        public BankLoginPageSuccess() {
        	setTitle("Bank Login Page");
            setSize(300, 200);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            textLabel=new JLabel("Created new Account Successfully");
            HomeButton=new JButton("Home");
            HomeButton.addActionListener(this);
            JPanel panel = new JPanel(new GridLayout(4, 2));
            
            panel.add(textLabel);
            panel.add(new JLabel(" "));
            panel.add(new JLabel(" "));
            panel.add(HomeButton);
            
            add(panel, BorderLayout.CENTER);
            
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == HomeButton) {
                dispose();
                BankLoginPage bn=new BankLoginPage();
            	bn.setVisible(true);
            }      
        }
    }
 class Radio extends JFrame implements ActionListener
     {
      

      

          private JRadioButton radioButton1;
          private JRadioButton radioButton2;
          private JRadioButton radioButton3;
          private JRadioButton radioButton4;
          private JRadioButton radioButton5;
          private JRadioButton radioButton6;
          private ButtonGroup buttonGroup;
          

          public Radio() {
              // Set the frame properties
              setTitle("Multiple Radio Buttons Example");
              setDefaultCloseOperation(DISPOSE_ON_CLOSE);
              setSize(300, 200);

              // Create the radio buttons
              radioButton1 = new JRadioButton("Account Details");
              radioButton2 = new JRadioButton("Loan Application");
              radioButton3 = new JRadioButton("Transaction");
              radioButton4 = new JRadioButton("Transaction History");
              radioButton5 = new JRadioButton("Notifications");
              radioButton6 = new JRadioButton("Sign Out");
              // Add the radio buttons to a button group
              buttonGroup = new ButtonGroup();
              buttonGroup.add(radioButton1);
              buttonGroup.add(radioButton2);
              buttonGroup.add(radioButton3);
              buttonGroup.add(radioButton4);
              buttonGroup.add(radioButton5);
              buttonGroup.add(radioButton6);
              // Create a panel to hold the radio buttons
              JPanel radioPanel = new JPanel(new GridLayout(0, 1));
              radioPanel.add(radioButton1);
              radioPanel.add(radioButton2);
              radioPanel.add(radioButton3);
              radioPanel.add(radioButton4);
              radioPanel.add(radioButton5);
              radioPanel.add(radioButton6);
              
              
              radioButton1.setHorizontalAlignment(JLabel.CENTER);
              radioButton1.setVerticalAlignment(JLabel.CENTER);
              
              radioButton2.setHorizontalAlignment(JLabel.CENTER);
              radioButton2.setVerticalAlignment(JLabel.CENTER);
              
              radioButton3.setHorizontalAlignment(JLabel.CENTER);
              radioButton3.setVerticalAlignment(JLabel.CENTER);
              
              radioButton4.setHorizontalAlignment(JLabel.CENTER);
              radioButton4.setVerticalAlignment(JLabel.CENTER);
              
              radioButton5.setHorizontalAlignment(JLabel.CENTER);
              radioButton5.setVerticalAlignment(JLabel.CENTER);
              
              radioButton6.setHorizontalAlignment(JLabel.CENTER);
              radioButton6.setVerticalAlignment(JLabel.CENTER);
              
              // Add the panel to the content pane
              getContentPane().add(radioPanel, BorderLayout.CENTER);

              // Add an action listener to the radio buttons
              radioButton1.addActionListener(this);
              radioButton2.addActionListener(this);
              radioButton3.addActionListener(this);
              radioButton4.addActionListener(this);
              radioButton5.addActionListener(this);
              radioButton6.addActionListener(this);
              // Set the frame visible
          }

          public void actionPerformed(ActionEvent e) {
              // Determine which radio button was selected
              if (radioButton1.isSelected())
              {
            	  dispose();
            	  BankAccountDetailsForm bad=new BankAccountDetailsForm();
            	  bad.setVisible(true);
              } 
              else if (radioButton2.isSelected()) 
              {
            	  dispose();
            	  Simple s=new Simple();
            	  s.setVisible(true);
              } 
              else if (radioButton3.isSelected()) 
              {
            	  dispose();
            	  BankTransactionsGUI btg=new BankTransactionsGUI();
            	  btg.setVisible(true);
              }
              else if (radioButton4.isSelected()) 
              {
                  dispose();
                  BankTransactionHistoryGUI bth=new BankTransactionHistoryGUI();
                  bth.setVisible(true);
              }
              else if(radioButton5.isSelected()) 
              {
               JOptionPane.showMessageDialog(this, "Today's notification is make a deposit of 2,00,000 get 20% added to your account", "Selection", JOptionPane.INFORMATION_MESSAGE);
              }
              else if(radioButton6.isSelected()) 
              {
            	  dispose();
            	  BankLoginPage blp=new BankLoginPage();
            	  blp.setVisible(true);
            	  
              }
          }
     }

class Simple extends JFrame implements ActionListener{
  final JFrame f= new JFrame("ABSS");
  JLabel l1,l2,l3,l4,l5,l6,l7,l8;  
    static JTextField tf1;
    static JTextField tf2;
  static JTextField tf3;
  static JTextField tf4;
  static JTextField tf5;
  static JTextField tf6;
  static JTextField tf7; 
      
    Simple()
  {
    JButton b=new JButton("Submit");  
    JButton bb=new JButton("Back");  
    bb.addActionListener(this);
    b.setBounds(140,290,95,30); 
    bb.setBounds(235,290,95,30);
      f.add(b);  
      f.add(bb);
      b.setFocusable(false);
      bb.setFocusable(false);
      l1=new JLabel("LOAN SYSTEM");  
      l1.setBounds(140,40, 100,30);   
      l2=new JLabel("Full Name*");  
      l2.setBounds(50,100, 100,30);  
      l3=new JLabel("Acount Type*");  
      l3.setBounds(50,123, 100,30);
      l4=new JLabel("Amount of Loan*");  
      l4.setBounds(50,146, 100,30);
      l5=new JLabel("Intrest Rate*");
      l5.setBounds(50, 169, 100, 30);
      l6=new JLabel("No of payments*");
      l6.setBounds(50, 192, 100, 30);
      l7=new JLabel("Withdrawal");
      l7.setBounds(50, 215, 100, 30);
      l8=new JLabel("Deposit");
      l8.setBounds(50, 237, 100, 30); 
      
      tf1=new JTextField();  
        tf1.setBounds(145,108,150,20);  
      tf2=new JTextField();  
        tf2.setBounds(145,130,150,20); 
        tf3=new JTextField();  
        tf3.setBounds(145,152,150,20);  
        tf4=new JTextField();
        tf4.setBounds(145,174,150,20);
        tf5=new JTextField();
        tf5.setBounds(145,196,150,20);
        tf6=new JTextField();
        tf6.setBounds(145,218,150,20);
        tf7=new JTextField();
        tf7.setBounds(145,240,150,20);
     
      f.add(l1); f.add(l2);f.add(l3); f.add(l4);f.add(l5);f.add(l6);f.add(l7);f.add(l8);
      f.add(tf1);f.add(tf2);f.add(tf3); ;f.add(tf4);f.add(tf5);f.add(tf6);f.add(tf7);
  
      f.setSize(400,400);
    f.setLayout(null);
    f.setVisible(true);
    f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    b.addActionListener(this);
        f.getContentPane().add(b);
        f.getContentPane().add(bb);
        tf1.requestFocusInWindow();
        
     }
   public static String gettf1() {
          return tf1.getText();
   }
   public static String gettf2() {
        return tf2.getText();
   }
   public static String gettf3() {
          return tf3.getText();
   }
   public static String gettf4() {
          return tf4.getText();
   }
   public static String gettf5() {
          return tf5.getText();
   }
   @Override    	
    	public void actionPerformed(ActionEvent e) {
    	    // TODO Auto-generated method stub
    	    
    	    String button=e.getActionCommand();
    	    if(button.equals("Submit"))
    	    {  
    	      String name=tf1.getText();
    	      String acctype=tf2.getText();
    	      String amtL=tf3.getText();
    	      String ir=tf4.getText();
    	      String np=tf5.getText();
    	      String wd=tf6.getText();
    	      String d=tf7.getText();
    	      int flag=0;
    	      String pass = null;
    	    if(name=="" && acctype=="" && amtL=="" && ir=="" && np=="" && wd=="" && d=="") {
    	    	flag=1;
  	          JOptionPane.showMessageDialog(this,"NOTHING IS ENTERED. PLEASE ENTER THE DETAILS AS ASKED",pass, JOptionPane.ERROR_MESSAGE);	    	
    	    }
    	    if(name=="") {
    	        flag=1;
    	          JOptionPane.showMessageDialog(this,"INCORRECT CREDENTIALS",pass, JOptionPane.ERROR_MESSAGE);
    	      }
    	      for(int i=0;i<name.length();i++) {
    	          if(!((name.charAt(i)>='A' && name.charAt(i)<='Z') || (name.charAt(i)>='a' && name.charAt(i)<='z'))) {
    	            flag=1;
    	            break;
    	          }
    	            
    	        }
    	      int flagamttype=0;
    	      if(acctype=="") {
    	        flag=1;
    	          JOptionPane.showMessageDialog(this,"INCORRECT CREDENTIALS",pass, JOptionPane.ERROR_MESSAGE);
    	      }
    	      for(int i=0;i<acctype.length();i++) {
    	          if(!((acctype.charAt(i)>='A' && acctype.charAt(i)<='Z') || (acctype.charAt(i)>='a' && acctype.charAt(i)<='z'))) {
    	            flagamttype=1;
    	            break;
    	          }
    	            
    	        }
    	      if(flagamttype==1 || flag==1) {
    	        flag=1;
    	        JOptionPane.showMessageDialog(this,"INCORRECT CREDENTIALS",pass, JOptionPane.ERROR_MESSAGE);
    	      
    	      }
    	      
    	      if(!(isValid(amtL) && isValid(ir) && isValid(np) && isValid(wd) && isValid(d))) {  
    	        flag=1;
    	        JOptionPane.showMessageDialog(this,"INCORRECT CREDENTIALS",pass, JOptionPane.ERROR_MESSAGE);
    	      }
    	      if(flag==0) {
    	        SecondFrame();
    	      }
    	    }  
    	    else if(button.equals("Back")){
    	      f.dispose();
    	    Radio r1=new Radio();
    	    r1.setVisible(true);
    	      }    
    	   }
    	   public static boolean isValid(String name) {
    	     if(name=="")
    	       return false;
    	     for(int i=0;i<name.length();i++) {
    	         if(!(name.charAt(i)>='0' && name.charAt(i)<='9')) {
    	           return false;
    	         }
    	       }
    	     return true;
    	   }		
   public static void SecondFrame()
   {
    
       JButton  b1, b2;
       JLabel l;
       final JFrame f= new JFrame("ABSS");
      JLabel l1,l2,l3,l4,l5,l6,l7,l8;  
      JTextField Tf1,Tf2,Tf3,Tf4,Tf5,Tf6,Tf7; 
      
       JButton b=new JButton("Exit");  
       b.setBounds(250,300,95,30);  
         f.add(b);  
         b.setFocusable(false);
       b.addActionListener(new ActionListener()
         {
         public void actionPerformed(ActionEvent e)
         {
           f.dispose();
         }
         });
         l1=new JLabel("Details :");  
       l1.setBounds(50,40, 100,30); 
        l2=new JLabel("Coustomer name");  
        l2.setBounds(50,100, 100,30);  
        l3=new JLabel("Acount Type");  
        l3.setBounds(50,123, 100,30);
        l4=new JLabel("Amount of Loan");  
        l4.setBounds(50,146, 100,30);
        l5=new JLabel("Intrest Rate");
        l5.setBounds(50, 169, 100, 30);
        l6=new JLabel("No of months");
        l6.setBounds(50, 192, 100, 30);
        l7=new JLabel("Payment per Month");
        l7.setBounds(50, 215, 100, 30);
        l8=new JLabel("Total Payment");
        l8.setBounds(50, 237, 100, 30); 
        
        int ta=Integer.parseInt(gettf3());  
        int ir= Integer.parseInt(gettf4()); 
        
        
        Tf1=new JTextField();  
          Tf1.setBounds(175,108,150,20);
Tf1.setText(gettf1());
          
          Tf2=new JTextField();  
          Tf2.setBounds(175,130,150,20); 
          Tf2.setText(gettf2());
          
          Tf3=new JTextField();  
          Tf3.setBounds(175,152,150,20); 
          Tf3.setText(gettf3());
          
          Tf4=new JTextField();
          Tf4.setBounds(175,174,150,20);
          Tf4.setText(gettf4());
          
          Tf5=new JTextField();
          Tf5.setBounds(175,196,150,20);
          Tf5.setText(gettf5());
          
          Tf6=new JTextField();
          Tf6.setBounds(175,218,150,20);
          int ppm=(ta+(ir*ta)/100)/12;
          String ppms=Integer.toString(ppm);
          Tf6.setText(ppms);
         
          Tf7=new JTextField();
          Tf7.setBounds(175,240,150,20);
          int tp=ta+(ir*ta)/100;
          String tps=Integer.toString(tp);
          Tf7.setText(tps);
          
          f.add(l1);f.add(l2);f.add(l3); f.add(l4);f.add(l5);f.add(l6);f.add(l7);f.add(l8);
        f.add(Tf1);f.add(Tf2);f.add(Tf3);f.add(Tf4);f.add(Tf5);f.add(Tf6);f.add(Tf7);
        
        f.setSize(400,400);
      f.setLayout(null);
      f.setVisible(true);
      f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   }
  }

class BankAccountDetailsForm extends JFrame implements ActionListener {

    JTextField firstNameTextField, lastNameTextField, accountNumberTextField;
    JLabel profileImageLabel;
    JButton uploadImageButton, saveButton, homeButton;
    ImageIcon profileImageIcon;

    public BankAccountDetailsForm() {
        // Set window properties
        setTitle("Bank Account Details");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setLayout(null);

        // Add components to the window
        JPanel detailsPanel = new JPanel(new GridLayout(7, 2));
        detailsPanel.setBounds(20, 20, 400, 320);

        detailsPanel.add(new JLabel("First Name:"));
        firstNameTextField = new JTextField();
        detailsPanel.add(firstNameTextField);

        detailsPanel.add(new JLabel("Last Name:"));
        lastNameTextField = new JTextField();
        detailsPanel.add(lastNameTextField);

        detailsPanel.add(new JLabel("Account Number:"));
        accountNumberTextField = new JTextField();
        detailsPanel.add(accountNumberTextField);

        detailsPanel.add(new JLabel("IFSC code:"));
        JTextField ifscCodeTextField = new JTextField();
        detailsPanel.add(ifscCodeTextField);

        detailsPanel.add(new JLabel("Pan ID Number:"));
        JTextField panIdTextField = new JTextField();
        detailsPanel.add(panIdTextField);

        detailsPanel.add(new JLabel("Phone No.:"));
        JTextField phoneNoTextField = new JTextField();
        detailsPanel.add(phoneNoTextField);

        detailsPanel.add(new JLabel("Address:"));
        JTextField addressTextField = new JTextField();
        detailsPanel.add(addressTextField);

        uploadImageButton = new JButton("Upload Image");
        uploadImageButton.setBounds(480, 20, 140, 30);
        uploadImageButton.addActionListener(this);

        profileImageLabel = new JLabel();
        profileImageLabel.setBounds(480, 70, 256, 256);

        saveButton = new JButton("Save");
        saveButton.setBounds(580, 330, 80, 30);
        saveButton.addActionListener(this);

        homeButton = new JButton("Back");
        homeButton.setBounds(680, 330, 100, 30);
        homeButton.addActionListener(this);

        add(detailsPanel);
        add(uploadImageButton);
        add(profileImageLabel);
        add(saveButton);
        add(homeButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == uploadImageButton) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                String imagePath = fileChooser.getSelectedFile().getPath();
                profileImageIcon = new ImageIcon(imagePath);
                profileImageIcon = new ImageIcon(profileImageIcon.getImage().getScaledInstance(profileImageLabel.getWidth(), profileImageLabel.getHeight(), Image.SCALE_DEFAULT));
                profileImageLabel.setIcon(profileImageIcon);
            }
        } else if (e.getSource() == saveButton) {
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String accountNumber = accountNumberTextField.getText();
            // TODO: Save the data to the database
            JOptionPane.showMessageDialog(this, "Data saved successfully!");
        } else if (e.getSource() == homeButton) {
            // TODO: Handle the action for the home button
        	dispose();
        	Radio r1=new Radio();
        	r1.setVisible(true);
        }
    }
}
class BankTransactionsGUI extends JFrame {
    private JLabel nameLabel, amountLabel, typeLabel;
    private JTextField nameField, amountField;
    private JRadioButton depositRadio, withdrawRadio;
    private ButtonGroup typeGroup;
    private JButton submitButton,backButton;

    public BankTransactionsGUI() {
        // Set the window title
    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Bank Transactions");

        // Set the window size and position
        setBounds(100, 100, 400, 200);

        // Create the labels
        nameLabel = new JLabel("Account Holder Name:");
        amountLabel = new JLabel("Amount:");
        typeLabel = new JLabel("Transaction Type:");

        // Create the text fields
        nameField = new JTextField();
        amountField = new JTextField();

        // Create the radio buttons
        depositRadio = new JRadioButton("Deposit");
        withdrawRadio = new JRadioButton("Withdraw");

        // Create the button group
        typeGroup = new ButtonGroup();
        typeGroup.add(depositRadio);
        typeGroup.add(withdrawRadio);

        // Create the submit button
        submitButton = new JButton("Submit");
        backButton=new JButton("Back");
        submitButton.addActionListener(e -> {
            // Get the selected transaction type
            String transactionType = "";
            if (depositRadio.isSelected()) {
                transactionType = "deposit";
            } else if (withdrawRadio.isSelected()) {
                transactionType = "withdrawal";
            }

            // Show confirmation message
            if (transactionType.equals("deposit")) {
                JOptionPane.showMessageDialog(this, "Deposit successful.");
            } else if (transactionType.equals("withdrawal")) {
                JOptionPane.showMessageDialog(this, "Thank you for selecting our bank and take your money.");
            }
        });
        backButton.addActionListener(e -> {
        	dispose();
        	Radio r1=new Radio();
        	r1.setVisible(true);
        });

        // Set the position and size of the components
        nameLabel.setBounds(10, 10, 150, 20);
        nameField.setBounds(170, 10, 200, 20);
        amountLabel.setBounds(10, 40, 150, 20);
        amountField.setBounds(170, 40, 200, 20);
        typeLabel.setBounds(10, 70, 150, 20);
        depositRadio.setBounds(170, 70, 80, 20);
        withdrawRadio.setBounds(260, 70, 100, 20);
        submitButton.setBounds(10, 100, 150, 30);
        backButton.setBounds(170,100,150,30);
        // Add the components to the content pane
        getContentPane().setLayout(null);
        getContentPane().add(nameLabel);
        getContentPane().add(nameField);
        getContentPane().add(amountLabel);
        getContentPane().add(amountField);
        getContentPane().add(typeLabel);
        getContentPane().add(depositRadio);
        getContentPane().add(withdrawRadio);
        getContentPane().add(submitButton);
        getContentPane().add(backButton);
        // Set the window to be visible
    }
}

class BankTransactionHistoryGUI extends JFrame {
    private JTable transactionTable;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JButton backButton;

 BankTransactionHistoryGUI() {
        // Set the window title
        setTitle("Bank Transaction History");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // Set the window size and position
        setBounds(100, 100, 600, 400);

        // Create the table
        String[] columnNames = {"Transaction ID", "Account Holder Name", "Transaction Amount", "Transaction Type", "Transaction Date"};
        Object[][] data = {{"1", "Azmatulla", "500.00", "Deposit", "2022-03-25"}, {"2", "Balaji", "200.00", "Withdrawal", "2022-03-24"},{"3", "Gowtham", "20000.00", "Withdrawal", "2022-03-21"},{"4", "Shiva", "10000.00", "deposit", "2022-03-18"},{"5", "Santhosh", "166500.00", "deposit", "2022-03-15"}};
        tableModel = new DefaultTableModel(data, columnNames);
        transactionTable = new JTable(tableModel);
        scrollPane = new JScrollPane(transactionTable);

        // Set the position and size of the components
        scrollPane.setBounds(10, 10, 560, 300);

        // Add the components to the content pane
        getContentPane().setLayout(null);
        getContentPane().add(scrollPane);

        // Add back button
        backButton = new JButton("Back");
        backButton.setBounds(10, 320, 80, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: Add code to go back to previous screen
            }
        });
        getContentPane().add(backButton);
        backButton.addActionListener(e -> {
        	dispose();
        	Radio r1=new Radio();
        	r1.setVisible(true);
        });
    }
}
