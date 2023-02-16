package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.MainModel;
import view.StaffMenuView;
import view.LoginGUIView;
import view.StaffLoginView;

public class StaffLoginController implements ActionListener{
	//Model and view for StaffLoginController
	MainModel mainModel;
	StaffLoginView staffLoginView;
	
	//Pass respective model and view to controller
	public StaffLoginController(MainModel mainModel, StaffLoginView staffLoginView) { 
		this.mainModel = mainModel;
		this.staffLoginView = staffLoginView;
		
		//Add action-listeners to JButtons from staffLoginView
		this.staffLoginView.getJBLogin().addActionListener(this);
		this.staffLoginView.getJBBack().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//get user-name and password entered by the staff from JTextFields using accessors from
		// staffLoginView
		String username = staffLoginView.getJTUsername().getText();
		String password =staffLoginView.getJTPsw().getText();
		
		/* Check for button presses and display respective GUI based on it (by passing view and model
		 * to the controller).
		 * Also set the current view visibility to false
		*/
		if (e.getSource() ==staffLoginView.getJBLogin()){
			//empty JTextFields after pressing login
			staffLoginView.getJTUsername().setText(null);
			staffLoginView.getJTPsw().setText(null);
			
			//pass user-name and password to validateLogin method to check for a valid login
			if (mainModel.validateLogin(username, password) == 1) {
				//after login credentials are validated, display staff dash-board
				staffLoginView.setVisible(false); 
				StaffMenuView staffMenuView = new StaffMenuView(); 
				new StaffMenuController(staffMenuView);	
			}
		}
		//if back is pressed
		if (e.getSource() ==staffLoginView.getJBBack()){
			staffLoginView.setVisible(false);

			LoginGUIView loginGUIView = new LoginGUIView() ;
			new LoginGUIController(loginGUIView);

		}
		
	}

  }

