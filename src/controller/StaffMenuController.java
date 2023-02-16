package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.LoginGUI;
import model.AddRecordsModel;
import model.HireVehiclesModel;
import view.AddCustomerView;
import view.AddVehiclesView;
import view.HireVehiclesView;
import view.StaffMenuView;

public class StaffMenuController implements ActionListener {
	//View for StaffMenuController
	StaffMenuView staffMenuView;
	
	//Pass respective view to controller
	public StaffMenuController(StaffMenuView staffMenuView) { //parameterized constructor
		this.staffMenuView = staffMenuView;
		//Add action-listeners to JButtons from staffMenuView
		this.staffMenuView.getJBAddVehicles().addActionListener(this);
		this.staffMenuView.getJBAddCustomers().addActionListener(this);
		this.staffMenuView.getJBHireVehicles().addActionListener(this); 
		this.staffMenuView.getJBLogout().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//if add vehicles button is pressed
		if (e.getSource() ==staffMenuView.getJBAddVehicles()){
			staffMenuView.setVisible(false);
			AddRecordsModel addRecordsModel = new AddRecordsModel();
			AddVehiclesView addVehiclesView = new AddVehiclesView();
			 new AddVehiclesController(addRecordsModel, addVehiclesView);
		}
		//if add customers button is pressed
		if (e.getSource() ==staffMenuView.getJBAddCustomers()){
			staffMenuView.setVisible(false);
			AddRecordsModel addRecordsModel = new AddRecordsModel();
			AddCustomerView addCustomerView = new AddCustomerView();
			new AddCustomerController(addRecordsModel, addCustomerView);
		}
		//if hire vehicles button is pressed
		if (e.getSource() ==staffMenuView.getJBHireVehicles()){
			staffMenuView.setVisible(false);
			HireVehiclesModel hireVehiclesModel = new HireVehiclesModel();
			HireVehiclesView hireVehiclesView = new HireVehiclesView();
			new HireVehiclesController(hireVehiclesModel, hireVehiclesView);
			
		}
		//if logout is pressed
		if (e.getSource() ==staffMenuView.getJBLogout()){
			staffMenuView.setVisible(false);
			LoginGUI.main(null);
		}
	}
}
