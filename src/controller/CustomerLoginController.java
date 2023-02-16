package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.MainModel;
import view.CustomerLoginView;
import view.CustomerMenuView;
import view.LoginGUIView;

public class CustomerLoginController implements ActionListener { 
	//Model and view for CustomerLoginController
	MainModel mainModel = new MainModel();
	CustomerLoginView customerLoginGUIView;
	
	//Pass respective model and view to controller
	public CustomerLoginController(MainModel mainModel, CustomerLoginView customerLoginGUIView){
		this.mainModel = mainModel;
		this.customerLoginGUIView = customerLoginGUIView;
		
		//Add action-listeners to JButtons from customerLoginView
		this.customerLoginGUIView.getJBLogin().addActionListener(this);
		this.customerLoginGUIView.getJBBack().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//get user-name and password entered by the staff from JTextFields using 
		//accessors from customerLoginView
		String username = customerLoginGUIView.getJTUsername().getText();
		String password = customerLoginGUIView.getJTPsw().getText();

		/* Check for button presses and display respective GUI based on it (by passing view and model
		 * to the controller).
		 * Also set the current view visibility to false
		*/
		if (e.getSource() == customerLoginGUIView.getJBLogin()) {
			//empty JTextFields after pressing login
			customerLoginGUIView.getJTUsername().setText(null);
			customerLoginGUIView.getJTPsw().setText(null);
			
			//pass user-name and password to validateLogin method to check for a valid login
			if (mainModel.validateCLogin(username, password) == 1) {
				//after login credentials are validated, display customer dash-board

					JOptionPane.showMessageDialog(null, "Logged in successfully!", "Welcome", 
							JOptionPane.INFORMATION_MESSAGE);
					
				customerLoginGUIView.setVisible(false); 
				CustomerMenuView customerMenuView = new CustomerMenuView();
				new CustomerMenuController(customerMenuView);
					
			}
			else if (mainModel.validateCLogin(username, password) == 0)  {
				//display error message
			
					 JOptionPane.showMessageDialog(null, "Invalid Credentials, Try again!", "Log in Error"
							 , JOptionPane.ERROR_MESSAGE);
				}
				
			 }
			
		
		
		if (e.getSource() ==customerLoginGUIView.getJBBack()){
			// display login view if back is pressed  
			customerLoginGUIView.setVisible(false);
			
			LoginGUIView loginGUIView = new LoginGUIView() ;
			new LoginGUIController(loginGUIView);
		}
		}
}
