package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.MainModel;
import view.CustomerMenuView;
import view.LoginGUIView;


public class CustomerMenuController implements ActionListener {
	//view for CustomerMenuController
	CustomerMenuView customerMenuView;
	
	//Pass respective view to controller
	public CustomerMenuController(CustomerMenuView customerMenuView) { //parameterized constructor
		this.customerMenuView = customerMenuView;
		//Add action-listeners to JButtons from customerMenuView
		this.customerMenuView.getJBProfile().addActionListener(this);
		this.customerMenuView.getJBOnLoan().addActionListener(this);
		
		this.customerMenuView.getJBCToLoan().addActionListener(this);
		this.customerMenuView.getJBMBToLoan().addActionListener(this);
		this.customerMenuView.getJBLToLoan().addActionListener(this);
		//buttons to request hire and return of vehicles
		this.customerMenuView.getJBCHire().addActionListener(this);
		this.customerMenuView.getJBMBHire().addActionListener(this);
		this.customerMenuView.getJBLHire().addActionListener(this);
		this.customerMenuView.getJBReturn().addActionListener(this);
		
		this.customerMenuView.getJBLogout().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainModel mainModel = new MainModel();
		//store getters into variables that are used often
		JScrollPane jSPCars = customerMenuView.getJSPCars();
		JScrollPane jSPMiniBuses = customerMenuView.getJSPMiniBuses();
		JScrollPane jSPLorries = customerMenuView.getJSPLorries();
		
		DefaultTableModel dTMCars = customerMenuView.getDTMCars();
		DefaultTableModel dTMMiniBuses = customerMenuView.getDTMMiniBuses();
		DefaultTableModel dTMLorries = customerMenuView.getDTMLorries();
		
		JTable jTblCars = customerMenuView.getJTblCars();
		JTable jTblMiniBuses = customerMenuView.getJTblMiniBuses();
		JTable jTblLorries = customerMenuView.getJTblLorries();
		
		//button to view customer profile
		if (e.getSource() == customerMenuView.getJBProfile()) {
			mainModel.customerRecords();	
		}
		
		if (e.getSource() == customerMenuView.getJBCToLoan()) { //get cars to loan
			jSPCars.setVisible(true);
			jSPMiniBuses.setVisible(false);
			jSPLorries.setVisible(false);
			
			mainModel.vehiclesToHire(dTMCars, "Car");
			
			customerMenuView.getJBMBHire().setVisible(false);
			customerMenuView.getJBLHire().setVisible(false);
			customerMenuView.getJBReturn().setVisible(false);
			customerMenuView.getJBCHire().setVisible(true);		
		}
		if (e.getSource() == customerMenuView.getJBCHire()) {
			if (jTblCars.getSelectedRowCount() == 1) { //if hire requested
				int vId = (int) jTblCars.getValueAt(jTblCars.getSelectedRow(), 0);
				mainModel.vehicleWishList(vId, "Car");	
			}
		}
		
		if (e.getSource() == customerMenuView.getJBMBToLoan()) { //get mini-buses to loan
			jSPMiniBuses.setVisible(true);
			jSPCars.setVisible(false);
			jSPLorries.setVisible(false);
			
			mainModel.vehiclesToHire(dTMMiniBuses, "Mini Bus");

			customerMenuView.getJBCHire().setVisible(false);
			customerMenuView.getJBLHire().setVisible(false);
			customerMenuView.getJBReturn().setVisible(false);
			customerMenuView.getJBMBHire().setVisible(true);		
		}
		if (e.getSource() == customerMenuView.getJBMBHire()) {
			if (jTblMiniBuses.getSelectedRowCount() == 1) { //if hire requested
				int vId = (int) jTblMiniBuses.getValueAt(jTblMiniBuses.getSelectedRow(), 0);
				mainModel.vehicleWishList(vId, "Mini Bus");	
			}
		}
		
		if (e.getSource() == customerMenuView.getJBLToLoan()) { //get lorries to loan
			jSPLorries.setVisible(true);
			
			jSPMiniBuses.setVisible(false);
			jSPCars.setVisible(false);
			mainModel.vehiclesToHire(dTMLorries, "Lorry");

			customerMenuView.getJBCHire().setVisible(false);
			customerMenuView.getJBMBHire().setVisible(false);
			customerMenuView.getJBReturn().setVisible(false);
			customerMenuView.getJBLHire().setVisible(true);		
		}
		if (e.getSource() == customerMenuView.getJBLHire()) {
			if (jTblLorries.getSelectedRowCount() == 1) { //if hire requested
				int vId = (int) jTblLorries.getValueAt(jTblLorries.getSelectedRow(), 0);
				mainModel.vehicleWishList(vId, "Lorry");	
			}
		}
		//view vehicles on loan
		if (e.getSource() == customerMenuView.getJBOnLoan()) {
			customerMenuView.getJBCHire().setVisible(false);
			customerMenuView.getJBMBHire().setVisible(false);
			customerMenuView.getJBLHire().setVisible(false);
			customerMenuView.getJBReturn().setVisible(true);
			
			jSPCars.setVisible(true);
			jSPMiniBuses.setVisible(true);
			jSPLorries.setVisible(true);
			
			mainModel.vehiclesOnHire(dTMCars, "Car");
			mainModel.vehiclesOnHire(dTMMiniBuses, "Mini Bus");
			mainModel.vehiclesOnHire(dTMLorries, "Lorry");	
		}
		//if request return vehicle button is pressed
		if (e.getSource() == customerMenuView.getJBReturn()) {
			if (jTblCars.getSelectedRowCount() == 1) { //if hire requested
				int vId = (int) jTblCars.getValueAt(jTblCars.getSelectedRow(), 0);
				mainModel.requestReturnV(vId, "Car");	
			}
			else if (jTblMiniBuses.getSelectedRowCount() == 1) { //if hire requested
				int vId = (int) jTblMiniBuses.getValueAt(jTblMiniBuses.getSelectedRow(), 0);
				mainModel.requestReturnV(vId, "Mini Bus");	
			}
			else if (jTblLorries.getSelectedRowCount() == 1) { //if hire requested
				int vId = (int) jTblLorries.getValueAt(jTblLorries.getSelectedRow(), 0);
				mainModel.requestReturnV(vId, "Lorry");	
			}
		}
		//if logout button is pressed
		if (e.getSource() == customerMenuView.getJBLogout()) {
			customerMenuView.setVisible(false);
			LoginGUIView loginGUIView = new LoginGUIView() ;
			new LoginGUIController(loginGUIView);
		}
			
		}

}
