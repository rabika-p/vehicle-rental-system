package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import view.AddCustomerView;
import view.StaffMenuView;
import model.AddRecordsModel;

public class AddCustomerController  implements ActionListener{  
	//Model and view for AddCustomerController
	AddCustomerView addCustomerView;
	AddRecordsModel addRecordsModel;
	
	//parameterized constructor, pass respective model and view to controller
	public AddCustomerController(AddRecordsModel addRecordsModel, AddCustomerView addCustomerView) { 
		this.addRecordsModel = addRecordsModel;
		this.addCustomerView = addCustomerView;
		
		//Add action-listeners to JButtons from addCustomerView
		this.addCustomerView.getJBAdd().addActionListener(this);
		this.addCustomerView.getJBEdit().addActionListener(this);
		this.addCustomerView.getJBDelete().addActionListener(this);
		this.addCustomerView.getJBBack().addActionListener(this);
		this.addCustomerView.getJBUpdate().addActionListener(this);
		this.addCustomerView.getJBDisplay().addActionListener(this);
		this.addCustomerView.getJBSave().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Store variables from addCustomerView, using accessor methods which are reused frequently 
		// in the program
		
		//JTable and DefaultTableModel to display list of all customers
		DefaultTableModel dTMCustomers = addCustomerView.getDTMCustomers();
		JTable jTblCustomers = addCustomerView.getJTblCustomers();
		
		//JTextFields to store customer data entered by the staff
		JTextField jTId = addCustomerView.getJTId();
		JTextField jTCName = addCustomerView.getJTCName();
		JTextField jTPhone = addCustomerView.getJTPhone();
		JTextField jTAddress = addCustomerView.getJTAddress();
		JTextField jTEmail = addCustomerView.getJTEmail();
		JTextField jTUsername = addCustomerView.getJTUsername();
		JTextField jTPassword = addCustomerView.getJTPassword();
		
		/* Check for button presses and perform functionality based on it (display button is to be
		 * pressed first to load data from the file, to which new data can be added, edited, or 
		deleted which is loaded into the file on pressing save to file button. */

		
		if (e.getSource()== addCustomerView.getJBAdd()) {
			//get all the data entered by the staff to enter new customer record 
			int id = Integer.parseInt(jTId.getText());
			String name = jTCName.getText();
			String address = jTAddress.getText();
			String phone = jTPhone.getText();
			String email = jTEmail.getText();
			String username = jTUsername.getText();
			String password = jTPassword.getText();
			
			//check for any empty inputs, display error if found.
			if (name.equals("") || address.equals("") || phone.equals("") || 
					email.equals("") || username.equals("")|| password.equals("")) {
				JOptionPane.showMessageDialog(null, "All fields are mandatory!", "Error"
						 ,JOptionPane.ERROR_MESSAGE);
			}
			//check for duplicate entry of id
			else if (addRecordsModel.checkDuplicateId(dTMCustomers, jTId) == true){
			JOptionPane.showMessageDialog(null, "Duplicate id!", "Error"
					 ,JOptionPane.ERROR_MESSAGE);
			}
			//if no errors found, add new customer and display in the JTable
			else {
				Object [] rowCustomers =  {id, name, address, phone, email, username,
						password};
				dTMCustomers.addRow(rowCustomers); 
				JOptionPane.showMessageDialog(null, "Data added successfully!", 
						"Customer added", JOptionPane.INFORMATION_MESSAGE);
				
				//reset JTextFields after successfully inputting data
				addRecordsModel.resetCustomerDetails(jTId, jTCName, jTAddress, jTPhone, jTEmail,
						jTUsername, jTPassword);
			}
			}
		if (e.getSource()== addCustomerView.getJBEdit()) {
			
			// check for invalid edit tries by the staff, example trying to edit more than one record
			// at a time
			addRecordsModel.checkValidEdit(jTblCustomers);
		
			//can only edit one record at a time
			if (jTblCustomers.getSelectedRowCount() == 1) {
				//get current values of customer attribute to be edited
				String id = dTMCustomers.getValueAt(jTblCustomers.getSelectedRow(),  0).toString();
				String name = dTMCustomers.getValueAt(jTblCustomers.getSelectedRow(),  1).toString();
				String address = dTMCustomers.getValueAt(jTblCustomers.getSelectedRow(),  2).toString();
				String phone = dTMCustomers.getValueAt(jTblCustomers.getSelectedRow(),  3).toString();
				String email = dTMCustomers.getValueAt(jTblCustomers.getSelectedRow(),  4).toString();
				String username = dTMCustomers.getValueAt(jTblCustomers.getSelectedRow(),  5).toString();
				String password = dTMCustomers.getValueAt(jTblCustomers.getSelectedRow(),  6).toString();
				
				jTId.setText(id);
				jTId.setEditable(false); //make customer id not editable
				//place current values of customer record in the JTextFields
				jTCName.setText(name);
				jTAddress.setText(address);
				jTPhone.setText(phone);
				jTEmail.setText(email);
				jTUsername.setText(username);
				jTPassword.setText(password);
				
				//Display update button instead of add
				addCustomerView.getJBAdd().setVisible(false);
				addCustomerView.getJBUpdate().setVisible(true);		
		}
			
		
		}
		if (e.getSource()== addCustomerView.getJBUpdate()) {
			//replace old record in the table with edited data from the JTextFields
			int editedId = Integer.parseInt(jTId.getText());
			String editedName = jTCName.getText();
			String editedAddress = jTAddress.getText();
			String editedPhone = jTPhone.getText();
			String editedEmail = jTEmail.getText();
			String editedUsername = jTUsername.getText();
			String editedPassword =jTPassword.getText();
			
			dTMCustomers.setValueAt(editedId, jTblCustomers.getSelectedRow(), 0);
			dTMCustomers.setValueAt(editedName, jTblCustomers.getSelectedRow(), 1);
			dTMCustomers.setValueAt(editedAddress, jTblCustomers.getSelectedRow(), 2);
			dTMCustomers.setValueAt(editedPhone, jTblCustomers.getSelectedRow(), 3);
			dTMCustomers.setValueAt(editedEmail, jTblCustomers.getSelectedRow(), 4);
			dTMCustomers.setValueAt(editedUsername, jTblCustomers.getSelectedRow(), 5);
			dTMCustomers.setValueAt(editedPassword, jTblCustomers.getSelectedRow(), 6);
			
			JOptionPane.showMessageDialog(null, "Data updated successfully!", 
					"Customer updated", JOptionPane.INFORMATION_MESSAGE); 
			//reset JTextFields after successfully updating data
			addRecordsModel.resetCustomerDetails(jTId, jTCName, jTAddress, jTPhone, jTEmail, 
					jTUsername, jTPassword);
			
			//Display add button instead of update, make id editable for adding new record
			addCustomerView.getJBUpdate().setVisible(false);
			addCustomerView.getJBAdd().setVisible(true);
			jTId.setEditable(true);
		}
		if (e.getSource()== addCustomerView.getJBDisplay()) {
			//enable other buttons only after display is pressed (file data is loaded after pressing
			//display records which can be then added to, edited or deleted
			addCustomerView.getJBDisplay().setEnabled(false);
			
			addCustomerView.getJBAdd().setEnabled(true);
			addCustomerView.getJBEdit().setEnabled(true);
			addCustomerView.getJBDelete().setEnabled(true);
			addCustomerView.getJBSave().setEnabled(true);
			
			addRecordsModel.displayTryBlock(dTMCustomers, "Customer");
		}
		if (e.getSource()== addCustomerView.getJBDelete()) {
			//to delete a row of customer record
			addRecordsModel.deleteDataRow(dTMCustomers, jTblCustomers);	
		}
		
		if (e.getSource()== addCustomerView.getJBBack()) {
			// display staff menu if back is pressed  
			
			addCustomerView.setVisible(false);
			StaffMenuView staffMenuView = new StaffMenuView();
			new StaffMenuController(staffMenuView);
		}	
		if (e.getSource()== addCustomerView.getJBSave()) {	
			//store data to file if save is pressed
			addRecordsModel.writeTryBlock(dTMCustomers, "Customer");
		}
	}

 }
	
