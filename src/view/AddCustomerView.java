package view;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddCustomerView extends JFrame {
	//JLabels and JTextFields to get data of customer from staff  
	private JLabel jLId, jLName, jLAddress, jLPhone, jLEmail, jLUsername, jLPassword;
	private JTextField jTId, jTName, jTAddress, jTPhone, jTEmail, jTUsername, jTPassword;
	
	//JButtons to add, edit, delete, update, display, save data and go back to previous menu
	private JButton jBAdd, jBBack, jBEdit, jBDelete, jBUpdate, jBDisplay, jBSave;
	
	//DefaultTableModel and JTable to store and display data of all corporate customers
	private DefaultTableModel dTMCustomers;
	private JTable jTblCustomers;
	
	//constructor to set frame size, title, location and other properties
	public AddCustomerView(){
		setSize(2500,700);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add Customers - Admin");
		createAddView();
		setVisible(true);	
	}
	//adds components such as JLabels, JButtons, JTextFields, JScrollPane to the window
	private void createAddView() {
		 Container window = getContentPane();
		 window.setLayout(null);
		
		 /*JLabels and JTextFields to get id, name, address, phone number, email, user-name and 
		   password of customers, and setting bounds of these components on the window */
	
		 jLId = new JLabel("Id: ");
		 jLId.setBounds(55, 60, 105, 25);
		
		 jLName = new JLabel("Name: ");
		 jLName.setBounds(55, 110, 105, 25);
		
		 jLAddress = new JLabel("Address: ");
		 jLAddress.setBounds(55, 160, 105, 25);
		 
		 jLPhone = new JLabel("Phone Number: ");
		 jLPhone.setBounds(55, 210, 105, 25);
		 
		 jLEmail = new JLabel("Email: ");
		 jLEmail.setBounds(55, 260, 105, 25);
		 
		 jLUsername = new JLabel("Username: ");
		 jLUsername.setBounds(55, 310, 105, 25);
		 
		 jLPassword = new JLabel("Password: ");
		 jLPassword.setBounds(55, 360, 105, 25);
	     
		 jTId = new JTextField(10);
		 jTId.setBounds(180, 60, 155, 25);
		 
		 jTName = new JTextField(10);
		 jTName.setBounds(180, 110, 155, 25);
		 
		 jTAddress = new JTextField(10);
		 jTAddress.setBounds(180, 160, 155, 25);
		 
		 jTPhone = new JTextField(10);
		 jTPhone.setBounds(180, 210, 155, 25);
		 
		 jTEmail = new JTextField(10);
		 jTEmail.setBounds(180, 260, 155, 25);
	     	
		 jTUsername = new JTextField(10);
		 jTUsername.setBounds(180, 310, 155, 25);
		 
		 jTPassword = new JTextField(10);
		 jTPassword.setBounds(180, 360, 155, 25);
		 
		 /*JButtons to add, edit, display, update and delete customer records, and to go back to 
		  * previous staff menu, add, edit, delete and save are enabled only after pressing display,
		  * update button is visible only after edit is pressed.
		  * Also set bounds of these components on the window */
		 
	     jBAdd = new JButton("Add");
		 jBAdd.setBounds(180, 430, 75, 30);
		 
		 jBUpdate = new JButton("Update");
		 jBUpdate.setBounds(160, 430, 75, 30);
		 jBUpdate.setVisible(false);
		 
		 jBEdit = new JButton("Edit");
		 jBEdit.setBounds(80, 490, 75, 30);
		 
		 jBDelete = new JButton("Delete");
		 jBDelete.setBounds(180, 490, 75, 30);
		 
		 jBBack = new JButton("Back");
		 jBBack.setBounds(15, 15, 75, 30);
		 
		 jBDisplay = new JButton("Display");
		 jBDisplay.setBounds(280, 490, 80, 30);
		 
		 jBSave = new JButton("Save To File");
		 jBSave.setBounds(170, 550, 110, 30);
			
		 
		 jBAdd.setEnabled(false);
		 jBEdit.setEnabled(false);
		 jBDelete.setEnabled(false);
		 jBSave.setEnabled(false);
         
		 //Use DefaultTableModel and JTable to display data of customers with columns id, name, etc
		
		 Object [] colCustomers = {"Id", "Name", "Address","Phone","Email", "Username",
		 		"Passsword"};
		
		 dTMCustomers = new DefaultTableModel(null,colCustomers);
		
		 jTblCustomers = new JTable(dTMCustomers);
		
		 //Add table to JScrollPane and add the JScrollPane in specified bounds in the window
		 JScrollPane scrollPane = new JScrollPane(jTblCustomers);
		 scrollPane.setBounds(410, 17, 850, 603);
		 window.add(scrollPane);
		
		//add components to the window
		 window.add(jLId);
		 window.add(jTId);
		 window.add(jLName);
		 window.add(jTName);
		 window.add(jLAddress);
		 window.add(jTAddress);
		 window.add(jLPhone);
		 window.add(jTPhone);
		 window.add(jLEmail);
		 window.add(jTEmail);
		 window.add(jLUsername);
		 window.add(jTUsername);
		 window.add(jLPassword);
		 window.add(jTPassword);
		 
		 window.add(jBAdd);
		 window.add(jBUpdate);
		 window.add(jBBack); 
		 window.add(jBEdit);
		 window.add(jBDelete);
		 window.add(jBDisplay);
		 window.add(jBSave);
	 }
	
	//accessors for JTextFields
	public JTextField getJTId() {
		return jTId;
	}
	public JTextField getJTCName() {
		return jTName;
	}
	public JTextField getJTAddress() {
		return jTAddress;
	}
	public JTextField getJTPhone() {
		return jTPhone;
	}
	public JTextField getJTEmail() {
		return jTEmail;
	}
	public JTextField getJTUsername() {
		return jTUsername;
	}
	public JTextField getJTPassword() {
		return jTPassword;
	}
	
	//accessors for JButtons
	public JButton getJBAdd() {
		return jBAdd;
	}
	public JButton getJBUpdate() {
		return jBUpdate;
	}
	public JButton getJBEdit() {
		return jBEdit;
	}
	public JButton getJBDelete() {
		return jBDelete;
	}
	public JButton getJBBack() {
		return jBBack;
	}
	public JButton getJBSave() {
		return jBSave;
	}
	public JButton getJBDisplay() {
		return jBDisplay;
	}
	
	//accessor for JTable
	public JTable getJTblCustomers() {
		return jTblCustomers;	
	}
	
	//accessor for table model
	public DefaultTableModel getDTMCustomers() {
		return dTMCustomers;	
	}

}
