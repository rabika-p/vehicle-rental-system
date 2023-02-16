package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.MainModel;
import view.CustomerLoginView;
import view.LoginGUIView;
import view.StaffLoginView;

public class LoginGUIController implements ActionListener { 
	//view for LoginGUIController
	LoginGUIView loginGUIView;
	
	//Pass respective model and view to controller
	public LoginGUIController( LoginGUIView loginGUIView){
		this.loginGUIView = loginGUIView;
		
		//Add action-listeners to JButtons from loginGUIView
		this.loginGUIView.getJBStaff().addActionListener(this);
		this.loginGUIView.getJBCus().addActionListener(this);
		this.loginGUIView.getJBExit().addActionListener(this);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/* Check for button presses and display respective GUI based on it (by passing view and model
		 * to the controller), or exit the program.
		 * Also set the current view visibility to false
		*/
		if (e.getSource() == loginGUIView.getJBStaff()) {
			loginGUIView.setVisible(false);
			
			MainModel mainModel = new MainModel();
			StaffLoginView staffLoginView = new StaffLoginView(); 
			new StaffLoginController(mainModel, staffLoginView);
		}
		
		if (e.getSource() == loginGUIView.getJBCus()) { 
			loginGUIView.setVisible(false);
			
			MainModel mainModel = new MainModel();
			CustomerLoginView customerLoginView = new CustomerLoginView(); 
			new CustomerLoginController(mainModel, customerLoginView);
		}
		
		if (e.getSource() == loginGUIView.getJBExit()) {
			System.exit(0);	
		}
	}
}


